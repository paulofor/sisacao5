package gerador.targetstoptrend.passo;


import gerador.targetstoptrend.loopback.DaoAplicacao;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CotacaoIntradayAcaoResultado_PendentePorFechamentoRegra extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	protected int idFechamentoRegraDia;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getFechamentoRegraDiaCorrente())) {
			repCotacaoIntradayAcaoResultado.pendentePorFechamentoRegra( idFechamentoRegraDia, new ListCallback<CotacaoIntradayAcaoResultado>() { 
				public void onSuccess(List<CotacaoIntradayAcaoResultado> lista) {
					for (CotacaoIntradayAcaoResultado item : lista) {
						ds.setEntrada(item);
						executaProximoSemFinalizar();
					}
					preFinalizar();
					finalizar();
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
		return new CotacaoIntradayAcaoResultado_ListaPossiveisSaidasImpl();
	}


	protected boolean executaCustom( FechamentoRegraDia fechamentoRegraDiaCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

