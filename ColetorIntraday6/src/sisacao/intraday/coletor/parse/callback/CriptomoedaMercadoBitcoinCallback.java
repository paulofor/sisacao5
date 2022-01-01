package sisacao.intraday.coletor.parse.callback;

import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONException;

import br.com.digicom.parse.CallbackParseJson;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.CotacaoIntradayMercadoBitcoin;
import sisacao.intraday.coletor.parse.dados.CotacaoIntradayMercadoBitcoinDados;
import sisacao.intraday.coletor.util.DataHoraUtil;

public class CriptomoedaMercadoBitcoinCallback extends CallbackParseJson {

	//https://api.mercadobitcoin.net/api/v4/tickers?symbols=ADA-BRL
	
	private CotacaoIntradayMercadoBitcoinDados dados = null;

	
	@Override
	public URL getUrl() throws MalformedURLException {
		return new URL("https://api.mercadobitcoin.net/api/v4/tickers?symbols=" + dados.getTicker() + "-BRL");
	}

	@Override
	public void setDados(IDadosParse paramIDadosParse) {
		dados = (CotacaoIntradayMercadoBitcoinDados) paramIDadosParse;
	}

	@Override
	public void finalizacaoErro() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void finalizacaoOk() {
		JSONArray json = this.getJsonList();
		Double valor = 0d;
		try {
			valor = json.getJSONObject(0).getDouble("last");
			if (valor!=0) {
				CotacaoIntradayMercadoBitcoin cotacao = new CotacaoIntradayMercadoBitcoin();
				cotacao.setValor(valor);
				cotacao.setTicker(dados.getTicker());
				cotacao.setDataHora(DataHoraUtil.getDataHora());
				cotacao.setDiaNum(DataHoraUtil.getDiaNum());
				cotacao.setMaximo(json.getJSONObject(0).getDouble("high"));
				cotacao.setMinimo(json.getJSONObject(0).getDouble("low"));
				cotacao.setTickerMoeda(json.getJSONObject(0).getString("pair"));
				dados.registra(cotacao);
			}
		} catch (JSONException e) {
			e.printStackTrace();
		}
		System.out.println("Finalizou: " + valor);
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
