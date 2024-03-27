package gerador.gerarcachetreino.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.gerarcachetreino.passo.*;
import gerador.gerarcachetreino.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class GerarCacheTreino {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("GerarCacheTreino");
		System.out.println("(14/03/2024 06:04:02)");
		try {
			carregaProp();
			GerarCacheTreinoObj obj = new GerarCacheTreinoObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("GerarCacheTreino.err", true);
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
		DaoBaseComum.setProximo("GerarCacheTreinoObj", new ExperimentoRedeNeural_ObtemParaCacheImpl());
		DaoBaseComum.setProximo("ExperimentoRedeNeural_ObtemParaCache", new ProcessaExperimentoImpl());
	}
}
