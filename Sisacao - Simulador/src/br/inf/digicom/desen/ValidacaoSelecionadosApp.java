package br.inf.digicom.desen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.Constantes;
import br.inf.digicom.ValidacaoSelecionadosObj;

public class ValidacaoSelecionadosApp {

	
	
	public static void main(String[] args) {
		System.out.println("Inicialiando ValidacaoSelecionadosApp");
		System.out.println("Versao: 24-03-2022");
		try {
			carregaProp();
			ValidacaoSelecionadosObj obj = new ValidacaoSelecionadosObj();
			obj.executa(11);
			System.out.println("Finalizacao");
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		System.exit(0);
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("ValidacaoSelecionados.config");
		Properties prop = new Properties();
        prop.load(input);
        Constantes.UrlLoopback = prop.getProperty("loopback.url");
	}
}
