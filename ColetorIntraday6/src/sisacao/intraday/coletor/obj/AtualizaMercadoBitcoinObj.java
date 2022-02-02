package sisacao.intraday.coletor.obj;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.intraday.coletor.parse.callback.AtivosMercadoBitcoinCallback;
import sisacao.intraday.coletor.parse.dados.AtivosMercadoBitcoinDados;

public class AtualizaMercadoBitcoinObj {

	private static ExecutadorParseApache2 executadorParse = new ExecutadorParseApache2();
	
	public void executa() {
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
	}
}
