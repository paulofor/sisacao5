package gerador.insereexemplotreinoacaoentradaperiodo.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.insereexemplotreinoacaoentradaperiodo.passo.*;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class InsereExemploTreinoAcaoEntradaPeriodo {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoEntradaPeriodo");
		System.out.println("(10/10/2023 11:40:52)");
		try {
			carregaProp();
			InsereExemploTreinoAcaoEntradaPeriodoObj obj = new InsereExemploTreinoAcaoEntradaPeriodoObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("InsereExemploTreinoAcaoEntradaPeriodo.err", true);
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
		DaoBaseComum.setProximo("InsereExemploTreinoAcaoEntradaPeriodoObj", new DiaPregao_ListaDataPeriodoImpl());
		DaoBaseComum.setProximo("DiaPregao_ListaDataPeriodo", new AtivoAcao_ListaParaInsereExemploSaidaImpl());
		DaoBaseComum.setProximo("AtivoAcao_ListaParaInsereExemploSaida", new DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade", new CriaDataSetEntradaImpl());
		DaoBaseComum.setProximo("CriaDataSetEntrada", new ExemploTreinoAcaoEntrada_InsereExemploEntradaImpl());
	}
}
