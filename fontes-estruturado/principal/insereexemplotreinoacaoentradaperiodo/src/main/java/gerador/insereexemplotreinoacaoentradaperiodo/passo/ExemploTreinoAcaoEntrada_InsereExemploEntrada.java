package gerador.insereexemplotreinoacaoentradaperiodo.passo;


import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExemploTreinoAcaoEntrada_InsereExemploEntrada extends DaoAplicacao { 

	private int NUM_PASSO = 6;


	protected ExemploTreinoAcaoEntrada exemplo;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExemploEntrada())) {
			if (exemplo==null) {
				throw new RuntimeException("exemplo precisa ser atribuido em ExemploTreinoAcaoEntrada_InsereExemploEntradaImpl ");
			}
			repExemploTreinoAcaoEntrada.insereExemploEntrada( exemplo, new VoidCallback() { 
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


	protected boolean executaCustom( ExemploTreinoAcaoEntrada exemploEntrada ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

