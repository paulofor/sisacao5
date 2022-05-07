package sisacao.dataset.treino.entrada.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class InsereExemploTreinoAcaoEntradaApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoEntradaApp");
		System.out.println(" (04-05-2022)");
		try {
			carregaProp();
			int posicaoEntrada = -2;
			int qtdeDias = 3;
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
