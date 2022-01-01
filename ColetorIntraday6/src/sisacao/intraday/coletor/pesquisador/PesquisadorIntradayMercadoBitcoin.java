package sisacao.intraday.coletor.pesquisador;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.intraday.coletor.parse.callback.CriptomoedaMercadoBitcoinCallback;
import sisacao.intraday.coletor.parse.dados.CotacaoIntradayMercadoBitcoinDados;

public class PesquisadorIntradayMercadoBitcoin extends PesquisadorTimer{
	
	protected ExecutadorParseApache2 executadorParse = new ExecutadorParseApache2();
	private String ticker = null;

	public PesquisadorIntradayMercadoBitcoin(String ticker) {
		this.ticker = ticker;
	}

	public void inicializa(String diaAtual) {
		System.out.println("Inicializando " + this.ticker);
		ICallbackParse callback = getCallback();
		IDadosParse manipulador = getManipulador(this.ticker,diaAtual);
		executadorParse.setCallbackParse(callback);
		executadorParse.setDadosParse(manipulador);
		//super.setCallbackParse(callback);
		//super.setDadosParse(manipulador);

	}

	private ICallbackParse getCallback() {
		return (ICallbackParse) new CriptomoedaMercadoBitcoinCallback();
	}

	private IDadosParse getManipulador(String ticker, String diaAtual) {
		return new CotacaoIntradayMercadoBitcoinDados(ticker);
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
