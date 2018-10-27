package sisacaoweb2online.timer;

import br.com.digicom.cotacao.callback.CallbackPregaoOnlineAjax;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;

public class PesquisadorCotacaoOpcao extends PesquisadorTicker {
	protected ICallbackCotacao getCallbackParse() {
		// return new CallbackBovespa2Html();
		//return new CallbackAgoraHtml();
		return new CallbackPregaoOnlineAjax();
	}
}

/*
 * Location: D:\Documentos de
 * Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * 
 * Qualified Name: sisacaoweb2online.timer.PesquisadorCotacaoOpcao
 * 
 * JD-Core Version: 0.7.0.1
 */