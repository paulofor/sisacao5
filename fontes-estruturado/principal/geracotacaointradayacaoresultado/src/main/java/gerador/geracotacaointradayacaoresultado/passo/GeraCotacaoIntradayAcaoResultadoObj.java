package gerador.geracotacaointradayacaoresultado.passo;


import gerador.geracotacaointradayacaoresultado.loopback.DaoAplicacao;
import gerador.geracotacaointradayacaoresultado.loopback.DatasetAplicacao;
import gerador.geracotacaointradayacaoresultado.passo.impl.*;
import br.com.gersis.daobase.DaoBase;
import br.com.gersis.daobase.IDatasetComum;

public class GeraCotacaoIntradayAcaoResultadoObj extends DaoAplicacao { 

	@Override
	protected void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		AtivoAcao_ListaParaIntradayResultado exec = new AtivoAcao_ListaParaIntradayResultadoImpl();
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

