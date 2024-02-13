package gerador.cotacaoresultadoindice.passo;


import gerador.cotacaoresultadoindice.loopback.DaoAplicacao;
import gerador.cotacaoresultadoindice.loopback.DatasetAplicacao;
import gerador.cotacaoresultadoindice.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndice extends DaoAplicacao { 

	private int NUM_PASSO = 3;


	protected String ticker;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getIndiceCorrente())) {
			if (ticker==null) {
				throw new RuntimeException("ticker precisa ser atribuido em CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndiceImpl ");
			}
			repCotacaoIntradayIndiceResultado.gravaVaziaComAnteriorIndice( ticker , new ObjectCallback<CotacaoIntradayIndiceResultado>() { 
				public void onSuccess(CotacaoIntradayIndiceResultado object) {
					ds.setResultado(object);
					//preFinalizar();
					executaProximo();
				}
				public void onError(Throwable t) {
					onErrorBase(t);
				}
			});
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new DummyDaoBase();
	}


	protected boolean executaCustom( AtivoIndice indiceCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

