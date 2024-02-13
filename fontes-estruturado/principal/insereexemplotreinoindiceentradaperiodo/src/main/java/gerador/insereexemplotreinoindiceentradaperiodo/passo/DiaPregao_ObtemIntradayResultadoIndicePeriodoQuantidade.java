package gerador.insereexemplotreinoindiceentradaperiodo.passo;


import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DaoAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.loopback.DatasetAplicacao;
import gerador.insereexemplotreinoindiceentradaperiodo.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidade extends DaoAplicacao { 

	private int NUM_PASSO = 4;


	protected String ticker;
	protected int qtdeDia;
	protected int diaNumPrevisao;

	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom(ds.getTipoCorrente(), ds.getDiaCorrente(), ds.getIndiceCorrente())) {
			if (ticker==null) {
				throw new RuntimeException("ticker precisa ser atribuido em DiaPregao_ObtemIntradayResultadoIndicePeriodoQuantidadeImpl ");
			}
			repDiaPregao.obtemIntradayResultadoIndicePeriodoQuantidade( ticker,qtdeDia,diaNumPrevisao, new ListCallback<DiaPregao>() { 
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
		return new CriaDataSetEntradaIndiceImpl();
	}


	protected boolean executaCustom( TipoExemploTreino tipoCorrente , DiaPregao diaCorrente , AtivoIndice indiceCorrente ) { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

