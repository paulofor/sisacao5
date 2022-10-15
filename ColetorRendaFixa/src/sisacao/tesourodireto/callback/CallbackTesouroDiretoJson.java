package sisacao.tesourodireto.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.TesouroDiretoCotacao;

public class CallbackTesouroDiretoJson extends CallbackParseJson  {

	private TesouroDadosParse dados;
	
	// exemplo url: https://www.tesourodireto.com.br/json/br/com/b3/tesourodireto/service/api/treasurybondsinfo.json
	
	
	

	@Override
	public URL getUrl() throws MalformedURLException {
		//String data = dados.getAAAA_MM_DD();
		return new URL("https://www.tesourodireto.com.br/json/br/com/b3/tesourodireto/service/api/treasurybondsinfo.json");
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		this.dados = (TesouroDadosParse) paramIDadosParse;
		
	}

	@Override
	public void finalizacaoErro() {
		System.out.println("Gerou erro");
	}

	@Override
	public void finalizacaoOk() throws DaoException{
		System.out.println("Finalizou com JSON");
		JSONObject obj = this.getJson();
		try {
			JSONArray itens = obj.getJSONObject("response").getJSONArray("TrsrBdTradgList");
			for (int i=0; i<itens.length(); i++) {
				JSONObject item = itens.getJSONObject(i).getJSONObject("TrsrBd");
				TesouroDiretoCotacao cotacao = new TesouroDiretoCotacao();
				cotacao.setCodigoTesouro(item.getString("isinCd"));
				cotacao.setNome(item.getString("nm"));
				cotacao.setTaxaMercado(item.getDouble("anulInvstmtRate"));
				this.dados.adicionaCotacao(cotacao);
			}
			this.dados.enviaDados();
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}

	@Override
	public void inicializacao() {
		this.dados.inicializaLista();
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

	@Override
	public void setString(String resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void antesLoop() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setConcluidoFalse() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public boolean getConcluido() {
		// TODO Auto-generated method stub
		return false;
	}

	

}
