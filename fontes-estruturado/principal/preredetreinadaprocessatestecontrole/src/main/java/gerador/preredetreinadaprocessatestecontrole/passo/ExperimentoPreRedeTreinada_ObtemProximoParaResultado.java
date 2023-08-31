package gerador.preredetreinadaprocessatestecontrole.passo;


import gerador.preredetreinadaprocessatestecontrole.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessatestecontrole.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExperimentoPreRedeTreinada_ObtemProximoParaResultado extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repExperimentoPreRedeTreinada.obtemProximoParaResultado(  new ObjectCallback<ExperimentoPreRedeTreinada>() { 
				public void onSuccess(ExperimentoPreRedeTreinada object) {
					ds.setExperimento(object);
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
		return new ExperimentoPreRedeTreinadaControle_ReinicializaExperimentoImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

