package sisacao.intraday.coletor.pesquisador;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.intraday.coletor.parse.callback.CriptomoedaFoxbitCallback;
import sisacao.intraday.coletor.parse.dados.CotacaoIntradayFoxbitDados;

public class PesquisadorIntradayFoxbit extends PesquisadorTimer{
	
	protected ExecutadorParseApache2 executadorParse = new ExecutadorParseApache2();


	public void inicializa(String diaAtual) {

		ICallbackParse callback = getCallback();
		IDadosParse manipulador = getManipulador(diaAtual);
		executadorParse.setCallbackParse(callback);
		executadorParse.setDadosParse(manipulador);
		//super.setCallbackParse(callback);
		//super.setDadosParse(manipulador);

	}

	private ICallbackParse getCallback() {
		return (ICallbackParse) new CriptomoedaFoxbitCallback();
	}

	private IDadosParse getManipulador(String diaAtual) {
		return new CotacaoIntradayFoxbitDados();
	}

	
	public void run() {
		try {
			executadorParse.executa();
		} catch (DaoException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	

}
