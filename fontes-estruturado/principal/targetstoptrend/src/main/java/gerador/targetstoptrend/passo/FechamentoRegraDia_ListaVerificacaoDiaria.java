package gerador.targetstoptrend.passo;


import gerador.targetstoptrend.loopback.DaoAplicacao;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class FechamentoRegraDia_ListaVerificacaoDiaria extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repFechamentoRegraDia.listaVerificacaoDiaria(  new ListCallback<FechamentoRegraDia>() { 
				public void onSuccess(List<FechamentoRegraDia> lista) {
					for (FechamentoRegraDia item : lista) {
						ds.setFechamentoRegraDiaCorrente(item);
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
		return new CotacaoIntradayAcaoResultado_PendentePorFechamentoRegraImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

