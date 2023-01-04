package sisacao.coinmarketcap.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;


public class CoinMarketCapCallback extends CallbackParseJson {

	@Override
	public void setString(String resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getUrl() throws MalformedURLException {
		String url = "https://graph.facebook.com/v15.0/108595265406053/messages";
		return new URL(url);
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void inicializacao() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getLoop() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean isPost() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List camposPost() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setCookies(CookieManager cookies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CookieManager getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getCharSet() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public URL getJsonUrl() throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void antesLoop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConcluidoFalse() {
		// TODO Auto-generated method stub
		
	}

}
