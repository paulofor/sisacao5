package br.inf.digicom.atualizaProximo;

import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.simulacao.validacao.PeriodoExperimento_findById;

public class AtualizaProximoPeriodoExperimento extends PeriodoExperimento_findById {

	@Override
	protected DaoBaseApp getProximo() {
		return new AtualizaProximoAtivoAcao();
	}

	
}
