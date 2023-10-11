package gerador.insereexemplotreinoacaoentradaperiodo.passo;


import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class InsereExemploTreinoAcaoEntradaPeriodoObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		DiaPregao_ListaDataPeriodo exec = new DiaPregao_ListaDataPeriodoImpl();
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

