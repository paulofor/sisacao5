package cotacaojava2.app;

import br.com.digicom.cotacao.threads.ExecutorObjBase;
import br.com.digicom.cotacao.threads.ThreadPaiBase;
import cotacaojava2.timer.CotacaoOpcao2ThreadPai;

public class ColetorJava2Obj extends ExecutorObjBase {
	
	protected ThreadPaiBase criaThreadPai() {
		return new CotacaoOpcao2ThreadPai();
	}
}

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.app.ColetorJava2Obj JD-Core Version: 0.6.0
 */