package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.DiaPregao;
import coletorjava.regracolecao.filtro.DiaPregaoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class DiaPregaoDaoBase extends DaoAplicacao implements DiaPregaoDaoBaseI {
	
	
	public DiaPregaoDaoBase() {
		super();
	}
	public DiaPregaoDaoBase(DataFonte dataSource) {
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
		return new DiaPregaoMontador();
	}
	public static String tabelaSelect() {
		return " dia_pregao" ;
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
		return " order by " + tabelaSelect() + ".data " ;
	}
	
	
	public static String camposOrdenados() {
		return " dia_pregao.id_dia_pregao " 
		+ " , DATE_FORMAT(dia_pregao.data,'%d-%m-%Y') " 
		+ " ,dia_pregao.feriado " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_dia_pregao " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".feriado " 
		;
	}
	
	
	@Override
	public void insereItem(DiaPregao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(DiaPregao item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(DiaPregao item) throws DaoException {
		DiaPregao teste = this.obtemPorChave(item.getIdDiaPregao());
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
	public void insereItemLoad(DiaPregao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_dia_pregao) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdDiaPregao(id);	
	}
	@Override
	public void alteraItem(DiaPregao item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_dia_pregao = " + item.getIdDiaPregao();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(DiaPregao item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_dia_pregao = " + item.getIdDiaPregao();
		executaSql(query);
	}
	@Override
	public DiaPregao obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_dia_pregao = " + id;
        return (DiaPregao) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(DiaPregaoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( DiaPregaoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(DiaPregaoFiltro filtro)
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
	
	
	protected String valoresInsert(DiaPregao item) {
		return " ( '" + item.getIdDiaPregao() + "'  " 
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ,'" + (item.getFeriado()?"S":"N") + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_dia_pregao " 
		+ " ,data " 
		+ " ,feriado " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(DiaPregao item) {
		return " id_dia_pregao = '" + item.getIdDiaPregao() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , feriado = '" + (item.getFeriado()?"S":"N") + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(DiaPregao item) {
		return " id_dia_pregao = '" + item.getIdDiaPregao() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , feriado = '" + (item.getFeriado()?"S":"N") + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public DiaPregao obtemPorEscolhaOpcaoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinEscolhaOpcao_Possui() + 
			" where id_escolha_opcao = " + id;
		return (DiaPregao) getObjeto(sql);
	}
	*/
	public static String innerJoinEscolhaOpcao_Possui() {
		return " inner join " + EscolhaOpcaoDaoBase.tabelaSelect() + " on " + EscolhaOpcaoDaoBase.tabelaSelect() + ".id_dia_pregao_ra = " + tabelaSelect() + ".id_dia_pregao ";  
	}
	public static String outerJoinEscolhaOpcao_Possui() {
		return " left outer join " + EscolhaOpcaoDaoBase.tabelaSelect() + " on " + EscolhaOpcaoDaoBase.tabelaSelect() + ".id_dia_pregao_ra = " + tabelaSelect() + ".id_dia_pregao ";  
	}
 	
	/*
	public DiaPregao obtemPorOpcaoReferenciaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOpcaoReferencia_Possui() + 
			" where id_opcao_referencia = " + id;
		return (DiaPregao) getObjeto(sql);
	}
	*/
	public static String innerJoinOpcaoReferencia_Possui() {
		return " inner join " + OpcaoReferenciaDaoBase.tabelaSelect() + " on " + OpcaoReferenciaDaoBase.tabelaSelect() + ".id_dia_pregao_ra = " + tabelaSelect() + ".id_dia_pregao ";  
	}
	public static String outerJoinOpcaoReferencia_Possui() {
		return " left outer join " + OpcaoReferenciaDaoBase.tabelaSelect() + " on " + OpcaoReferenciaDaoBase.tabelaSelect() + ".id_dia_pregao_ra = " + tabelaSelect() + ".id_dia_pregao ";  
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
        montador.adicionaMontador(new DiaPregaoMontador(), null);
         return montador;
    }
	
	
}
