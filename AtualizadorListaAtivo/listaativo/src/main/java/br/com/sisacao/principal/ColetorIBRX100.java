package br.com.sisacao.principal;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.coletorjson.ICallbackJSON;
import br.com.digicom.coletorjson.ParserJson2;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public class ColetorIBRX100 extends DaoBaseComum implements ICallbackJSON {

	
	List<AtivoAcao> listaTicker = new LinkedList<AtivoAcao>();
	
	@Override
	protected long getTempo() {
		return 60000;
	}

	@Override
	protected void executaImpl() {
		ParserJson2 parser = new ParserJson2(this);
		parser.start();
	}

	public URL getUrl() throws MalformedURLException {
		String url = "https://sistemaswebb3-listados.b3.com.br/indexProxy/indexCall/GetPortfolioDay/eyJsYW5ndWFnZSI6InB0LWJyIiwicGFnZU51bWJlciI6MSwicGFnZVNpemUiOjEyMCwiaW5kZXgiOiJJQlhYIiwic2VnbWVudCI6IjEifQ==";
		return new URL(url);
	}

	public void setJsonList(JSONArray result) {
		System.out.println("recebeu lista-jason");
	}

	public void setJson(JSONObject result) {
		//System.out.println("recebeu item-jason");
		this.listaTicker.clear();
		JSONArray lista = result.getJSONArray("results");
		AtivoAcao atual = null;
		for (int i=0;i<lista.length();i++) {
			JSONObject ativo = lista.getJSONObject(i);
			atual = new AtivoAcao();
			atual.setNome(ativo.getString("asset"));
			atual.setTicker(ativo.getString("cod"));
			this.listaTicker.add(atual);
		}
		chamaServidor();
	}
	
	private void chamaServidor() {
		RestAdapter adapterItem = new RestAdapter(urlLoopback);
		final RepositorioAcaoBase.AtivoAcaoRepository rep = adapterItem.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
		rep.colocaColetaPorIndice(this.listaTicker, new VoidCallback() {

			public void onSuccess() {
				System.exit(0);
			}

			public void onError(Throwable t) {
				t.printStackTrace();
				System.exit(-1);
			}});
	}

	public void inicializacao() {
		// TODO Auto-generated method stub
		
	}

	public void finalizacaoOk() {
		// TODO Auto-generated method stub
		
	}

	public void setString(String responseBody) {
		// TODO Auto-generated method stub
		
	}



}
