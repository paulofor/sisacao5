package gerador.preredetreinadaprocessatestecontrole.passo;


import gerador.preredetreinadaprocessatestecontrole.loopback.DaoAplicacao;
import gerador.preredetreinadaprocessatestecontrole.loopback.DatasetAplicacao;
import gerador.preredetreinadaprocessatestecontrole.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior extends DaoAplicacao { 

	private int NUM_PASSO = 5;


	protected String ticker;
	protected int dataNumInicio;
	protected int tamanhoAmostra;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getExperimento(), ds.getDiaCorrente(), ds.getEscolhidoDia())) {
			if (ticker==null) {
				throw new RuntimeException("ticker precisa ser atribuido em DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl ");
			}
			repDiaPregao.obtemIntradayResultadoTickerAteFinalInicioAnterior( ticker,dataNumInicio,tamanhoAmostra, new ListCallback<DiaPregao>() { 
				public void onSuccess(List<DiaPregao> lista) {
						ds.setListaDiaComCotacao(lista);
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
		return new VerificaTradeImpl();
	}


	protected boolean executaCustom( ExperimentoPreRedeTreinada experimento , DiaPregao diaCorrente , ExperimentoPreRedeTreinadaScore escolhidoDia ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

