package sisacao.dataset.treino.saida.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class InsereExemploTreinoAcaoSaidaApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("InsereExemploTreinoAcaoSaidaApp");
		System.out.println(" (12-05-2022)");
		try {
			carregaProp();
			int posicaoEntrada = 0;
			int qtdeDias = 120;
			String codigoGrupoAcao = "Neg-100";
			String codigoRegra = "t11s17v";
			InsereExemploTreinoAcaoSaidaObj obj = new InsereExemploTreinoAcaoSaidaObj();
			obj.executa(posicaoEntrada, qtdeDias, codigoGrupoAcao, codigoRegra);
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
