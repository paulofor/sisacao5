package br.com.digicom.cotacao.threads;

import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.RestricaoTempo;

public abstract class PesquisadorTicker extends PesquisadorTimer {
	
	public void inicializa(String ticker, RestricaoTempo restricao) {
		ICallbackCotacao callback = getCallbackParse();
		callback.setTicker(ticker);
		super.setRestricaoTempo(restricao);
		super.setCallbackParse(callback);
		super.setDadosParse(new CotacaoManipulador());
	}

	protected abstract ICallbackCotacao getCallbackParse();
}

/*
 * Location: D:\Java-Recuperacao\coletorcotacao.jar Qualified Name:
 * br.com.digicom.cotacao.threads.PesquisadorTicker JD-Core Version: 0.6.0
 */