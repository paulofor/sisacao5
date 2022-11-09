package sisacao.dataset.treino.entrada.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class InsereExemploTreinoAcaoEntradaApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoEntradaApp");
		System.out.println(" (12-05-2022)");
		try {
			//PrintStream printStream = new PrintStream("Error-InsereExemploTreinoAcaoEntradaApp.txt");
		    //System.setErr(printStream);
			
			carregaProp();
			int posicaoEntrada = 0;
			int qtdeDias = Integer.parseInt(args[0]);
			String codigoGrupoAcao = "Neg-100";
			InsereExemploTreinoAcaoEntradaObj obj = new InsereExemploTreinoAcaoEntradaObj();
			obj.executa(posicaoEntrada, qtdeDias, codigoGrupoAcao);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	

	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("CriaExemploTreinoAcao.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
        DaoBaseComum.setUrl(UrlLoopback);
	}

}
