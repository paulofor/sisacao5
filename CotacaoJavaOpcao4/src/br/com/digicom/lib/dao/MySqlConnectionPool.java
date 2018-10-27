/*  1:   */ package br.com.digicom.lib.dao;
/*  2:   */ 
/*  3:   */ import java.sql.Connection;
/*  4:   */ import java.sql.DriverManager;
/*  5:   */ 
/*  6:   */ public class MySqlConnectionPool
/*  7:   */ {
/*  8: 8 */   private static Object _driver = null;
/*  9:   */   
/* 10:   */   public static Connection criaConexao(String url, String usuario, String senha, String driver)
/* 11:   */     throws DaoException
/* 12:   */   {
/* 13:   */     try
/* 14:   */     {
/* 15:12 */       Connection conexao = null;
/* 16:13 */       if (_driver == null) {
/* 17:14 */         _driver = Class.forName(driver).newInstance();
/* 18:   */       }
/* 19:15 */       return DriverManager.getConnection(url, usuario, senha);
/* 20:   */     }
/* 21:   */     catch (Exception e)
/* 22:   */     {
/* 23:18 */       throw new DaoException(e);
/* 24:   */     }
/* 25:   */   }
/* 26:   */   
/* 27:   */   public static void liberaConexao(Connection conexao)
/* 28:   */     throws DaoException
/* 29:   */   {
/* 30:   */     try
/* 31:   */     {
/* 32:24 */       conexao.close();
/* 33:   */     }
/* 34:   */     catch (Exception e)
/* 35:   */     {
/* 36:26 */       throw new DaoException(e);
/* 37:   */     }
/* 38:   */   }
/* 39:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.MySqlConnectionPool
 * JD-Core Version:    0.7.0.1
 */