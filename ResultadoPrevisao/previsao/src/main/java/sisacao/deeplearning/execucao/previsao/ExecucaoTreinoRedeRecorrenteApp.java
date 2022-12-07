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
public class ExecucaoTreinoRedeRecorrenteApp 
{
	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.print("ExecucaoTreinoRedeRecorrenteApp");
		System.out.println(" (03-12-2022)");
		try {
			carregaProp();
			ExecucaoTreinoRedeRecorrenteObj obj = new ExecucaoTreinoRedeRecorrenteObj();
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
