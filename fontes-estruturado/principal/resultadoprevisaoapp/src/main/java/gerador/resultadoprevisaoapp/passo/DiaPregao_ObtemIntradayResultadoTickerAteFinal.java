package gerador.resultadoprevisaoapp.passo;


import gerador.resultadoprevisaoapp.loopback.DaoAplicacao;
import gerador.resultadoprevisaoapp.loopback.DatasetAplicacao;
import gerador.resultadoprevisaoapp.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ObtemIntradayResultadoTickerAteFinal extends DaoAplicacao { 

	private int NUM_PASSO = 4;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getDiaNumInicio(), ds.getTamanhoAmostra(), ds.getTicker())) {
			executaProximo();
		} else {
			finalizar()
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new BuscaSaidaTradeImpl();
	}


	protected boolean executaCustom( int diaNumInicio , int tamanhoAmostra , String ticker ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

