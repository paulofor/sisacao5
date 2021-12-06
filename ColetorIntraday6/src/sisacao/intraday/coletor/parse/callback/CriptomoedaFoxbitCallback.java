package sisacao.intraday.coletor.parse.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import br.com.digicom.parse.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.CotacaoIntradayFoxbit;
import sisacao.intraday.coletor.parse.dados.CotacaoIntradayFoxbitDados;
import sisacao.intraday.coletor.util.DataHoraUtil;

public class CriptomoedaFoxbitCallback extends CallbackParseJson {

	//https://watcher.foxbit.com.br/api/Ticker/
	
	private CotacaoIntradayFoxbitDados dados = null;
	
	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL("https://watcher.foxbit.com.br/api/Ticker/");
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		dados = (CotacaoIntradayFoxbitDados) paramIDadosParse;
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() {
		System.out.println("Finalizou");
		List<CotacaoIntradayFoxbit> listaCotacao = new LinkedList<CotacaoIntradayFoxbit>();
		JSONArray lista = this.getJsonList();
		System.out.println(lista);
		JSONObject item;
		CotacaoIntradayFoxbit cotacao = null;
		for (int i=0; i<lista.length(); i++) {
			try {
				item = lista.getJSONObject(i);
				cotacao = new CotacaoIntradayFoxbit();
				cotacao.setValor(item.getDouble("last"));
				cotacao.setValorCompra(item.getDouble("buyPrice"));
				cotacao.setValorVenda(item.getDouble("sellPrice"));
				cotacao.setTickerMoeda(item.getString("currency"));
				cotacao.setCambio(item.getString("exchange"));
				cotacao.setDataHora(DataHoraUtil.getDataHora());
				cotacao.setDiaNum(DataHoraUtil.getDiaNum());
				if ("BRLX".equals(item.getString("currency").substring(0,4))) {
					cotacao.setTicker(item.getString("currency").substring(4));
				}
				listaCotacao.add(cotacao);
				System.out.println(cotacao);
			} catch (JSONException e) {
				e.printStackTrace();
			}
		}
		dados.setLista(listaCotacao);
		dados.registra();

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
	public void setString(String resposta) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void antesLoop() {
		// TODO Auto-generated method stub
		
	}

}
