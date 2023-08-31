package gerador.preredetreinadaprocessatestecontrole.passo;


import gerador.preredetreinadaprocessatestecontrole.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessatestecontrole.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class VerificaTrade extends DaoAplicacao { 

	private int NUM_PASSO = 6;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExperimento(), ds.getListaDiaComCotacao(), ds.getEscolhidoDia())) {
			executaProximo();
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new ExperimentoPreRedeTreinadaControle_InsereImpl();
	}


	protected boolean executaCustom( ExperimentoPreRedeTreinada experimento , List<DiaPregao> listaDiaComCotacao , ExperimentoPreRedeTreinadaScore escolhidoDia ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

