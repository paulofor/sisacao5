package br.inf.digicom;

import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;

public class SisacaoSimuladorObj {

	public void execute() {
		System.out.println("Ola Mundo");
		SerieCotacaoIntradayFacade facade = new SerieCotacaoIntradayFacade();
		
		facade.obtemSerie("LWSA3", 25);
	}
	
	
}
