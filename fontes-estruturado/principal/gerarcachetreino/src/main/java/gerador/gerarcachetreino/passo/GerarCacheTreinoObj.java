package gerador.gerarcachetreino.passo;


import gerador.gerarcachetreino.loopback.DaoAplicacao;
import gerador.gerarcachetreino.loopback.DatasetAplicacao;
import gerador.gerarcachetreino.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class GerarCacheTreinoObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		ExperimentoRedeNeural_ObtemParaCache exec = new ExperimentoRedeNeural_ObtemParaCacheImpl();
		exec.setComum(ds);
		exec.executa();
		executaFinalizacao(ds);
		finalizar();
	}
	private void executaFinalizacao(DatasetAplicacao ds) {
	}
	public int getNumPasso() {
		return 1;
	}
}

