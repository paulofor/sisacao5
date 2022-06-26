package br.com.sisacao.coletor.diario.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorDiarioDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
