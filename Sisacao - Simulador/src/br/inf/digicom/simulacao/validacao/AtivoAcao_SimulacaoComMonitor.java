package br.inf.digicom.simulacao.validacao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.RepositorioCotacao;

public class AtivoAcao_SimulacaoComMonitor extends DaoBaseApp{


	
	
	@Override
	protected void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		this.repAcao.simulacaoComMonitor(ds.getPeriodo().getId(), new ListCallback<AtivoAcao>() {

			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				for (AtivoAcao acao : objects) {
					RepositorioCotacao.limpa();
					System.out.println("Ticker: " + acao.getTicker());
					ds.setAtivoAcao(acao);
					executaProximo();
					
				}
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBaseApp getProximo() {
		return new DiaPregao_ObtemIntradayTickerPeriodo();
	}


}
