package gerador.preredetreinadaprocessatestecontrole.passo;


import gerador.preredetreinadaprocessatestecontrole.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessatestecontrole.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ObtemPeriodoPrevisaoTeste extends DaoAplicacao { 

	private int NUM_PASSO = 3;


	protected int idPeriodoTreinoRede;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExperimento())) {
			repDiaPregao.obtemPeriodoPrevisaoTeste( idPeriodoTreinoRede, new ListCallback<DiaPregao>() { 
				public void onSuccess(List<DiaPregao> lista) {
					for (DiaPregao item : lista) {
						ds.setDiaCorrente(item);
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
		return new ExperimentoPreRedeTreinadaScore_ObtemAleatoriaBaseadaEmMelhoresImpl();
	}


	protected boolean executaCustom( ExperimentoPreRedeTreinada experimento ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

