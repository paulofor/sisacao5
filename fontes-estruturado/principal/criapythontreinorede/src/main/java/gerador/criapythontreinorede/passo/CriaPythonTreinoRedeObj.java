package gerador.criapythontreinorede.passo;


import gerador.criapythontreinorede.loopback.DaoAplicacao;
import gerador.criapythontreinorede.loopback.DatasetAplicacao;
import gerador.criapythontreinorede.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class CriaPythonTreinoRedeObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		TreinoRede_ObtemListaParaTreino exec = new TreinoRede_ObtemListaParaTreinoImpl();
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

