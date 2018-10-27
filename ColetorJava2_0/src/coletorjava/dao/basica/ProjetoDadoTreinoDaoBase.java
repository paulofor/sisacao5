package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.ProjetoDadoTreino;
import coletorjava.regracolecao.filtro.ProjetoDadoTreinoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ProjetoDadoTreinoDaoBase extends DaoAplicacao implements ProjetoDadoTreinoDaoBaseI {
	
	
	public ProjetoDadoTreinoDaoBase() {
		super();
	}
	public ProjetoDadoTreinoDaoBase(DataFonte dataSource) {
		super(dataSource);
	}
	protected String ConsultaJoin() {
		String tabelas;
		tabelas = tabelaSelect();
		return tabelas;
	}
	protected String CamposSelectJoin() {
		String select;
		select = camposOrdenados();
		return select;
	}
	protected  MontadorDaoI criaMontadorPadrao() {
		return new ProjetoDadoTreinoMontador();
	}
	public static String tabelaSelect() {
		return " projeto_dado_treino" ;
	}
	public  String orderByLista() {
		return orderBy();
	}
	public String getLimite() {
		return "";
	}
	public  String whereLista() {
		return "";
	}
	public  String whereListaConcatenado() {
		return "";
	}
	public   static String orderBy() {
		return " order by " + tabelaSelect() + ".target " ;
	}
	
	
	public static String camposOrdenados() {
		return " projeto_dado_treino.id_projeto_dado_treino " 
		+ " ,projeto_dado_treino.target " 
		+ " ,projeto_dado_treino.stop " 
		+ " ,projeto_dado_treino.posicao_compra_venda " 
		+ " , DATE_FORMAT(projeto_dado_treino.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,projeto_dado_treino.id_ticker_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_projeto_dado_treino " 
		+ " , " + nomeTabela + ".target " 
		+ " , " + nomeTabela + ".stop " 
		+ " , " + nomeTabela + ".posicao_compra_venda " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_ticker_ra " 
		;
	}
	
	
	@Override
	public void insereItem(ProjetoDadoTreino item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ProjetoDadoTreino item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ProjetoDadoTreino item) throws DaoException {
		ProjetoDadoTreino teste = this.obtemPorChave(item.getIdProjetoDadoTreino());
      	if (teste == null)
      	{
        	insereItemCompleto(item);
          	return true;
      	}
      	else
      	{
          	return false;
      	}
	}
	@Override
	public void insereItemLoad(ProjetoDadoTreino item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_projeto_dado_treino) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdProjetoDadoTreino(id);	
	}
	@Override
	public void alteraItem(ProjetoDadoTreino item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_projeto_dado_treino = " + item.getIdProjetoDadoTreino();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ProjetoDadoTreino item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_projeto_dado_treino = " + item.getIdProjetoDadoTreino();
		executaSql(query);
	}
	@Override
	public ProjetoDadoTreino obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_projeto_dado_treino = " + id;
        return (ProjetoDadoTreino) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ProjetoDadoTreinoFiltro filtro) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + CamposSelectJoin() + " from " + ConsultaJoin();
      	String where;
      	where = WhereFiltro(filtro) + whereListaConcatenado();
      	if (where.length() > 0)
        	sql += " where " + where;
      	sql += orderByLista();
      	return getListaSql(sql);
	}
	
	protected  String WhereFiltro( ProjetoDadoTreinoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoTickerReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_ticker_ra = " + filtro.getCodigoTickerReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ProjetoDadoTreinoFiltro filtro)
			throws DaoException {
		setMontador(null);
		String sql;
		sql = "select " + camposOrdenados() + " from " + tabelaSelect();
      	String where;
		where = WhereFiltro(filtro)  + whereListaConcatenado();
		if (where.length() > 0)
			sql += " where " + where;
		sql += orderByLista();
		return getListaSql(sql);
	}
	
	@Override
	public List ListaCorrente() throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenados() + " from " + tabelaSelect() + orderByLista();
      	return getListaSql(sql);
	}
	
	
	protected String valoresInsert(ProjetoDadoTreino item) {
		return " ( '" + item.getIdProjetoDadoTreino() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getTarget()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getStop()) + "'  "
		+ " ,'" + item.getPosicaoCompraVenda() + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ," + item.getIdTickerRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_projeto_dado_treino " 
		+ " ,target " 
		+ " ,stop " 
		+ " ,posicao_compra_venda " 
		+ " ,ultima_alteracao " 
		+ " ,id_ticker_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ProjetoDadoTreino item) {
		return " id_projeto_dado_treino = '" + item.getIdProjetoDadoTreino() + "'  " 
		+ " , target = '" +  DCConvert.ToDataBase(item.getTarget()) + "'  "
		+ " , stop = '" +  DCConvert.ToDataBase(item.getStop()) + "'  "
		+ " , posicao_compra_venda = '" + item.getPosicaoCompraVenda() + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(ProjetoDadoTreino item) {
		return " id_projeto_dado_treino = '" + item.getIdProjetoDadoTreino() + "'  " 
		+ " , target = '" +  DCConvert.ToDataBase(item.getTarget()) + "'  " 
		+ " , stop = '" +  DCConvert.ToDataBase(item.getStop()) + "'  " 
		+ " , posicao_compra_venda = '" + item.getPosicaoCompraVenda() + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public ProjetoDadoTreino obtemPorDadoTreinoGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinDadoTreino_Gerou() + 
			" where id_dado_treino = " + id;
		return (ProjetoDadoTreino) getObjeto(sql);
	}
	*/
	public static String innerJoinDadoTreino_Gerou() {
		return " inner join " + DadoTreinoDaoBase.tabelaSelect() + " on " + DadoTreinoDaoBase.tabelaSelect() + ".id_projeto_dado_treino_p = " + tabelaSelect() + ".id_projeto_dado_treino ";  
	}
	public static String outerJoinDadoTreino_Gerou() {
		return " left outer join " + DadoTreinoDaoBase.tabelaSelect() + " on " + DadoTreinoDaoBase.tabelaSelect() + ".id_projeto_dado_treino_p = " + tabelaSelect() + ".id_projeto_dado_treino ";  
	}
 	
	/*
	public ProjetoDadoTreino obtemPorResultadoMesGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinResultadoMes_Gerou() + 
			" where id_resultado_mes = " + id;
		return (ProjetoDadoTreino) getObjeto(sql);
	}
	*/
	public static String innerJoinResultadoMes_Gerou() {
		return " inner join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_projeto_dado_treino_gp = " + tabelaSelect() + ".id_projeto_dado_treino ";  
	}
	public static String outerJoinResultadoMes_Gerou() {
		return " left outer join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_projeto_dado_treino_gp = " + tabelaSelect() + ".id_projeto_dado_treino ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteATicker(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_ticker_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorTickerReferenteA(long id) throws DaoException {
		return getPorReferenteATicker(id);
	}
	public boolean excluiPorReferenteATicker(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_ticker_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinTicker_ReferenteA() {
	//	return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_projeto_dado_treino_g = " + tabelaSelect() + ".id_projeto_dado_treino ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemTicker_ReferenteA = false;
	public void setObtemTicker_ReferenteA() {
		_obtemTicker_ReferenteA = true;
	}
	protected String outterJoinTicker_ReferenteA() {
		return " left outer join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	public boolean atualizaReferenteATicker(long idProjetoDadoTreino, long idTickerRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_ticker_ra  = " + idTickerRa +
        " where id_projeto_dado_treino = " +  idProjetoDadoTreino;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinTicker_ReferenteA() {
		return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemTicker_ReferenteA?" , " +TickerDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemTicker_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemTicker_ReferenteA? outterJoinTicker_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ProjetoDadoTreinoMontador(), null);
		if (this._obtemTicker_ReferenteA)
            montador.adicionaMontador(new TickerMontador(), "Ticker_ReferenteA");
         return montador;
    }
	
	
}
