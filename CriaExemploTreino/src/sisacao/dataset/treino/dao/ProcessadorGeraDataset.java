package sisacao.dataset.treino.dao;

import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.dataset.treino.proc.GeraDataset;

public class ProcessadorGeraDataset extends DaoBaseApp {

	GeraDataset gerador = new GeraDataset();
	private DummyDaoBase dummy = null;
	
	@Override
	protected void executaImpl() {
		gerador.setDatasetComum((DatasetComum) getComum());
		gerador.executa();
		this.dummy.setConcluido();
		this.executaProximo();
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

}
