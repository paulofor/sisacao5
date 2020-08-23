package sisacao.opcaointra.app;

import br.com.digicom.cotacao.callback.CallbackCotacaoB3Json;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;

public class PesquisadorCotacaoOpcao extends PesquisadorTicker {
	protected ICallbackCotacao getCallbackParse() {
		// return new CallbackBovespa2Html();
		//return new CallbackAgoraHtml();
		//return new CallbackPregaoOnlineAjax();
		return new CallbackCotacaoB3Json();
	}
}

