package gerador.preredetreinadaprocessatestecontrole.passo;


import gerador.preredetreinadaprocessatestecontrole.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessatestecontrole.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExperimentoPreRedeTreinadaScore_ObtemAleatoriaBaseadaEmMelhores extends DaoAplicacao { 

	private int NUM_PASSO = 4;


	protected int diaNum;
	protected int experimentoId;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExperimento(), ds.getDiaCorrente())) {
			repExperimentoPreRedeTreinadaScore.obtemAleatoriaBaseadaEmMelhores( diaNum,experimentoId, new ListCallback<ExperimentoPreRedeTreinadaScore>() { 
				public void onSuccess(List<ExperimentoPreRedeTreinadaScore> lista) {
					for (ExperimentoPreRedeTreinadaScore item : lista) {
						ds.setEscolhidoDia(item);
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
		return new DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl();
	}


	protected boolean executaCustom( ExperimentoPreRedeTreinada experimento , DiaPregao diaCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

