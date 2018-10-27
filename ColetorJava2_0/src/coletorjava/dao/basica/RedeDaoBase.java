package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.Rede;
import coletorjava.regracolecao.filtro.RedeFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class RedeDaoBase extends DaoAplicacao implements RedeDaoBaseI {
	
	
	public RedeDaoBase() {
		super();
	}
	public RedeDaoBase(DataFonte dataSource) {
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
		return new RedeMontador();
	}
	public static String tabelaSelect() {
		return " rede" ;
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
		return " order by " + tabelaSelect() + ".qtdeHidden1 " ;
	}
	
	
	public static String camposOrdenados() {
		return " rede.id_rede " 
		+ " ,rede.qtdeHidden1 " 
		+ " ,rede.qtdeHidden2 " 
		+ " ,rede.qtdeHidden3 " 
		+ " , DATE_FORMAT(rede.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_rede " 
		+ " , " + nomeTabela + ".qtdeHidden1 " 
		+ " , " + nomeTabela + ".qtdeHidden2 " 
		+ " , " + nomeTabela + ".qtdeHidden3 " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		;
	}
	
	
	@Override
	public void insereItem(Rede item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Rede item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Rede item) throws DaoException {
		Rede teste = this.obtemPorChave(item.getIdRede());
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
	public void insereItemLoad(Rede item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_rede) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdRede(id);	
	}
	@Override
	public void alteraItem(Rede item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_rede = " + item.getIdRede();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Rede item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_rede = " + item.getIdRede();
		executaSql(query);
	}
	@Override
	public Rede obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_rede = " + id;
        return (Rede) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(RedeFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( RedeFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(RedeFiltro filtro)
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
	
	
	protected String valoresInsert(Rede item) {
		return " ( '" + item.getIdRede() + "'  " 
		+ " ,'" + item.getQtdeHidden1() + "'  "
		+ " ,'" + item.getQtdeHidden2() + "'  "
		+ " ,'" + item.getQtdeHidden3() + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_rede " 
		+ " ,qtdeHidden1 " 
		+ " ,qtdeHidden2 " 
		+ " ,qtdeHidden3 " 
		+ " ,ultima_alteracao " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Rede item) {
		return " id_rede = '" + item.getIdRede() + "'  " 
		+ " , qtdeHidden1 = '" + item.getQtdeHidden1() + "'  "
		+ " , qtdeHidden2 = '" + item.getQtdeHidden2() + "'  "
		+ " , qtdeHidden3 = '" + item.getQtdeHidden3() + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		;
	}
	protected String camposValoresUpdateEdicao(Rede item) {
		return " id_rede = '" + item.getIdRede() + "'  " 
		+ " , qtdeHidden1 = '" + item.getQtdeHidden1() + "'  " 
		+ " , qtdeHidden2 = '" + item.getQtdeHidden2() + "'  " 
		+ " , qtdeHidden3 = '" + item.getQtdeHidden3() + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Rede obtemPorTreinoRedeGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinTreinoRede_Gerou() + 
			" where id_treino_rede = " + id;
		return (Rede) getObjeto(sql);
	}
	*/
	public static String innerJoinTreinoRede_Gerou() {
		return " inner join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_rede_pa = " + tabelaSelect() + ".id_rede ";  
	}
	public static String outerJoinTreinoRede_Gerou() {
		return " left outer join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_rede_pa = " + tabelaSelect() + ".id_rede ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
        return saida;
    }
    
    public void limpaObtem()
    {
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new RedeMontador(), null);
         return montador;
    }
	
	
}
