package br.inf.digicom.desen;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import br.inf.digicom.Constantes;
import br.inf.digicom.loopback.ExperimentoSimulacaoFacade;

public class MontaExperimentoSimulacaoApp {
	
	

	public static void main(String[] args) {
		System.out.println("Ola Mundo - MontaExperimentoSimulacaoApp");

		try {
			carregaProp();
			ExperimentoSimulacaoFacade facade = new ExperimentoSimulacaoFacade();
			facade.obtemExperimento();
		} catch (IOException e) {
			e.printStackTrace();
		}
	
	}
	
	private static void carregaProp() throws IOException {
		System.out.println("Dir:" + System.getProperty("user.dir"));
		InputStream input = new FileInputStream("MontaExperimentoSimulacao.config");
		Properties prop = new Properties();
        prop.load(input);
        Constantes.UrlLoopback = prop.getProperty("loopback.url");
	}

}
