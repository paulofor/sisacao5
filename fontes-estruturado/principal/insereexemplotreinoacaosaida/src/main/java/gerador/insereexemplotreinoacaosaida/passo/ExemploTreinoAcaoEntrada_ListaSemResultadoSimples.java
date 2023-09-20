package gerador.insereexemplotreinoacaosaida.passo;


import gerador.insereexemplotreinoacaosaida.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaosaida.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaosaida.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class ExemploTreinoAcaoEntrada_ListaSemResultadoSimples extends DaoAplicacao { 

	private int NUM_PASSO = 3;


	protected String ticker;
	protected int regraId;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getRegraSaida(), ds.getAtivoCorrente())) {
			repExemploTreinoAcaoEntrada.listaSemResultadoSimples( ticker,regraId, new ListCallback<ExemploTreinoAcaoEntrada>() { 
				public void onSuccess(List<ExemploTreinoAcaoEntrada> lista) {
					for (ExemploTreinoAcaoEntrada item : lista) {
						ds.setExemploCorrente(item);
						executaProximoSemFinalizar();
					}
					preFinalizar();
					finalizar();
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
		return new DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl();
	}


	protected boolean executaCustom( RegraProjecao regraSaida , AtivoAcao ativoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

