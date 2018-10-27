package sisacaoweb2online.app;

import sisacaoweb2online.app.teste.PesquisadorCotacaoOpcaoTeste;
import br.com.digicom.cotacao.callback.CallbackPregaoOnlineAjax;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.parse.Pesquisador;

public class TestadorPregaoOnlineBovespa {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		PesquisadorCotacaoOpcaoTeste pesquisador = new PesquisadorCotacaoOpcaoTeste();
		ICallbackCotacao callback = new CallbackPregaoOnlineAjax();
		callback.setTicker("PETRC2");
		pesquisador.setCallbackParse(callback);
		pesquisador.setDadosParse(new CotacaoManipulador());
		pesquisador.run();
		
	}

}
