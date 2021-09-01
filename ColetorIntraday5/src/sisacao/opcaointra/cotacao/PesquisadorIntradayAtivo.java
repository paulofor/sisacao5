package sisacao.opcaointra.cotacao;

import br.com.digicom.cotacao.callback.CallbackCotacaoB3Json;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.RestricaoTempo;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.Ativo;

public class PesquisadorIntradayAtivo extends PesquisadorTimer {

	public void inicializa(Ativo ativo, String data, RestricaoTempo restricao) {
		System.out.println("Inicializando..." + ativo.getTicker());
		ICallbackCotacao callback = getCallback();
		IDadosParse manipulador = getManipulador(ativo,data);
		callback.setTicker(ativo.getTicker());
		super.setRestricaoTempo(restricao);
		super.setCallbackParse(callback);
		super.setDadosParse(manipulador);
	}
	
	
	protected ICallbackCotacao getCallback() {
		return new CallbackCotacaoB3Json();
	}
	
	private IDadosParse getManipulador(Ativo ativo, String data) {
		return new CotacaoIntradayManipuladorAtivo(ativo,data);
	}
	
}
