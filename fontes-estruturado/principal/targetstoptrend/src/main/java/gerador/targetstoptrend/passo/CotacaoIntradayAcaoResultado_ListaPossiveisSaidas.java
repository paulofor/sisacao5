package gerador.targetstoptrend.passo;


import gerador.targetstoptrend.loopback.DaoAplicacao;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CotacaoIntradayAcaoResultado_ListaPossiveisSaidas extends DaoAplicacao { 

	private int NUM_PASSO = 3;


	protected CotacaoIntradayAcaoResultado entrada;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getEntrada())) {
			if (entrada==null) {
				throw new RuntimeException("entrada precisa ser atribuido em CotacaoIntradayAcaoResultado_ListaPossiveisSaidasImpl ");
			}
			repCotacaoIntradayAcaoResultado.listaPossiveisSaidas( entrada, new ListCallback<CotacaoIntradayAcaoResultado>() { 
				public void onSuccess(List<CotacaoIntradayAcaoResultado> lista) {
						ds.setPossivelSaida(lista);
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
		return new CalculaPontoSaidaImpl();
	}


	protected boolean executaCustom( CotacaoIntradayAcaoResultado entrada ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

