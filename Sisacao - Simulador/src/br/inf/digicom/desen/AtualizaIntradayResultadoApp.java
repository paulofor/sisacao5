package br.inf.digicom.desen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.AtualizaIntradayResultadoObj;
import br.inf.digicom.Constantes;

public class AtualizaIntradayResultadoApp {

	private static final int ID_GRUPO01_100 = 8;
	private static final int ID_GRUPO02_100 = 9;
	private static final int ID_GRUPO03_100 = 10;
	private static final int ID_GRUPO04_100 = 11;
	
	
	public static void main(String[] args) {
		
		try {
			carregaProp();
			int idGrupo = Integer.parseInt(args[0]);
			AtualizaIntradayResultadoObj obj = new AtualizaIntradayResultadoObj();
					
			List<AtivoAcao> lista = obj.obtemAtivos(idGrupo);
			System.out.println("Temos " + lista.size() + " ativos");
			for (AtivoAcao ativo : lista) {
				while (obj.executaTicker(ativo.getTicker())!=null);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.exit(0);
		

	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("AtualizaIntradayResultado.config");
		Properties prop = new Properties();
        prop.load(input);
        Constantes.UrlLoopback = prop.getProperty("loopback.url");
	}

}
