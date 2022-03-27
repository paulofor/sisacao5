package br.inf.digicom.simulacao.validacao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.PeriodoExperimento;
import br.inf.digicom.loopback.DaoBase;

public class PeriodoExperimento_findById extends DaoBase{

	private Integer idPeriodo;
	
	public void setIdPeriodo(int idPeriodo) {
		this.idPeriodo = idPeriodo;
	}
	
	@Override
	protected void executaImpl() {
		this.repPeriodo.findById(idPeriodo, new ObjectCallback<PeriodoExperimento>() {

			@Override
			public void onSuccess(PeriodoExperimento object) {
				getComum().setPeriodo(object);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});
		
	}

	@Override
	protected DaoBase getProximo() {
		return new AtivoAcao_SimulacaoComMonitor();
	}

}
