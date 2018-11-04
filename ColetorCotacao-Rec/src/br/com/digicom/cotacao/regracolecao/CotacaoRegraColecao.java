/*     */ package br.com.digicom.cotacao.regracolecao;
/*     */ 
/*     */ import br.com.digicom.cotacao.dao.CotacaoDao;
/*     */ import br.com.digicom.cotacao.dao.CotacaoDaoBaseI;
/*     */ import br.com.digicom.cotacao.vo.Cotacao;
/*     */ import br.com.digicom.lib.dao.DaoConexao;
/*     */ import br.com.digicom.lib.dao.DaoException;
/*     */ import java.util.List;
/*     */ 
/*     */ public abstract class CotacaoRegraColecao
/*     */ {
/*     */   private CotacaoFiltro _filtro;
/*     */   private CotacaoFiltro[] _listaEntrada;
/*     */ 
/*     */   public CotacaoRegraColecao()
/*     */   {
/*  17 */     this._filtro = null;
/*     */   }
/*     */ 
/*     */   public List ListaCorrente()
/*     */     throws DaoException
/*     */   {
/*  23 */     CotacaoDaoBaseI dao = getDao();
/*  24 */     DaoConexao conexao = dao.criaConexao();
/*  25 */     dao.setConexao(conexao);
/*     */ 
/*  27 */     CotacaoFiltro filtroWork = getFiltro();
/*  28 */     List saida = dao.ListaCorrente();
/*  29 */     dao.liberaConexao(conexao);
/*  30 */     return saida;
/*     */   }
/*     */ 
/*     */   public CotacaoFiltro getFiltro()
/*     */   {
/*  35 */     if (this._filtro == null) this._filtro = new CotacaoFiltro();
/*  36 */     return this._filtro;
/*     */   }
/*     */   public void setFiltro(CotacaoFiltro dado) {
/*  39 */     this._filtro = dado;
/*     */   }
/*     */ 
/*     */   public CotacaoFiltro[] getListaEntrada() {
/*  43 */     return this._listaEntrada;
/*     */   }
/*     */   public void setListaEntrada(CotacaoFiltro[] dado) {
/*  46 */     this._listaEntrada = dado;
/*     */   }
/*     */ 
/*     */   public final Cotacao InsereCotacao() throws DaoException {
/*  50 */     CotacaoDaoBaseI dao = getDao();
/*  51 */     preparaDaoParaConexao(dao);
/*  52 */     DaoConexao conexao = dao.criaConexao();
/*  53 */     Cotacao saida = InsereCotacao(conexao);
/*  54 */     dao.liberaConexao(conexao);
/*  55 */     return saida; } 
/*     */   public abstract Cotacao InsereCotacao(DaoConexao paramDaoConexao) throws DaoException;
/*     */ 
/*     */   protected abstract CotacaoDao getDao();
/*     */ 
/*     */   protected void preparaDaoParaConexao(CotacaoDaoBaseI dao) throws DaoException {  }
/*     */ 
/*  63 */   public List ListaFiltro() throws DaoException { CotacaoDaoBaseI dao = getDao();
/*  64 */     DaoConexao conexao = dao.criaConexao();
/*  65 */     dao.setConexao(conexao);
/*  66 */     List saida = dao.ListaFiltroSimples(getFiltro());
/*  67 */     dao.liberaConexao(conexao);
/*  68 */     return saida; }
/*     */ 
/*     */   public List ListaFiltroSimples() throws DaoException {
/*  71 */     CotacaoDaoBaseI dao = getDao();
/*  72 */     DaoConexao conexao = dao.criaConexao();
/*  73 */     dao.setConexao(conexao);
/*  74 */     List saida = dao.ListaFiltroSimples(getFiltro());
/*  75 */     dao.liberaConexao(conexao);
/*  76 */     return saida;
/*     */   }
/*     */   public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
/*  79 */     CotacaoDaoBaseI dao = getDao();
/*  80 */     dao.setConexao(conexao);
/*  81 */     List saida = dao.ListaFiltroSimples(getFiltro());
/*  82 */     return saida;
/*     */   }
/*     */   public Cotacao PreInsercao(Cotacao item) {
/*  85 */     return item;
/*     */   }
/*     */   public Cotacao PreAlteracao(Cotacao item) {
/*  88 */     return item;
/*     */   }
/*     */   public Cotacao obtemPorChave(long chave) throws DaoException {
/*  91 */     CotacaoDaoBaseI dao = getDao();
/*  92 */     DaoConexao conexao = dao.criaConexao();
/*  93 */     dao.setConexao(conexao);
/*  94 */     Cotacao saida = obtemPorChave(chave, conexao);
/*  95 */     dao.liberaConexao(conexao);
/*  96 */     return saida;
/*     */   }
/*     */   public Cotacao obtemPorChave(long chave, DaoConexao conexao) throws DaoException {
/*  99 */     CotacaoDaoBaseI dao = getDao();
/* 100 */     dao.setConexao(conexao);
/* 101 */     Cotacao saida = dao.obtemPorChave(chave);
/* 102 */     return saida;
/*     */   }
/*     */ }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.regracolecao.CotacaoRegraColecao
 * JD-Core Version:    0.6.0
 */