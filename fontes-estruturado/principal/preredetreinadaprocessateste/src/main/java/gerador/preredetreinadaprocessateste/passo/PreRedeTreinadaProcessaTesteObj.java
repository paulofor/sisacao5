package gerador.preredetreinadaprocessateste.passo;


import gerador.preredetreinadaprocessateste.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessateste.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessateste.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class PreRedeTreinadaProcessaTesteObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		ExperimentoPreRedeTreinada_ObtemProximoParaResultado exec = new ExperimentoPreRedeTreinada_ObtemProximoParaResultadoImpl();
		exec.setComum(ds);
		exec.executa();
		executaFinalizacao(ds);
		finalizar();
	}
	private void executaFinalizacao(DatasetAplicacao ds) {
		DaoBase finalizacao1 = new ExperimentoPreRedeTreinada_CalculaResultadoImpl();
		finalizacao1.setComum(ds);
		finalizacao1.executa();
	}
	public int getNumPasso() {
		return 1;
	}
}

