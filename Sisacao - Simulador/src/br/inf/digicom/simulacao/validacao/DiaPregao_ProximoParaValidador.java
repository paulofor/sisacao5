package br.inf.digicom.simulacao.validacao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;

public class DiaPregao_ProximoParaValidador extends DaoBaseApp {

	@Override
	protected void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		String ticker = ds.getAtivoAcao().getTicker();
		long idPeriodo = ds.getPeriodo().getId();
		this.repDiaPregao.proximoParaValidador(ticker, idPeriodo, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				ds.setDiaValidacao(objects);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
				
			}});
	}

	@Override
	protected DaoBaseApp getProximo() {
		return new AtualizaDataDaoBase();
	}

}
