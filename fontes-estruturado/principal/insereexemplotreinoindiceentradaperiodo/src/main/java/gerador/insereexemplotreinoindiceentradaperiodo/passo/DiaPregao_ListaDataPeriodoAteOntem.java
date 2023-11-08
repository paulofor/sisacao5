package gerador.insereexemplotreinoindiceentradaperiodo.passo;


import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ListaDataPeriodoAteOntem extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	protected int diaNumInicio;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getTipoCorrente())) {
			repDiaPregao.listaDataPeriodoAteOntem( diaNumInicio, new ListCallback<DiaPregao>() { 
				public void onSuccess(List<DiaPregao> lista) {
					for (DiaPregao item : lista) {
						ds.setDiaCorrente(item);
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
		return new AtivoIndice_ListaBovespaImpl();
	}


	protected boolean executaCustom( TipoExemploTreino tipoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

