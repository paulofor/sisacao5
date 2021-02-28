package br.inf.digicom.desen;

import java.util.HashMap;
import java.util.Map;

import br.inf.digicom.loopback.SerieCotacaoIntradayFacade;
import br.inf.digicom.simulacao.regra.RegraPontoEntrada;

public class SisacaoSimuladorAppDesen {

	public static void main(String[] args) {
		System.out.println("Ola Mundo");
		SerieCotacaoIntradayFacade facade = new SerieCotacaoIntradayFacade();
		RegraPontoEntrada regra = new RegraPontoEntrada();
		Map param = new HashMap();
		param.put("target", .07);
		param.put("stop", .1);
		param.put("dias", 5);
		param.put("posicaoSaida", 10);
		//facade.obtemSerie("ABV4", regra, param, 10);
	}

}
