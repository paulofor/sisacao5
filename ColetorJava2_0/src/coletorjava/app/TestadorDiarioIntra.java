package coletorjava.app;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.regracolecao.CotacaoProcessadaOpcaoResultadoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.filtro.Tipos;

public class TestadorDiarioIntra {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//geraArquivoRedeNeuralMix();
			geraArquivoRedeNeuralIndicadores();
		} catch (DaoException e) {
			e.printStackTrace();
		}
	}

	
	private static void geraArquivoRedeNeuralMix() throws DaoException {
		CotacaoProcessadaOpcaoResultadoRegraColecao srv  = FabricaRegra.getInstancia().getCotacaoProcessadaOpcaoResultadoRegraColecao();
		srv.getFiltro().setCodigoFaixa(1); // 1 - Compra,   2 - Venda.
		//srv.getFiltro().setIdTickerArquivo(2); // BBAS3 = 4, VALE5 = 2
		//srv.getFiltro().setPosicaoCompraVendaArquivo("V");
		srv.getFiltro().setQuantidadeDiaIntradayArquivo(5);
		srv.getFiltro().setQuantidadeDiaDiarioArquivo(0); 
		srv.getFiltro().setAno("2011");
		//srv.getFiltro().setDataInicio("01-01-2011");
		//srv.getFiltro().setDataFinal("31-12-2011");
		srv.getFiltro().setNomeTicker("VALE5");
		srv.getFiltro().setSaltoTickerIntraArquivo(4); 
		srv.getFiltro().setTipoDadoBruto(Tipos.DADO_BRUTO);
		srv.getFiltro().setTipoDadoIntraday(Tipos.INTRADAY_SOMENTE_OPCAO);
		srv.getFiltro().setTipoDadoStopTarget(Tipos.TARGET50_STOP50);
		srv.GeraArquivoTreinoValorOpcao(); 
	}
	
	
	private static void geraArquivoRedeNeuralIndicadores() throws DaoException {
		CotacaoProcessadaOpcaoResultadoRegraColecao srv  = FabricaRegra.getInstancia().getCotacaoProcessadaOpcaoResultadoRegraColecao();
		srv.getFiltro().setCodigoFaixa(1); // 1 - Compra,   2 - Venda.
		//srv.getFiltro().setQuantidadeDiaIntradayArquivo(5);
		//srv.getFiltro().setQuantidadeDiaDiarioArquivo(0); 
		srv.getFiltro().setAno("2011");
		srv.getFiltro().setNomeTicker("VALE5");
		srv.getFiltro().setSaltoTickerIntraArquivo(4); 
		//srv.getFiltro().setTipoDadoBruto(Tipos.DADO_BRUTO);
		//srv.getFiltro().setTipoDadoIntraday(Tipos.INTRADAY_SOMENTE_OPCAO);
		srv.getFiltro().setTipoDadoStopTarget(Tipos.TARGET50_STOP50);
		srv.GeraArquivoTreinoOpcaoIndicadores(); 
	}
}
