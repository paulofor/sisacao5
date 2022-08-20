package sisacao.coletor.uniswap.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorUniswapDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
