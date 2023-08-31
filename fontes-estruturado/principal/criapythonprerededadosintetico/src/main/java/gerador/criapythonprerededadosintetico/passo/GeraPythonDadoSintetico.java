package gerador.criapythonprerededadosintetico.passo;


import gerador.criapythonprerededadosintetico.loopback.DaoAplicacao;
import gerador.criapythonprerededadosintetico.loopback.DatasetAplicacao;
import gerador.criapythonprerededadosintetico.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class GeraPythonDadoSintetico extends DaoAplicacao { 

	private int NUM_PASSO = 2;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExperimentoCorrente())) {
			executaProximo();
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new DummyDaoBase();
	}


	protected boolean executaCustom( ExperimentoPreRede experimentoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

