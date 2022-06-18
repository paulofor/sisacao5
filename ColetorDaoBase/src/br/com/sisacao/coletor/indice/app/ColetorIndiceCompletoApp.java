package br.com.sisacao.coletor.indice.app;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.util.MonitoraThread;


public class ColetorIndiceCompletoApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		
		
		MonitoraThread monitora = new MonitoraThread();
		monitora.inicializa(60);
		
		
		
		System.out.println("Inicialiando ColetorIndiceCompletoApp");
		System.out.println("Versao: 16-06-2022");
		try {
			carregaProp();
			preparaComum();
			ColetorIndiceCompletoObj obj = new ColetorIndiceCompletoObj();
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
