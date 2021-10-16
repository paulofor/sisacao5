package br.com.digicom.cotacao.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseHtml;
import br.com.digicom.parse.callback.IDadosParse;

public class CallbackCotacaoGoogle  extends CallbackParseHtml implements ICallbackCotacao {

	
	private CotacaoManipulador dados;
	
	// exemplo url: https://arquivos.b3.com.br/apinegocios/ticker/petru216/2020-08-17
	
	private String dataReferencia;
	
	private Double valor;
	private String horario;
	
	
	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL("https://arquivos.b3.com.br/apinegocios/ticker/" + dados.getTicker().toLowerCase() + "/" + dados.getAAAA_MM_DD());
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dados = (CotacaoManipulador) paramIDadosParse;
		
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() throws DaoException {
		
	}

	@Override
	public void inicializacao() {
		// TODO Auto-generated method stub
		this.setDebug();
		
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
	public void setTicker(String paramString) {
		// TODO Auto-generated method stub
		
	}

}
