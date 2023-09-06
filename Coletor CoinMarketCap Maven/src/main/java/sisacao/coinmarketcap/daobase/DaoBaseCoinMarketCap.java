package sisacao.coinmarketcap.daobase;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioCotacaoIntradayCoinmarketcap;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public abstract class DaoBaseCoinMarketCap extends DaoBaseComum{

	
	private RestAdapter adapter = new RestAdapter(DaoBaseComum.urlLoopback); 
	protected RepositorioCotacaoIntradayCoinmarketcap repCotacao = adapter.createRepository(RepositorioCotacaoIntradayCoinmarketcap.class);
	
	@Override
	protected long getTempo() {
		return 30000;
	}



}
