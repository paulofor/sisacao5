/*  1:   */ package br.com.digicom.lib.dao;
/*  2:   */ 
/*  3:   */ import br.com.digicom.lib.DCIObjetoDominio;
/*  4:   */ 
/*  5:   */ public abstract class MontadorDao
/*  6:   */ {
/*  7:   */   public boolean extraiRegistroListaInterna(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
/*  8:   */     throws DaoException
/*  9:   */   {
/* 10:10 */     objeto = ((MontadorDaoI)this).extraiRegistro(paramResultadoLista);
/* 11:11 */     return true;
/* 12:   */   }
/* 13:   */   
/* 14:   */   public boolean extraiRegistroInterno(ResultadoLista paramResultadoLista, DCIObjetoDominio objeto)
/* 15:   */     throws DaoException
/* 16:   */   {
/* 17:17 */     objeto = ((MontadorDaoI)this).extraiRegistro(paramResultadoLista);
/* 18:18 */     return true;
/* 19:   */   }
/* 20:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.MontadorDao
 * JD-Core Version:    0.7.0.1
 */