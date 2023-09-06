package sisacao.coinmarketcap.callback;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import br.com.digicom.coletor.ICallbackJSON;
import br.com.digicom.coletor.ParserJson2;
import br.com.digicom.sisacao.modelo.CotacaoIntradayCoinmarketcap;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrente;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.DaoBaseRestricaoTempo;
import sisacao.coinmarketcap.daobase.DatasetCoinMarketCap;
import sisacao.coinmarketcap.daobase.EnviaLista;


public class CoinMarketCapCallback extends DaoBaseRecorrente implements ICallbackJSON { 

	private List<CotacaoIntradayCoinmarketcap> listaCotacao = new ArrayList<CotacaoIntradayCoinmarketcap>();

	public URL getUrl() throws MalformedURLException {
		return new URL("https://pro-api.coinmarketcap.com/v1/cryptocurrency/listings/latest?start=1&limit=250&convert=USD");
	}

	public void setJsonList(JSONArray result) {
		System.out.println("Chegou resultado Lista");
		this.executaProximo();
	}

	public void setJson(JSONObject result) {
		System.out.println("Chegou resultado Objecto");
		this.montaListaCotacao(result.getJSONArray("data"));
		DatasetCoinMarketCap ds = (DatasetCoinMarketCap) this.getComum();
		ds.setListaCotacao(this.listaCotacao);
		this.executaProximo();
	}

	private void montaListaCotacao(JSONArray result) {
		listaCotacao.clear();
		for (int i=0;i<result.length();i++) {
			JSONObject item = result.getJSONObject(i);
			//System.out.println(i);
			CotacaoIntradayCoinmarketcap novo = new CotacaoIntradayCoinmarketcap();
			novo.setTicker(item.getString("symbol"));
			novo.setNumMarketPair(item.getDouble("num_market_pairs"));
			novo.setCirculationSupply(item.getDouble("circulating_supply"));
			
			novo.setTotalSupply(item.getDouble("total_supply"));
			novo.setCmcRank(item.getDouble("cmc_rank"));
			
			JSONObject valor = item.getJSONObject("quote").getJSONObject("USD");
			novo.setPrice(valor.getDouble("price"));
			novo.setVolume24h(valor.getDouble("volume_24h"));
			novo.setMarketCap(valor.getDouble("market_cap"));
			novo.setMarketCapDominance(valor.getDouble("market_cap_dominance"));
			novo.setFullyDilutedMarketCap(valor.getDouble("fully_diluted_market_cap"));
			listaCotacao.add(novo);
		}
	}
	
	
	public void inicializacao() {
	}

	public void finalizacaoOk() {
	}

	
	public void setString(String responseBody) {
		System.out.println(responseBody);
	}

	@Override
	protected void inicializaTempos(DaoBaseRestricaoTempo restricaoTempo2) {
		// TODO Auto-generated method stub
		restricaoTempo2.setHorarioInicial(0,15);
		restricaoTempo2.setHorarioFinal(23,55);
		restricaoTempo2.setHorarioDesliga(16,00);
	}

	@Override
	protected int getIntervaloMinuto() {
		return 30;
	}

	@Override
	protected void executaPrincipal() {
		ParserJson2 parser = new ParserJson2(this);
		parser.start();
	}

	@Override
	protected long getTempo() {
		return 30000;
	}

	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	@Override
	protected DaoBase getProximo() {
		return new EnviaLista();
	}

	

}
