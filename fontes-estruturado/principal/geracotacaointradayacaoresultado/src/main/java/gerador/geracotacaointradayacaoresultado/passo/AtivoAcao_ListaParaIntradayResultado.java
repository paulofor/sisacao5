package gerador.geracotacaointradayacaoresultado.passo;


import gerador.geracotacaointradayacaoresultado.loopback.DaoAplicacao;
import gerador.geracotacaointradayacaoresultado.loopback.DatasetAplicacao;
import gerador.geracotacaointradayacaoresultado.passo.impl.*;
import br.com.gersis.daobase.*;
import br.com.gersis.loopback.modelo.*;

import java.util.List;
import com.strongloop.android.loopback.callbacks.*;


public abstract class AtivoAcao_ListaParaIntradayResultado extends DaoAplicacao { 

	private int NUM_PASSO = 1;



	@Override
	protected final void executaImpl() {
		final DatasetAplicacao ds = (DatasetAplicacao) this.getComum();
		if (executaCustom()) {
			repAtivoAcao.listaParaIntradayResultado(  new ListCallback<AtivoAcao>() { 
				public void onSuccess(List<AtivoAcao> lista) {
					for (AtivoAcao item : lista) {
						ds.setAcaoCorrente(item);
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
		return new CotacaoIntradayAcaoResultado_GravaVaziaComAnteriorImpl();
	}


	protected boolean executaCustom() { return true; }

	protected void preFinalizar() { return; }

	public int getNumPasso() {
		return NUM_PASSO;
	}


}

