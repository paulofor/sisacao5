package gerador.insereexemplotreinoacaosaida.passo;


import gerador.insereexemplotreinoacaosaida.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaosaida.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaosaida.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExemploTreinoAcaoSaida_InsereExemploSaida extends DaoAplicacao { 

	private int NUM_PASSO = 6;


	protected ExemploTreinoAcaoSaida exemplo;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getSaida())) {
			if (exemplo==null) {
				throw new RuntimeException("exemplo precisa ser atribuido em ExemploTreinoAcaoSaida_InsereExemploSaidaImpl ");
			}
			repExemploTreinoAcaoSaida.insereExemploSaida( exemplo, new VoidCallback() { 
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


	protected boolean executaCustom( ExemploTreinoAcaoSaida saida ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

