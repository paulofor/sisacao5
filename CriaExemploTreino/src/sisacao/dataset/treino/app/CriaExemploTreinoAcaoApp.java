package sisacao.dataset.treino.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.dataset.treino.obj.CriaExemploTreinoAcaoObj;

public class CriaExemploTreinoAcaoApp {
	
	
	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("CriaExemploTreinoAcaoApp");
		System.out.println(" (30-12-2021)");
		try {
			carregaProp();
			String codigoRegra = "t15s10v";
			int qtdeDias = 3;
			CriaExemploTreinoAcaoObj obj = new CriaExemploTreinoAcaoObj();
			obj.executa(codigoRegra, qtdeDias);
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
