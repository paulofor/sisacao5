package br.inf.digicom.simulacao.validacao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.loopback.DaoBase;

public class AtivoAcao_SimulacaoComMonitor extends DaoBase{


	
	
	@Override
	protected void executaImpl() {
		this.repAcao.simulacaoComMonitor(getComum().getPeriodo().getId(), new ListCallback<AtivoAcao>() {

			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				for (AtivoAcao acao : objects) {
					System.out.println("Ticker: " + acao.getTicker());
					getComum().setAtivoAcao(acao);
					executaProximo();
					
				}
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBase getProximo() {
		return new DiaPregao_ObtemIntradayTickerPeriodo();
	}


}
