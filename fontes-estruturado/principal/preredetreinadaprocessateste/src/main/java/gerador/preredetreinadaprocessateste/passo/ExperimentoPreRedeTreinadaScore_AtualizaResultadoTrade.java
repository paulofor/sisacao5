package gerador.preredetreinadaprocessateste.passo;


import gerador.preredetreinadaprocessateste.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessateste.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessateste.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExperimentoPreRedeTreinadaScore_AtualizaResultadoTrade extends DaoAplicacao { 

	private int NUM_PASSO = 6;


	protected ExperimentoPreRedeTreinadaScore resultado;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getAtivoMelhorDia())) {
			repExperimentoPreRedeTreinadaScore.atualizaResultadoTrade( resultado, new VoidCallback() { 
				public void onSuccess() {
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


	protected boolean executaCustom( ExperimentoPreRedeTreinadaScore ativoMelhorDia ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

