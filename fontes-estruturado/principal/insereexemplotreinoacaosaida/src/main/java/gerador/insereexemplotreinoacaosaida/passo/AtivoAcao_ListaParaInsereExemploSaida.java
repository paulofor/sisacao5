package gerador.insereexemplotreinoacaosaida.passo;


import gerador.insereexemplotreinoacaosaida.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaosaida.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaosaida.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class AtivoAcao_ListaParaInsereExemploSaida extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	protected int qtdeDias;
	protected int diaNum;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repAtivoAcao.listaParaInsereExemploSaida( qtdeDias,diaNum, new ListCallback<AtivoAcao>() { 
				public void onSuccess(List<AtivoAcao> lista) {
					for (AtivoAcao item : lista) {
						ds.setAtivoCorrente(item);
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
		return new ExemploTreinoAcaoEntrada_ListaSemResultadoSimplesImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

