package br.inf.digicom.desen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.CotacaoRegraProjecaoValorObj;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.simulacao.regraProjecao.CotacaoIntradayAcaoResultado_DataInicialTickerRegra;
import br.inf.digicom.simulacao.regraProjecao.ProcessadorRegraProjecao;

public class CotacaoRegraProjecaoValorApp {

	public static String UrlLoopback = "";
	
	public static void main(String[] args) {
		System.out.println("Inicialiando CotacaoRegraProjecao");
		System.out.println("Versao: 24-02-2022");
		try {
			carregaProp();
			preparaComum();
			CotacaoRegraProjecaoValorObj obj = new CotacaoRegraProjecaoValorObj();
			String codigoRegra = args[0];
			String codigoGrupo = args[1];
			obj.executa(codigoRegra,codigoGrupo);
			System.out.println("Finalizacao");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("CotacaoRegraProjecao.config");
		Properties prop = new Properties();
        prop.load(input);
        UrlLoopback = prop.getProperty("loopback.url");
	}

	private static void preparaComum() {
		DaoBaseComum.setUrl(UrlLoopback);
		DaoBaseComum.setProximo("AtivoAcao_ListaPorNomeGrupo", new CotacaoIntradayAcaoResultado_DataInicialTickerRegra());
		DaoBaseComum.setProximo("DiaPregao_ObtemIntradayResultadoValor", new ProcessadorRegraProjecao());
		DaoBaseComum.setProximo("RegraProjecao_ObtemPorCodigoRegra", new AtivoAcao_ListaPorNomeGrupo());
	}
}
