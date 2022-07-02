package br.com.sisacao.coletor.mercadoria.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorMercadoriaDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
