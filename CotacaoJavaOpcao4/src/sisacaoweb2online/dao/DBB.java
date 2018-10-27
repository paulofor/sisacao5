/*  1:   */ package sisacaoweb2online.dao;
/*  2:   */ 
/*  3:   */ import br.com.digicom.cotacao.dao.CotacaoDao;
/*  4:   */ 
/*  5:   */ public class DBB
/*  6:   */ {
/*  7: 7 */   private static DBB _instancia = null;
/*  8:   */   private CotacaoDao _cotacaoDao;
/*  9:   */   
/* 10:   */   public DBB()
/* 11:   */   {
/* 12:12 */     this._cotacaoDao = null;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public static DBB getInstancia()
/* 16:   */   {
/* 17:17 */     if (_instancia == null) {
/* 18:17 */       _instancia = new DBB();
/* 19:   */     }
/* 20:18 */     return _instancia;
/* 21:   */   }
/* 22:   */   
/* 23:   */   public CotacaoDao getCotacaoDao()
/* 24:   */   {
/* 25:23 */     if (this._cotacaoDao == null) {
/* 26:23 */       this._cotacaoDao = new CotacaoDaoExtendidaApp();
/* 27:   */     }
/* 28:24 */     return this._cotacaoDao;
/* 29:   */   }
/* 30:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.dao.DBB
 * JD-Core Version:    0.7.0.1
 */