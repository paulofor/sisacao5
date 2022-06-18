package br.com.sisacao.coletor.indice.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorIndiceDaoBase extends DaoBaseComum{

	
	@Override
	protected final long getTempo() {
		return 5000;
	}
}
