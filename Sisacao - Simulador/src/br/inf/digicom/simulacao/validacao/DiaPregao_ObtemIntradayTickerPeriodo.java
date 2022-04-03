package br.inf.digicom.simulacao.validacao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;

public class DiaPregao_ObtemIntradayTickerPeriodo extends DaoBaseApp {

	@Override
	protected void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		String ticker = ds.getAtivoAcao().getTicker();
		int inicioPeriodo = ds.getPeriodo().getDataNumInicioColeta();
		this.repDiaPregao.obtemIntradayTickerPeriodo(ticker, inicioPeriodo, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				ds.setListaDiaPregao(objects);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
				
			}});

	}

	@Override
	protected DaoBaseApp getProximo() {
		return new DiaPregao_ProximoParaValidador();
	}

}
