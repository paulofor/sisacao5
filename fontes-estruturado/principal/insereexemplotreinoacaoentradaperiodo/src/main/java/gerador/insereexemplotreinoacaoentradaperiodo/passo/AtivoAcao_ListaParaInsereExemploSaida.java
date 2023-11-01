package gerador.insereexemplotreinoacaoentradaperiodo.passo;


import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class AtivoAcao_ListaParaInsereExemploSaida extends DaoAplicacao { 

	private int NUM_PASSO = 3;


	protected int qtdeDias;
	protected int diaNum;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getDiaCorrente(), ds.getTipoCorrente())) {
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
		return new DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidadeImpl();
	}


	protected boolean executaCustom( DiaPregao diaCorrente , TipoExemploTreino tipoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

