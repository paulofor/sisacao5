package coletorjava.regracolecao.impl;


import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.CotacaoDiarioDao;
import coletorjava.dao.CotacaoDiarioTabelaUnicaDao;
import coletorjava.dao.DBB;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.modelo.Ticker;
import coletorjava.modelo.comparador.CotacaoDiarioComparador;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoGeralRegraColecao;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;


public  class CotacaoDiarioRegraColecaoImpl  extends CotacaoDiarioRegraColecao { 
	public CotacaoDiario CotacaoMaisRecentePorTicker( DaoConexao conexao )  throws  DaoException{
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		Ticker ticker = this.getFiltro().getTicker();
		if (ticker==null || ticker.getNome()==null) {
			throw new RuntimeException("Ticker(ou nome_ticker) est� nulo");
		}
		CotacaoDiario cotacao = dao.ObtemMaisRecentePorTicker(ticker.getNome());
		return cotacao;
	}

	@Override
	public CotacaoDiario ObtemPorNomeTickerData(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaData();
		this.getFiltro().validaTicker();
		CotacaoDiarioDao dao = getDao(conexao);
		String data = this.getFiltro().getData();
		Ticker ticker = this.getFiltro().getTicker();
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		CotacaoDiario cotacao = dao.ObtemPorNomeTickerData(dataBd,ticker.getNome());
		return cotacao;
	}

	@Override
	public CotacaoDiario CorrigeAnoHistoricoTicker(DaoConexao conexao)
			throws DaoException {
		String data = this.getFiltro().getData();
		Ticker ticker = this.getFiltro().getTicker();
		if (data==null) {
			throw new RuntimeException("Data est� null");
		}
		if (ticker==null || ticker.getNome()==null) {
			throw new RuntimeException("Ticker(ou nome_ticker) est� nulo");
		}
		try {
			List<CotacaoDiario> listaCotacao = leArquivoHistorico(this.nomeArquivoHistorico(data),ticker);
			Collections.sort(listaCotacao, new CotacaoDiarioComparador());
			CotacaoDiarioDao dao = getDao(conexao);
			dao.CriaTabela(ticker.getNome());
			for (CotacaoDiario cotacao : listaCotacao) {
				preencheCorrigido(cotacao);
				dao.insereSeNaoExiste(cotacao);
				System.out.println(cotacao.getData());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
	private List<CotacaoDiario> leArquivoHistorico(String nome, Ticker ticker) throws IOException {
		List<CotacaoDiario> saida = new ArrayList<CotacaoDiario>();
		File arquivo = new File(nome);
		BufferedReader reader = null;
		reader = new BufferedReader(new FileReader(arquivo));
		String linha = reader.readLine();
		while ((linha = reader.readLine()) != null) {
			CotacaoDiario cotacao = FabricaVo.criaCotacaoDiario();
			cotacao.setLinhaArquivoHistorico(linha);
			if (cotacao.getLinhaArquivoHistorico() != null && 
					ticker.getNome().compareToIgnoreCase(cotacao.getNomeTicker())==0) {
				saida.add(cotacao);
			}
		}
		reader.close();
		return saida;
	}
	
	private void preencheCorrigido(CotacaoDiario cotacao) {
		cotacao.setAberturaCorrigido(cotacao.getAberturaOriginal());
		cotacao.setFechamentoCorrigido(cotacao.getFechamentoOriginal());
		cotacao.setMaximoCorrigido(cotacao.getMaximoOriginal());
		cotacao.setMinimoCorrigido(cotacao.getMinimoOriginal());
	}
	
	
	     
	     
	private String nomeArquivoHistorico(String data) {
		// dd-mm-aaaa
		// 0123456789
		String ano = data.substring(6);
		return "D:/CotacaoJava/historico/COTAHIST_A" + ano + ".txt";
	}

	
	@Override
	public CotacaoDiario CorrigeAnoHistoricoOpcaoGeral(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaData();
		List<CotacaoDiario> listaParaAno = this.HistoricoCompletoTodasOpcaoAno(conexao);
		OpcaoSisacaoGeralRegraColecao opcaoGeralSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		for (CotacaoDiario cotacao : listaParaAno) {
			this.getFiltro().setItem(cotacao);
			this.InsereSeNaoExisteOpcao(conexao);
			opcaoGeralSrv.getFiltro().setCotacaoDiario(cotacao);
			opcaoGeralSrv.RegistrarPorCotacaoDiario(conexao);
		}
		return null;
	}
	
	@Override
	public List<CotacaoDiario> HistoricoCompletoTodasOpcaoAno(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaData();
		List<CotacaoDiario> saida = new ArrayList<CotacaoDiario>();
		try {
			File arquivo = new File(nomeArquivoHistorico(this.getFiltro().getData()));
			BufferedReader reader = null;
			reader = new BufferedReader(new FileReader(arquivo));
			String linha = reader.readLine();
			while ((linha = reader.readLine()) != null) {
				CotacaoDiario cotacao = FabricaVo.criaCotacaoDiario();
				cotacao.setLinhaArquivoHistorico(linha);
				if (cotacao.getLinhaArquivoHistorico() != null ) {
					if (cotacao.getEhOpcao())
						saida.add(cotacao);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return saida;
	}

	@Override
	public CotacaoDiario InsereSeNaoExisteOpcao(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaItem();
		CotacaoDiario cotacao = this.getFiltro().getItem();
		CotacaoDiarioDao dao = getDao(conexao);
		try {
			dao.insereSeNaoExiste(cotacao);
		} catch (DaoException e) {
			dao.CriaTabela(cotacao.getNomeTicker());
			dao.insereSeNaoExiste(cotacao);
		}
		return cotacao;
	}

	@Override
	public List<CotacaoDiario> IdentificadorSplitAno(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaAno();
		this.getFiltro().validaTicker();
		List<CotacaoDiario> saida = new ArrayList<CotacaoDiario>();
		List<CotacaoDiario> completa = this.ListaPorAnoTicker(conexao);
		CotacaoDiario cotacaoAnterior = null;
		for (CotacaoDiario atual : completa) {
			if (cotacaoAnterior==null) {
				cotacaoAnterior = atual;
			} else {
				if (atual.getFechamentoCorrigido() > (cotacaoAnterior.getFechamentoCorrigido() * 1.1) ||
						atual.getFechamentoCorrigido() < (cotacaoAnterior.getFechamentoCorrigido() * 0.9)) {
					saida.add(cotacaoAnterior);
					saida.add(atual);
				}
			}
			cotacaoAnterior = atual;
		}
		return saida;
	}

	@Override
	public List<CotacaoDiario> ListaPorAnoTicker(DaoConexao conexao) throws DaoException {
		this.getFiltro().validaAno();
		this.getFiltro().validaTicker();
		String dataInicialBd = this.getFiltro().getAno() + "-01-01";
		String dataFinalBd = this.getFiltro().getAno() + "-12-31";
		String nomeTicker = this.getFiltro().getTicker().getNome();
		CotacaoDiarioDao dao = getDao(conexao);
		List<CotacaoDiario> listaSaida = dao.ListaPorDatasTicker(dataInicialBd, dataFinalBd, nomeTicker);
		return listaSaida;
	}

	@Override
	public List<CotacaoDiario> MelhoresPorNegocioDiaAnteriorTicker(DaoConexao conexao) throws DaoException {
		List<CotacaoDiario> saida = new ArrayList<CotacaoDiario>();
		this.getFiltro().validaMesAnoPesquisa();
		this.getFiltro().validaCodigoTicker();
		String codigoTicker = this.getFiltro().getCodigoTicker();
		String mesAnoPesquisa = this.getFiltro().getMesAnoPesquisa();
		OpcaoSisacaoGeralRegraColecao opcaoGeralSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		// Vencimento no mes seguinte
		String proximoMes = proximoMesAno(mesAnoPesquisa);
		opcaoGeralSrv.getFiltro().setMesAno(proximoMes);
		opcaoGeralSrv.getFiltro().setCodigoTicker(codigoTicker);
		List<OpcaoSisacaoGeral> listaOpcao = opcaoGeralSrv.ListaPorMesAnoCodigoTicker(conexao);
		// Verificar a cotacao diario no dia anterior de pregao.
		DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		diaPregaoSrv.getFiltro().setDiasDeslocamento(-1);
		diaPregaoSrv.getFiltro().setDataDeslocamento(mesAnoPesquisa);
		DiaPregao diaAnterior = diaPregaoSrv.DeslocaDias(conexao);
		
		CotacaoDiarioRegraColecao diarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
		diarioSrv.getFiltro().setData(diaAnterior.getData());
		for (OpcaoSisacaoGeral opcao : listaOpcao) {
			diarioSrv.getFiltro().setCodigoTicker(opcao.getCodigoMercado());
			CotacaoDiario cotacao = diarioSrv.ObtemPorNomeTickerData();
			if (cotacao!=null) {
				saida.add(cotacao);
			}
		}
		ordenaSaida(saida);
		return saida;
	}
	
	
	
	private void ordenaSaida(List<CotacaoDiario> saida) {
		
		
	}

	private String proximoMesAno(String mesAno) {
		// 01-MM-AAAA
		// 0123456789
		String mes = mesAno.substring(3,5);
		String ano = mesAno.substring(6);
		int mesNum = Integer.parseInt(mes);
		int anoNum = Integer.parseInt(ano);
		mesNum++;
		if (mesNum==13) {
			mesNum = 1;
			anoNum++;
		} 
		String mesStr = String.format("%02d", mesNum);
		String dataSaida = "01-" + mesStr + "-" + anoNum;
		return dataSaida;
	}

	@Override
	public CotacaoDiario ObtemPorNomeTickerAnteriorData(DaoConexao conexao) throws DaoException {
		String data = getFiltro().validaData();
		String ticker = getFiltro().getCodigoTicker();
		data = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(data);
		CotacaoDiarioDao dao = getDao(conexao);
		CotacaoDiario cotacao = dao.ObtemPorNomeTickerAnteriorData(data,ticker);
		return cotacao;
	}

	@Override
	public CotacaoDiario CorrigeAnoHistoricoOpcaoPorTicker(DaoConexao conexao) throws DaoException {
		String ticker = this.getFiltro().getCodigoTicker();
		this.getFiltro().validaData();
		List<CotacaoDiario> listaParaAno = this.HistoricoCompletoTodasOpcaoAno(conexao);
		OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		for (CotacaoDiario cotacao : listaParaAno) {
			if (ticker.substring(0,4).equalsIgnoreCase(cotacao.getNomeTicker().substring(0,4))) {
				System.out.println(cotacao.getNomeTicker()  + " " + getFiltro().getData());
				opcaoSrv.getFiltro().setCodigoTicker(cotacao.getNomeTicker());
				opcaoSrv.getFiltro().setData(this.getFiltro().validaData());
				OpcaoSisacao op = opcaoSrv.ObtemPorCodigoMercadoAno();
				if (op!=null) {
					System.out.println("Encontrou");
					this.getFiltro().setItem(cotacao);
					this.InsereSeNaoExisteOpcao();
				}
				//opcaoGeralSrv.getFiltro().setCotacaoDiario(cotacao);
				//opcaoGeralSrv.RegistrarPorCotacaoDiario(conexao);
			}
		}
		return null;
	}

	@Override
	public CotacaoDiario ExtraiLinhaArquivoDiario(DaoConexao conexao) throws DaoException {
		CotacaoDiario cotacao = FabricaVo.criaCotacaoDiario();
		cotacao.setLinhaArquivoDiario(getFiltro().getLinhaArquivoDiario());
		return cotacao;
	}

	@Override
	public void InsereListaAcao() throws DaoException {
		
		CotacaoDiarioTabelaUnicaDao dao = DBB.getInstancia().getCotacaoDiarioTabelaUnicaDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Collection<CotacaoDiario> listaCotacao = this.getListaEntradaItem();
		for (CotacaoDiario cotacao : listaCotacao) {
			try {
				dao.insereDiarioAcao(cotacao);
			} catch(DaoException e) {
				e.printStackTrace();
			}
			
		}
		conexao.fechaConexao();
	}

	
}
