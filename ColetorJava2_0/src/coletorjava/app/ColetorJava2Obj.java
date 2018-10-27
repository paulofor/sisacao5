package coletorjava.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoGeralRegraColecao;

public class ColetorJava2Obj {

	//public final static String NOME_ARQUIVO_BDI = "D:/CotacaoJava/download/BDIN";
	public final static String NOME_ARQUIVO_BDI ="W:/download/BDIN";
	OpcaoSisacaoGeralRegraColecao servico = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
	DiaPregaoRegraColecao diaPregaoSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
	CotacaoDiarioRegraColecao cotacaoDiarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
	
	
	public void executa() {
		servico.getFiltro().setNomeCompletoArquivoBDI(NOME_ARQUIVO_BDI);
		try {
			List<OpcaoSisacaoGeral> listaDia = servico.LeArquivoBDI();
			servico.setListaEntradaItem(listaDia);
			servico.AtualizaLista();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		
	}
	
	public void verificador15MinutosOpcoes() {
		CotacaoProcessadaRegraColecao servico = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		servico.getFiltro().setDataInicial("01-12-2013");
		servico.getFiltro().setDataFinal("31-12-2014");
		servico.getFiltro().setNomeTicker("BBDC4");
		try {
			servico.VerificadorOpcao15PorPeriodoTicker();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	public void verificarSeAconteceuColetaIntraday(String dataBd, String dataInicial, String dataFinal, String ticker) {
		OpcaoSisacaoGeralRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		CotacaoRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoRegraColecao();
		cotacaoSrv.getFiltro().setDataInicial(dataInicial);
		cotacaoSrv.getFiltro().setDataFinal(dataFinal);
		try {
			opcaoSrv.getFiltro().setCodigoTicker(ticker);
			opcaoSrv.getFiltro().setMesAno(dataBd);
			List<OpcaoSisacaoGeral> lista  = opcaoSrv.ListaPorMesAnoCodigoTicker();
			List<Cotacao> cotacaoIntra = null;
			cotacaoSrv.getFiltro().setNomeTicker(ticker);
			for (OpcaoSisacaoGeral opcao : lista) {
				if (opcao.getPossui15minutos()) {
					cotacaoSrv.getFiltro().setNomeTicker(opcao.getCodigoMercado());
					try {
						cotacaoIntra = cotacaoSrv.ListaPorPeriodoTickerOpcao();
						if (cotacaoIntra.size()>0) {
							System.out.println(opcao.getCodigoMercado() + " tem intraday");
							opcao.setPossuiColetaIntraday(true);
							opcaoSrv.alteraItem(opcao);
						}
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	public void criarOpcoesParaColeta(String data, String ticker) {
		OpcaoSisacaoGeralRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoGeralRegraColecao();
		//opcaoSrv.getFiltro().setData("20-09-2009");
		opcaoSrv.getFiltro().setData(data);
		opcaoSrv.getFiltro().setCodigoTicker(ticker);
		try {
			List<OpcaoSisacaoGeral> lista = opcaoSrv.SelecionarParaColetaPorDataTicker();
			for (OpcaoSisacaoGeral opcao : lista) {
				// BBDCG40E
				// 0123456789 -> tam = 8
				String ultCar = opcao.getCodigoMercado().substring(opcao.getCodigoMercado().length()-1);
				if (!"E".equals(ultCar)) {
					System.out.println("15 Minutos para " + opcao.getCodigoMercado());
					opcao.setPossui15minutos(true);
					opcaoSrv.alteraItem(opcao);
				}
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	
	public void criaHistoricoOpcao15(String nomeTicker, String mesAnoInicial, String mesAnoFinal) {
		CotacaoProcessadaRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		cotacaoSrv.getFiltro().setDataInicial(mesAnoInicial);
		cotacaoSrv.getFiltro().setDataFinal(mesAnoFinal);
		cotacaoSrv.getFiltro().setNomeTicker(nomeTicker);
		try {
			cotacaoSrv.CriaHistorico15OpcaoPorTickerPeriodo();
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void obtemNovas() {
		try {
			servico.ExtraiOpcoesParaColeta();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	
	public void corrigeTodasOpcoesDiarioAno(String ano) {
		try {
			this.cotacaoDiarioSrv.getFiltro().setData("01-01-" + ano);
			this.cotacaoDiarioSrv.CorrigeAnoHistoricoOpcaoGeral();
		} catch (DaoException e) {
			System.out.println(e.getMessage());
			e.printStackTrace();
		}
	}
	
	
	public void corrigeDiasSemCotacaoDiario(String ativo, String ano) {
		// Nao permite duplicacao.
		try {
			this.cotacaoDiarioSrv.getFiltro().setData("01-01-" + ano);
			Ticker ticker = FabricaVo.criaTicker();
			ticker.setNome(ativo);
			this.cotacaoDiarioSrv.getFiltro().setTicker(ticker);
			System.out.println("Corrigindo " + ativo + " no ano de: " + ano);
			this.cotacaoDiarioSrv.CorrigeAnoHistoricoTicker();
			System.out.println("Correção concluída.");
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	public void exibeDiasSemCotacaoDiario(String ticker, String ano) {
		try {
			this.diaPregaoSrv.getFiltro().setDataInicialPesquisa("01-01-" + ano);
			this.diaPregaoSrv.getFiltro().setDataFinalPesquisa("31-12-" + ano);
			this.diaPregaoSrv.getFiltro().setNomeTicker(ticker);
			List<DiaPregao> lista = this.diaPregaoSrv.ListaSemCotacaoDiarioPorTickerData();
			exibeDatas(lista);
		} catch (Exception e){
			e.printStackTrace();
		}
	}
	
	private void exibeDatas(List<DiaPregao> lista) {
		System.out.println("Total de dias sem cotação diario: " + lista.size());
		for (DiaPregao dia : lista) {
			System.out.println(dia.getData());
		}
	}

	public void verificarIntraday(String ticker, String ano) {
		CotacaoProcessadaRegraColecao srv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		String dataInicial = "01-01-" + ano;
		String dataFinal = "31-12-" + ano;
		srv.getFiltro().setDataInicial(dataInicial);
		srv.getFiltro().setDataFinal(dataFinal);
		srv.getFiltro().setNomeTicker(ticker);
		try {
			srv.CriaHistorico15PorTickerPeriodo();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	public void verificaSplits() {
		Ticker tickerObj = FabricaVo.criaTicker();
		tickerObj.setNome("ITUB4");
		CotacaoDiarioRegraColecao srv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
		try {
			for (int ano = 2008;ano<=2013;ano++) {
				System.out.println("Ano: " + ano);
				srv.getFiltro().setAno(String.valueOf(ano));
				srv.getFiltro().setTicker(tickerObj);
				List<CotacaoDiario> listaItens = srv.IdentificadorSplitAno();
				for (CotacaoDiario cotacao : listaItens) {
					System.out.println(cotacao.getData() + " " + cotacao.getFechamentoOriginalFormatada()); 
				}
			}
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	

	
}
