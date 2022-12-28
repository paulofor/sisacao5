package sisacao.coinmarketcap.daobase;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class DaoBaseCoinMarketCap extends DaoBaseComum{

	@Override
	protected long getTempo() {
		return 30000;
	}



}
