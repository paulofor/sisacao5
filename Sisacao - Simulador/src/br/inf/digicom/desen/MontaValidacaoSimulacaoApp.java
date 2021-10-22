package br.inf.digicom.desen;

import br.inf.digicom.validador.Experimento_ObtemParaValidacao;

public class MontaValidacaoSimulacaoApp {

	public static void main(String[] args) {
		System.out.println("Ola Mundo - MontaValidacaoSimulacaoApp");
		Experimento_ObtemParaValidacao obj = new Experimento_ObtemParaValidacao();
		obj.executa();
		System.out.println("Finalizou");
		System.exit(0);
		//ExperimentoSimulacaoFacade facade = new ExperimentoSimulacaoFacade();
		//facade.obtemExperimentoValidacao();
	}

}
