package gerador.simulacaopreredetrade.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.simulacaopreredetrade.passo.*;
import gerador.simulacaopreredetrade.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class SimulacaoPreRedeTrade {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("SimulacaoPreRedeTrade");
		System.out.println("(30/08/2023 08:25:31)");
		try {
			carregaProp();
			SimulacaoPreRedeTradeObj obj = new SimulacaoPreRedeTradeObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("SimulacaoPreRedeTrade.err", true);
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
	}
}
