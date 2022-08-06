package sisacao.deeplearning.desenvolvimento.previsao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;



/**
 * Hello world!
 *
 */
public class ResultadoPrevisaoApp 
{
	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("ResultadoPrevisaoApp");
		System.out.println(" (19-07-2022)");
		try {
			//PrintStream printStream = new PrintStream("Error-InsereExemploTreinoAcaoEntradaApp.txt");
		    //System.setErr(printStream);
			carregaProp();
			ResultadoPrevisaoObj obj = new ResultadoPrevisaoObj();
			obj.executa(2,20220601,20220731,0.5);
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
