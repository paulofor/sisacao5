package gerador.insereexemplotreinoindiceentradaperiodo.passo;


import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExemploTreinoIndiceAcaoEntrada_InsereExemploEntradaIndice extends DaoAplicacao { 

	private int NUM_PASSO = 6;


	protected ExemploTreinoIndiceAcaoEntrada exemplo;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExemploEntradaIndice())) {
			if (exemplo==null) {
				throw new RuntimeException("exemplo precisa ser atribuido em ExemploTreinoIndiceAcaoEntrada_InsereExemploEntradaIndiceImpl ");
			}
			repExemploTreinoIndiceAcaoEntrada.insereExemploEntradaIndice( exemplo, new VoidCallback() { 
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


	protected boolean executaCustom( ExemploTreinoIndiceAcaoEntrada exemploEntradaIndice ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

