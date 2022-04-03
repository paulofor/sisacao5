package sisacao.fii.app.desen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import sisacao.fii.parser.Constante;
import sisacao.fii.parser.FundoImobiliarioFacade;


public class ObtemAluguelFundoImob {

	
	public static void main(String[] args) {
		try {
			System.out.println("ObtemAluguelFundoImob");
			System.out.println("(28-02-2022)");
			carregaProp();
			FundoImobiliarioFacade facade = new FundoImobiliarioFacade();
			facade.obtemListaAluguelFundo();
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("FundoImob.config");
		Properties prop = new Properties();
        prop.load(input);
        Constante.LoopbackUrl = prop.getProperty("loopback.url");
        System.out.println("Loopback:" + Constante.LoopbackUrl);
	}
}
