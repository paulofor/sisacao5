package gerador.criapythonprerededadosintetico.passo;


import gerador.criapythonprerededadosintetico.loopback.DaoAplicacao;
import gerador.criapythonprerededadosintetico.loopback.DatasetAplicacao;
import gerador.criapythonprerededadosintetico.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class CriaPythonPreRedeDadoSinteticoObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		ExperimentoPreRede_ListaExperimentoParaTreino exec = new ExperimentoPreRede_ListaExperimentoParaTreinoImpl();
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

