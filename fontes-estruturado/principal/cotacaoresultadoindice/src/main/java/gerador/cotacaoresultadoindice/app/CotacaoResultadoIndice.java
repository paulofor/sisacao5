package gerador.cotacaoresultadoindice.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.cotacaoresultadoindice.passo.*;
import gerador.cotacaoresultadoindice.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class CotacaoResultadoIndice {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("CotacaoResultadoIndice");
		System.out.println("(17/10/2023 01:52:31)");
		try {
			carregaProp();
			CotacaoResultadoIndiceObj obj = new CotacaoResultadoIndiceObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("CotacaoResultadoIndice.err", true);
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
		DaoBaseComum.setProximo("CotacaoResultadoIndiceObj", new IndiceAcao_ListaIntradayResultadoImpl());
		DaoBaseComum.setProximo("IndiceAcao_ListaIntradayResultado", new AtualizaDiaImpl());
		DaoBaseComum.setProximo("AtualizaDia", new CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndiceImpl());
	}
}
