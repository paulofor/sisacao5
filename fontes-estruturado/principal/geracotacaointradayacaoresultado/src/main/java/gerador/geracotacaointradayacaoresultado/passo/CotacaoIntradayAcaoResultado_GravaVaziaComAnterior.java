package gerador.geracotacaointradayacaoresultado.passo;


import gerador.geracotacaointradayacaoresultado.loopback.DaoAplicacao;
import gerador.geracotacaointradayacaoresultado.loopback.DatasetAplicacao;
import gerador.geracotacaointradayacaoresultado.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CotacaoIntradayAcaoResultado_GravaVaziaComAnterior extends DaoAplicacao { 

	private int NUM_PASSO = 3;


	protected String ticker;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getAcaoCorrente())) {
			if (ticker==null) {
				throw new RuntimeException("ticker precisa ser atribuido em CotacaoIntradayAcaoResultado_GravaVaziaComAnteriorImpl ");
			}
			repCotacaoIntradayAcaoResultado.gravaVaziaComAnterior( ticker , new ObjectCallback<CotacaoIntradayAcaoResultado>() { 
				public void onSuccess(CotacaoIntradayAcaoResultado object) {
					ds.setCotacaoResultado(object);
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


	protected boolean executaCustom( AtivoAcao acaoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

