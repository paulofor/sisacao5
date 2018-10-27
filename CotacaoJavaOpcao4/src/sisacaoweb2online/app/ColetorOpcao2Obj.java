/*  1:   */package sisacaoweb2online.app;

/*  2:   */
/*  3:   */import br.com.digicom.cotacao.threads.ExecutorObjBase;
/*  4:   */
import br.com.digicom.cotacao.threads.ThreadPaiBase;
/*  5:   */
import sisacaoweb2online.timer.CotacaoOpcao2ThreadPai;

/*  6:   */
/*  7:   */public class ColetorOpcao2Obj
/* 8: */extends ExecutorObjBase
/* 9: */{
	/* 10: */protected ThreadPaiBase criaThreadPai()
	/* 11: */{
		/* 12:11 */return new CotacaoOpcao2ThreadPai();
		/* 13: */}
	/* 14: */
}

/*
 * Location: D:\Documentos de
 * Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * 
 * Qualified Name: sisacaoweb2online.app.ColetorOpcao2Obj
 * 
 * JD-Core Version: 0.7.0.1
 */