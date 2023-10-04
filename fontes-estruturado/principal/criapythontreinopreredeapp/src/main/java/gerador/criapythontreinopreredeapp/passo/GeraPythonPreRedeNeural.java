package gerador.criapythontreinopreredeapp.passo;


import gerador.criapythontreinopreredeapp.loopback.DaoAplicacao;
import gerador.criapythontreinopreredeapp.loopback.DatasetAplicacao;
import gerador.criapythontreinopreredeapp.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class GeraPythonPreRedeNeural extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	// campos saida
	protected PreRedeNeural  saidaPreRedeNeuralCorrente;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			ds.setPreRedeNeuralCorrente(saidaPreRedeNeuralCorrente);
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

