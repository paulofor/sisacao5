package sisacao.intraday.coletor.thread;

import br.com.digicom.lib.dao.DaoException;
import sisacao.intraday.coletor.agregador.AgregadorThreadMercadoBitcoin;

public class ThreadPrincipalMercadoBitcoin extends ThreadPaiBase{

	private AgregadorThreadMercadoBitcoin agregador = new AgregadorThreadMercadoBitcoin();

	@Override
	protected void mudouDiaColetores(String novoDia) throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	protected void mudouDia(String paramString1, String paramString2, boolean paramBoolean) throws DaoException {
		// TODO Auto-generated method stub
		
	}

}
