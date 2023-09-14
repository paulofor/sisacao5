package gerador.resultadoprevisaoapp.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.resultadoprevisaoapp.passo.*;
import gerador.resultadoprevisaoapp.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class ResultadoPrevisaoApp {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("ResultadoPrevisaoApp");
		System.out.println("(13/09/2023 01:46:41)");
		try {
			carregaProp();
			ResultadoPrevisaoObj obj = new ResultadoPrevisaoObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("ResultadoPrevisaoApp.err", true);
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
		DaoBaseComum.setProximo("ResultadoPrevisaoObj", new TreinoRede_ObtemListaPrevisaoTesteImpl());
		DaoBaseComum.setProximo("TreinoRede_ObtemListaPrevisaoTeste", new PrevisaoTeste_ListaComDiarioTesteImpl());
		DaoBaseComum.setProximo("PrevisaoTeste_ListaComDiarioTeste", new TrataPrevisaoImpl());
		DaoBaseComum.setProximo("TrataPrevisao", new DiaPregao_ObtemIntradayResultadoTickerAteFinalImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoTickerAteFinal", new BuscaSaidaTradeImpl());
		DaoBaseComum.setProximo("BuscaSaidaTrade", new PrevisaoTeste_AtualizaResultadoTesteImpl());
		DaoBaseComum.setProximo("PrevisaoTeste_AtualizaResultadoTeste", new TreinoRede_ExecutouPrevisaoTesteImpl());
	}
}
