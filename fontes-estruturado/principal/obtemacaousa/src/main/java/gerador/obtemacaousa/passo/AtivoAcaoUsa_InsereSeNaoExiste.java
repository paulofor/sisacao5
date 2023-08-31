package gerador.obtemacaousa.passo;


import gerador.obtemacaousa.loopback.DaoAplicacao;
import gerador.obtemacaousa.loopback.DatasetAplicacao;
import gerador.obtemacaousa.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class AtivoAcaoUsa_InsereSeNaoExiste extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	protected AtivoAcaoUsa ativo;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repAtivoAcaoUsa.insereSeNaoExiste( ativo, new VoidCallback() { 
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


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

