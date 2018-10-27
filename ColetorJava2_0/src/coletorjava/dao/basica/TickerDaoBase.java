package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.filtro.TickerFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class TickerDaoBase extends DaoAplicacao implements TickerDaoBaseI {
	
	
	public TickerDaoBase() {
		super();
	}
	public TickerDaoBase(DataFonte dataSource) {
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
		return new TickerMontador();
	}
	public static String tabelaSelect() {
		return " ticker" ;
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
		return " order by " + tabelaSelect() + ".nome " ;
	}
	
	
	public static String camposOrdenados() {
		return " ticker.id_ticker " 
		+ " ,ticker.nome " 
		+ " ,ticker.empresa " 
		+ " ,ticker.tipo_acao " 
		+ " , DATE_FORMAT(ticker.data_inicio_diario,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(ticker.data_mais_recente_diario,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(ticker.data_inicio_coleta_opcao,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(ticker.data_final_coleta_opcao,'%d-%m-%Y') " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_ticker " 
		+ " , " + nomeTabela + ".nome " 
		+ " , " + nomeTabela + ".empresa " 
		+ " , " + nomeTabela + ".tipo_acao " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_diario,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_mais_recente_diario,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_coleta_opcao,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_final_coleta_opcao,'%d-%m-%Y') " 
		;
	}
	
	
	@Override
	public void insereItem(Ticker item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Ticker item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Ticker item) throws DaoException {
		Ticker teste = this.obtemPorChave(item.getIdTicker());
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
	public void insereItemLoad(Ticker item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_ticker) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdTicker(id);	
	}
	@Override
	public void alteraItem(Ticker item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_ticker = " + item.getIdTicker();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Ticker item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_ticker = " + item.getIdTicker();
		executaSql(query);
	}
	@Override
	public Ticker obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_ticker = " + id;
        return (Ticker) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(TickerFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( TickerFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(TickerFiltro filtro)
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
	
	
	protected String valoresInsert(Ticker item) {
		return " ( '" + item.getIdTicker() + "'  " 
		+ " ,'" + item.getNome() + "'  "
		+ " ,'" + item.getEmpresa() + "'  "
		+ " ,'" + item.getTipoAcao() + "'  "
		+ " ," + (item.getDataInicioDiario()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioDiario()) ) + "  "
		+ " ," + (item.getDataMaisRecenteDiario()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataMaisRecenteDiario()) ) + "  "
		+ " ," + (item.getDataInicioColetaOpcao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColetaOpcao()) ) + "  "
		+ " ," + (item.getDataFinalColetaOpcao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataFinalColetaOpcao()) ) + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_ticker " 
		+ " ,nome " 
		+ " ,empresa " 
		+ " ,tipo_acao " 
		+ " ,data_inicio_diario " 
		+ " ,data_mais_recente_diario " 
		+ " ,data_inicio_coleta_opcao " 
		+ " ,data_final_coleta_opcao " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Ticker item) {
		return " id_ticker = '" + item.getIdTicker() + "'  " 
		+ " , nome = '" + item.getNome() + "'  "
		+ " , empresa = '" + item.getEmpresa() + "'  "
		+ " , tipo_acao = '" + item.getTipoAcao() + "'  "
		+ " , data_inicio_diario = " + (item.getDataInicioDiario()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioDiario()) ) + "  "
		+ " , data_mais_recente_diario = " + (item.getDataMaisRecenteDiario()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataMaisRecenteDiario()) ) + "  "
		+ " , data_inicio_coleta_opcao = " + (item.getDataInicioColetaOpcao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColetaOpcao()) ) + "  "
		+ " , data_final_coleta_opcao = " + (item.getDataFinalColetaOpcao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataFinalColetaOpcao()) ) + "  "
		;
	}
	protected String camposValoresUpdateEdicao(Ticker item) {
		return " id_ticker = '" + item.getIdTicker() + "'  " 
		+ " , nome = '" + item.getNome() + "'  " 
		+ " , empresa = '" + item.getEmpresa() + "'  " 
		+ " , tipo_acao = '" + item.getTipoAcao() + "'  " 
		+ " , data_inicio_diario = " + (item.getDataInicioDiario()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioDiario()) ) + "  " 
		+ " , data_mais_recente_diario = " + (item.getDataMaisRecenteDiario()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataMaisRecenteDiario()) ) + "  " 
		+ " , data_inicio_coleta_opcao = " + (item.getDataInicioColetaOpcao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColetaOpcao()) ) + "  " 
		+ " , data_final_coleta_opcao = " + (item.getDataFinalColetaOpcao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataFinalColetaOpcao()) ) + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public Ticker obtemPorOpcaoSisacaoGeralPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOpcaoSisacaoGeral_Possui() + 
			" where id_opcao_sisacao_geral = " + id;
		return (Ticker) getObjeto(sql);
	}
	*/
	public static String innerJoinOpcaoSisacaoGeral_Possui() {
		return " inner join " + OpcaoSisacaoGeralDaoBase.tabelaSelect() + " on " + OpcaoSisacaoGeralDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
	public static String outerJoinOpcaoSisacaoGeral_Possui() {
		return " left outer join " + OpcaoSisacaoGeralDaoBase.tabelaSelect() + " on " + OpcaoSisacaoGeralDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
 	
	/*
	public Ticker obtemPorOpcaoSisacaoGera(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOpcaoSisacao_Gera() + 
			" where id_opcao_sisacao = " + id;
		return (Ticker) getObjeto(sql);
	}
	*/
	public static String innerJoinOpcaoSisacao_Gera() {
		return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_ticker_dd = " + tabelaSelect() + ".id_ticker ";  
	}
	public static String outerJoinOpcaoSisacao_Gera() {
		return " left outer join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_ticker_dd = " + tabelaSelect() + ".id_ticker ";  
	}
 	
	/*
	public Ticker obtemPorEscolhaOpcaoPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinEscolhaOpcao_Possui() + 
			" where id_escolha_opcao = " + id;
		return (Ticker) getObjeto(sql);
	}
	*/
	public static String innerJoinEscolhaOpcao_Possui() {
		return " inner join " + EscolhaOpcaoDaoBase.tabelaSelect() + " on " + EscolhaOpcaoDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
	public static String outerJoinEscolhaOpcao_Possui() {
		return " left outer join " + EscolhaOpcaoDaoBase.tabelaSelect() + " on " + EscolhaOpcaoDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
 	
	/*
	public Ticker obtemPorProjetoDadoTreinoGera(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinProjetoDadoTreino_Gera() + 
			" where id_projeto_dado_treino = " + id;
		return (Ticker) getObjeto(sql);
	}
	*/
	public static String innerJoinProjetoDadoTreino_Gera() {
		return " inner join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
	public static String outerJoinProjetoDadoTreino_Gera() {
		return " left outer join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
 	
	/*
	public Ticker obtemPorOpcaoReferenciaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOpcaoReferencia_Possui() + 
			" where id_opcao_referencia = " + id;
		return (Ticker) getObjeto(sql);
	}
	*/
	public static String innerJoinOpcaoReferencia_Possui() {
		return " inner join " + OpcaoReferenciaDaoBase.tabelaSelect() + " on " + OpcaoReferenciaDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
	}
	public static String outerJoinOpcaoReferencia_Possui() {
		return " left outer join " + OpcaoReferenciaDaoBase.tabelaSelect() + " on " + OpcaoReferenciaDaoBase.tabelaSelect() + ".id_ticker_ra = " + tabelaSelect() + ".id_ticker ";  
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
        montador.adicionaMontador(new TickerMontador(), null);
         return montador;
    }
	
	
}
