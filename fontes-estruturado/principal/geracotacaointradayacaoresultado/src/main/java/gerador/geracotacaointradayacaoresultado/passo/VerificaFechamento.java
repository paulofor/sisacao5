package gerador.geracotacaointradayacaoresultado.passo;


import gerador.geracotacaointradayacaoresultado.loopback.DaoAplicacao;
import gerador.geracotacaointradayacaoresultado.loopback.DatasetAplicacao;
import gerador.geracotacaointradayacaoresultado.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class VerificaFechamento extends DaoAplicacao { 

	private int NUM_PASSO = 2;


	// campos saida

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getCotacaoResultado())) {
			executaProximo();
		} else {
			finalizar();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new CotacaoIntradayAcaoResultado_GravaVaziaComAnteriorImpl();
	}


	protected boolean executaCustom( CotacaoIntradayAcaoResultado cotacaoResultado ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

