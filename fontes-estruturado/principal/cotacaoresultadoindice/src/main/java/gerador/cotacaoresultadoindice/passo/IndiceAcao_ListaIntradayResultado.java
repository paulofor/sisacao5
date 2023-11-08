package gerador.cotacaoresultadoindice.passo;


import gerador.cotacaoresultadoindice.loopback.DaoAplicacao;
import gerador.cotacaoresultadoindice.loopback.DatasetAplicacao;
import gerador.cotacaoresultadoindice.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class IndiceAcao_ListaIntradayResultado extends DaoAplicacao { 

	private int NUM_PASSO = 1;



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
		return new AtualizaDiaImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

