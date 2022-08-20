package sisacao.coletor.uniswap.processamento;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;

public class UniswapCallback extends CallbackParseJson{

	public void setString(String resposta) {
		// TODO Auto-generated method stub
		
	}

	public URL getUrl() throws MalformedURLException {
		return new URL("https://watcher.foxbit.com.br/api/Ticker/");
		//return new URL("https://api.thegraph.com/subgraphs/name/uniswap/uniswap-v2");
	}

	public void setDados(IDadosParse paramIDadosParse) {
		// TODO Auto-generated method stub
		
	}

	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	public void finalizacaoOk() throws DaoException {
		// TODO Auto-generated method stub
		
	}

	public void inicializacao() {
		// TODO Auto-generated method stub
		
	}

	public boolean getLoop() {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean isPost() {
		// TODO Auto-generated method stub
		return false;
	}

	public List camposPost() {
		// TODO Auto-generated method stub
		return null;
	}

	public void setCookies(CookieManager cookies) {
		// TODO Auto-generated method stub
		
	}

	public CookieManager getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

	public String getCharSet() {
		// TODO Auto-generated method stub
		return null;
	}

	public URL getJsonUrl() throws MalformedURLException {
		// TODO Auto-generated method stub
		return null;
	}

	public void antesLoop() {
		// TODO Auto-generated method stub
		
	}

	public void setConcluidoFalse() {
		// TODO Auto-generated method stub
		
	}

	public boolean getConcluido() {
		// TODO Auto-generated method stub
		return false;
	}

	
}
