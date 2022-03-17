package br.inf.digicom.desen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.Constantes;
import br.inf.digicom.ValidadorSimulacaoObj;

public class ValidadorSimulacaoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Inicialiando CotacaoRegraProjecao");
		System.out.println("Versao: 10-03-2022");
		try {
			carregaProp();
			ValidadorSimulacaoObj obj = new ValidadorSimulacaoObj();
			obj.executa();
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
        Constantes.UrlLoopback = prop.getProperty("loopback.url");
	}

}
