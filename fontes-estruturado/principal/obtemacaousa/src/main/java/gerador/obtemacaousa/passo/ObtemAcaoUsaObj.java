package gerador.obtemacaousa.passo;


import gerador.obtemacaousa.loopback.DaoAplicacao;
import gerador.obtemacaousa.loopback.DatasetAplicacao;
import gerador.obtemacaousa.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class ObtemAcaoUsaObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		ColetorListaAcao exec = new ColetorListaAcaoImpl();
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

