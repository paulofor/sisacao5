package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.OpcaoSisacaoSerie;
import coletorjava.regracolecao.filtro.OpcaoSisacaoSerieFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OpcaoSisacaoSerieDaoBase extends DaoAplicacao implements OpcaoSisacaoSerieDaoBaseI {
	
	
	public OpcaoSisacaoSerieDaoBase() {
		super();
	}
	public OpcaoSisacaoSerieDaoBase(DataFonte dataSource) {
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
		return new OpcaoSisacaoSerieMontador();
	}
	public static String tabelaSelect() {
		return " opcao_sisacao_serie" ;
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
		return " order by " + tabelaSelect() + ".mes_ano " ;
	}
	
	
	public static String camposOrdenados() {
		return " opcao_sisacao_serie.id_opcao_sisacao_serie " 
		+ " , DATE_FORMAT(opcao_sisacao_serie.mes_ano,'%d-%m-%Y') " 
		+ " ,opcao_sisacao_serie.letra " 
		+ " , DATE_FORMAT(opcao_sisacao_serie.data_vencimento,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(opcao_sisacao_serie.data_inicio_coleta,'%d-%m-%Y') " 
		+ " ,opcao_sisacao_serie.construida " 
		+ " ,opcao_sisacao_serie.possui_intraday " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_opcao_sisacao_serie " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".mes_ano,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".letra " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_vencimento,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_coleta,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".construida " 
		+ " , " + nomeTabela + ".possui_intraday " 
		;
	}
	
	
	@Override
	public void insereItem(OpcaoSisacaoSerie item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OpcaoSisacaoSerie item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OpcaoSisacaoSerie item) throws DaoException {
		OpcaoSisacaoSerie teste = this.obtemPorChave(item.getIdOpcaoSisacaoSerie());
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
	public void insereItemLoad(OpcaoSisacaoSerie item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_opcao_sisacao_serie) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOpcaoSisacaoSerie(id);	
	}
	@Override
	public void alteraItem(OpcaoSisacaoSerie item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_opcao_sisacao_serie = " + item.getIdOpcaoSisacaoSerie();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OpcaoSisacaoSerie item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_opcao_sisacao_serie = " + item.getIdOpcaoSisacaoSerie();
		executaSql(query);
	}
	@Override
	public OpcaoSisacaoSerie obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_opcao_sisacao_serie = " + id;
        return (OpcaoSisacaoSerie) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OpcaoSisacaoSerieFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( OpcaoSisacaoSerieFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(OpcaoSisacaoSerieFiltro filtro)
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
	
	
	protected String valoresInsert(OpcaoSisacaoSerie item) {
		return " ( '" + item.getIdOpcaoSisacaoSerie() + "'  " 
		+ " ," + (item.getMesAno()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAno()) ) + "  "
		+ " ,'" + item.getLetra() + "'  "
		+ " ," + (item.getDataVencimento()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataVencimento()) ) + "  "
		+ " ," + (item.getDataInicioColeta()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColeta()) ) + "  "
		+ " ,'" + (item.getConstruida()?"S":"N") + "'  "
		+ " ,'" + (item.getPossuiIntraday()?"S":"N") + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_opcao_sisacao_serie " 
		+ " ,mes_ano " 
		+ " ,letra " 
		+ " ,data_vencimento " 
		+ " ,data_inicio_coleta " 
		+ " ,construida " 
		+ " ,possui_intraday " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OpcaoSisacaoSerie item) {
		return " id_opcao_sisacao_serie = '" + item.getIdOpcaoSisacaoSerie() + "'  " 
		+ " , mes_ano = " + (item.getMesAno()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAno()) ) + "  "
		+ " , letra = '" + item.getLetra() + "'  "
		+ " , data_vencimento = " + (item.getDataVencimento()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataVencimento()) ) + "  "
		+ " , data_inicio_coleta = " + (item.getDataInicioColeta()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColeta()) ) + "  "
		+ " , construida = '" + (item.getConstruida()?"S":"N") + "'  "
		+ " , possui_intraday = '" + (item.getPossuiIntraday()?"S":"N") + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(OpcaoSisacaoSerie item) {
		return " id_opcao_sisacao_serie = '" + item.getIdOpcaoSisacaoSerie() + "'  " 
		+ " , mes_ano = " + (item.getMesAno()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAno()) ) + "  " 
		+ " , letra = '" + item.getLetra() + "'  " 
		+ " , data_vencimento = " + (item.getDataVencimento()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataVencimento()) ) + "  " 
		+ " , data_inicio_coleta = " + (item.getDataInicioColeta()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColeta()) ) + "  " 
		+ " , construida = '" + (item.getConstruida()?"S":"N") + "'  " 
		+ " , possui_intraday = '" + (item.getPossuiIntraday()?"S":"N") + "'  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public OpcaoSisacaoSerie obtemPorOpcaoSisacaoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOpcaoSisacao_Possui() + 
			" where id_opcao_sisacao = " + id;
		return (OpcaoSisacaoSerie) getObjeto(sql);
	}
	*/
	public static String innerJoinOpcaoSisacao_Possui() {
		return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao_serie_pa = " + tabelaSelect() + ".id_opcao_sisacao_serie ";  
	}
	public static String outerJoinOpcaoSisacao_Possui() {
		return " left outer join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao_serie_pa = " + tabelaSelect() + ".id_opcao_sisacao_serie ";  
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
        montador.adicionaMontador(new OpcaoSisacaoSerieMontador(), null);
         return montador;
    }
	
	
}
