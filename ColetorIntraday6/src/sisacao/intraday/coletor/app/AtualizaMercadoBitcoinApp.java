package sisacao.intraday.coletor.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sisacao.intraday.coletor.obj.AtualizaMercadoBitcoinObj;
import sisacao.intraday.coletor.thread.ThreadPaiBase;

public class AtualizaMercadoBitcoinApp {

	public static void main(String[] args) {
		try {
			carregaProp();
			AtualizaMercadoBitcoinObj obj = new AtualizaMercadoBitcoinObj();
			obj.executa();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("AtualizaMercadoBitcoin.config");
		Properties prop = new Properties();
        prop.load(input);
        ThreadPaiBase.LoopBackUrl = prop.getProperty("loopback.url");
	}

}
