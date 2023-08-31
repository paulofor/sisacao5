package gerador.resultadoprevisaoapp.passo;


import gerador.resultadoprevisaoapp.loopback.DaoAplicacao;
import gerador.resultadoprevisaoapp.loopback.DatasetAplicacao;
import gerador.resultadoprevisaoapp.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class ResultadoPrevisaoObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		TreinoRede_ObtemListaPrevisaoTeste exec = new TreinoRede_ObtemListaPrevisaoTesteImpl();
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

