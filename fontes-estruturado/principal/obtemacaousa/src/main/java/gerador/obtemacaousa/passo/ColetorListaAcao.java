package gerador.obtemacaousa.passo;


import gerador.obtemacaousa.loopback.DaoAplicacao;
import gerador.obtemacaousa.loopback.DatasetAplicacao;
import gerador.obtemacaousa.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ColetorListaAcao extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			executaProximo();
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new AtivoAcaoUsa_InsereSeNaoExisteImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

