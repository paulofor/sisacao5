package br.inf.digicom.simulacao.validacao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DummyDaoBase;

public class PontoEntradaSimulacao_PreparaProximoDia extends DaoBaseApp {
	
	
	private DummyDaoBase dummy = null;
	
	public PontoEntradaSimulacao_PreparaProximoDia() {
		this.dummy = new DummyDaoBase();
	}
	

	@Override
	protected void executaImpl() {
		this.repPontoEntrada.preparaProximoDia(new VoidCallback() {

			@Override
			public void onSuccess() {
				finalizar();
			}

			@Override
			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}
