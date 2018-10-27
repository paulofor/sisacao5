package coletorjava.regracolecao.impl;


import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.LinkedList;
import java.util.List;

import javax.swing.JTextArea;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import coletorjava.dao.CotacaoDiarioDao;
import coletorjava.dao.CotacaoProcessadaDao;
import coletorjava.dao.CotacaoProcessadaOpcaoResultadoDao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.CotacaoProcessadaOpcaoResultado;
import coletorjava.modelo.DadoTreino;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.EscolhaOpcao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.OpcaoSisacaoSerie;
import coletorjava.modelo.ProjetoDadoTreino;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaOpcaoResultadoRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.DadoTreinoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.EscolhaOpcaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoSerieRegraColecao;
import coletorjava.regracolecao.ProjetoDadoTreinoRegraColecao;
import coletorjava.regracolecao.TickerRegraColecao;
import coletorjava.regracolecao.filtro.Tipos;


public  class CotacaoProcessadaOpcaoResultadoRegraColecaoImpl  extends CotacaoProcessadaOpcaoResultadoRegraColecao {

	private DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
	private EscolhaOpcaoRegraColecao escolhaSrv = FabricaRegra.getInstancia().getEscolhaOpcaoRegraColecao();
	private TickerRegraColecao tickerSrv = FabricaRegra.getInstancia().getTickerRegraColecao();
	private CotacaoProcessadaRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
	private CotacaoProcessadaRegraColecao cotacaoAcaoSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();

	private OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
	private OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
	
	private JTextArea saida = null;
	
	private int VALOR_FAIXA_COMPRA = 1;
	private int VALOR_FAIXA_VENDA = 2;
	
	void setSaida(String mensagem) {
		if (saida!=null) {
			saida.append(mensagem);
		}
	}
	
	@Override
	public CotacaoProcessadaOpcaoResultado CalcularPeriodoTicker(DaoConexao conexao) throws DaoException {
		String dataInicial = this.getFiltro().validaDataInicio();
		String dataFinal = this.getFiltro().validaDataFinal();
		String nomeTicker = this.getFiltro().validaNomeTicker();
		long codigoFaixa = this.getFiltro().getCodigoFaixa();
		JTextArea saida = this.getFiltro().getTextArea();
		CalcularPeriodoTickerTh thread = new CalcularPeriodoTickerTh(dataInicial, dataFinal, nomeTicker, saida, codigoFaixa);
		thread.start();
		return  null;
	}
	
	class CalcularPeriodoTickerTh extends Thread {
		
		private String dataInicial = null;
		private String dataFinal = null;
		private String nomeTicker = null;
		private long codigoFaixa = 0;
		
		public CalcularPeriodoTickerTh(String dataIni, String dataFim, String ticker, JTextArea texto, long faixa) {
			dataInicial = dataIni;
			dataFinal = dataFim;
			nomeTicker = ticker;
			saida = texto;
			codigoFaixa = faixa;
		}
		
		public void run() {
			setSaida("inicializando..." + '\n');
			diaPregaoSrv.getFiltro().setDataInicialPesquisa(dataInicial);
			diaPregaoSrv.getFiltro().setDataFinalPesquisa(dataFinal);
			try {
				List<DiaPregao> listaDia = diaPregaoSrv.ListaPorData();
				getFiltro().setListaDiaPregao(listaDia);
				GeraRegistros();
				getFiltro().setDataInicio(dataInicial);
				getFiltro().setDataFinal(dataFinal);
				getFiltro().setNomeTicker(nomeTicker);
				getFiltro().setCodigoFaixa(codigoFaixa);
				CalculaResultados();
				setSaida("Tratado " + listaDia.size() + " dias.");
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

	@Override
	public CotacaoProcessadaOpcaoResultado GeraRegistroPorTickerPeriodoOpcao(DaoConexao conexao) throws DaoException {
		String dataInicial = this.getFiltro().validaDataInicio();
		String dataFinal = this.getFiltro().validaDataFinal();
		String ticker = this.getFiltro().validaNomeTicker();
		String opcao = this.getFiltro().validaNomeOpcao();
		
		OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		opcaoSrv.getFiltro().setCodigoTicker(opcao);
		opcaoSrv.getFiltro().setData(dataFinal);
		OpcaoSisacao opcaoObj = opcaoSrv.ObtemPorCodigoMercadoAno();
		
		CotacaoProcessadaRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		cotacaoSrv.getFiltro().setDataInicial(dataInicial);
		cotacaoSrv.getFiltro().setDataFinal(dataFinal);
		cotacaoSrv.getFiltro().setNomeTicker(opcao);
	
		List<CotacaoProcessada> listaCotacaoOpcao = cotacaoSrv.ListaPorPeriodoTicker();
		
		List<CotacaoProcessadaOpcaoResultado> listaResultado = new LinkedList<CotacaoProcessadaOpcaoResultado>();
		for (CotacaoProcessada cotacao : listaCotacaoOpcao) {
			CotacaoProcessadaOpcaoResultado result = FabricaVo.criaCotacaoProcessadaOpcaoResultado();
			result.setCodigoMercadoOpcao(opcao);
			result.setValorOpcao(cotacao.getValor());
			result.setContadorDia(cotacao.getContadorDia());
			result.setHoraSerieTemporal(cotacao.getHoraSerieTemporal());
			result.setData(cotacao.getData());
			result.setIdOpcaoSisacaoRa(opcaoObj.getIdObj());
			//-- continuar aqui
			listaResultado.add(result);
		}
		
		
		//int codigoFaixa = 1;
		CotacaoProcessadaOpcaoResultadoDao dao = this.getDao(conexao);
		//dao.ExcluiPeriodo();
		
		for (CotacaoProcessadaOpcaoResultado cotacao : listaResultado) {
			dao.IncluiDia(ticker, 2, cotacao);
		}
		
		
		return null;
		
	}
	
	@Override
	public CotacaoProcessadaOpcaoResultado GeraRegistros(DaoConexao conexao) throws DaoException {
		JTextArea saida = this.getFiltro().getTextArea();
		String nomeTicker = this.getFiltro().getNomeTicker();
		tickerSrv.getFiltro().setCodigoEmpresa(nomeTicker);
		Ticker tickerObj = tickerSrv.ObtemPorCodigo();
		
		escolhaSrv.getFiltro().setCodigoTickerReferenteA(tickerObj.getIdObj());
		getFiltro().setCodigoFaixa(VALOR_FAIXA_COMPRA);
		getFiltro().setNomeTicker(nomeTicker);
		this.criaTabelaSeNecessario(VALOR_FAIXA_COMPRA, nomeTicker, conexao);
		List<CotacaoProcessadaOpcaoResultado> listaCotRes = new LinkedList<CotacaoProcessadaOpcaoResultado>();
		
		// Cotacao Processada do Ativo
		this.cotacaoAcaoSrv.getFiltro().setNomeTicker(nomeTicker);
		
		List listaDia = getFiltro().validaListaDiaPregao();
		for (Object diaObj : listaDia) {
			DiaPregao dia = (DiaPregao) diaObj;
			if (!dia.getFeriado()) {
				escolhaSrv.getFiltro().setCodigoDiaPregaoReferenteA(dia.getIdDiaPregao());
				EscolhaOpcao escolhaOpcao = escolhaSrv.ObtemPorIdTickerDiaComOpcao();
				
				// Obter dados da opção
				cotacaoSrv.getFiltro().setDiaPregao(dia.getData());
				cotacaoSrv.getFiltro().setNomeTicker(escolhaOpcao.getOpcaoSisacaoEscolha(false).getCodigoMercado());
				List<CotacaoProcessada> listaCotacao = cotacaoSrv.ListaPorDataTicker();
				
				// Obter dados do Ativo
				cotacaoAcaoSrv.getFiltro().setNomeTicker(nomeTicker);
				cotacaoAcaoSrv.getFiltro().setDataPesquisa(dia.getData());
				List<CotacaoProcessada> listaCotacaoAtivo = cotacaoAcaoSrv.ListaPorDataTicker();
				
				setSaida(dia.getData() + " [ " + escolhaOpcao.getOpcaoSisacaoEscolha(false).getCodigoMercado() + " ] " + listaCotacao.size() + "/" + 
						listaCotacaoAtivo.size() + " itens \n");
				// --- Inicio Tratamento --- //
				
				int idx = 0;
				for (CotacaoProcessada cotacao : listaCotacao) {
					CotacaoProcessadaOpcaoResultado cotOp = FabricaVo.criaCotacaoProcessadaOpcaoResultado();
					CotacaoProcessada cotacaoAtivo = listaCotacaoAtivo.get(idx++);
					if (cotacaoAtivo.getContadorDia()==cotacao.getContadorDia()) {
						cotOp.setValorAcao(cotacaoAtivo.getValor());
					}
					cotOp.setContadorDia(cotacao.getContadorDia());
					cotOp.setData(dia.getData());
					cotOp.setHoraSerieTemporal(cotacao.getHoraSerieTemporal());
					cotOp.setCodigoMercadoOpcao(escolhaOpcao.getOpcaoSisacaoEscolha(false).getCodigoMercado());
					cotOp.setValorOpcao(cotacao.getValor());
					cotOp.setIdOpcaoSisacaoRa(escolhaOpcao.getOpcaoSisacaoEscolha(false).getIdObj());
					listaCotRes.add(cotOp);
				}
			}
		}
		// Colocando dados na base.
		getFiltro().setListaDiaPregao(listaDia);
		this.setSaida("Inicialização de exclusões");
		ExcluiPorListaDataTickerFaixa();
		this.setSaida("Inicialização de inclusões, total = " + listaCotRes.size());
		getFiltro().setListaCotacaoOpcao(listaCotRes);
		IncluiPorListTickerFaixa();
		this.setSaida("Processamento GeraRegistros concluído");
		return null;
	}

	private void criaTabelaSeNecessario(long faixa, String nomeTicker, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao(conexao);
		dao.criaSeNecessario(nomeTicker, faixa);
	}
	
	@Override
	public CotacaoProcessadaOpcaoResultado CalculaResultados(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao(conexao);
		String dataInicial = this.getFiltro().validaDataInicio();
		String dataFinal = this.getFiltro().validaDataFinal();
		long faixa = this.getFiltro().validaCodigoFaixa();
		String nomeTicker = this.getFiltro().validaNomeTicker();
		List<CotacaoProcessadaOpcaoResultado> lista = this.ListaPorIntervaloDataFaixaTicker(conexao);
		List<CotacaoProcessada> listaCotacaoOpcaoCorrente = null;
		String opcaoCorrente = null;
		for (CotacaoProcessadaOpcaoResultado cotacao : lista) {
			if (opcaoCorrente==null || cotacao.getCodigoMercadoOpcao().compareTo(opcaoCorrente)!=0) {
				// Carregar cotacao
				this.cotacaoSrv.getFiltro().setNomeTicker(cotacao.getCodigoMercadoOpcao());
				this.cotacaoSrv.getFiltro().setDataInicial(cotacao.getData());
				this.cotacaoSrv.getFiltro().setDataFinal(getDataVencimentoMaisUm(cotacao));
				listaCotacaoOpcaoCorrente = this.cotacaoSrv.ListaPorPeriodoTicker();
				opcaoCorrente = cotacao.getCodigoMercadoOpcao();
			}
			PontoSaida situacao = null;
			if (faixa==1) {
				situacao = completaSaidaCompra(cotacao,listaCotacaoOpcaoCorrente,.55f,.5f);
			} else {
				situacao = completaSaidaVenda(cotacao,listaCotacaoOpcaoCorrente,.55f,.5f);
			}
			cotacao.setDataHoraSaidaT50S50(situacao.data + " " + situacao.horaSerieTemporal); 
			cotacao.setValorSaidaT50S50(situacao.valor);
			cotacao.setResultadoT50S50(situacao.resultado);
			if (faixa==1) {
				situacao = completaSaidaCompra(cotacao,listaCotacaoOpcaoCorrente,.65f,.6f);
			} else {
				situacao = completaSaidaVenda(cotacao,listaCotacaoOpcaoCorrente,.65f,.6f);
			}
			cotacao.setDataHoraSaidaT60S60(situacao.data + " " + situacao.horaSerieTemporal); 
			cotacao.setValorSaidaT60S60(situacao.valor);
			cotacao.setResultadoT60S60(situacao.resultado);
			dao.AlteraItem(nomeTicker, faixa, cotacao);
			log50_50(cotacao);
		}
		return null;
	}
	
	
	private void log50_50(CotacaoProcessadaOpcaoResultado escolhida) {
		String mensagem = escolhida.getData() + " " + escolhida.getHoraSerieTemporal() + " : " + escolhida.getValorOpcaoFormatada() +
				"  " + escolhida.getDataHoraSaidaT50S50() + " : " + escolhida.getValorSaidaT50S50Formatada() + " [ " + escolhida.getResultadoT50S50() + " ]";
		this.setSaida(mensagem + "\n");
	}
	
	
	private PontoSaida completaSaidaCompra(CotacaoProcessadaOpcaoResultado escolhida, List<CotacaoProcessada> lista, float target, float stop) {
		float valorEntrada = 0;
		int posicao = getPosicao(escolhida, lista, 0);
		CotacaoProcessada cotacao = lista.get(posicao);
		if (cotacao.getValor()!=escolhida.getValorOpcao()) {
			System.out.println("Pesquisa com erro !!!");
		}
		valorEntrada = cotacao.getValor();
		float valorTarget = valorEntrada * (1f+target);
		float valorStop = valorEntrada * (1f-stop);
		boolean saiuTrade = false;
		long resultado = 0;
		while (!saiuTrade && posicao<lista.size()) {
			cotacao = lista.get(posicao++);
			if (cotacao.getValor()>=valorTarget) {
				resultado = 1;
				saiuTrade = true;
			}
			if (cotacao.getValor()<=valorStop) {
				resultado = -1;
				saiuTrade = true;
			}
		}
		PontoSaida saida = new PontoSaida(cotacao.getData(),cotacao.getHoraSerieTemporal(),cotacao.getValor(),resultado);
		return saida;
	}
	private PontoSaida completaSaidaVenda(CotacaoProcessadaOpcaoResultado escolhida, List<CotacaoProcessada> lista, float target, float stop) {
		float valorEntrada = 0;
		int posicao = getPosicao(escolhida, lista, 0);
		CotacaoProcessada cotacao = lista.get(posicao);
		if (cotacao.getValor()!=escolhida.getValorOpcao()) {
			System.out.println("Pesquisa com erro !!!");
		}
		valorEntrada = cotacao.getValor();
		float valorTarget = valorEntrada * (1f-target);
		float valorStop = valorEntrada * (1f+stop);
		boolean saiuTrade = false;
		long resultado = 0;
		while (!saiuTrade && posicao<lista.size()) {
			cotacao = lista.get(posicao++);
			if (cotacao.getValor()<=valorTarget) {
				resultado = 1;
				saiuTrade = true;
			}
			if (cotacao.getValor()>=valorStop) {
				resultado = -1;
				saiuTrade = true;
			}
		}
		PontoSaida saida = new PontoSaida(cotacao.getData(),cotacao.getHoraSerieTemporal(),cotacao.getValor(),resultado);
		return saida;
	}
	
	private void completaSaida50_50(CotacaoProcessadaOpcaoResultado escolhida, List<CotacaoProcessada> lista) {
		float valorEntrada = 0;
		int posicao = getPosicao(escolhida, lista, 0);
		CotacaoProcessada cotacao = lista.get(posicao);
		valorEntrada = cotacao.getValor();
		float valorTarget = valorEntrada * (1f+.5f);
		float valorStop = valorEntrada * (1f-.5f);
		boolean saiuTrade = false;
		long resultado = 0;
		while (!saiuTrade && posicao<lista.size()) {
			cotacao = lista.get(posicao++);
			if (cotacao.getValor()>=valorTarget) {
				resultado = 1;
				saiuTrade = true;
			}
			if (cotacao.getValor()<=valorStop) {
				resultado = -1;
				saiuTrade = true;
			}
		}
		if (saiuTrade) {
			escolhida.setDataHoraSaidaT50S50(cotacao.getData() + " " + cotacao.getHoraSerieTemporal()); 
			escolhida.setValorSaidaT50S50(cotacao.getValor());
			escolhida.setResultadoT50S50(resultado);
		}
	}
	
	private class PontoSaida {
		public float valor;
		public long resultado;
		public String horaSerieTemporal;
		public String data;
		
		public PontoSaida(String data, String hora, float valor, long resultado) {
			this.data = data;
			this.horaSerieTemporal = hora;
			this.valor = valor;
			this.resultado = resultado;
		}
	}
	
	private int getPosicao(CotacaoProcessadaOpcaoResultado escolhida, List<CotacaoProcessada> lista, int posInicial) {
		int posicaoAtual = posInicial;
		System.out.println("Vai pesquisar " + escolhida.getCodigoMercadoOpcao() + " " + escolhida.getContadorDia() + " " + escolhida.getData());
		while (	lista.get(posicaoAtual).getHoraSerieTemporal().compareTo(escolhida.getHoraSerieTemporal())!=0 ||
				lista.get(posicaoAtual).getData().compareTo(escolhida.getData())!= 0) {
			posicaoAtual++;
		}
		return posicaoAtual;
	}
	


	private String getDataVencimentoMaisUm(CotacaoProcessadaOpcaoResultado cotacao) throws DaoException {
		OpcaoSisacao opcao = opcaoSrv.obtemPorChave(cotacao.getIdOpcaoSisacaoRa());
		OpcaoSisacaoSerie serie = opcao.getOpcaoSisacaoSeriePertenceA(true);
		String data = serie.getDataVencimento();
		// DD-MM-AAAA
		// 0123456789
		int dia = Integer.parseInt(data.substring(0,2));
		dia++;
		return String.format("%02d", dia)+ data.substring(2);
	}

	@Override
	public CotacaoProcessadaOpcaoResultado ExcluiPorListaDataTickerFaixa(DaoConexao conexao) throws DaoException {
		String nomeTicker = this.getFiltro().validaNomeTicker();
		long faixa = this.getFiltro().validaCodigoFaixa();
		CotacaoProcessadaOpcaoResultadoDao dao = getDao(conexao);
		List listaDia = this.getFiltro().validaListaDiaPregao();
		for (Object obj : listaDia) {
			DiaPregao dia = (DiaPregao) obj;
			String dataDb = DCConvert.ToDataSqlAAAA_MM_DD(dia.getData());
			dao.ExluiDia(nomeTicker, faixa, dataDb);
		}
		return null;
	}

	@Override
	public CotacaoProcessadaOpcaoResultado IncluiPorListTickerFaixa(DaoConexao conexao) throws DaoException {
		String nomeTicker = this.getFiltro().validaNomeTicker();
		long faixa = this.getFiltro().validaCodigoFaixa();
		CotacaoProcessadaOpcaoResultadoDao dao = getDao(conexao);
		List listaCotacao = this.getFiltro().validaListaCotacaoOpcao();
		for (Object obj : listaCotacao) {
			CotacaoProcessadaOpcaoResultado cotacao = (CotacaoProcessadaOpcaoResultado) obj;
			//String dataDb = DCConvert.ToDataSqlAAAA_MM_DD(dia.getData());
			dao.IncluiDia(nomeTicker, faixa, cotacao);
		}
		return null;
	}

	@Override
	public List<CotacaoProcessadaOpcaoResultado> ListaPorIntervaloDataFaixaTicker(DaoConexao conexao) throws DaoException {
		String dataInicial = this.getFiltro().validaDataInicio();
		String dataFinal = this.getFiltro().validaDataFinal();
		long faixa = this.getFiltro().validaCodigoFaixa();
		String nomeTicker = this.getFiltro().validaNomeTicker();
		String dtInicioBd = DCConvert.ToDataSqlAAAA_MM_DD(dataInicial);
		String dtFinalBd = DCConvert.ToDataSqlAAAA_MM_DD(dataFinal);
		
		CotacaoProcessadaOpcaoResultadoDao dao = getDao(conexao);
		List<CotacaoProcessadaOpcaoResultado> saida = dao.ListaPorIntervaloDataFaixaTicker(dtInicioBd, dtFinalBd, nomeTicker, faixa);
		return saida;
	}

	@Override
	public CotacaoProcessadaOpcaoResultado TestaPeriodoTicker(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	
	private final int TICKER_POR_DIA = 32;
	private final int SALTO_TICK_INTRA = 2;
	private final int QUANTIDADE_DIA_INTRA = 10;
	private final int DIAS_DIARIO = 0;
	
	//private final int TAMANHO_ENTRADAS = TICKER_POR_DIA * QUANTIDADE_DIA_INTRA; // 600
	
	//private float fatorMultiplicador = (1/30);
		
	private final String ARQUIVO_PATH = "D:\\Documentos de Projetos\\Rede Neural\\Dados\\";
	
	private boolean pertenceAoMes(String mmAAAA, CotacaoProcessadaOpcaoResultado item) {
		String data = item.getData().substring(3);
		// DD-MM-AAAA
		// 0123456789
		return (mmAAAA.compareTo(data)==0);
	}
	
	/*
	 * Retorna as posicoes final de cada mes.
	 * 
	 */
	private int[] getPosicaoMes(List<CotacaoProcessadaOpcaoResultado> lista, String ano) {
		String mesAno = "01-" + ano;
		int[] saida = new int[13];
		int posicaoTeste = 0;
		while (!pertenceAoMes(mesAno,lista.get(posicaoTeste))) {
			posicaoTeste++;
		}
		Object obj = lista.get(posicaoTeste);
		saida[0] = posicaoTeste;
		
		for (int i = 1; (i<12); i++) {
			mesAno = String.format("%02d", i) + "-" + ano;
			while (pertenceAoMes(mesAno,lista.get(posicaoTeste))) {
				posicaoTeste++;
			}
			obj = lista.get(posicaoTeste);
			saida[i] = posicaoTeste;
			
		}
		saida[12] = lista.size() + 1;
		return saida;
	}
	
	private int totalIntradayNoDia(String ano) {
		if ("2011".equals(ano)) return 30;
		if ("2012".equals(ano)) return 30;
		if ("2015".equals(ano)) return 32;
		return 0;
	}
	
	
	@Override
	public CotacaoProcessadaOpcaoResultado GeraArquivoTreinoValorOpcao(DaoConexao conexao) throws DaoException {
		//ProjetoDadoTreino itemPesquisa = FabricaVo.criaProjetoDadoTreino();
		//itemPesquisa.setTarget(this.getFiltro().validaTargetArquivo());
		//itemPesquisa.setStop(this.getFiltro().validaStopArquivo());
		//itemPesquisa.setPosicaoCompraVenda(this.getFiltro().validaPosicaoCompraVendaArquivo());
		//itemPesquisa.setIdTickerRa(this.getFiltro().validaIdTickerArquivo());
		
		//ProjetoDadoTreinoRegraColecao projetoSrv = FabricaRegra.getInstancia().getProjetoDadoTreinoRegraColecao();
		//projetoSrv.getFiltro().setItem(itemPesquisa);
		//ProjetoDadoTreino item = projetoSrv.ObtemPorItem();
		
		
		
		String ano = this.getFiltro().validaAno();
		String dtInicio = "01-01-" + ano;
		String dtFinal = "31-12-" + ano;
		getFiltro().setDataInicio(dtInicio);
		getFiltro().setDataFinal(dtFinal);
		List<CotacaoProcessadaOpcaoResultado> lista =this.ListaPorIntervaloDataFaixaTicker();
		int[] posIniMes = getPosicaoMes(lista,ano);
		
		String arq = null;
		String nomeTicker = this.getFiltro().getNomeTicker();
		//DadoTreinoRegraColecao dadoTreinoSrv = FabricaRegra.getInstancia().getDadoTreinoRegraColecao();
		//DadoTreino dadoTreino = FabricaVo.criaDadoTreino();
		//dadoTreino.setCodigoFaixa(this.getFiltro().validaCodigoFaixa());
		//dadoTreino.setDiasEntradaDiario(this.getFiltro().validaQuantidadeDiaDiarioArquivo());
		//dadoTreino.setDiasEntradaIntraday(this.getFiltro().validaQuantidadeDiaIntradayArquivo());
		//dadoTreino.setAno(Long.parseLong(ano));
		//dadoTreino.setProjetoDadoTreinoPossui(item);
		
		int tamanhoIntraday = (int) (totalIntradayNoDia(this.getFiltro().validaAno()) * this.getFiltro().getQuantidadeDiaIntradayArquivo());
		// Quadrimestre
		int itemAno = 1;
		boolean valorAcao = !(getFiltro().getTipoDadoIntraday() == Tipos.INTRADAY_SOMENTE_OPCAO);
		
		
		// Mensal
		itemAno = 1;
		for (int i=0;(i+5)<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Sem_" + String.format("%02d", (i+1)) + "-" + String.format("%02d", (i+6)) +"_" + ano + 
							"_Intra" + (this.getFiltro().getSaltoTickerIntraArquivo() * 15)+ "_QtdDia" + this.getFiltro().getQuantidadeDiaDiarioArquivo() + "_QtdInt" + this.getFiltro().getQuantidadeDiaIntradayArquivo() + ".dat";
			GeraArquivo(arq,posIniMes[i], posIniMes[i+6],
					(int)this.getFiltro().getQuantidadeDiaDiarioArquivo(), tamanhoIntraday,
					(int)this.getFiltro().validaSaltoTickerIntraArquivo(), lista, valorAcao, (int)getFiltro().validaTipoDadoStopTarget(),
					nomeTicker);
		}
		
		
		itemAno = 1;
		for (int i=0;i<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Mensal_" + String.format("%02d", (i+1)) + "-" + String.format("%02d", (i+1)) +"_" + ano + 
					"_Intra" + (this.getFiltro().getSaltoTickerIntraArquivo() * 15)+ "_QtdDia" + this.getFiltro().getQuantidadeDiaDiarioArquivo() + "_QtdInt" + this.getFiltro().getQuantidadeDiaIntradayArquivo() + ".dat";
			GeraArquivo(arq,posIniMes[i], posIniMes[i+1],
					(int)this.getFiltro().getQuantidadeDiaDiarioArquivo(), tamanhoIntraday,
					(int)this.getFiltro().validaSaltoTickerIntraArquivo(), lista, valorAcao, (int)getFiltro().validaTipoDadoStopTarget(),
					nomeTicker);
		}
		/*itemAno = 1;
		for (int i=0;(i+3)<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Qua_" + String.format("%02d", (i+1)) + "-" + String.format("%02d", (i+4)) +"_" + ano + 
							"_Intra" + (this.getFiltro().getSaltoTickerIntraArquivo() * 15)+ "_QtdDia" + this.getFiltro().getQuantidadeDiaDiarioArquivo() + "_QtdInt" + this.getFiltro().getQuantidadeDiaIntradayArquivo() + ".dat";
			GeraArquivo(arq,posIniMes[i], posIniMes[i+4],
					(int)this.getFiltro().getQuantidadeDiaDiarioArquivo(), tamanhoIntraday,
					(int)this.getFiltro().validaSaltoTickerIntraArquivo(), lista, valorAcao, (int)getFiltro().validaTipoDadoStopTarget(),
					nomeTicker);
		}*/
		
		
		
		return null;
	}
	
	

	/**
	 * @param arq   Nome do arquivo a ser gerado
	 * @param posIni Posicao inicial de dados do arquivo
	 * @param posFim Posição final de dados do arquivo
	 * @param validaQuantidadeDiaIntradayArquivo
	 * @param validaQuantidadeDiaDiarioArquivo
	 * @param tamanhoIntradayDia
	 * @param lista
	 * @throws DaoException 
	 */
	private void GeraArquivo(String arq, int posIni, int posFim, int qtdeTickDiario, int qtdeTickIntraday,
			int saltoIntraday, List<CotacaoProcessadaOpcaoResultado> lista, boolean valorAcao, int codigoTargetStop, String nomeTicker ) throws DaoException {
		File fArquivo = new File(arq);
		BufferedWriter outArq = null;
		
		CotacaoProcessadaDao daoCotacao = null;
		daoCotacao = CotacaoProcessadaRegraColecao.getDao();
		daoCotacao.setConexao(daoCotacao.criaConexao());

		CotacaoDiarioDao daoDiario = null;
		daoDiario = CotacaoDiarioRegraColecao.getDao();
		daoDiario.setConexao(daoDiario.criaConexao());	
		
		
		try {
			outArq = new BufferedWriter(new FileWriter(fArquivo));
			for (int x=posIni;x<posFim && x < lista.size();x++) {
				//if (x>=tamanhoAmostra && x>(TICKER_POR_DIA * DIAS_DIARIO)) {
					String linhaEntrada = "";
					if (valorAcao) {
						linhaEntrada = this.getLinhaAtivo(nomeTicker, x, qtdeTickDiario, qtdeTickIntraday, saltoIntraday, lista, daoDiario);
					} else {
						linhaEntrada = this.getLinhaOpcao(nomeTicker, x, qtdeTickDiario, qtdeTickIntraday, saltoIntraday, lista, daoCotacao, daoDiario);
					}
					if (linhaEntrada!=null) {
						long valorY = -1;
						if (codigoTargetStop==Tipos.TARGET50_STOP50) {
							if (lista.get(x).getResultadoT50S50()==1) {
								valorY = 1;
							} else { 
								valorY = 0;
							}
						}
						if (codigoTargetStop==Tipos.TARGET60_STOP60) {
							if (lista.get(x).getResultadoT60S60()==1) {
								valorY = 1;
							} else { 
								valorY = 0;
							}
						}
						outArq.write(linhaEntrada + valorY + this.getLogResultado(lista.get(x)) + "\n");
					}
				//}
			}
			outArq.close();

			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

	
	@Override
	public CotacaoProcessadaOpcaoResultado GeraArquivoTreinoOpcaoIndicadores(DaoConexao conexao) throws DaoException {
		final int CODIGO_FAIXA = 1;
		String nomeTicker = this.getFiltro().getNomeTicker();
		long saltoIntraday = this.getFiltro().validaSaltoTickerIntraArquivo();
		
		String ano = this.getFiltro().validaAno();
		this.getFiltro().setCodigoFaixa(CODIGO_FAIXA);
		
		String dtInicio = "01-01-" + ano;
		String dtFinal = "31-12-" + ano;
		getFiltro().setDataInicio(dtInicio);
		getFiltro().setDataFinal(dtFinal);
		List<CotacaoProcessadaOpcaoResultado> lista = ListaPorIntervaloDataFaixaTicker(conexao);
		int[] posIniMes = getPosicaoMes(lista,ano);
		
		String nomeArquivo = null;
		int tempoMeses = 0;
		int itemAno = 1;
		
		// Semestre
		tempoMeses = 6;
		itemAno = 1;
		for (int i=0;(i+(tempoMeses-1))<12;i++) {
			nomeArquivo = ARQUIVO_PATH + "Dado_" + tempoMeses + "_Meses_" + String.format("%02d", (i+1)) + "_" + String.format("%02d", (i+tempoMeses)) + "_" + ano + 
					"_Intra" + (this.SALTO_TICK_INTRA * 15)+ "_QtdDia" + DIAS_DIARIO + "_QtdInt" + QUANTIDADE_DIA_INTRA + ".dat";
			GeraArquivoIndicadores(nomeArquivo,posIniMes[i],posIniMes[i+tempoMeses],(int)getFiltro().validaSaltoTickerIntraArquivo(),
					lista,(int)getFiltro().validaTipoDadoStopTarget(),nomeTicker);
		}
		// Mensal
		tempoMeses = 1;
		itemAno = 1;
		for (int i=0;(i+(tempoMeses-1))<12;i++) {
			nomeArquivo = ARQUIVO_PATH + "Dado_" + tempoMeses + "_Meses_" + String.format("%02d", (i+1)) + "_" + String.format("%02d", (i+tempoMeses)) + "_" + ano + 
					"_Intra" + (this.SALTO_TICK_INTRA * 15)+ "_QtdDia" + DIAS_DIARIO + "_QtdInt" + QUANTIDADE_DIA_INTRA + ".dat";
			GeraArquivoIndicadores(nomeArquivo,posIniMes[i],posIniMes[i+tempoMeses],(int)getFiltro().validaSaltoTickerIntraArquivo(),
					lista,(int)getFiltro().validaTipoDadoStopTarget(),nomeTicker);
		}
		
		
		return null;
	}

	int TAMANHO_ENTRADAS = 0;

	@Override
	public CotacaoProcessadaOpcaoResultado GeraArquivoTreino(DaoConexao conexao) throws DaoException {
		
		ProjetoDadoTreino itemPesquisa = FabricaVo.criaProjetoDadoTreino();
		itemPesquisa.setTarget(55);
		itemPesquisa.setStop(50);
		itemPesquisa.setPosicaoCompraVenda("C");
		itemPesquisa.setIdTickerRa(2);
		
		ProjetoDadoTreinoRegraColecao projetoSrv = FabricaRegra.getInstancia().getProjetoDadoTreinoRegraColecao();
		projetoSrv.getFiltro().setItem(itemPesquisa);
		ProjetoDadoTreino item = projetoSrv.ObtemPorItem();
		
		
		final int CODIGO_FAIXA = 1;
		
		String ano = this.getFiltro().validaAno();
		this.getFiltro().setCodigoFaixa(CODIGO_FAIXA);
		List<CotacaoProcessadaOpcaoResultado> lista = ListaPorIntervaloDataFaixaTicker(conexao);
		int[] posIniMes = getPosicaoMes(lista,ano);
		
		String arq = null;
		DadoTreinoRegraColecao dadoTreinoSrv = FabricaRegra.getInstancia().getDadoTreinoRegraColecao();
		DadoTreino dadoTreino = FabricaVo.criaDadoTreino();
		dadoTreino.setCodigoFaixa(CODIGO_FAIXA);
		dadoTreino.setDiasEntradaDiario(DIAS_DIARIO);
		dadoTreino.setDiasEntradaIntraday(QUANTIDADE_DIA_INTRA);
		dadoTreino.setAno(Long.parseLong(ano));
		dadoTreino.setProjetoDadoTreinoPossui(item);
		
		// Quadrimestre
		int itemAno = 1;
		for (int i=0;(i+3)<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Qua_" + String.format("%02d", (i+1)) + "-" + String.format("%02d", (i+4)) +"_" + ano + 
					"_Intra" + (this.SALTO_TICK_INTRA * 15)+ "_QtdDia" + DIAS_DIARIO + "_QtdInt" + QUANTIDADE_DIA_INTRA + ".dat";
			GeraArquivo(arq,posIniMes[i],posIniMes[i+4],TAMANHO_ENTRADAS,lista,true);
			dadoTreino.setNomeArquivoX(arq);
			dadoTreino.setUltimaAlteracao(DCConvert.getDataDD_MM_AAAA());
			dadoTreino.setTipoPeriodo("Qua");
			dadoTreino.setContadorPorAno(itemAno++);
			dadoTreino.setMinutosIntraday(this.SALTO_TICK_INTRA * 15);
			dadoTreinoSrv.insereItemLoad(dadoTreino);
			dadoTreino.setIdDadoTreino(0);
		}
		// Semestre
		itemAno = 1;
		for (int i=0;(i+5)<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Sem_" + String.format("%02d", (i+1)) + "-" + String.format("%02d", (i+6)) + "_" + ano + 
					"_Intra" + (this.SALTO_TICK_INTRA * 15)+ "_QtdDia" + DIAS_DIARIO + "_QtdInt" + QUANTIDADE_DIA_INTRA + ".dat";
			GeraArquivo(arq,posIniMes[i],posIniMes[i+6],TAMANHO_ENTRADAS,lista,true);
			dadoTreino.setNomeArquivoX(arq);
			dadoTreino.setUltimaAlteracao(DCConvert.getDataDD_MM_AAAA());
			dadoTreino.setTipoPeriodo("Sem");
			dadoTreino.setContadorPorAno(itemAno++);
			dadoTreino.setMinutosIntraday(this.SALTO_TICK_INTRA * 15);
			dadoTreinoSrv.insereItemLoad(dadoTreino);
			dadoTreino.setIdDadoTreino(0);
		}
		// Trimestre
		itemAno = 1;
		for (int i=0;(i+2)<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Tri_" + String.format("%02d", (i+1)) + "-" + String.format("%02d", (i+3)) + "_" + ano + 
					"_Intra" + (this.SALTO_TICK_INTRA * 15)+ "_QtdDia" + DIAS_DIARIO + "_QtdInt" + QUANTIDADE_DIA_INTRA + ".dat";
			GeraArquivo(arq,posIniMes[i],posIniMes[i+3],TAMANHO_ENTRADAS,lista,true);
			dadoTreino.setNomeArquivoX(arq);
			dadoTreino.setUltimaAlteracao(DCConvert.getDataDD_MM_AAAA());
			dadoTreino.setTipoPeriodo("Tri");
			dadoTreino.setContadorPorAno(itemAno++);
			dadoTreino.setMinutosIntraday(this.SALTO_TICK_INTRA * 15);
			dadoTreinoSrv.insereItemLoad(dadoTreino);
			dadoTreino.setIdDadoTreino(0);
		}
		// Mensal
		itemAno = 1;
		for (int i=0;i<12;i++) {
			arq = ARQUIVO_PATH + "Dado_Mensal_" + String.format("%02d", (i+1)) + "_" + ano + 
					"_Intra" + (this.SALTO_TICK_INTRA * 15)+ "_QtdDia" + DIAS_DIARIO + "_QtdInt" + QUANTIDADE_DIA_INTRA + ".dat";
			GeraArquivo(arq,posIniMes[i],posIniMes[i+1],TAMANHO_ENTRADAS,lista,true);
			dadoTreino.setNomeArquivoX(arq);
			dadoTreino.setTipoPeriodo("Mes");
			dadoTreino.setContadorPorAno(itemAno++);
			dadoTreino.setMinutosIntraday(this.SALTO_TICK_INTRA * 15);
			dadoTreinoSrv.insereItemLoad(dadoTreino);
			dadoTreino.setIdDadoTreino(0);
		}
		
		
		return null;
	} 
	
	
	
	/*private void GeraArquivo(String nomeArquivoX, String nomeArquivoY, int posIni, int posFim, int tamanhoAmostra, List<CotacaoProcessadaOpcaoResultado> lista, boolean valorAcao) {
		File fArquivoX = new File(nomeArquivoX);
		File fArquivoY = new File(nomeArquivoY);
		BufferedWriter outArqX = null;
		BufferedWriter outArqY = null;
		
		try {
			outArqX = new BufferedWriter(new FileWriter(fArquivoX));
			outArqY = new BufferedWriter(new FileWriter(fArquivoY));
			//for (int x=quantidade;x<lista.size();x++) {
			for (int x=posIni;x<posFim && x < lista.size();x++) {
				if (x>=tamanhoAmostra && x>(TICKER_POR_DIA * DIAS_DIARIO)) {
					String linhaEntrada = getLinha(x,tamanhoAmostra, lista, valorAcao);
					long valorY = (lista.get(x).getResultadoT50S50()==1?2:1);
					outArqX.write(linhaEntrada + "\n");
					outArqY.write(valorY + "\n");
				}
			}
			outArqX.close();
			outArqY.close();
			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	*/
	private void GeraArquivo(String nomeArquivo, int posIni, int posFim, int tamanhoAmostra, List<CotacaoProcessadaOpcaoResultado> lista, boolean valorAcao) throws DaoException {
		File fArquivo = new File(nomeArquivo);
		BufferedWriter outArq = null;
		
		CotacaoProcessadaDao daoCotacao = null;
		if (!valorAcao) {
			daoCotacao = CotacaoProcessadaRegraColecao.getDao();
			daoCotacao.setConexao(daoCotacao.criaConexao());
		}
		
		try {
			outArq = new BufferedWriter(new FileWriter(fArquivo));
			//for (int x=quantidade;x<lista.size();x++) {
			for (int x=posIni;x<posFim && x < lista.size();x++) {
				if (x>=tamanhoAmostra && x>(TICKER_POR_DIA * DIAS_DIARIO)) {
					String linhaEntrada = "";
					if (valorAcao) {
						linhaEntrada = this.getLinha(x, tamanhoAmostra, lista);
					} else {
						linhaEntrada = this.getLinhaPorOpcao(x, tamanhoAmostra, lista, daoCotacao);
					}
					long valorY = 0;
					if (lista.get(x).getResultadoT50S50()==1) {
						valorY = 1;
					}
					//if (lista.get(x).getResultadoT50S50()==-1) {
					//	valorY = 1;
					//}
					outArq.write(linhaEntrada + valorY + this.getLogResultado(lista.get(x)) + "\n");
				}
			}
			outArq.close();

			
			
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}
	
	private void GeraArquivoIndicadores(String arq, int posIni, int posFim, int saltoIntraday, List<CotacaoProcessadaOpcaoResultado> lista, int codigoTargetStop, String nomeTicker ) throws DaoException {
	
		File fArquivo = new File(arq);
		BufferedWriter outArq = null;
		
		CotacaoProcessadaDao daoCotacao = null;
		daoCotacao = CotacaoProcessadaRegraColecao.getDao();
		daoCotacao.setConexao(daoCotacao.criaConexao());

		CotacaoDiarioDao daoDiario = null;
		daoDiario = CotacaoDiarioRegraColecao.getDao();
		daoDiario.setConexao(daoDiario.criaConexao());	
		
		
		try {
			outArq = new BufferedWriter(new FileWriter(fArquivo));
			for (int x=posIni;x<posFim && x < lista.size();x++) {
				String linhaEntrada = "";
				linhaEntrada = this.getLinhaOpcaoIndicadores(nomeTicker, x, saltoIntraday, lista, daoCotacao, daoDiario);
				if (linhaEntrada!=null) {
					long valorY = -1;
					if (codigoTargetStop==Tipos.TARGET50_STOP50) {
						if (lista.get(x).getResultadoT50S50()==1) {
							valorY = 1;
						} else { 
							valorY = 0;
						}
					}
					if (codigoTargetStop==Tipos.TARGET60_STOP60) {
						if (lista.get(x).getResultadoT60S60()==1) {
							valorY = 1;
						} else { 
							valorY = 0;
						}
					}
					outArq.write(linhaEntrada + valorY + this.getLogResultado(lista.get(x)) + "\n");
				}
			}
			outArq.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	
	private String getLinhaOpcaoIndicadores(String nomeAcao, int posicao, int salto, List<CotacaoProcessadaOpcaoResultado> lista, CotacaoProcessadaDao dao, CotacaoDiarioDao daoDia )throws DaoException {
		final int MINIMO_LIMITE = 150;
		
		String saidaIntraday = null;
		CotacaoProcessadaOpcaoResultado cotacao = lista.get(posicao);
		String dataBd = DCConvert.ToDataAAAA_MM_DD(cotacao.getData());
		
		List<CotacaoProcessada> listaCotacao = dao.ListaPorQuantidadeTickerRegressiva(cotacao.getCodigoMercadoOpcao(), dataBd, cotacao.getHoraSerieTemporal(),1000);
		List<CotacaoDiario> listaCotacaoDia = daoDia.ListaPorQuantidadeTickerRegressiva(nomeAcao, dataBd,50);

		if (listaCotacao.size()>=MINIMO_LIMITE) {
			CotacaoProcessada corrente = listaCotacao.get(0);
			saidaIntraday =  getMediaMovel(listaCotacao, 150, 0) +
							" , " + getMediaMovel(listaCotacao, 135, 0) +
							" , " + getMediaMovel(listaCotacao, 120, 0) +
							" , " + getMediaMovel(listaCotacao, 105, 0) +
							" , " + getMediaMovel(listaCotacao, 90, 0) +
							" , " + getMediaMovel(listaCotacao, 75, 0) +
							" , " + getMediaMovel(listaCotacao, 60, 0) +
							" , " + getMediaMovel(listaCotacao, 45, 0) +
							" , " + getMediaMovel(listaCotacao, 30, 0) +
							" , " + getMediaMovel(listaCotacao, 15, 0) +
							" , " + corrente.getValor() + " , ";
		}
		
		return saidaIntraday;
	}
	
	private String getMediaMovel(List<CotacaoProcessada> listaCotacao, int qtde, int salto) {
		int cont = 0;
		int idx = 0;
		float total = 0;
		// Enquanto não chegou no limite de itens para a media nem no tamanho da lista
		while (cont<qtde && idx<listaCotacao.size()) {
			total += listaCotacao.get(idx).getValor();
			cont++;
			idx++;
		}
		float media = total / cont;
		DecimalFormat df = new DecimalFormat("0.00");
		return df.format(media).replace(',','.');
	}
	
	
	private String getLinhaOpcao(String nomeAcao, int posicao, int tickDiario, int tickIntraday, int salto, List<CotacaoProcessadaOpcaoResultado> lista, CotacaoProcessadaDao dao, CotacaoDiarioDao daoDia )throws DaoException {
		String saidaIntraday = "";
		CotacaoProcessadaOpcaoResultado cotacao = lista.get(posicao);
		String dataBd = DCConvert.ToDataAAAA_MM_DD(cotacao.getData());
		
		List<CotacaoProcessada> listaCotacao = dao.ListaPorQuantidadeTickerRegressiva(cotacao.getCodigoMercadoOpcao(), dataBd, cotacao.getHoraSerieTemporal(), tickIntraday);
		List<CotacaoDiario> listaCotacaoDia = daoDia.ListaPorQuantidadeTickerRegressiva(nomeAcao, dataBd, tickDiario);

		if (listaCotacao.size()!=tickIntraday || listaCotacaoDia.size()!=tickDiario) {
			return null;
		}
		for (CotacaoDiario cotDiario : listaCotacaoDia) {
			//saidaIntraday += cotDiario.getFechamentoOriginal() + "," ;
			saidaIntraday = cotDiario.getFechamentoOriginal() + "," + saidaIntraday;
		}
		int cont = 0;
		for (CotacaoProcessada cotIntra : listaCotacao) {
			if (cont % salto == 0) {
				//saidaIntraday += cotIntra.getValor() + getLog(cotIntra) + ",";
				saidaIntraday = cotIntra.getValor() + getLog(cotIntra) + "," + saidaIntraday;
			}
			cont++;
		}
		
		return saidaIntraday;
	}
	
	private String getLog(CotacaoProcessada cotacao) {
		return "";
		//return " (" + cotacao.getData() + " [" + cotacao.getHoraSerieTemporal() + "]) ";
	}
	private String getLogResultado(CotacaoProcessadaOpcaoResultado result) {
		return "";
		//return " (" + result.getCodigoMercadoOpcao() + ":" + result.getDataHoraSaidaT50S50() + " [" + 
		//		result.getValorSaidaT50S50Formatada() + "]) ";
		
	}
	
	private String getLinhaAtivo(String nomeAcao, int posicao, int tickDiario, int tickIntraday, int salto, List<CotacaoProcessadaOpcaoResultado> lista, CotacaoDiarioDao daoDia )throws DaoException {
		String saidaIntraday = "";
		CotacaoProcessadaOpcaoResultado cotacao = lista.get(posicao);
		String dataBd = DCConvert.ToDataAAAA_MM_DD(cotacao.getData());
		
		//List<CotacaoProcessada> listaCotacao = dao.ListaPorQuantidadeTickerRegressiva(cotacao.getCodigoMercadoOpcao(), dataBd, cotacao.getHoraSerieTemporal(), tickIntraday);
		List<CotacaoDiario> listaCotacaoDia = daoDia.ListaPorQuantidadeTickerRegressiva(nomeAcao, dataBd, tickDiario);

		if (listaCotacaoDia.size()!=tickDiario) {
			return null;
		}
		
		int cont = 0;
		while (cont<tickIntraday && lista.size()>cont) {
			if ((lista.size()> cont) && (cont % salto) == 0) {
				// ticker que interessa
				saidaIntraday += lista.get(cont).getValorAcao() + ",";
			}
			cont++;
		}
		for (CotacaoDiario cotDiario : listaCotacaoDia) {
			saidaIntraday += cotDiario.getFechamentoOriginal() + "," ;
		}
		return saidaIntraday;
		
	}
	
	private String getLinhaPorOpcao(int posicao, int tamanhoAmostra, List<CotacaoProcessadaOpcaoResultado> lista, CotacaoProcessadaDao dao) throws DaoException {
	
		
		String saidaIntraday = "";
		CotacaoProcessadaOpcaoResultado cotacao = lista.get(posicao);
		String dataBd = DCConvert.ToDataAAAA_MM_DD(cotacao.getData());
		List<CotacaoProcessada> listaCotacao = dao.ListaPorQuantidadeTickerRegressiva(cotacao.getCodigoMercadoOpcao(), dataBd, cotacao.getHoraSerieTemporal(), 500);
		int cont = 0;
		while (cont<tamanhoAmostra && listaCotacao.size()>cont) {
			if ((listaCotacao.size()> cont) && (cont % this.getFiltro().validaSaltoTickerIntraArquivo()) == 0) {
				// ticker que interessa
				saidaIntraday += listaCotacao.get(cont).getValor() + ",";
			}
			cont++;
		}
		return saidaIntraday;
	}
	
	private String getLinha(int posicao, int tamanhoAmostra,  List<CotacaoProcessadaOpcaoResultado> lista) {
		int inicial = posicao - tamanhoAmostra;
		String saidaIntraday = "";
		String saidaDiario = "";
		int cont = 0;
		float primeiroValor = 0;
		float multiploDez = 0;
		float multiploUm = 0;
		float valorCorrente = 0;
		float diferencaDez = 0;
		float diferencaUm = 0;
		for (int x=inicial; x<posicao ; x++) {
			if ((cont % this.getFiltro().validaSaltoTickerIntraArquivo()) == 0) {
				if (primeiroValor==0) {
					primeiroValor = lista.get(x).getValorAcao();
					multiploDez = primeiroValor % 10;
					multiploUm = primeiroValor % 1;
					diferencaDez = primeiroValor - multiploDez;
					diferencaUm = primeiroValor - multiploUm;
				}
				valorCorrente = lista.get(x).getValorAcao() - diferencaUm;
				saidaIntraday += valorCorrente + ",";
				//saidaIntraday += lista.get(x).getValorAcao() + "," + lista.get(x).getContadorDia() + ",";
			}
			cont++;
		}
		saidaDiario = getLinhaDiario(posicao,DIAS_DIARIO,lista);
		String saida = saidaIntraday + saidaDiario;
		return saida.substring(0,saida.length()-1);
	}
	
	private String getLinhaDiario(int posicao, int qtdeDia, List<CotacaoProcessadaOpcaoResultado> lista) {
		String saida = "";
		int diasCorrente = 0;
		int pos = posicao - 1;
		while (pos>=0 && diasCorrente<qtdeDia) {
			while (pos>=0 && lista.get(pos).getContadorDia()!=30) {
				pos--;
			}
			if (pos>=0 && lista.get(pos).getContadorDia()==30) {
				CotacaoProcessadaOpcaoResultado op = lista.get(pos);
				saida += (op.getValorAcao()) + ",";
				pos--;
				diasCorrente++;
			}
		}
		if (diasCorrente==qtdeDia) 
			return saida;
		else
			return "";
	}

	@Override
	public CotacaoProcessadaOpcaoResultado GeraScriptOctave(DaoConexao conexao) throws DaoException {
		String ano = getFiltro().validaAno(); 
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public CotacaoProcessadaOpcaoResultado GeraArquivoPlanilhaEstudo(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	
	

	
	
}
