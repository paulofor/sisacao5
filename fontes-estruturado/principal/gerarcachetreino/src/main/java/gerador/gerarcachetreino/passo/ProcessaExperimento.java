package gerador.gerarcachetreino.passo;


import gerador.gerarcachetreino.loopback.DaoAplicacao;
import gerador.gerarcachetreino.loopback.DatasetAplicacao;
import gerador.gerarcachetreino.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ProcessaExperimento extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	// campos saida

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			executaProximo();
		} else {
			finalizar();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new DummyDaoBase();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

