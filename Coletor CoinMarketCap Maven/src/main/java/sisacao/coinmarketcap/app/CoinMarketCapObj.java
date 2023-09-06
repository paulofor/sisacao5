package sisacao.coinmarketcap.app;

import sisacao.coinmarketcap.callback.CoinMarketCapCallback;
import sisacao.coinmarketcap.daobase.DatasetCoinMarketCap;

public class CoinMarketCapObj {

	public void executa() {
	
		DatasetCoinMarketCap ds = new DatasetCoinMarketCap();
		CoinMarketCapCallback servico = new CoinMarketCapCallback();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");

	}
	

}
