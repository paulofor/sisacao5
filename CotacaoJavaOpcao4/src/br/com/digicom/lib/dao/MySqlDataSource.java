/*   1:    */ package br.com.digicom.lib.dao;
/*   2:    */ 
/*   3:    */ import java.sql.Connection;
/*   4:    */ import java.sql.ResultSet;
/*   5:    */ import java.sql.SQLException;
/*   6:    */ import java.sql.Statement;
/*   7:    */ 
/*   8:    */ public class MySqlDataSource
/*   9:    */   implements DataFonte
/*  10:    */ {
/*  11: 11 */   private String urlConexao = null;
/*  12: 12 */   private final String DRIVER = "com.mysql.jdbc.Driver";
/*  13: 13 */   private String usuario = null;
/*  14: 14 */   private String senha = null;
/*  15:    */   
/*  16:    */   public MySqlDataSource(String url, String usuario, String senha)
/*  17:    */   {
/*  18: 17 */     this.urlConexao = url;
/*  19: 18 */     this.usuario = usuario;
/*  20: 19 */     this.senha = senha;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public void setUrlConexao(String url)
/*  24:    */   {
/*  25: 23 */     this.urlConexao = url;
/*  26:    */   }
/*  27:    */   
/*  28:    */   public DaoConexao criaConexao()
/*  29:    */     throws DaoException
/*  30:    */   {
/*  31: 27 */     DaoConexao daoConexao = new DaoConexao();
/*  32: 28 */     daoConexao.setConexao(MySqlConnectionPool.criaConexao(this.urlConexao, this.usuario, this.senha, "com.mysql.jdbc.Driver"));
/*  33: 29 */     return daoConexao;
/*  34:    */   }
/*  35:    */   
/*  36:    */   public void liberaConexao(DaoConexao conexao)
/*  37:    */     throws DaoException
/*  38:    */   {
/*  39: 32 */     MySqlConnectionPool.liberaConexao(conexao.getConexao());
/*  40: 33 */     conexao = null;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public ResultSet getListaSql(String sql, DaoConexao conexao)
/*  44:    */     throws DaoException
/*  45:    */   {
/*  46: 37 */     return getListaSql(sql, conexao.getConexao());
/*  47:    */   }
/*  48:    */   
/*  49:    */   public void executaSql(String sql, DaoConexao conexao)
/*  50:    */     throws DaoException
/*  51:    */   {
/*  52: 40 */     executaSql(sql, conexao.getConexao());
/*  53:    */   }
/*  54:    */   
/*  55:    */   public ResultSet getListaSql(String sql, Connection conexao)
/*  56:    */     throws DaoException
/*  57:    */   {
/*  58: 45 */     Statement stmt = null;
/*  59:    */     try
/*  60:    */     {
/*  61: 48 */       stmt = conexao.createStatement();
/*  62: 49 */       stmt.execute(sql);
/*  63: 50 */       return stmt.getResultSet();
/*  64:    */     }
/*  65:    */     catch (NullPointerException e)
/*  66:    */     {
/*  67: 53 */       if (conexao == null) {
/*  68: 53 */         throw new DaoException(e, "sem conexÃ£o aberta");
/*  69:    */       }
/*  70: 54 */       throw new DaoException(e, sql);
/*  71:    */     }
/*  72:    */     catch (Exception e)
/*  73:    */     {
/*  74: 56 */       throw new DaoException(e, sql);
/*  75:    */     }
/*  76:    */   }
/*  77:    */   
/*  78:    */   public void executaSql(String sql, Connection conexao)
/*  79:    */     throws DaoException
/*  80:    */   {
/*  81: 61 */     Statement stmt = null;
/*  82:    */     try
/*  83:    */     {
/*  84: 63 */       stmt = conexao.createStatement();
/*  85: 64 */       stmt.executeUpdate(sql);
/*  86: 65 */       stmt.close();
/*  87:    */     }
/*  88:    */     catch (SQLException e)
/*  89:    */     {
/*  90: 67 */       throw new DaoException(e, sql);
/*  91:    */     }
/*  92:    */   }
/*  93:    */   
/*  94:    */   public int getValorInt(String sql, DaoConexao conexao)
/*  95:    */     throws DaoException
/*  96:    */   {
/*  97: 73 */     Statement stmt = null;
/*  98:    */     try
/*  99:    */     {
/* 100: 76 */       stmt = conexao.getConexao().createStatement();
/* 101: 77 */       stmt.execute(sql);
/* 102: 78 */       ResultSet rs = stmt.getResultSet();
/* 103: 79 */       rs.next();
/* 104: 80 */       return rs.getInt(1);
/* 105:    */     }
/* 106:    */     catch (NullPointerException e)
/* 107:    */     {
/* 108: 83 */       if (conexao.getConexao() == null) {
/* 109: 83 */         throw new DaoException(e, "sem conexÃ£o aberta");
/* 110:    */       }
/* 111: 84 */       throw new DaoException(e, sql);
/* 112:    */     }
/* 113:    */     catch (Exception e)
/* 114:    */     {
/* 115: 86 */       throw new DaoException(e, sql);
/* 116:    */     }
/* 117:    */   }
/* 118:    */   
/* 119:    */   public String getValorString(String sql, DaoConexao conexao)
/* 120:    */     throws DaoException
/* 121:    */   {
/* 122: 91 */     Statement stmt = null;
/* 123:    */     try
/* 124:    */     {
/* 125: 94 */       stmt = conexao.getConexao().createStatement();
/* 126: 95 */       stmt.execute(sql);
/* 127: 96 */       ResultSet rs = stmt.getResultSet();
/* 128: 97 */       rs.next();
/* 129: 98 */       return rs.getString(1);
/* 130:    */     }
/* 131:    */     catch (NullPointerException e)
/* 132:    */     {
/* 133:100 */       if (conexao.getConexao() == null) {
/* 134:100 */         throw new DaoException(e, "sem conexÃ£o aberta");
/* 135:    */       }
/* 136:101 */       throw new DaoException(e, sql);
/* 137:    */     }
/* 138:    */     catch (Exception e)
/* 139:    */     {
/* 140:103 */       throw new DaoException(e, sql);
/* 141:    */     }
/* 142:    */   }
/* 143:    */   
/* 144:    */   public long getValorLong(String sql, DaoConexao conexao)
/* 145:    */     throws DaoException
/* 146:    */   {
/* 147:108 */     Statement stmt = null;
/* 148:    */     try
/* 149:    */     {
/* 150:111 */       stmt = conexao.getConexao().createStatement();
/* 151:112 */       stmt.execute(sql);
/* 152:113 */       ResultSet rs = stmt.getResultSet();
/* 153:114 */       rs.next();
/* 154:115 */       return rs.getLong(1);
/* 155:    */     }
/* 156:    */     catch (NullPointerException e)
/* 157:    */     {
/* 158:117 */       if (conexao.getConexao() == null) {
/* 159:117 */         throw new DaoException(e, "sem conexÃ£o aberta");
/* 160:    */       }
/* 161:118 */       throw new DaoException(e, sql);
/* 162:    */     }
/* 163:    */     catch (Exception e)
/* 164:    */     {
/* 165:120 */       throw new DaoException(e, sql);
/* 166:    */     }
/* 167:    */   }
/* 168:    */   
/* 169:    */   public void executaSqlForcado(String sql, DaoConexao conexao)
/* 170:    */     throws DaoException
/* 171:    */   {
/* 172:    */     try
/* 173:    */     {
/* 174:129 */       executaSql(sql, conexao.getConexao());
/* 175:    */     }
/* 176:    */     catch (Exception e)
/* 177:    */     {
/* 178:    */       try
/* 179:    */       {
/* 180:132 */         if (conexao.getConexao().isClosed())
/* 181:    */         {
/* 182:133 */           conexao.setConexao(MySqlConnectionPool.criaConexao(this.urlConexao, this.usuario, this.senha, "com.mysql.jdbc.Driver"));
/* 183:134 */           executaSql(sql, conexao.getConexao());
/* 184:    */         }
/* 185:    */         else
/* 186:    */         {
/* 187:135 */           throw new DaoException(e);
/* 188:    */         }
/* 189:    */       }
/* 190:    */       catch (Exception e2)
/* 191:    */       {
/* 192:138 */         throw new DaoException(e);
/* 193:    */       }
/* 194:    */     }
/* 195:    */   }
/* 196:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.MySqlDataSource
 * JD-Core Version:    0.7.0.1
 */