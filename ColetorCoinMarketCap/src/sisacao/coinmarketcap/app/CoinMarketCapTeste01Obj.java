package sisacao.coinmarketcap.app;

import br.com.digicom.coletor.ParserJson2;
import sisacao.coinmarketcap.callback.CoinMarketCapCallback;

public class CoinMarketCapTeste01Obj {

	public void executa() {
		System.out.println("Executa");
		ParserJson2 parser = new ParserJson2();
		CoinMarketCapCallback callback = new CoinMarketCapCallback();
		parser.setCallback(callback);
		parser.start();
	}
}
