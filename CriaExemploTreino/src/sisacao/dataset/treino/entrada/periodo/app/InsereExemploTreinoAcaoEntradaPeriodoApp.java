package sisacao.dataset.treino.entrada.periodo.app;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public class InsereExemploTreinoAcaoEntradaPeriodoApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoEntradaApp");
		System.out.println(" (15-06-2022)");
		trataErros();
		try {
			carregaProp();
			int posicaoEntrada = 0;
			
			String codigoGrupoAcao = "Neg-100";
			int diaNumInicio = Integer.parseInt(args[0]);
			int diaNumFinal = Integer.parseInt(args[1]);
			int qtdeDias = Integer.parseInt(args[2]);
			InsereExemploTreinoAcaoEntradaPeriodoObj obj = new InsereExemploTreinoAcaoEntradaPeriodoObj();
			obj.executa(posicaoEntrada, qtdeDias, codigoGrupoAcao, diaNumInicio, diaNumFinal);
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}
	
	private static void trataErros() {
		try {
	        File file = new File("InsereExemploTreinoAcaoEntradaPeriodoApp.err");
	        if (!file.exists()) {
	            file.createNewFile();
	        }
	        PrintStream ps = new PrintStream(new FileOutputStream(file));
	        System.setErr(ps);
	    } catch (IOException e) {
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
