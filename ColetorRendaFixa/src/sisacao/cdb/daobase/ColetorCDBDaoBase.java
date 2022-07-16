package sisacao.cdb.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorCDBDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
