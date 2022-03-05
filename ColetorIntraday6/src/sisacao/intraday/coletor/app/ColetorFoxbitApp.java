package sisacao.intraday.coletor.app;


import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sisacao.intraday.coletor.obj.ColetorFoxbitObj;
import sisacao.intraday.coletor.thread.ThreadPaiBase;

public class ColetorFoxbitApp {

	

	public static void main(String[] args) {
		System.out.println("ColetorFoxbitApp");
		System.out.println("25-02-2022");
		try {
			carregaProp();
			ColetorFoxbitObj obj = new ColetorFoxbitObj();
			obj.executa();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("ColetorFoxbit.config");
		Properties prop = new Properties();
        prop.load(input);
        ThreadPaiBase.LoopBackUrl = prop.getProperty("loopback.url");
	}
	

}
