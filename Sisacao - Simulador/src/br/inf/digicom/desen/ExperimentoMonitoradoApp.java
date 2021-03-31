package br.inf.digicom.desen;

import br.inf.digicom.monitor.ExperimentoMonitoradoFacade;

public class ExperimentoMonitoradoApp {

	
	public static void main(String[] args) {
		System.out.println("Ola Mundo - ExperimentoMonitoradoApp");

		int dataNum = 20210401;
		
		ExperimentoMonitoradoFacade facade = new ExperimentoMonitoradoFacade();
		facade.atualizaPrecoEntrada(dataNum);
	}
}
