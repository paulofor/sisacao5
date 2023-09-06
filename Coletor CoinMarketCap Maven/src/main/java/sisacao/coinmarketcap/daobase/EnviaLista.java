package sisacao.coinmarketcap.daobase;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.CotacaoIntradayCoinmarketcap;

public class EnviaLista extends DaoBaseCoinMarketCap{


	
	@Override
	protected void executaImpl() {
		DatasetCoinMarketCap ds = (DatasetCoinMarketCap) this.getComum();
		this.repCotacao.recebeCoinmarketcap(ds.getListaCotacao(), new ObjectCallback<CotacaoIntradayCoinmarketcap>() {

			public void onSuccess(CotacaoIntradayCoinmarketcap object) {
				finalizar();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}



}
