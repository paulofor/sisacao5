package gerador.cotacaoresultadoativoacao.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.cotacaoresultadoativoacao.passo.*;
import gerador.cotacaoresultadoativoacao.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class CotacaoResultadoAtivoAcao {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("CotacaoResultadoAtivoAcao");
		System.out.println("(20/09/2023 01:56:51)");
		try {
			carregaProp();
			CotacaoResultadoAtivoAcaoObj obj = new CotacaoResultadoAtivoAcaoObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("CotacaoResultadoAtivoAcao.err", true);
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
