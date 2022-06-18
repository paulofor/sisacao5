package sisacao.deeplearning.tensorflow;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;


public class CriaPythonTreinoRedeApp {

	public static String UrlLoopback = "";
	
	
	public static void main(String[] args) {
		System.out.print("CriaPythonTreinoRedeApp");
		System.out.println("(14-04-2022)");
		try {
			carregaProp();
			CriaPythonTreinoRedeObj obj = new CriaPythonTreinoRedeObj();
			obj.executa();
			System.exit(0);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("CriaPythonTreinoRede.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
        DaoBaseComum.setUrl(UrlLoopback);
	}

}
