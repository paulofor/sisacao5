package gerador.cotacaoresultadoindice.passo;


import gerador.cotacaoresultadoindice.loopback.DaoAplicacao;
import gerador.cotacaoresultadoindice.loopback.DatasetAplicacao;
import gerador.cotacaoresultadoindice.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class AtualizaDia extends DaoAplicacao { 

	private int NUM_PASSO = 2;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			executaProximo();
		} else {
			finalizar()
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new CotacaoIntradayIndiceResultado_GravaVaziaComAnteriorIndiceImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

