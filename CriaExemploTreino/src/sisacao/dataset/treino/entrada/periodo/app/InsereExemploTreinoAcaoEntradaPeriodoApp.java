package sisacao.dataset.treino.entrada.periodo.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class InsereExemploTreinoAcaoEntradaPeriodoApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoEntradaApp");
		System.out.println(" (10-06-2022)");
		try {
			carregaProp();
			int posicaoEntrada = 0;
			int qtdeDias = 120;
			String codigoGrupoAcao = "Neg-100";
			int diaNumInicio = Integer.parseInt(args[0]);
			int diaNumFinal = 20220531;
			InsereExemploTreinoAcaoEntradaPeriodoObj obj = new InsereExemploTreinoAcaoEntradaPeriodoObj();
			obj.executa(posicaoEntrada, qtdeDias, codigoGrupoAcao, diaNumInicio, diaNumFinal);
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
