package sisacao.tesourodireto.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.cdb.app.ColetorDiarioCDBObj;

public class ColetorTesouroDiretoApp {

public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		
		
		//MonitoraThread monitora = new MonitoraThread();
		//monitora.inicializa(60);
		
		
		
		System.out.println("Inicialiando ColetorTesouroDiretoApp");
		System.out.println("Versao: 26-09-2022");
		try {
			carregaProp();
			preparaComum();
			ColetorTesouroDiretoObj obj = new ColetorTesouroDiretoObj();
			obj.executa();
			System.out.println("Finalizacao");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("ColetorTesouro.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
	}

	private static void preparaComum() {
		DaoBaseComum.setUrl(UrlLoopback);
		//DaoBaseComum.setProximo("AtivoAcao_ListaPorNomeGrupo", new CotacaoIntradayAcaoResultado_DataInicialTickerRegra());
		//DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoValor", new ProcessadorRegraProjecao());
		//DaoBaseComum.setProximo("RegraProjecao_ObtemPorCodigoRegra", new AtivoAcao_ListaPorNomeGrupo());
	}
}
