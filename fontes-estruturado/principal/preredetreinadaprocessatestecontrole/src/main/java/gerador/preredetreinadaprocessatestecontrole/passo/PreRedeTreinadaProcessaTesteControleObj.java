package gerador.preredetreinadaprocessatestecontrole.passo;


import gerador.preredetreinadaprocessatestecontrole.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessatestecontrole.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class PreRedeTreinadaProcessaTesteControleObj extends DaoAplicacao { 

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
		DaoBase finalizacao1 = new ExperimentoPreRedeTreinada_CalculaResultadoControleImpl();
		finalizacao1.setComum(ds);
		finalizacao1.executa();
	}
	public int getNumPasso() {
		return 1;
	}
}

