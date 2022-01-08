package sisacao.intraday.coletor.parse.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;
import sisacao.intraday.coletor.parse.dados.AtivosMercadoBitcoinDados;

public class AtivosMercadoBitcoinCallback extends CallbackParseJson{

	
	private AtivosMercadoBitcoinDados dados = null;
	
	@Override
	public void setString(String resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL("https://api.mercadobitcoin.net/api/v4/symbols");
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dados = (AtivosMercadoBitcoinDados) paramIDadosParse;
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		System.out.println("Finalizou AtivosMercadoBitcoinCallback");
		dados.setJson(this.getJson());
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
