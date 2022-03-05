package sisacao.intraday.coletor.app;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sisacao.intraday.coletor.obj.ColetorMercadoBitcoinObj;
import sisacao.intraday.coletor.thread.ThreadPaiBase;

public class ColetorMercadoBitcoinApp {

	public static void main(String[] args) {
		System.out.print("ColetorMercadoBitcoinApp");
		System.out.println("(28-02-2022)");
		try {
			carregaProp();
			ColetorMercadoBitcoinObj obj = new ColetorMercadoBitcoinObj();
			obj.executa();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("ColetorMercadoBitcoin.config");
		Properties prop = new Properties();
        prop.load(input);
        ThreadPaiBase.LoopBackUrl = prop.getProperty("loopback.url");
	}
}
