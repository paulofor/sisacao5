package br.inf.digicom.desen;

import br.inf.digicom.loopback.ExperimentoSimulacaoFacade;

public class MontaValidacaoSimulacaoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ola Mundo - MontaValidacaoSimulacaoApp");
		
		ExperimentoSimulacaoFacade facade = new ExperimentoSimulacaoFacade();
		facade.obtemExperimentoValidacao();
	}

}
