 package cotacaojava2.timer;
 
 import br.com.digicom.cotacao.callback.CallbackPregaoOnlineAjax;
import br.com.digicom.cotacao.callback.ICallbackCotacao;
import br.com.digicom.cotacao.threads.PesquisadorTicker;
 
 public class PesquisadorCotacaoAcao extends PesquisadorTicker
 {
   protected ICallbackCotacao getCallbackParse()
   {
/* 12 */     //return new CallbackBovespa2Xml();
	   	//return new CallbackAgoraHtml();
	   	//return new CallbackAgoraHtml();
	   return new CallbackPregaoOnlineAjax();
   }
 }

/* Location:           D:\Java-Recuperacao\CotacaoJava2.jar
 * Qualified Name:     cotacaojava2.timer.PesquisadorCotacaoAcao
 * JD-Core Version:    0.6.0
 */