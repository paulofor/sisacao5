package sisacao.opcaointra.cotacao;

import br.com.digicom.cotacao.callback.CallbackCotacaoB3Json;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.RestricaoTempo;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.Ativo;

public class PesquisadorIntradayAtivoIndice extends PesquisadorIntradayAtivo {

	
	
	
	protected ICallbackCotacao getCallback() {
		return new CallbackCotacaoGoogle();
	}
	

	
}
