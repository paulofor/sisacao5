package gerador.preredetreinadaprocessateste.passo;


import gerador.preredetreinadaprocessateste.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessateste.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessateste.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class VerificaTrade extends DaoAplicacao { 

	private int NUM_PASSO = 5;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExperimento(), ds.getAtivoMelhorDia(), ds.getListaDiaComCotacao())) {
			executaProximo();
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new ExperimentoPreRedeTreinadaScore_AtualizaResultadoTradeImpl();
	}


	protected boolean executaCustom( ExperimentoPreRedeTreinada experimento , ExperimentoPreRedeTreinadaScore ativoMelhorDia , List<DiaPregao> listaDiaComCotacao ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

