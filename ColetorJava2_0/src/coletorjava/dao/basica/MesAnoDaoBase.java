package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.MesAno;
import coletorjava.regracolecao.filtro.MesAnoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class MesAnoDaoBase extends DaoAplicacao implements MesAnoDaoBaseI {
	
	
	public MesAnoDaoBase() {
		super();
	}
	public MesAnoDaoBase(DataFonte dataSource) {
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
		return new MesAnoMontador();
	}
	public static String tabelaSelect() {
		return " mes_ano" ;
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
		return " order by " + tabelaSelect() + ".nome_mes " ;
	}
	
	
	public static String camposOrdenados() {
		return " mes_ano.id_mes_ano " 
		+ " ,mes_ano.nome_mes " 
		+ " ,mes_ano.numero_ano " 
		+ " , DATE_FORMAT(mes_ano.mes_ano_data,'%d-%m-%Y') " 
		+ " ,mes_ano.numero_mes " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_mes_ano " 
		+ " , " + nomeTabela + ".nome_mes " 
		+ " , " + nomeTabela + ".numero_ano " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".mes_ano_data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".numero_mes " 
		;
	}
	
	
	@Override
	public void insereItem(MesAno item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(MesAno item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(MesAno item) throws DaoException {
		MesAno teste = this.obtemPorChave(item.getIdMesAno());
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
	public void insereItemLoad(MesAno item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_mes_ano) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdMesAno(id);	
	}
	@Override
	public void alteraItem(MesAno item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_mes_ano = " + item.getIdMesAno();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(MesAno item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_mes_ano = " + item.getIdMesAno();
		executaSql(query);
	}
	@Override
	public MesAno obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_mes_ano = " + id;
        return (MesAno) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(MesAnoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( MesAnoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(MesAnoFiltro filtro)
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
	
	
	protected String valoresInsert(MesAno item) {
		return " ( '" + item.getIdMesAno() + "'  " 
		+ " ,'" + item.getNomeMes() + "'  "
		+ " ,'" + item.getNumeroAno() + "'  "
		+ " ," + (item.getMesAnoData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAnoData()) ) + "  "
		+ " ,'" + item.getNumeroMes() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_mes_ano " 
		+ " ,nome_mes " 
		+ " ,numero_ano " 
		+ " ,mes_ano_data " 
		+ " ,numero_mes " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(MesAno item) {
		return " id_mes_ano = '" + item.getIdMesAno() + "'  " 
		+ " , nome_mes = '" + item.getNomeMes() + "'  "
		+ " , numero_ano = '" + item.getNumeroAno() + "'  "
		+ " , mes_ano_data = " + (item.getMesAnoData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAnoData()) ) + "  "
		+ " , numero_mes = '" + item.getNumeroMes() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(MesAno item) {
		return " id_mes_ano = '" + item.getIdMesAno() + "'  " 
		+ " , nome_mes = '" + item.getNomeMes() + "'  " 
		+ " , numero_ano = '" + item.getNumeroAno() + "'  " 
		+ " , mes_ano_data = " + (item.getMesAnoData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAnoData()) ) + "  " 
		+ " , numero_mes = '" + item.getNumeroMes() + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public MesAno obtemPorResultadoPrevisaoGera(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinResultadoPrevisao_Gera() + 
			" where id_resultado_previsao = " + id;
		return (MesAno) getObjeto(sql);
	}
	*/
	public static String innerJoinResultadoPrevisao_Gera() {
		return " inner join " + ResultadoPrevisaoDaoBase.tabelaSelect() + " on " + ResultadoPrevisaoDaoBase.tabelaSelect() + ".id_mes_ano_ra = " + tabelaSelect() + ".id_mes_ano ";  
	}
	public static String outerJoinResultadoPrevisao_Gera() {
		return " left outer join " + ResultadoPrevisaoDaoBase.tabelaSelect() + " on " + ResultadoPrevisaoDaoBase.tabelaSelect() + ".id_mes_ano_ra = " + tabelaSelect() + ".id_mes_ano ";  
	}
 	
	/*
	public MesAno obtemPorResultadoMesBasePara(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinResultadoMes_BasePara() + 
			" where id_resultado_mes = " + id;
		return (MesAno) getObjeto(sql);
	}
	*/
	public static String innerJoinResultadoMes_BasePara() {
		return " inner join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_mes_ano_ra = " + tabelaSelect() + ".id_mes_ano ";  
	}
	public static String outerJoinResultadoMes_BasePara() {
		return " left outer join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_mes_ano_ra = " + tabelaSelect() + ".id_mes_ano ";  
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
        montador.adicionaMontador(new MesAnoMontador(), null);
         return montador;
    }
	
	
}
