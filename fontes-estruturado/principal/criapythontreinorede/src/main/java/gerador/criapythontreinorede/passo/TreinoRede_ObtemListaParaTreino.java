package gerador.criapythontreinorede.passo;


import gerador.criapythontreinorede.loopback.DaoAplicacao;
import gerador.criapythontreinorede.loopback.DatasetAplicacao;
import gerador.criapythontreinorede.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class TreinoRede_ObtemListaParaTreino extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repTreinoRede.obtemListaParaTreino(  new ListCallback<TreinoRede>() { 
				public void onSuccess(List<TreinoRede> lista) {
					for (TreinoRede item : lista) {
						ds.setTreinoCorrente(item);
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
		return new GeraPythonTreinoRedeImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

