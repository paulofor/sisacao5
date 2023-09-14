package gerador.cotacaoresultadoindice.passo;


import gerador.cotacaoresultadoindice.loopback.DaoAplicacao;
import gerador.cotacaoresultadoindice.loopback.DatasetAplicacao;
import gerador.cotacaoresultadoindice.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class CotacaoResultadoIndiceObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		IndiceAcao_ListaIntradayResultado exec = new IndiceAcao_ListaIntradayResultadoImpl();
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

