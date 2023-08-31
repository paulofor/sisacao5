package gerador.targetstoptrend.passo;


import gerador.targetstoptrend.loopback.DaoAplicacao;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class TargetStopTrendObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		FechamentoRegraDia_ListaVerificacaoDiaria exec = new FechamentoRegraDia_ListaVerificacaoDiariaImpl();
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

