/*     */ package br.com.digicom.cotacao.dao;
/*     */ 
/*     */ import br.com.digicom.cotacao.regracolecao.CotacaoFiltro;
/*     */ import br.com.digicom.cotacao.vo.Cotacao;
/*     */ import br.com.digicom.lib.dao.DaoException;
/*     */ import br.com.digicom.lib.dao.DataFonte;
/*     */ import br.com.digicom.lib.dao.MontadorDaoI;
/*     */ import br.com.digicom.lib.util.DCConvert;
/*     */ import java.util.List;
/*     */ 
/*     */ public class CotacaoDaoBase extends DaoAplicacao
/*     */   implements CotacaoDaoBaseI
/*     */ {
/*     */   public CotacaoDaoBase(DataFonte dataSource)
/*     */   {
/*  19 */     super(dataSource);
/*     */   }
/*     */ 
/*     */   protected String ConsultaJoin()
/*     */   {
/*  24 */     String tabelas = tabelaSelect();
/*  25 */     return tabelas;
/*     */   }
/*     */ 
/*     */   protected String CamposSelectJoin()
/*     */   {
/*  31 */     String select = camposOrdenados();
/*  32 */     return select;
/*     */   }
/*     */ 
/*     */   protected MontadorDaoI criaMontadorPadrao() {
/*  36 */     return new CotacaoMontador();
/*     */   }
/*     */   public static String camposOrdenados() {
/*  39 */     String camposSaida = null;
/*     */ 
/*  46 */     return camposSaida;
/*     */   }
/*     */   public static String camposOrdenadosAlias(String nomeTabela) {
/*  49 */     String camposSaida = null;
/*  50 */     camposSaida = " ";
/*  51 */     camposSaida = camposSaida + nomeTabela;
/*  52 */     camposSaida = camposSaida + ".id_opcao_cotacao";
/*  53 */     camposSaida = camposSaida + ", ";
/*  54 */     camposSaida = camposSaida + nomeTabela;
/*  55 */     camposSaida = camposSaida + ".neg";
/*  56 */     camposSaida = camposSaida + ", DATE_FORMAT(";
/*  57 */     camposSaida = camposSaida + nomeTabela;
/*  58 */     camposSaida = camposSaida + ".data,'%d-%m-%Y')";
/*  59 */     camposSaida = camposSaida + ", ";
/*  60 */     camposSaida = camposSaida + nomeTabela;
/*  61 */     camposSaida = camposSaida + ".ult";
/*  62 */     camposSaida = camposSaida + ", DATE_FORMAT(";
/*  63 */     camposSaida = camposSaida + nomeTabela;
/*  64 */     camposSaida = camposSaida + ".hora_real,'%H:%i')";
/*  65 */     camposSaida = camposSaida + ", DATE_FORMAT(";
/*  66 */     camposSaida = camposSaida + nomeTabela;
/*  67 */     camposSaida = camposSaida + ".hora_neg,'%H:%i')";
/*  68 */     return camposSaida;
/*     */   }
/*     */   public static String tabelaSelect() {
/*  71 */     return " cotacao";
/*     */   }
/*     */   public String orderByLista() {
/*  74 */     return "";
/*     */   }
/*     */   public String whereLista() {
/*  77 */     return "";
/*     */   }
/*     */   public String whereListaConcatenado() {
/*  80 */     return "";
/*     */   }
/*     */   public static String orderBy() {
/*  83 */     return "";
/*     */   }
/*     */   public void insereItem(Cotacao item) throws DaoException {
/*  86 */     String query = null;
/*  87 */     query = " insert into cotacao (neg , data , ult , hora_real , hora_neg) values ('" + item.getNeg() + "' , '" + DCConvert.ToDataAAAA_MM_DD(item.getData()) + "' , '" + item.getUlt() + "' , '" + item.getHoraReal() + "' , '" + item.getHoraNegocio() + "')";
/*  88 */     executaSql(query);
/*     */   }
/*     */   public void insereItemCompleto(Cotacao item) throws DaoException {
/*  91 */     String query = null;
/*  92 */     query = " insert into cotacao (id_opcao_cotacao , neg , data , ult , hora_real , hora_neg) values ('" + item.getIdCotacao() + "' , '" + item.getNeg() + "' , '" + DCConvert.ToDataAAAA_MM_DD(item.getData()) + "' , '" + item.getUlt() + "' , '" + item.getHoraReal() + "' , '" + item.getHoraNegocio() + "')";
/*  93 */     executaSql(query);
/*     */   }
/*     */   public boolean insereSeNaoExiste(Cotacao item) throws DaoException {
/*  96 */     Cotacao teste = obtemPorChave(item.getIdCotacao());
/*  97 */     if (teste == null)
/*     */     {
/*  99 */       insereItemCompleto(item);
/* 100 */       return true;
/*     */     }
/*     */ 
/* 104 */     return false;
/*     */   }
/*     */ 
/*     */   public void insereItemLoad(Cotacao item) throws DaoException {
/* 108 */     String query = null;
/* 109 */     query = " insert into opcao_cotacao (neg , data , ult , hora_real , hora_neg) values ('" + item.getNeg() + "' , '" + DCConvert.ToDataAAAA_MM_DD(item.getData()) + "' , '" + item.getUlt() + "' , '" + item.getHoraReal() + "' , '" + item.getHoraNegocio() + "')";
/* 110 */     executaSql(query);
/*     */ 
/* 113 */     long id = getValorLong(" SELECT MAX(id_opcao_cotacao) from opcao_cotacao");
/* 114 */     item.setIdCotacao(id);
/*     */   }
/*     */   public void alteraItem(Cotacao item) throws DaoException {
/* 117 */     String query = null;
/* 118 */     query = " update opcao_cotacao set neg = '" + item.getNeg() + "'  , data = '" + DCConvert.ToDataAAAA_MM_DD(item.getData()) + "'  , ult = '" + item.getUlt() + "'  , hora_real = '" + item.getHoraReal() + "'  , hora_neg = '" + item.getHoraNegocio() + "'   where id_opcao_cotacao = " + item.getIdCotacao();
/* 119 */     executaSql(query);
/*     */   }
/*     */   public void excluiItem(Cotacao item) throws DaoException {
/* 122 */     String query = null;
/* 123 */     query = " delete from opcao_cotacao  where id_opcao_cotacao = " + item.getIdCotacao();
/* 124 */     executaSql(query);
/*     */   }
/*     */   public Cotacao obtemPorChave(long chave) throws DaoException {
/* 127 */     String query = null;
/* 128 */     query = " select " + CamposSelectJoin() + " from " + ConsultaJoin() + "  where id_opcao_cotacao = " + chave;
/* 129 */     return (Cotacao)getObjeto(query);
/*     */   }
/*     */ 
/*     */   public List ListaCorrente() throws DaoException
/*     */   {
/* 134 */     String sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin() + orderBy();
/* 135 */     return getListaSql(sql);
/*     */   }
/*     */ 
/*     */   public List ListaFiltroSimples(CotacaoFiltro filtro) throws DaoException
/*     */   {
/* 140 */     String sql = "select " + camposOrdenados() + " from " + tabelaSelect();
/*     */ 
/* 142 */     String where = WhereFiltro(filtro) + whereListaConcatenado();
/* 143 */     if (where.length() > 0)
/* 144 */       sql = sql + " where " + where;
/* 145 */     sql = sql + orderByLista();
/* 146 */     return getListaSql(sql);
/*     */   }
/*     */   protected String WhereFiltro(CotacaoFiltro filtro) {
/* 149 */     String saida = "";
/*     */ 
/* 151 */     boolean primeiro = true;
/* 152 */     return saida;
/*     */   }
/*     */ 
/*     */   public List ListaFiltro(CotacaoFiltro filtro) throws DaoException {
/* 156 */     String sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
/*     */ 
/* 158 */     String where = WhereFiltro(filtro) + whereListaConcatenado();
/* 159 */     if (where.length() > 0)
/* 160 */       sql = sql + " where " + where;
/* 161 */     sql = sql + orderByLista();
/* 162 */     return getListaSql(sql);
/*     */   }
/*     */ 
/*     */   public static String joinTotal()
/*     */   {
/* 169 */     return "";
/*     */   }
/*     */ }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.dao.CotacaoDaoBase
 * JD-Core Version:    0.6.0
 */