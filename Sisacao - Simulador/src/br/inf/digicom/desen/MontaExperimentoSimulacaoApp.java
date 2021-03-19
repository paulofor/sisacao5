package br.inf.digicom.desen;

import br.inf.digicom.loopback.ExperimentoSimulacaoFacade;

public class MontaExperimentoSimulacaoApp {
	
	

	public static void main(String[] args) {
		System.out.println("Ola Mundo - MontaExperimentoSimulacaoApp");

		Long idExperimento = 12L;
		
		ExperimentoSimulacaoFacade facade = new ExperimentoSimulacaoFacade();
		facade.carregaExperimento(idExperimento);
		//facade.obtemProximaCombinacao();
	}

}
