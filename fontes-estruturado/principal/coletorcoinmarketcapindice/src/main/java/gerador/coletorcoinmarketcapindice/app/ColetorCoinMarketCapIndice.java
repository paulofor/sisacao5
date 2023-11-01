package gerador.coletorcoinmarketcapindice.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.coletorcoinmarketcapindice.passo.*;
import gerador.coletorcoinmarketcapindice.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class ColetorCoinMarketCapIndice {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("ColetorCoinMarketCapIndice");
		System.out.println("(31/10/2023 09:51:10)");
		try {
			carregaProp();
			ColetorCoinMarketCapIndiceObj obj = new ColetorCoinMarketCapIndiceObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("ColetorCoinMarketCapIndice.err", true);
			PrintWriter printWriter = new PrintWriter(fileWriter);
			e.printStackTrace(printWriter);
			printWriter.close();
		} catch (IOException ex) {
			ex.printStackTrace();
		}
	}

	private static void carregaProp() throws IOException {
		//System.out.println("Dir:" + System.getProperty("user.dir"));
		//InputStream input = new FileInputStream("CriaPythonTreinoRede.config");
		//Properties prop = new Properties();
		//prop.load(input);
		//UrlLoopback = prop.getProperty("loopback.url");
		UrlLoopback = "http://vps-40d69db1.vps.ovh.ca:23004/api";
		DaoBaseComum.setUrl(UrlLoopback);
	}

	private static void preparaComum() {
		DaoBaseComum.setUrl(UrlLoopback);
		DaoBaseComum.setProximo("ColetorCoinMarketCapIndiceObj", new ColetaIndiceCriptoImpl());
	}
}
