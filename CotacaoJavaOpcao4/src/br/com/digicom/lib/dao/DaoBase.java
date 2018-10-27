/*   1:    */ package br.com.digicom.lib.dao;
/*   2:    */ 
/*   3:    */ import br.com.digicom.lib.DCIObjetoDominio;
/*   4:    */ import java.sql.ResultSet;
/*   5:    */ import java.util.ArrayList;
/*   6:    */ import java.util.LinkedList;
/*   7:    */ import java.util.List;
/*   8:    */ 
/*   9:    */ public abstract class DaoBase
/*  10:    */   implements DaoI
/*  11:    */ {
/*  12:    */   public static final String MY_SQL = "MySql";
/*  13:    */   private DataFonte _dataSource;
/*  14:    */   private String _tipoDataSource;
/*  15:    */   private DaoConexao _conexao;
/*  16:    */   private MontadorDaoI _montador;
/*  17:    */   
/*  18:    */   protected void setMontador(MontadorDaoI montador)
/*  19:    */   {
/*  20: 18 */     this._montador = montador;
/*  21:    */   }
/*  22:    */   
/*  23:    */   public MontadorDaoI getMontador()
/*  24:    */   {
/*  25: 22 */     if (this._montador == null) {
/*  26: 23 */       this._montador = criaMontadorPadrao();
/*  27:    */     }
/*  28: 25 */     return this._montador;
/*  29:    */   }
/*  30:    */   
/*  31:    */   protected abstract MontadorDaoI criaMontadorPadrao();
/*  32:    */   
/*  33:    */   public void setConexao(DaoConexao conexao)
/*  34:    */   {
/*  35: 31 */     this._conexao = conexao;
/*  36:    */   }
/*  37:    */   
/*  38:    */   protected void setDataSource(DataFonte dataSource)
/*  39:    */   {
/*  40: 35 */     this._dataSource = dataSource;
/*  41:    */   }
/*  42:    */   
/*  43:    */   public DaoBase(DataFonte dataSource)
/*  44:    */   {
/*  45: 39 */     this._dataSource = dataSource;
/*  46:    */   }
/*  47:    */   
/*  48:    */   public DaoConexao criaConexao()
/*  49:    */     throws DaoException
/*  50:    */   {
/*  51: 43 */     return this._dataSource.criaConexao();
/*  52:    */   }
/*  53:    */   
/*  54:    */   public void liberaConexao(DaoConexao conexao)
/*  55:    */     throws DaoException
/*  56:    */   {
/*  57: 47 */     this._dataSource.liberaConexao(conexao);
/*  58:    */   }
/*  59:    */   
/*  60:    */   protected List getListaSqlListaInterna(String sql)
/*  61:    */     throws DaoException
/*  62:    */   {
/*  63: 51 */     List saida = getListaSqlListaInterna(sql, this._conexao);
/*  64: 52 */     return saida;
/*  65:    */   }
/*  66:    */   
/*  67:    */   protected List getListaSql(String sql)
/*  68:    */     throws DaoException
/*  69:    */   {
/*  70: 56 */     List saida = getListaSql(sql, this._conexao);
/*  71:    */     
/*  72: 58 */     return saida;
/*  73:    */   }
/*  74:    */   
/*  75:    */   private List getListaSqlListaInterna(String sql, DaoConexao conexao)
/*  76:    */     throws DaoException
/*  77:    */   {
/*  78: 62 */     List listaSaida = new ArrayList();
/*  79: 63 */     ResultSet resultado = this._dataSource.getListaSql(sql, conexao);
/*  80: 64 */     ResultadoLista resultadoLista = new ResultadoLista();
/*  81: 65 */     resultadoLista.setResultSet(resultado);
/*  82: 66 */     resultadoLista.setSql(sql);
/*  83: 67 */     boolean insere = false;
/*  84: 68 */     DCIObjetoDominio objeto = null;
/*  85: 69 */     DaoItemRetorno retorno = null;
/*  86: 70 */     while (resultadoLista.next())
/*  87:    */     {
/*  88:    */       try
/*  89:    */       {
/*  90: 72 */         retorno = getMontador().extraiRegistroListaInterna(resultadoLista, objeto);
/*  91: 73 */         insere = retorno.getInsere();
/*  92: 74 */         objeto = retorno.getObjeto();
/*  93:    */       }
/*  94:    */       catch (Exception e)
/*  95:    */       {
/*  96: 76 */         throw new DaoException(e, sql);
/*  97:    */       }
/*  98: 78 */       if (insere) {
/*  99: 79 */         listaSaida.add(objeto);
/* 100:    */       }
/* 101:    */     }
/* 102: 82 */     return listaSaida;
/* 103:    */   }
/* 104:    */   
/* 105:    */   private List getListaSql(String sql, DaoConexao conexao)
/* 106:    */     throws DaoException
/* 107:    */   {
/* 108: 88 */     List listaSaida = new LinkedList();
/* 109: 89 */     ResultSet resultado = this._dataSource.getListaSql(sql, conexao);
/* 110: 90 */     ResultadoLista resultadoLista = new ResultadoLista();
/* 111: 91 */     resultadoLista.setResultSet(resultado);
/* 112: 92 */     resultadoLista.setSql(sql);
/* 113: 93 */     while (resultadoLista.next())
/* 114:    */     {
/* 115: 94 */       DCIObjetoDominio objeto = getMontador().extraiRegistro(
/* 116: 95 */         resultadoLista);
/* 117: 96 */       listaSaida.add(objeto);
/* 118:    */     }
/* 119: 98 */     return listaSaida;
/* 120:    */   }
/* 121:    */   
/* 122:    */   protected void executaSql(String sql)
/* 123:    */     throws DaoException
/* 124:    */   {
/* 125:102 */     executaSql(sql, this._conexao);
/* 126:    */   }
/* 127:    */   
/* 128:    */   protected void executaSqlForcado(String sql)
/* 129:    */     throws DaoException
/* 130:    */   {
/* 131:106 */     executaSqlForcado(sql, this._conexao);
/* 132:    */   }
/* 133:    */   
/* 134:    */   private void executaSql(String sql, DaoConexao conexao)
/* 135:    */     throws DaoException
/* 136:    */   {
/* 137:110 */     this._dataSource.executaSql(sql, conexao);
/* 138:    */   }
/* 139:    */   
/* 140:    */   private void executaSqlForcado(String sql, DaoConexao conexao)
/* 141:    */     throws DaoException
/* 142:    */   {
/* 143:115 */     this._dataSource.executaSqlForcado(sql, conexao);
/* 144:    */   }
/* 145:    */   
/* 146:    */   protected DCIObjetoDominio getObjeto(String sql)
/* 147:    */     throws DaoException
/* 148:    */   {
/* 149:119 */     DCIObjetoDominio saida = getObjeto(sql, this._conexao);
/* 150:120 */     return saida;
/* 151:    */   }
/* 152:    */   
/* 153:    */   private DCIObjetoDominio getObjeto(String sql, DaoConexao conexao)
/* 154:    */     throws DaoException
/* 155:    */   {
/* 156:125 */     DCIObjetoDominio objeto = null;
/* 157:126 */     ResultSet resultado = this._dataSource.getListaSql(sql, conexao);
/* 158:127 */     ResultadoLista resultadoLista = new ResultadoLista();
/* 159:128 */     resultadoLista.setResultSet(resultado);
/* 160:129 */     resultadoLista.setSql(sql);
/* 161:130 */     if (resultadoLista.next()) {
/* 162:131 */       objeto = getMontador().extraiRegistro(resultadoLista);
/* 163:    */     }
/* 164:133 */     return objeto;
/* 165:    */   }
/* 166:    */   
/* 167:    */   private long getValorLong(String sql, DaoConexao conexao)
/* 168:    */     throws DaoException
/* 169:    */   {
/* 170:138 */     return this._dataSource.getValorLong(sql, conexao);
/* 171:    */   }
/* 172:    */   
/* 173:    */   protected long getValorLong(String sql)
/* 174:    */     throws DaoException
/* 175:    */   {
/* 176:142 */     long saida = getValorLong(sql, this._conexao);
/* 177:143 */     return saida;
/* 178:    */   }
/* 179:    */   
/* 180:    */   private int getValorInt(String sql, DaoConexao conexao)
/* 181:    */     throws DaoException
/* 182:    */   {
/* 183:147 */     return this._dataSource.getValorInt(sql, conexao);
/* 184:    */   }
/* 185:    */   
/* 186:    */   protected int getValorInt(String sql)
/* 187:    */     throws DaoException
/* 188:    */   {
/* 189:151 */     int saida = getValorInt(sql, this._conexao);
/* 190:152 */     return saida;
/* 191:    */   }
/* 192:    */   
/* 193:    */   private String getValorString(String sql, DaoConexao conexao)
/* 194:    */     throws DaoException
/* 195:    */   {
/* 196:157 */     return this._dataSource.getValorString(sql, conexao);
/* 197:    */   }
/* 198:    */   
/* 199:    */   protected String getValorString(String sql)
/* 200:    */     throws DaoException
/* 201:    */   {
/* 202:161 */     String saida = getValorString(sql, this._conexao);
/* 203:162 */     return saida;
/* 204:    */   }
/* 205:    */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.dao.DaoBase
 * JD-Core Version:    0.7.0.1
 */