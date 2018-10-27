package coletorjava.regracolecao.impl;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.CotacaoProcessadaDao;
import coletorjava.log.ArquivoLog;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.modelo.PeriodoPregao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoGeralRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;
import coletorjava.regracolecao.PeriodoPregaoRegraColecao;
import coletorjava.regracolecao.custom.calcprocessadas.MontadorPontos;

public class CotacaoProcessadaRegraColecaoImpl extends CotacaoProcessadaRegraColecao {

	CotacaoRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoRegraColecao();
	
	@Override
	public List<CotacaoProcessada> MontaDiaTicker(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaNomeTicker();
		this.getFiltro().validaDiaPregao();
		
		cotacaoSrv.getFiltro().setNomeTicker(this.getFiltro().getNomeTicker());
		cotacaoSrv.getFiltro().setDataPesquisa(this.getFiltro().getDiaPregao());
		List<Cotacao> listaCotacao = null;
		if (this.getFiltro().getNomeTicker().length()==5)
			listaCotacao = cotacaoSrv.ListaPorDataTicker();
		else
			listaCotacao = cotacaoSrv.ListaPorDataTickerOpcao();
		
		PeriodoPregaoRegraColecao periodoSrv = FabricaRegra.getInstancia().getPeriodoPregaoRegraColecao();
		periodoSrv.getFiltro().setDataPesquisa(this.getFiltro().getDiaPregao());
		PeriodoPregao periodo = periodoSrv.PesquisaPorDia();
		
		MontadorPontos montador = new MontadorPontos();
		List<CotacaoProcessada> listaSaida = 
				montador.montaCotacaoProcessada(this.getFiltro().getDiaPregao(), periodo, listaCotacao, this.getFiltro().getNomeTicker());
		try {
			geraLogs(this.getFiltro().getDiaPregao(),listaSaida,listaCotacao);
			//insereLista(this.getFiltro().getNomeTicker(), listaSaida, conexao);
		} catch (IOException e) {
			e.printStackTrace();
		}
		return listaSaida;
	}
	
	
	
	
	@Override
	public CotacaoProcessada InsereListaBase(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaNomeTicker();
		CotacaoProcessadaDao dao = getDao(conexao);
		List<CotacaoProcessada> listaItem = this.getListaEntradaItem();
		String nomeTicker = this.getFiltro().getNomeTicker();
		dao.CriaTabela(nomeTicker);
		for (CotacaoProcessada cotacao : listaItem) {
			dao.insereOuAtualiza(cotacao,nomeTicker);
		}
		return null;
	}




	private void geraLogs(String diaPregao, List<CotacaoProcessada> listaSaida, List<Cotacao> listaCotacao) throws IOException {
		String nomeArquivo = "D:/Sisacao/Logs/" + diaPregao + "-Bruta.log";
		File arq = new File(nomeArquivo);
		BufferedWriter output = new BufferedWriter(new FileWriter(arq));
		for (Cotacao cotacao : listaCotacao) {
			output.write(cotacao.getLinhaLog());
			output.write(System.lineSeparator());
		}
        output.close();
        nomeArquivo = "D:/Sisacao/Logs/" + diaPregao + "-Processada.log";
		arq = new File(nomeArquivo);
		output = new BufferedWriter(new FileWriter(arq));
		for (CotacaoProcessada cotacao : listaSaida) {
			output.write(cotacao.getLinhaLog());
			output.write(System.lineSeparator());
		}
        output.close();
	}



	@Override
	public CotacaoProcessada CriaHistorico15PorTickerPeriodo(DaoConexao conexao) throws DaoException {
		getFiltro().validaDataInicial();
		getFiltro().validaDataFinal();
		getFiltro().validaNomeTicker();
		String dataInicial = getFiltro().getDataInicial();
		String dataFinal = getFiltro().getDataFinal();
		String ticker = getFiltro().getNomeTicker();
		
		DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		diaPregaoSrv.getFiltro().setDataInicialPesquisa(dataInicial);
		diaPregaoSrv.getFiltro().setDataFinalPesquisa(dataFinal);

		this.getFiltro().setIntervaloTick(15);
		List<DiaPregao> dias = diaPregaoSrv.ListaPorData(conexao);
		
		
		
		for (DiaPregao dia : dias) {
			if (!dia.getFeriado()) {
				this.getFiltro().setNomeTicker(ticker);
				this.getFiltro().setDiaPregao(dia.getData());
				List<CotacaoProcessada> listaProcessada = MontaDiaTicker(conexao);
				this.setListaEntradaItem(listaProcessada);
				InsereListaBase(conexao);
			}
		}
		return null;
	}

	@Override
	public List<CotacaoProcessada> CalculaHorariosTick(DaoConexao conexao) throws DaoException {
		// TODO Auto-generated method stub
		List<CotacaoProcessada> saida = null;
		getFiltro().validaDiaPregao();
		String dataTrabalho = getFiltro().getDiaPregao();
		getFiltro().validaIntervaloTick();
		int intervaloTempo = (int) getFiltro().getIntervaloTick();
		int intervaloFinal = 20;
		
		PeriodoPregaoRegraColecao periodoRC = FabricaRegra.getInstancia().getPeriodoPregaoRegraColecao();
		periodoRC.getFiltro().setDataPesquisa(dataTrabalho);
		PeriodoPregao periodo = periodoRC.PesquisaPorDia();
		
		
		if (periodo == null) {
			System.out.println("dia:" + dataTrabalho + " nao encontrado referencia de horario em PeriodoPregao.");
		} else {
			saida = tempos(periodo.getHoraInicio(), periodo.getHoraTermino(), intervaloTempo, intervaloFinal);
		}
		return saida;
	}

	private ArrayList tempos(String horarioInicial, String horarioFinal, int intervaloTempo, int intervalorFinal) {
		int contador = 1;
		ArrayList tempoSaida = new ArrayList();
		Calendar dataCorrente = converteStringParaData(horarioInicial);
		tempoSaida.add(converteData(dataCorrente, contador++));
		Calendar dataFinal = converteStringParaData(horarioFinal);
		dataFinal.add(13, -1);
		while (dataCorrente.before(dataFinal)) {
			//System.out.println("Corrente=" + DatasUtils.exibe(dataCorrente.getTime()));
			//System.out.println("Final=" + DatasUtils.exibe(dataFinal.getTime()));
			dataCorrente.add(12, intervaloTempo);
			tempoSaida.add(converteData(dataCorrente, contador++));
		}
		dataCorrente.add(12, intervalorFinal);
		tempoSaida.add(converteData(dataCorrente, contador++));
		return tempoSaida;
	}

	private Calendar converteStringParaData(String horario) {
		Calendar data = Calendar.getInstance();
		int hora = Integer.parseInt(horario.substring(0, 2));
		int minuto = Integer.parseInt(horario.substring(3, 5));
		data.set(0, 0, 0, hora, minuto, 0);
		return data;
	}

	private String converteDataParaString(Calendar data) {
		String horaStr = "" +data.get(11);
		String minutoStr = "" + data.get(12);
		if (horaStr.length() < 2)
			horaStr = "0" + horaStr;
		if (minutoStr.length() < 2)
			minutoStr = "0" + minutoStr;
		return horaStr + ":" + minutoStr + ":00";
	}

	private CotacaoProcessada converteData(Calendar data, int contador) {
		CotacaoProcessada cotacaoP = FabricaVo.criaCotacaoProcessada();
		cotacaoP.setHoraSerieTemporal(converteDataParaString(data));
		cotacaoP.setContadorDia(contador);
		return cotacaoP;
	}




	@Override
	public CotacaoProcessada CriaHistorico15OpcaoPorTickerPeriodo(DaoConexao conexao) throws DaoException {
		String dataInicial = getFiltro().validaDataInicial();
		String dataFinal = getFiltro().validaDataFinal();
		String ticker = getFiltro().validaNomeTicker();
		
		DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		diaPregaoSrv.getFiltro().setDataInicialPesquisa(dataInicial);
		diaPregaoSrv.getFiltro().setDataFinalPesquisa(dataFinal);

		this.getFiltro().setIntervaloTick(15);
		List<DiaPregao> dias = diaPregaoSrv.ListaPorData(conexao);
		
		OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		
		for (DiaPregao dia : dias) {
			if (!dia.getFeriado()) {
				opcaoSrv.getFiltro().setData(dia.getData());
				opcaoSrv.getFiltro().setCodigoTicker(ticker);
				
				List<OpcaoSisacao> listaOpcao = opcaoSrv.Lista15MinutosPorDataTicker(conexao);
				for (OpcaoSisacao opcao : listaOpcao) {
					System.out.println("delete from " + opcao.getCodigoMercado() + "_15 where data >= '" + DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(dia.getData())+ "';" );
				}
				System.out.println(dia.getData());
				for (OpcaoSisacao opcao : listaOpcao) {
					System.out.println(opcao.getCodigoMercado());
					if ("ITUBB34".equals(opcao.getCodigoMercado()) && "30-01-2013".equals(dia.getData())) {
						System.out.println("Opcao");
					}
					if (opcao.getCodigoMercado().charAt(opcao.getCodigoMercado().length()-1)!='E') {
						this.getFiltro().setNomeTicker(opcao.getCodigoMercado());
						this.getFiltro().setDiaPregao(dia.getData());
						List<CotacaoProcessada> listaProcessada = MontaDiaTicker(conexao);
						this.setListaEntradaItem(listaProcessada);
						InsereListaBase(conexao);
					}
				}
			}
		}
		return null;
	}

	
	private String converteParaAnoMes(String dataNormal) {
		// DD-MM-AAAA
		// 0123456789
		String saida = "01-" + dataNormal.substring(3);
		return saida;
	}




	@Override
	public List<CotacaoProcessada> ListaPorDataTicker(DaoConexao conexao) throws DaoException {
		String data = this.getFiltro().validaDiaPregao();
		String ticker = this.getFiltro().validaNomeTicker();
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		return getDao(conexao).ListaPorDataTicker(dataBd,ticker);
	}




	@Override
	public CotacaoProcessada VerificadorOpcao15PorPeriodoTicker(DaoConexao conexao) throws DaoException {
		String dataInicial = this.getFiltro().validaDataInicial();
		String dataFinal = this.getFiltro().validaDataFinal();
		String ticker = this.getFiltro().validaNomeTicker();
		
		DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		diaPregaoSrv.getFiltro().setDataInicialPesquisa(dataInicial);
		diaPregaoSrv.getFiltro().setDataFinalPesquisa(dataFinal);
		List<DiaPregao> dias = diaPregaoSrv.ListaPorData(conexao);
		
		OpcaoSisacaoGeralRegraColecao opcaoGeralSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		opcaoGeralSrv.getFiltro().setCodigoTicker(ticker);
		
		for (DiaPregao dia : dias) {
			if (!dia.getFeriado()) {
				System.out.println(dia.getData());
				opcaoGeralSrv.getFiltro().setData(dia.getData());
				List<OpcaoSisacaoGeral> listaColeta = opcaoGeralSrv.Lista15MinutosPorDataTicker(conexao);

				for (OpcaoSisacaoGeral opcao : listaColeta) {
					System.out.println(opcao.getCodigoMercado());
					this.getFiltro().setDiaPregao(dia.getData());
					this.getFiltro().setNomeTicker(opcao.getCodigoMercado());
					List<CotacaoProcessada> cotacoes = this.ListaPorDataTicker();
					System.out.println("Cotacoes:" + cotacoes.size());
					if (cotacoes.size() < 30 || cotacoes.size() > 32) {
						ArquivoLog.getInstancia().salvaLog(dia.getData() + "[" + opcao.getCodigoMercado() + "] " + cotacoes.size());
					}
				}
			}
		}
		return null;
	}




	@Override
	public List<CotacaoProcessada> AnteriorDataPesquisaQuantidadeOpcao(DaoConexao conexao) throws DaoException {
		String data =  DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().validaDataPesquisa());
		String ticker = this.getFiltro().validaNomeTicker();
		int QUANTIDADE = 1;
		CotacaoProcessadaDao dao = getDao(conexao);
		return dao.AnteriorDataPesquisaQuantidadeOpcao(data,ticker,QUANTIDADE);
	}




	@Override
	public List<CotacaoProcessada> ListaPorPeriodoTicker(DaoConexao conexao) throws DaoException {
		String dataIniBd = DCConvert.ToDataAAAA_MM_DD(this.getFiltro().validaDataInicial());
		String dataFimBd = DCConvert.ToDataAAAA_MM_DD(this.getFiltro().validaDataFinal());
		String ticker = this.getFiltro().validaNomeTicker();
		List<CotacaoProcessada> saida = null;
		CotacaoProcessadaDao dao = getDao(conexao);
		saida = dao.ListaPorPeriodoTicker(dataIniBd,dataFimBd,ticker);
		return saida;
	}




	@Override
	public List<CotacaoProcessada> ListaHorarios15Minutos(DaoConexao conexao) throws DaoException {
		return getListaHorario();
	}
	
	



	private List<CotacaoProcessada> getListaHorario() {
		List<CotacaoProcessada> lista = new ArrayList<CotacaoProcessada>(); 
		CotacaoProcessada cotacao = null;
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("10:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("10:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("11:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("11:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("11:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("11:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("12:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("12:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("12:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("12:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("13:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("13:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("13:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("13:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("14:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("14:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("14:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("15:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("15:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("15:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("15:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("16:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("16:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("16:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("16:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("17:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("17:15:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("17:30:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("17:45:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("18:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("18:20:00");
		lista.add(cotacao);
		return lista;
	}

	
	private List<CotacaoProcessada> getListaHorario2() {
		List<CotacaoProcessada> lista = new ArrayList<CotacaoProcessada>(); 
		CotacaoProcessada cotacao = null;
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:35:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:38:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:40:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:42:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:44:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:46:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:48:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:50:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:52:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:54:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:56:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("20:58:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("21:00:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("21:02:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("21:04:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("21:06:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("21:08:00");
		lista.add(cotacao);
		cotacao = FabricaVo.criaCotacaoProcessada();
		cotacao.setHoraSerieTemporal("21:10:00");
		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("15:15:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("15:30:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("15:45:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("16:00:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("16:15:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("16:30:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("16:45:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("17:00:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("17:15:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("17:30:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("17:45:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("18:00:00");
//		lista.add(cotacao);
//		cotacao = FabricaVo.criaCotacaoProcessada();
//		cotacao.setHoraSerieTemporal("18:20:00");
//		lista.add(cotacao);
		return lista;
	}


	@Override
	public CotacaoProcessada InsereItemOnline(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao(conexao);
		CotacaoProcessada cotacao = this.getFiltro().validaCotacaoInsercao();
		String nomeTicker = this.getFiltro().validaNomeTicker();
		dao.insereItem(cotacao, nomeTicker);
		return cotacao;
	}




	@Override
	public CotacaoProcessada CriaObjetoOnline(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao(conexao);
		String nomeTicker = this.getFiltro().validaNomeTicker();
		dao.CriaTabela(nomeTicker);
		return null;
	}






	

	
}
