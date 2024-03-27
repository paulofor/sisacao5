package gerador.insereexemplotreinoindiceentradaperiodo.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;
import java.io.FileWriter;
import java.io.PrintWriter;

import gerador.insereexemplotreinoindiceentradaperiodo.passo.*;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.comum.DaoBaseComum;

public class InsereExemploTreinoIndiceEntradaPeriodo {

	private static String UrlLoopback = "";

	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoIndiceEntradaPeriodo");
		System.out.println("(14/03/2024 06:04:00)");
		try {
			carregaProp();
			InsereExemploTreinoIndiceEntradaPeriodoObj obj = new InsereExemploTreinoIndiceEntradaPeriodoObj();
			obj.executa();
			System.out.println("finalizou");
			System.exit(0);
		} catch (Exception e) {
			gravarErro(e);
		}
	}


	private static void gravarErro(Exception e) {
		try {
			FileWriter fileWriter = new FileWriter("InsereExemploTreinoIndiceEntradaPeriodo.err", true);
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
		DaoBaseComum.setProximo("InsereExemploTreinoIndiceEntradaPeriodoObj", new TipoExemploTreino_ListaGeraExemploIndiceImpl());
		DaoBaseComum.setProximo("TipoExemploTreino_ListaGeraExemploIndice", new DiaPregao_ListaDataPeriodoAteOntemImpl());
		DaoBaseComum.setProximo("DiaPregao_ListaDataPeriodoAteOntem", new AtivoIndice_ListaBovespaImpl());
		DaoBaseComum.setProximo("AtivoIndice_ListaBovespa", new DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidadeImpl());
		DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidade", new CriaDataSetEntradaIndiceImpl());
		DaoBaseComum.setProximo("CriaDataSetEntradaIndice", new ExemploTreinoIndiceAcaoEntrada_InsereExemploEntradaIndiceImpl());
	}
}
