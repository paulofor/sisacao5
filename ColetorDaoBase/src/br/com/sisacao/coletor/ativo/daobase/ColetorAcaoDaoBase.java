package br.com.sisacao.coletor.ativo.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorAcaoDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
