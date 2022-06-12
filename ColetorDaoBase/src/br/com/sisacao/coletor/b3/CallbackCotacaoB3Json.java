package br.com.sisacao.coletor.b3;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;

public class CallbackCotacaoB3Json extends CallbackParseJson  {

	private B3DadosParse dados;
	
	// exemplo url: https://arquivos.b3.com.br/apinegocios/ticker/petru216/2020-08-17
	
	private String dataReferencia;
	
	private Double valor;
	private String horario;
	

	@Override
	public URL getUrl() throws MalformedURLException {
		String data = dados.getAAAA_MM_DD();
		return new URL("https://arquivos.b3.com.br/apinegocios/ticker/" + dados.getTicker().toLowerCase() + "/" + dados.getAAAA_MM_DD());
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dados = (B3DadosParse) paramIDadosParse;
		
	}

	@Override
	public void finalizacaoErro() {
	}

	@Override
	public void finalizacaoOk() throws DaoException{
		JSONObject obj = this.getJson();
		try {
			JSONArray valores =obj.getJSONArray("values");
			if (valores.length()>0) {
				JSONArray maisRecente = valores.getJSONArray(0);
				valor = maisRecente.getDouble(2);
				this.horario = maisRecente.getString(5);
				System.out.println("Valor: " + valor + "(" + horario + ")");
				dados.enviaValor(valor,horario);
				//Cotacao cotacao = new Cotacao();
				//cotacao.setHoraNegocio(this.horario);;
				//cotacao.setValor(valor);
				//dados.gravaIntraday(this.horario, valor);
			}
		} catch (JSONException e) {
			e.printStackTrace();
			throw new DaoException("Erro no Json");
		}
	}

	@Override
	public void inicializacao() {
	}

	@Override
	public boolean getLoop() {
		return false;
	}

	@Override
	public boolean isPost() {
		return false;
	}

	@Override
	public List camposPost() {
		return null;
	}

	@Override
	public void setCookies(CookieManager cookies) {
	}

	@Override
	public CookieManager getCookies() {
		return null;
	}

	@Override
	public String getCharSet() {
		return null;
	}

	@Override
	public URL getJsonUrl() throws MalformedURLException {
		return null;
	}

	

}
