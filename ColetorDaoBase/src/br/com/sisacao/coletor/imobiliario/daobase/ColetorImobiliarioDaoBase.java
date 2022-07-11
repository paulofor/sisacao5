package br.com.sisacao.coletor.imobiliario.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorImobiliarioDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
