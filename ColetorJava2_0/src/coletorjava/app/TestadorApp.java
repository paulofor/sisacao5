package coletorjava.app;

import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaOpcaoResultadoRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.OpcaoSisacaoRegraColecao;

public class TestadorApp {

	/*
	 * Preparando os dados de opção para ITUB4 - 2015
	 * 
	 * Passo 1 - Identificar as opçoes de cada mes com dados coletados nas tabelas locais.
	 * ( com possibilidade de fazer as tabelas de 15 minutos )
	 * Passo 2 - Fazer as tabelas 15 minutos ( talvez precise de dados diários )
	 * Passo 3 - Retirar as opções que nas tabelas de 15 minutos estão com falhas ( valores zerados )
	 * Passo 4 - Para cada dia identificar qual a opção que vai ser usada como referencia para a tabela consolidade
	 * de resultados - talvez precise de um algoritmo para isso.
	 * Passo 5 - Calcular os resultados.
	 * Passo 6 - fazer as estatisticas na tabela principal
	 * Passo 7 - Criar arquivos para redes neurais
	 * 		Podem usar como referência : valor da opção, valor da ação. Se usar dados de opção a tabela consolidade
	 *      não vai ser suficiente.
	 */
	
	
	private static void criaDiarioAtivo() throws DaoException {
		obtemHistoricoDiario("01-01-2011", "BBAS3");
		obtemHistoricoDiario("01-01-2012", "BBAS3");
		obtemHistoricoDiario("01-01-2013", "BBAS3");
		obtemHistoricoDiario("01-01-2014", "BBAS3");
		obtemHistoricoDiario("01-01-2015", "BBAS3");
	}
	
	private static void criaDiario() throws DaoException {
		//obtemHistoricoDiario("01-01-2015", "BBASB23");
		obtemHistoricoDiario("01-01-2015", "BBASC21");
		obtemHistoricoDiario("01-01-2015", "BBASD24");
		obtemHistoricoDiario("01-01-2015", "BBASE22");
		obtemHistoricoDiario("01-01-2015", "BBASF26");
		obtemHistoricoDiario("01-01-2015", "BBASG28");
		obtemHistoricoDiario("01-01-2015", "BBASH24");
		obtemHistoricoDiario("01-01-2015", "BBASI23");
		obtemHistoricoDiario("01-01-2015", "BBASJ48");
		obtemHistoricoDiario("01-01-2015", "BBASK20");
		obtemHistoricoDiario("01-01-2015", "BBASL18");
		obtemHistoricoDiario("01-01-2015", "BBASA18");
	}
	
	
	private static void cria15MinutosAtivo() throws DaoException {
		gera15Minutos("01-01-2015", "31-12-2015", "BBAS3");
	}
	
	
	private static void cria15Minutos() throws DaoException {
		//OpcaoSisacaoSerieRegraColecao serieSrv = FabricaRegra.getInstancia().getOpcaoSisacaoSerieRegraColecao();
		//serieSrv.getFiltro().setAnoPesquisa(2015);
		//List<OpcaoSisacaoSerie> listaSerie = serieSrv.ListaPorAno();
		//for (OpcaoSisacaoSerie serie : listaSerie) {
		//	System.out.println(serie.getMesAno() + ":   Vcto:" + serie.getDataVencimento() +  " (" + serie.getDataInicioColeta() +  ") ");
		//	String dataInicio15 = serie.
		//}
		gera15Minutos("01-01-2015", "09-02-2015", "BBASB23");
		gera15Minutos("01-02-2015", "16-03-2015", "BBASC21");
		gera15Minutos("01-03-2015", "20-04-2015", "BBASD24");
		gera15Minutos("01-04-2015", "18-05-2015", "BBASE22");
		gera15Minutos("01-05-2015", "15-06-2015", "BBASF26");
		gera15Minutos("01-06-2015", "20-07-2015", "BBASG28");
		gera15Minutos("01-07-2015", "17-08-2015", "BBASH24");
		gera15Minutos("01-08-2015", "21-09-2015", "BBASI23");
		gera15Minutos("01-09-2015", "19-10-2015", "BBASJ48");
		gera15Minutos("01-10-2015", "16-11-2015", "BBASK20");
		gera15Minutos("01-11-2015", "21-12-2015", "BBASL18");
	}
	
	private static void gera15Minutos(String dataInicial, String dataFinal, String ticker) throws DaoException {
		CotacaoProcessadaRegraColecao cotacaoProcessadaSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		cotacaoProcessadaSrv.getFiltro().setDataInicial(dataInicial);
		cotacaoProcessadaSrv.getFiltro().setDataFinal(dataFinal);
		cotacaoProcessadaSrv.getFiltro().setNomeTicker(ticker);
		cotacaoProcessadaSrv.CriaHistorico15PorTickerPeriodo();
	}
	
	
	
	private static void obtemHistoricoDiario(String dataAno, String tickerStr) throws DaoException {
		CotacaoDiarioRegraColecao diarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
		diarioSrv.getFiltro().setData(dataAno);
		Ticker ticker = FabricaVo.criaTicker();
		ticker.setNome(tickerStr);
		diarioSrv.getFiltro().setTicker(ticker);
		diarioSrv.CorrigeAnoHistoricoTicker();
	}
	
	
	/*
	 * Passo 1.1 - Quais são as opçoes disponiveis para cada mes
	 */
	private static void exibeOpcoesAnoTicker() throws DaoException {
		String[] saida = new String[12];
		
		DiaPregaoRegraColecao diaSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		CotacaoRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoRegraColecao();
		
		OpcaoSisacaoRegraColecao opcaoSrv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		opcaoSrv.getFiltro().setCodigoTicker("BBAS3");
		for (int mes = 1; mes < 13; mes++ ) {
			String data =  "01-" + String.format("%02d", mes) + "-2015";
			opcaoSrv.getFiltro().setData(data);
			OpcaoSisacao opcao = opcaoSrv.MelhorEscolhaTickerDataVenda();
			if (opcao==null)
				saida[(mes-1)] = data + " sem opçoes.";
			else
				saida[(mes-1)] = data + " : " + opcao.getCodigoMercado();
		}
		
		for (int cont = 0;cont<12;cont++) {
			System.out.println(saida[cont]);
		}
		
		/*
		List<OpcaoSisacao> listaOpcao = opcaoSrv.ListaPorTickerMesAno();
		int cont = 0;
		for (OpcaoSisacao item : listaOpcao) {
			
			cotacaoSrv.getFiltro().setDataPesquisa("01-01-2015");
			cotacaoSrv.getFiltro().setNomeTicker(item.getCodigoMercado());
			Cotacao cotacao = cotacaoSrv.AnteriorDataPesquisaQuantidadeOpcao();
			if (cotacao!=null) {
				System.out.println((++cont) +  " - " + item.getCodigoMercado() + ":" +cotacao.getNeg() + " " + cotacao.getUlt());
			}
		}
		*/
		
		
	}
	
	
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			//exibeOpcoesAnoTicker(); // Mostra as opções de cada mes.
			//criaDiario(); // As tabelas 15 minutos não funcionam se não existir as tabelas diario.
			//cria15Minutos(); // Criando as tabelas de 15 minutos de opções.
			//criaDiarioAtivo(); // 5 anos de dados diario do ativo principal.
			//cria15MinutosAtivo();
			//criaTabelaF(); // Criar a tabela unica 15 minutos juntando as opções do ano
			//calculaRetornoVenda();
			geraArquivoRedeNeural();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}
	
	private static void geraArquivoRedeNeural() throws DaoException {
		CotacaoProcessadaOpcaoResultadoRegraColecao srv  = FabricaRegra.getInstancia().getCotacaoProcessadaOpcaoResultadoRegraColecao();
		//srv.getFiltro().setTargetArquivo(50);
		//srv.getFiltro().setStopArquivo(50);
		srv.getFiltro().setCodigoFaixa(2);
		srv.getFiltro().setIdTickerArquivo(4);
		//srv.getFiltro().setPosicaoCompraVendaArquivo("V");
		srv.getFiltro().setQuantidadeDiaIntradayArquivo(5);
		srv.getFiltro().setAno("2015");
		srv.getFiltro().setDataInicio("01-01-2015");
		srv.getFiltro().setDataFinal("29-11-2015");
		srv.getFiltro().setNomeTicker("BBAS3");
		srv.getFiltro().setSaltoTickerIntraArquivo(1);
		srv.GeraArquivoTreinoValorOpcao();
	}
	
	
	private static void calculaRetornoVenda() throws DaoException {
		//float TARGET = 0.65f, STOP = 0.60f;
		CotacaoProcessadaOpcaoResultadoRegraColecao srv = FabricaRegra.getInstancia().getCotacaoProcessadaOpcaoResultadoRegraColecao();
		srv.getFiltro().setDataInicio("01-01-2015");
		srv.getFiltro().setDataFinal("30-11-2015");
		srv.getFiltro().setCodigoFaixa(2);
		srv.getFiltro().setNomeTicker("BBAS3");
		srv.CalculaResultados();
	}
	
	
	public static void criaTabelaF() throws DaoException {
		criaTabelaFPeriodo("01-01-2015","31-01-2015","BBASB23","BBAS3");
		criaTabelaFPeriodo("01-02-2015","28-02-2015","BBASC21","BBAS3");
		criaTabelaFPeriodo("01-03-2015","31-03-2015","BBASD24","BBAS3");
		criaTabelaFPeriodo("01-04-2015","30-04-2015","BBASE22","BBAS3");
		criaTabelaFPeriodo("01-05-2015","31-05-2015","BBASF26","BBAS3");
		criaTabelaFPeriodo("01-06-2015","30-06-2015","BBASG28","BBAS3");
		criaTabelaFPeriodo("01-07-2015","31-07-2015","BBASH24","BBAS3");
		criaTabelaFPeriodo("01-08-2015","31-08-2015","BBASI23","BBAS3");
		criaTabelaFPeriodo("01-09-2015","30-09-2015","BBASJ48","BBAS3");
		criaTabelaFPeriodo("01-10-2015","31-10-2015","BBASK20","BBAS3");
		criaTabelaFPeriodo("01-11-2015","30-11-2015","BBASL18","BBAS3");
		criaTabelaFPeriodo("01-12-2015","31-12-2015","BBASA18","BBAS3");
	}
	
	
	private static void criaTabelaFPeriodo(String dataInicial, String dataFinal, String opcao, String ticker) throws DaoException {
		CotacaoProcessadaOpcaoResultadoRegraColecao srv = FabricaRegra.getInstancia().getCotacaoProcessadaOpcaoResultadoRegraColecao();
		srv.getFiltro().setDataInicio(dataInicial);
		srv.getFiltro().setDataFinal(dataFinal);
		srv.getFiltro().setNomeOpcao(opcao);
		srv.getFiltro().setNomeTicker(ticker);
		srv.GeraRegistroPorTickerPeriodoOpcao();
	}
	
	public static void testandoExcluiOpcaoTickerAnoIntradayZerado() {
		OpcaoSisacaoRegraColecao srv = FabricaRegra.getInstancia().getOpcaoSisacaoRegraColecao();
		try {
			srv.getFiltro().setCodigoTicker("ITUB4");
			srv.getFiltro().setData("01-01-2014");
			srv.ExcluiOpcaoTickerAnoIntradayZerado();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

}
