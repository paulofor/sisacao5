package sisacao.opcaointra.cotacao;

import br.com.digicom.cotacao.callback.CallbackB3Json;
import br.com.digicom.cotacao.callback.ICallbackCotacao;

public class PesquisadorIntradayAtivoIndice extends PesquisadorIntradayAtivo {

	
	
	
	protected ICallbackCotacao getCallback() {
		return new CallbackB3Json();
	}
	

	
}
