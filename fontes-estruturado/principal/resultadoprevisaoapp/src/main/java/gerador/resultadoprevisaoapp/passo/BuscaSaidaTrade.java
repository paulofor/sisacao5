package gerador.resultadoprevisaoapp.passo;


import gerador.resultadoprevisaoapp.loopback.DaoAplicacao;
import gerador.resultadoprevisaoapp.loopback.DatasetAplicacao;
import gerador.resultadoprevisaoapp.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class BuscaSaidaTrade extends DaoAplicacao { 

	private int NUM_PASSO = 5;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getListaCotacaoResultado())) {
			executaProximo();
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new PrevisaoTeste_AtualizaResultadoTesteImpl();
	}


	protected boolean executaCustom( List<DiaPregao> listaCotacaoResultado ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

