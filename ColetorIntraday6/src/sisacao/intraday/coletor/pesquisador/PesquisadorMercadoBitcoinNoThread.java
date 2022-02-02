package sisacao.intraday.coletor.pesquisador;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.intraday.coletor.parse.callback.CriptomoedaMercadoBitcoinCallback;
import sisacao.intraday.coletor.parse.dados.CotacaoIntradayMercadoBitcoinDados;

public class PesquisadorMercadoBitcoinNoThread {
	
	protected ExecutadorParseApache2 executadorParse = new ExecutadorParseApache2();
	
	public void obtemCotacao(String ticker) throws DaoException {
		ICallbackParse callback = new CriptomoedaMercadoBitcoinCallback();
		IDadosParse manipulador = new CotacaoIntradayMercadoBitcoinDados(ticker);
		executadorParse.setCallbackParse(callback);
		executadorParse.setDadosParse(manipulador);
		executadorParse.executa();
	}

}
