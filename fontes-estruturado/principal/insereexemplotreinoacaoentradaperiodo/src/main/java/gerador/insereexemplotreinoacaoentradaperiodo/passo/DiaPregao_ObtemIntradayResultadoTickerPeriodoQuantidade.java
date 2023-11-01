package gerador.insereexemplotreinoacaoentradaperiodo.passo;


import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoacaoentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ObtemIntradayResultadoTickerPeriodoQuantidade extends DaoAplicacao { 

	private int NUM_PASSO = 4;


	protected String ticker;
	protected int qtdeDia;
	protected int diaNumPrevisao;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getDiaCorrente(), ds.getAtivoCorrente(), ds.getTipoCorrente())) {
			repDiaPregao.obtemIntradayResultadoTickerPeriodoQuantidade( ticker,qtdeDia,diaNumPrevisao, new ListCallback<DiaPregao>() { 
				public void onSuccess(List<DiaPregao> lista) {
						ds.setListaDiaCotacao(lista);
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
		return new CriaDataSetEntradaImpl();
	}


	protected boolean executaCustom( DiaPregao diaCorrente , AtivoAcao ativoCorrente , TipoExemploTreino tipoCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

