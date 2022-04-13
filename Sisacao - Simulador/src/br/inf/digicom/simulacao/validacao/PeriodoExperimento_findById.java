package br.inf.digicom.simulacao.validacao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.PeriodoExperimento;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;

public class PeriodoExperimento_findById extends DaoBaseApp{

	
	
	@Override
	protected void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		this.repPeriodo.findById(ds.getIdPeriodo(), new ObjectCallback<PeriodoExperimento>() {

			@Override
			public void onSuccess(PeriodoExperimento object) {
				ds.setPeriodo(object);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});
		
	}

	@Override
	protected DaoBaseApp getProximo() {
		return new AtivoAcao_SimulacaoComMonitor();
	}

}
