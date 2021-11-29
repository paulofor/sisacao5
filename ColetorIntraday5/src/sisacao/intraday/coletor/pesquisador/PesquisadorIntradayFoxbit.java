package sisacao.intraday.coletor.pesquisador;

import java.util.List;

import br.com.digicom.parse.PesquisadorTimer;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoCriptomoeda;
import sisacao.intraday.coletor.parse.callback.CriptomoedaFoxbitCallback;
import sisacao.intraday.coletor.parse.dados.CotacaoIntradayFoxbit;

public class PesquisadorIntradayFoxbit extends PesquisadorTimer{
	



	public void inicializa(String diaAtual) {

		ICallbackParse callback = getCallback();
		IDadosParse manipulador = getManipulador(diaAtual);
		super.setCallbackParse(callback);
		super.setDadosParse(manipulador);

	}

	private ICallbackParse getCallback() {
		return new CriptomoedaFoxbitCallback();
	}

	private IDadosParse getManipulador(String diaAtual) {
		return new CotacaoIntradayFoxbit();
	}

	
	
	

}
