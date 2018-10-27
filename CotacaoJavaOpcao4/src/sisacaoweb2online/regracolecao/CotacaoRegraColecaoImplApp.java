/*  1:   */ package sisacaoweb2online.regracolecao;
/*  2:   */ 
/*  3:   */ import br.com.digicom.cotacao.dao.CotacaoDao;
/*  4:   */ import br.com.digicom.cotacao.regracolecao.CotacaoRegraColecaoImpl;
/*  5:   */ import sisacaoweb2online.dao.DBB;
/*  6:   */ 
/*  7:   */ public class CotacaoRegraColecaoImplApp
/*  8:   */   extends CotacaoRegraColecaoImpl
/*  9:   */ {
/* 10:   */   protected CotacaoDao getDao()
/* 11:   */   {
/* 12:11 */     return DBB.getInstancia().getCotacaoDao();
/* 13:   */   }
/* 14:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.regracolecao.CotacaoRegraColecaoImplApp
 * JD-Core Version:    0.7.0.1
 */