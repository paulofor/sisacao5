/*  1:   */ package br.com.digicom.lib.dao;
/*  2:   */ 
/*  3:   */ public class DaoException
/*  4:   */   extends Exception
/*  5:   */ {
/*  6:   */   private Exception _original;
/*  7:   */   private String _mensagemAdicional;
/*  8:   */   
/*  9:   */   public DaoException(Exception original)
/* 10:   */   {
/* 11: 8 */     this._original = original;
/* 12: 9 */     this._mensagemAdicional = null;
/* 13:   */   }
/* 14:   */   
/* 15:   */   public DaoException(Exception original, String mensagem)
/* 16:   */   {
/* 17:13 */     this._mensagemAdicional = mensagem;
/* 18:14 */     this._original = original;
/* 19:   */   }
/* 20:   */   
/* 21:   */   public String getMessage()
/* 22:   */   {
/* 23:18 */     return 
/* 24:19 */       (this._mensagemAdicional == null ? "" : this._mensagemAdicional) + this._original.getMessage();
/* 25:   */   }
/* 26:   */   
/* 27:   */   public Exception getOriginal()
/* 28:   */   {
/* 29:23 */     return this._original;
/* 30:   */   }
/* 31:   */   
/* 32:   */   public void printStackTrace()
/* 33:   */   {
/* 34:27 */     this._original.printStackTrace();
/* 35:   */   }
/* 36:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.DaoException
 * JD-Core Version:    0.7.0.1
 */