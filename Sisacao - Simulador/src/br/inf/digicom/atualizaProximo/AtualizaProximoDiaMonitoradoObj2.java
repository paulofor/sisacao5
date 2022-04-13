package br.inf.digicom.atualizaProximo;

import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;

public class AtualizaProximoDiaMonitoradoObj2 extends DaoBaseApp{

	private int id;
	
	public void setId(int id) {
		this.id = id;
	}

	@Override
	protected void executaImpl() {
		DatasetComum ds = (DatasetComum) getComum();
		ds.setIdPeriodo(this.id);
		this.executaProximo();
		
	}

	@Override
	protected DaoBase getProximo() {
		return new AtualizaProximoPeriodoExperimento();
	}

}
