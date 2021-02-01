package br.inf.digicom.desen;

import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;

public class SisacaoSimuladorAppDesen {

	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		SerieCotacaoIntradayFacade facade = new SerieCotacaoIntradayFacade();
		facade.obtemSerie("PETR4", 10);
	}

}
