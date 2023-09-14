package gerador.criapythontreinopreredeapp.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.criapythontreinopreredeapp.passo.*;
import gerador.criapythontreinopreredeapp.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class CriaPythonTreinoPreRedeApp {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("CriaPythonTreinoPreRedeApp");
		System.out.println("(13/09/2023 01:46:42)");
		try {
			carregaProp();
			CriaPythonTreinoPreRedeObj obj = new CriaPythonTreinoPreRedeObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("CriaPythonTreinoPreRedeApp.err", true);
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
		DaoBaseComum.setProximo("CriaPythonTreinoPreRedeObj", new PreRedeNeural_ListaParaTreinoImpl());
		DaoBaseComum.setProximo("PreRedeNeural_ListaParaTreino", new GeraPythonPreRedeNeuralImpl());
	}
}
