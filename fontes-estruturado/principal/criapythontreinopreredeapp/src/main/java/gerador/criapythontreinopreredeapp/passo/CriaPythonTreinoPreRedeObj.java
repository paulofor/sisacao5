package gerador.criapythontreinopreredeapp.passo;


import gerador.criapythontreinopreredeapp.loopback.DaoAplicacao;
import gerador.criapythontreinopreredeapp.loopback.DatasetAplicacao;
import gerador.criapythontreinopreredeapp.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class CriaPythonTreinoPreRedeObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		PreRedeNeural_ListaParaTreino exec = new PreRedeNeural_ListaParaTreinoImpl();
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

