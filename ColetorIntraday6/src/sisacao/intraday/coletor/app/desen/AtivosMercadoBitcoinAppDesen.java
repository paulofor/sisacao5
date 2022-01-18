package sisacao.intraday.coletor.app.desen;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.intraday.coletor.parse.callback.AtivosMercadoBitcoinCallback;
import sisacao.intraday.coletor.parse.dados.AtivosMercadoBitcoinDados;

public class AtivosMercadoBitcoinAppDesen {

	
	private static ExecutadorParseApache2 executadorParse = new ExecutadorParseApache2();
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ICallbackParse callback = new AtivosMercadoBitcoinCallback();
		IDadosParse manipulador = new AtivosMercadoBitcoinDados();
		executadorParse.setCallbackParse(callback);
		executadorParse.setDadosParse(manipulador);
		try {
			executadorParse.executa();
			System.out.println("Terminou execute");
		} catch (DaoException e) {
			e.printStackTrace();
		}
		try {
			Thread.sleep(10000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		System.out.println("Exit");
		System.exit(0);
	}

}
