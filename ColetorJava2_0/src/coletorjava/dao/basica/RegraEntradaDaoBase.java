package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.RegraEntrada;
import coletorjava.regracolecao.filtro.RegraEntradaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class RegraEntradaDaoBase extends DaoAplicacao implements RegraEntradaDaoBaseI {
	
	
	public RegraEntradaDaoBase() {
		super();
	}
	public RegraEntradaDaoBase(DataFonte dataSource) {
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
		return new RegraEntradaMontador();
	}
	public static String tabelaSelect() {
		return " regra_entrada" ;
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
		return " order by " + tabelaSelect() + ".nome_regra " ;
	}
	
	
	public static String camposOrdenados() {
		return " regra_entrada.id_regra_entrada " 
		+ " ,regra_entrada.nome_regra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_regra_entrada " 
		+ " , " + nomeTabela + ".nome_regra " 
		;
	}
	
	
	@Override
	public void insereItem(RegraEntrada item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(RegraEntrada item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(RegraEntrada item) throws DaoException {
		RegraEntrada teste = this.obtemPorChave(item.getIdRegraEntrada());
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
	public void insereItemLoad(RegraEntrada item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_regra_entrada) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdRegraEntrada(id);	
	}
	@Override
	public void alteraItem(RegraEntrada item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_regra_entrada = " + item.getIdRegraEntrada();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(RegraEntrada item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_regra_entrada = " + item.getIdRegraEntrada();
		executaSql(query);
	}
	@Override
	public RegraEntrada obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_regra_entrada = " + id;
        return (RegraEntrada) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(RegraEntradaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( RegraEntradaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(RegraEntradaFiltro filtro)
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
	
	
	protected String valoresInsert(RegraEntrada item) {
		return " ( '" + item.getIdRegraEntrada() + "'  " 
		+ " ,'" + item.getNomeRegra() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_regra_entrada " 
		+ " ,nome_regra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(RegraEntrada item) {
		return " id_regra_entrada = '" + item.getIdRegraEntrada() + "'  " 
		+ " , nome_regra = '" + item.getNomeRegra() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(RegraEntrada item) {
		return " id_regra_entrada = '" + item.getIdRegraEntrada() + "'  " 
		+ " , nome_regra = '" + item.getNomeRegra() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
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
        montador.adicionaMontador(new RegraEntradaMontador(), null);
         return montador;
    }
	
	
}
