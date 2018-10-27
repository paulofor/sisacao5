/*  1:   */ package br.com.digicom.lib.dao;
/*  2:   */ 
/*  3:   */ public class ValorNaoEncontradoException
/*  4:   */   extends DaoException
/*  5:   */ {
/*  6:   */   public ValorNaoEncontradoException(Exception original)
/*  7:   */   {
/*  8: 7 */     super(original);
/*  9:   */   }
/* 10:   */   
/* 11:   */   public ValorNaoEncontradoException(Exception original, String mensagem)
/* 12:   */   {
/* 13:11 */     super(original, mensagem);
/* 14:   */   }
/* 15:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.ValorNaoEncontradoException
 * JD-Core Version:    0.7.0.1
 */