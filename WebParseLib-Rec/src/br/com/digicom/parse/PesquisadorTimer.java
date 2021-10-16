package br.com.digicom.parse;

import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import java.util.TimerTask;

public abstract class PesquisadorTimer extends TimerTask implements IPesquisador {
	private RestricaoTempo restricaoTempo;
	private ExecutadorParse executadorParse;

	public PesquisadorTimer() {
		this.executadorParse = new ExecutadorParse();
	}

	public PesquisadorTimer(RestricaoTempo restricaoTempo) {
		this.restricaoTempo = restricaoTempo;
		this.executadorParse = new ExecutadorParse();
	}

	public void setRestricaoTempo(RestricaoTempo restricaoTempo) {
		this.restricaoTempo = restricaoTempo;
	}

	public void setCallbackParse(ICallbackParse callback) {
		this.executadorParse.setCallbackParse(callback);
	}

	public void setDadosParse(IDadosParse dadosParse) {
		this.executadorParse.setDadosParse(dadosParse);
	}

	public void run() {
		if (this.restricaoTempo.podeAcessar())
			this.executadorParse.executa();
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.PesquisadorTimer JD-Core Version: 0.6.0
 */