package timer;

import br.com.digicom.cotacao.callback.CallbackPregaoOnlineAjax;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;

public class ColetorIndividualTh  extends PesquisadorTicker{

	@Override
	protected ICallbackCotacao getCallbackParse() {
		return new CallbackPregaoOnlineAjax();
	}

	
	
	

}
