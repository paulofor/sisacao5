/*  1:   */ package br.com.digicom.lib.dao;
/*  2:   */ 
/*  3:   */ import java.sql.Connection;
/*  4:   */ import java.sql.SQLException;
/*  5:   */ 
/*  6:   */ public class DaoConexao
/*  7:   */ {
/*  8:   */   private Connection _conexao;
/*  9:   */   
/* 10:   */   public boolean conexaoInativa()
/* 11:   */     throws DaoException
/* 12:   */   {
/* 13:   */     try
/* 14:   */     {
/* 15:15 */       return this._conexao.isClosed();
/* 16:   */     }
/* 17:   */     catch (SQLException e)
/* 18:   */     {
/* 19:17 */       throw new DaoException(e);
/* 20:   */     }
/* 21:   */   }
/* 22:   */   
/* 23:   */   public Connection getConexao()
/* 24:   */   {
/* 25:22 */     return this._conexao;
/* 26:   */   }
/* 27:   */   
/* 28:   */   public void setConexao(Connection conexao)
/* 29:   */   {
/* 30:25 */     this._conexao = conexao;
/* 31:   */   }
/* 32:   */   
/* 33:   */   public void abreConexao() {}
/* 34:   */   
/* 35:   */   public void fechaConexao()
/* 36:   */     throws DaoException
/* 37:   */   {
/* 38:   */     try
/* 39:   */     {
/* 40:36 */       this._conexao.close();
/* 41:   */     }
/* 42:   */     catch (SQLException e)
/* 43:   */     {
/* 44:38 */       throw new DaoException(e);
/* 45:   */     }
/* 46:   */   }
/* 47:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.DaoConexao
 * JD-Core Version:    0.7.0.1
 */