package coletorjava.app;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.regracolecao.CotacaoProcessadaOpcaoResultadoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.filtro.Tipos;

public class GeradorPlanilhaOpcao {

	public void main(String[] arg) {
		try {
			geraArquivoPlanilhaEstudo();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	private void geraArquivoPlanilhaEstudo() throws DaoException {
		CotacaoProcessadaOpcaoResultadoRegraColecao srv  = FabricaRegra.getInstancia().getCotacaoProcessadaOpcaoResultadoRegraColecao();
		srv.getFiltro().setCodigoFaixa(1); // 1 - Compra,   2 - Venda.
		srv.getFiltro().setAno("2011");
		srv.getFiltro().setNomeTicker("VALE5");
		srv.getFiltro().setTipoDadoStopTarget(Tipos.TARGET50_STOP50);
		srv.GeraArquivoPlanilhaEstudo(); 
	}
}
