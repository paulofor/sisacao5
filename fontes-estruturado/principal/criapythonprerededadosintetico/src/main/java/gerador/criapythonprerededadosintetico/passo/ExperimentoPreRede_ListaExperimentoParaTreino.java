package gerador.criapythonprerededadosintetico.passo;


import gerador.criapythonprerededadosintetico.loopback.DaoAplicacao;
import gerador.criapythonprerededadosintetico.loopback.DatasetAplicacao;
import gerador.criapythonprerededadosintetico.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExperimentoPreRede_ListaExperimentoParaTreino extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repExperimentoPreRede.listaExperimentoParaTreino(  new ListCallback<ExperimentoPreRede>() { 
				public void onSuccess(List<ExperimentoPreRede> lista) {
					for (ExperimentoPreRede item : lista) {
						ds.setExperimentoCorrente(item);
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
		return new GeraPythonDadoSinteticoImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

