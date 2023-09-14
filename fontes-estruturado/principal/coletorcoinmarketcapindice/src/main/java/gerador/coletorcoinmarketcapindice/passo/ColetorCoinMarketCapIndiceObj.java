package gerador.coletorcoinmarketcapindice.passo;


import gerador.coletorcoinmarketcapindice.loopback.DaoAplicacao;
import gerador.coletorcoinmarketcapindice.loopback.DatasetAplicacao;
import gerador.coletorcoinmarketcapindice.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class ColetorCoinMarketCapIndiceObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		ColetaIndiceCripto exec = new ColetaIndiceCriptoImpl();
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

