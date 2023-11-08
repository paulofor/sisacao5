package gerador.insereexemplotreinoindiceentradaperiodo.passo;


import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class AtivoIndice_ListaBovespa extends DaoAplicacao { 

	private int NUM_PASSO = 3;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repAtivoIndice.listaBovespa(  new ListCallback<AtivoIndice>() { 
				public void onSuccess(List<AtivoIndice> lista) {
					for (AtivoIndice item : lista) {
						ds.setIndiceCorrente(item);
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
		return new DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidadeImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

