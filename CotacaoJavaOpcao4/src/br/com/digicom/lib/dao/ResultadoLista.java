/*  1:   */ package br.com.digicom.lib.dao;
/*  2:   */ 
/*  3:   */ import java.sql.ResultSet;
/*  4:   */ import java.sql.SQLException;
/*  5:   */ import java.util.Date;
/*  6:   */ 
/*  7:   */ public class ResultadoLista
/*  8:   */ {
/*  9:   */   private ResultSet _lista;
/* 10: 9 */   private String _sql = null;
/* 11:   */   
/* 12:   */   public void setSql(String sql)
/* 13:   */   {
/* 14:12 */     this._sql = sql;
/* 15:   */   }
/* 16:   */   
/* 17:   */   public void setResultSet(ResultSet resultado)
/* 18:   */   {
/* 19:16 */     this._lista = resultado;
/* 20:   */   }
/* 21:   */   
/* 22:   */   public boolean next()
/* 23:   */     throws DaoException
/* 24:   */   {
/* 25:   */     try
/* 26:   */     {
/* 27:21 */       return this._lista.next();
/* 28:   */     }
/* 29:   */     catch (SQLException e)
/* 30:   */     {
/* 31:23 */       e.printStackTrace();
/* 32:24 */       throw new DaoException(e);
/* 33:   */     }
/* 34:   */   }
/* 35:   */   
/* 36:   */   public String getString(int indice)
/* 37:   */     throws DaoException
/* 38:   */   {
/* 39:   */     try
/* 40:   */     {
/* 41:30 */       return this._lista.getString(indice);
/* 42:   */     }
/* 43:   */     catch (SQLException e)
/* 44:   */     {
/* 45:32 */       e.printStackTrace();
/* 46:33 */       throw new DaoException(e);
/* 47:   */     }
/* 48:   */   }
/* 49:   */   
/* 50:   */   public int getInt(int indice)
/* 51:   */     throws DaoException
/* 52:   */   {
/* 53:   */     try
/* 54:   */     {
/* 55:39 */       return this._lista.getInt(indice);
/* 56:   */     }
/* 57:   */     catch (SQLException e)
/* 58:   */     {
/* 59:41 */       e.printStackTrace();
/* 60:42 */       throw new DaoException(e);
/* 61:   */     }
/* 62:   */   }
/* 63:   */   
/* 64:   */   public Date getDate(int indice)
/* 65:   */     throws DaoException
/* 66:   */   {
/* 67:   */     try
/* 68:   */     {
/* 69:48 */       return this._lista.getDate(indice);
/* 70:   */     }
/* 71:   */     catch (SQLException e)
/* 72:   */     {
/* 73:50 */       e.printStackTrace();
/* 74:51 */       throw new DaoException(e);
/* 75:   */     }
/* 76:   */   }
/* 77:   */   
/* 78:   */   public boolean getLogicoConvertido(int indice)
/* 79:   */     throws DaoException
/* 80:   */   {
/* 81:   */     try
/* 82:   */     {
/* 83:57 */       return this._lista.getString(indice).equals("S");
/* 84:   */     }
/* 85:   */     catch (SQLException e)
/* 86:   */     {
/* 87:59 */       e.printStackTrace();
/* 88:60 */       throw new DaoException(e);
/* 89:   */     }
/* 90:   */   }
/* 91:   */   
/* 92:   */   public float getFloat(int indice)
/* 93:   */     throws DaoException
/* 94:   */   {
/* 95:   */     try
/* 96:   */     {
/* 97:66 */       return this._lista.getFloat(indice);
/* 98:   */     }
/* 99:   */     catch (SQLException e)
/* :0:   */     {
/* :1:68 */       e.printStackTrace();
/* :2:69 */       throw new DaoException(e);
/* :3:   */     }
/* :4:   */   }
/* :5:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.ResultadoLista
 * JD-Core Version:    0.7.0.1
 */