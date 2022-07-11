package br.com.sisacao.coletor.ativo.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public class ColetorIntradayAtivoApp {
public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		
		//MonitoraThread monitora = new MonitoraThread();
		//monitora.inicializa(60);
		
		System.out.println("Inicialiando ColetorIntradayAtivoApp");
		System.out.println("Versao: 04-07-2022");
		

       
        
		try {
			PrintStream printStream = new PrintStream("Error-ColetorIntradayAtivoApp.txt");
		    System.setErr(printStream);
			carregaProp();
			preparaComum();
			ColetorIntradayAtivoObj obj = new ColetorIntradayAtivoObj();
			obj.executa();
			System.out.println("Finalizacao");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("ColetorAtivo.config");
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
