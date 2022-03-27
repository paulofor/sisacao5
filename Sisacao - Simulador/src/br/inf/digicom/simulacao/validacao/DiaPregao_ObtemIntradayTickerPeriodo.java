package br.inf.digicom.simulacao.validacao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;

public class DiaPregao_ObtemIntradayTickerPeriodo extends DaoBase {

	@Override
	protected void executaImpl() {
		String ticker = getComum().getAtivoAcao().getTicker();
		int inicioPeriodo = getComum().getPeriodo().getDataNumInicioColeta();
		this.repDiaPregao.obtemIntradayTickerPeriodo(ticker, inicioPeriodo, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				getComum().setListaDiaPregao(objects);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
				
			}});

	}

	@Override
	protected DaoBase getProximo() {
		return new ValidadorExperimentoDaoBase();
	}

}
