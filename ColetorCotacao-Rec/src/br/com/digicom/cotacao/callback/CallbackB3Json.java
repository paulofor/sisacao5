package br.com.digicom.cotacao.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;

public class CallbackB3Json extends CallbackParseJson implements ICallbackCotacao {

	
	private CotacaoManipulador dados;
	
	// exemplo url: http://cotacao.b3.com.br/mds/api/v1/instrumentQuotation/ibov
	
	private String dataReferencia;
	
	private Double valor;
	private String horario;
	
	
	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL("http://cotacao.b3.com.br/mds/api/v1/instrumentQuotation/" + dados.getTicker().toLowerCase());
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
		// TODO Auto-generated method stub
		JSONObject obj = this.getJson();
		try {
			JSONArray valores =obj.getJSONArray("Trad");
			if (valores.length()>0) {
				JSONObject item = valores.getJSONObject(0);
				JSONObject SctyQtn = item.getJSONObject("scty").getJSONObject("SctyQtn");
				valor = SctyQtn.getDouble("curPrc");
				this.horario = "";
				//this.horario = maisRecente.getString(5);
				System.out.println("Valor: " + valor + "(" + horario + ")");
				//Cotacao cotacao = new Cotacao();
				//cotacao.setHoraNegocio(this.horario);;
				//cotacao.setValor(valor);
				dados.gravaIntraday(this.horario, valor);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new DaoException("Erro no Json");
		}
		
	}

	@Override
	public void inicializacao() {
		// TODO Auto-generated method stub
		//this.setDebug();
		
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

	@Override
	public void setCookies(CookieManager cookies) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public CookieManager getCookies() {
		// TODO Auto-generated method stub
		return null;
	}

}
