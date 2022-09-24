package sisacao.deeplearning.execucao.previsao;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;



/**
 * Hello world!
 *
 */
public class ExecucaoTreinoRedeApp 
{
	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("ExecucaoTreinoRedeApp");
		System.out.println(" (24-09-2022)");
		try {
			//PrintStream printStream = new PrintStream("Error-InsereExemploTreinoAcaoEntradaApp.txt");
		    //System.setErr(printStream);
			carregaProp();
			ExecucaoTreinoRedeObj obj = new ExecucaoTreinoRedeObj();
			obj.executa();
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
