package br.inf.digicom.desen;

import br.inf.digicom.loopback.ExperimentoSimulacaoFacade;

public class MontaExperimentoSimulacaoApp {
	
	

	public static void main(String[] args) {
		System.out.println("Ola Mundo - MontaExperimentoSimulacaoApp");


		
		ExperimentoSimulacaoFacade facade = new ExperimentoSimulacaoFacade();
		facade.obtemExperimento();
		//facade.obtemProximaCombinacao();
	}

}
