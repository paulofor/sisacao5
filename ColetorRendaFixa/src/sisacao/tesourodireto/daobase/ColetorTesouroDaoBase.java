package sisacao.tesourodireto.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class ColetorTesouroDaoBase extends DaoBaseComum{

	@Override
	protected final long getTempo() {
		return 1000;
	}

	

}
