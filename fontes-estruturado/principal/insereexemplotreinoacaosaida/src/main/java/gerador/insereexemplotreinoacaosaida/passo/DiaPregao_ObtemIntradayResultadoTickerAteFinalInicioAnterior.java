package gerador.insereexemplotreinoacaosaida.passo;


import gerador.insereexemplotreinoacaosaida.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaosaida.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaosaida.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior extends DaoAplicacao { 

	private int NUM_PASSO = 4;


	protected String ticker;
	protected int dataNumInicio;
	protected int tamanhoAmostra;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getRegraSaida(), ds.getAtivoCorrente(), ds.getExemploCorrente())) {
			repDiaPregao.obtemIntradayResultadoTickerAteFinalInicioAnterior( ticker,dataNumInicio,tamanhoAmostra, new ListCallback<DiaPregao>() { 
				public void onSuccess(List<DiaPregao> lista) {
						ds.setListaDia(lista);
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
		return new CriaDataSetSaidaImpl();
	}


	protected boolean executaCustom( RegraProjecao regraSaida , AtivoAcao ativoCorrente , ExemploTreinoAcaoEntrada exemploCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

