package gerador.targetstoptrend.passo;


import gerador.targetstoptrend.loopback.DaoAplicacao;
import gerador.targetstoptrend.loopback.DatasetAplicacao;
import gerador.targetstoptrend.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class FechamentoPontoSaida_RegistraSaida extends DaoAplicacao { 

	private int NUM_PASSO = 5;


	protected FechamentoPontoSaida saida;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getFechamentoRegraDiaCorrente(), ds.getEntrada(), ds.getPontoSaida(), ds.getResultado(), ds.getPasso())) {
			if (saida==null) {
				throw new RuntimeException("saida precisa ser atribuido em FechamentoPontoSaida_RegistraSaidaImpl ");
			}
			repFechamentoPontoSaida.registraSaida( saida, new VoidCallback() { 
				public void onSuccess() {
					executaProximo();
				}
				public void onError(Throwable t) {
					onErrorBase(t);
				}
			});
		} else {
			executaProximo();
		}
	}


	@Override
	protected final DaoBase getProximo() {
		return new DummyDaoBase();
	}


	protected boolean executaCustom( FechamentoRegraDia fechamentoRegraDiaCorrente , CotacaoIntradayAcaoResultado entrada , CotacaoIntradayAcaoResultado pontoSaida , int resultado , int passo ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

