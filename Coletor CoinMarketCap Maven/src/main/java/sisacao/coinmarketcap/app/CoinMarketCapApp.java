package sisacao.coinmarketcap.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public class CoinMarketCapApp {
	
	public static String UrlLoopback = "";

	public static void main(String[] args) {
		try {
			carregaProp();
			CoinMarketCapObj obj = new CoinMarketCapObj();
			obj.executa();
			System.exit(0);
		} catch (IOException e) {
			e.printStackTrace();
			System.exit(-1);
		}
	}
	
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("CotacaoCoinMarketCap.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
        DaoBaseComum.setUrl(UrlLoopback);
	}
}
