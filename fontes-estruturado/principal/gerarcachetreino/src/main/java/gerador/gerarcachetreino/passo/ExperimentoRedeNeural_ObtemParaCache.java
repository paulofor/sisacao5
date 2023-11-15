package gerador.gerarcachetreino.passo;


import gerador.gerarcachetreino.loopback.DaoAplicacao;
import gerador.gerarcachetreino.loopback.DatasetAplicacao;
import gerador.gerarcachetreino.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExperimentoRedeNeural_ObtemParaCache extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repExperimentoRedeNeural.obtemParaCache(  new ListCallback<ExperimentoRedeNeural>() { 
				public void onSuccess(List<ExperimentoRedeNeural> lista) {
					for (ExperimentoRedeNeural item : lista) {
						ds.setExperimento(item);
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
		return new ProcessaExperimentoImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

