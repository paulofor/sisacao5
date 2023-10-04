package gerador.targetstoptrend.passo;


import gerador.targetstoptrend.loopback.DaoAplicacao;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class CalculaPontoSaida extends DaoAplicacao { 

	private int NUM_PASSO = 4;


	// campos saida
	protected CotacaoIntradayAcaoResultado  saidaPontoSaida;
	protected int  saidaResultado;
	protected int  saidaPasso;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getFechamentoRegraDiaCorrente(), ds.getEntrada(), ds.getPossivelSaida())) {
			ds.setPontoSaida(saidaPontoSaida);
			ds.setResultado(saidaResultado);
			ds.setPasso(saidaPasso);
			executaProximo();
		} else {
			finalizar();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new FechamentoPontoSaida_RegistraSaidaImpl();
	}


	protected boolean executaCustom( FechamentoRegraDia fechamentoRegraDiaCorrente , CotacaoIntradayAcaoResultado entrada , List<CotacaoIntradayAcaoResultado> possivelSaida ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

