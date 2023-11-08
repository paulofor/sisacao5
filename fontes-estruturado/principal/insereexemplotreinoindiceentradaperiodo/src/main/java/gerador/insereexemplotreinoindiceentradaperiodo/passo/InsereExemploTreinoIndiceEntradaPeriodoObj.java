package gerador.insereexemplotreinoindiceentradaperiodo.passo;


import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class InsereExemploTreinoIndiceEntradaPeriodoObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		TipoExemploTreino_ListaGeraExemploIndice exec = new TipoExemploTreino_ListaGeraExemploIndiceImpl();
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

