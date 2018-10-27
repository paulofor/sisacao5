package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.OpcaoSisacao;
import coletorjava.regracolecao.filtro.OpcaoSisacaoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OpcaoSisacaoDaoBase extends DaoAplicacao implements OpcaoSisacaoDaoBaseI {
	
	
	public OpcaoSisacaoDaoBase() {
		super();
	}
	public OpcaoSisacaoDaoBase(DataFonte dataSource) {
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
		return new OpcaoSisacaoMontador();
	}
	public static String tabelaSelect() {
		return " opcao_sisacao" ;
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
		return " order by " + tabelaSelect() + ".codigo_mercado " ;
	}
	
	
	public static String camposOrdenados() {
		return " opcao_sisacao.id_opcao_sisacao " 
		+ " ,opcao_sisacao.codigo_mercado " 
		+ " ,opcao_sisacao.preco_exercicio " 
		+ " , DATE_FORMAT(opcao_sisacao.data_inicio_coleta,'%d-%m-%Y') " 
		+ " ,opcao_sisacao.id_opcao_sisacao_serie_pa " 
		+ " ,opcao_sisacao.id_ticker_dd " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_opcao_sisacao " 
		+ " , " + nomeTabela + ".codigo_mercado " 
		+ " , " + nomeTabela + ".preco_exercicio " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_coleta,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".id_opcao_sisacao_serie_pa " 
		+ " , " + nomeTabela + ".id_ticker_dd " 
		;
	}
	
	
	@Override
	public void insereItem(OpcaoSisacao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OpcaoSisacao item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OpcaoSisacao item) throws DaoException {
		OpcaoSisacao teste = this.obtemPorChave(item.getIdOpcaoSisacao());
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
	public void insereItemLoad(OpcaoSisacao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_opcao_sisacao) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOpcaoSisacao(id);	
	}
	@Override
	public void alteraItem(OpcaoSisacao item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_opcao_sisacao = " + item.getIdOpcaoSisacao();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OpcaoSisacao item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_opcao_sisacao = " + item.getIdOpcaoSisacao();
		executaSql(query);
	}
	@Override
	public OpcaoSisacao obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_opcao_sisacao = " + id;
        return (OpcaoSisacao) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OpcaoSisacaoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( OpcaoSisacaoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoOpcaoSisacaoSeriePertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_opcao_sisacao_serie_pa = " + filtro.getCodigoOpcaoSisacaoSeriePertenceA();
      	}
      	
		if (filtro.getCodigoTickerDerivativoDe() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_ticker_dd = " + filtro.getCodigoTickerDerivativoDe();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(OpcaoSisacaoFiltro filtro)
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
	
	
	protected String valoresInsert(OpcaoSisacao item) {
		return " ( '" + item.getIdOpcaoSisacao() + "'  " 
		+ " ,'" + item.getCodigoMercado() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoExercicio()) + "'  "
		+ " ," + (item.getDataInicioColeta()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColeta()) ) + "  "
		+ " ," + item.getIdOpcaoSisacaoSeriePa() + "  "
		+ " ," + item.getIdTickerDd() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_opcao_sisacao " 
		+ " ,codigo_mercado " 
		+ " ,preco_exercicio " 
		+ " ,data_inicio_coleta " 
		+ " ,id_opcao_sisacao_serie_pa " 
		+ " ,id_ticker_dd " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OpcaoSisacao item) {
		return " id_opcao_sisacao = '" + item.getIdOpcaoSisacao() + "'  " 
		+ " , codigo_mercado = '" + item.getCodigoMercado() + "'  "
		+ " , preco_exercicio = '" +  DCConvert.ToDataBase(item.getPrecoExercicio()) + "'  "
		+ " , data_inicio_coleta = " + (item.getDataInicioColeta()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColeta()) ) + "  "
		+ " , id_opcao_sisacao_serie_pa = " + item.getIdOpcaoSisacaoSeriePa() + "  "
		+ " , id_ticker_dd = " + item.getIdTickerDd() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(OpcaoSisacao item) {
		return " id_opcao_sisacao = '" + item.getIdOpcaoSisacao() + "'  " 
		+ " , codigo_mercado = '" + item.getCodigoMercado() + "'  " 
		+ " , preco_exercicio = '" +  DCConvert.ToDataBase(item.getPrecoExercicio()) + "'  " 
		+ " , data_inicio_coleta = " + (item.getDataInicioColeta()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioColeta()) ) + "  " 
		+ " , id_opcao_sisacao_serie_pa = " + item.getIdOpcaoSisacaoSeriePa() + "  " 
		+ " , id_ticker_dd = " + item.getIdTickerDd() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public OpcaoSisacao obtemPorEscolhaOpcaoEscolhida(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinEscolhaOpcao_Escolhida() + 
			" where id_escolha_opcao = " + id;
		return (OpcaoSisacao) getObjeto(sql);
	}
	*/
	public static String innerJoinEscolhaOpcao_Escolhida() {
		return " inner join " + EscolhaOpcaoDaoBase.tabelaSelect() + " on " + EscolhaOpcaoDaoBase.tabelaSelect() + ".id_opcao_sisacao_e = " + tabelaSelect() + ".id_opcao_sisacao ";  
	}
	public static String outerJoinEscolhaOpcao_Escolhida() {
		return " left outer join " + EscolhaOpcaoDaoBase.tabelaSelect() + " on " + EscolhaOpcaoDaoBase.tabelaSelect() + ".id_opcao_sisacao_e = " + tabelaSelect() + ".id_opcao_sisacao ";  
	}
 	
	/*
	public OpcaoSisacao obtemPorCotacaoProcessadaOpcaoResultadoEstaEm(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinCotacaoProcessadaOpcaoResultado_EstaEm() + 
			" where id_cotacao_processada_opcao_resultado = " + id;
		return (OpcaoSisacao) getObjeto(sql);
	}
	*/
	public static String innerJoinCotacaoProcessadaOpcaoResultado_EstaEm() {
		return " inner join " + CotacaoProcessadaOpcaoResultadoDaoBase.tabelaSelect() + " on " + CotacaoProcessadaOpcaoResultadoDaoBase.tabelaSelect() + ".id_opcao_sisacao_ra = " + tabelaSelect() + ".id_opcao_sisacao ";  
	}
	public static String outerJoinCotacaoProcessadaOpcaoResultado_EstaEm() {
		return " left outer join " + CotacaoProcessadaOpcaoResultadoDaoBase.tabelaSelect() + " on " + CotacaoProcessadaOpcaoResultadoDaoBase.tabelaSelect() + ".id_opcao_sisacao_ra = " + tabelaSelect() + ".id_opcao_sisacao ";  
	}
 	
	/*
	public OpcaoSisacao obtemPorOpcaoReferenciaPossui(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinOpcaoReferencia_Possui() + 
			" where id_opcao_referencia = " + id;
		return (OpcaoSisacao) getObjeto(sql);
	}
	*/
	public static String innerJoinOpcaoReferencia_Possui() {
		return " inner join " + OpcaoReferenciaDaoBase.tabelaSelect() + " on " + OpcaoReferenciaDaoBase.tabelaSelect() + ".id_opcao_sisacao_ra = " + tabelaSelect() + ".id_opcao_sisacao ";  
	}
	public static String outerJoinOpcaoReferencia_Possui() {
		return " left outer join " + OpcaoReferenciaDaoBase.tabelaSelect() + " on " + OpcaoReferenciaDaoBase.tabelaSelect() + ".id_opcao_sisacao_ra = " + tabelaSelect() + ".id_opcao_sisacao ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAOpcaoSisacaoSerie(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_opcao_sisacao_serie_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorOpcaoSisacaoSeriePertenceA(long id) throws DaoException {
		return getPorPertenceAOpcaoSisacaoSerie(id);
	}
	public boolean excluiPorPertenceAOpcaoSisacaoSerie(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_opcao_sisacao_serie_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinOpcaoSisacaoSerie_PertenceA() {
	//	return " inner join " + OpcaoSisacaoSerieDaoBase.tabelaSelect() + " on " + OpcaoSisacaoSerieDaoBase.tabelaSelect() + ".id_opcao_sisacao_p = " + tabelaSelect() + ".id_opcao_sisacao ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorDerivativoDeTicker(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_ticker_dd = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorTickerDerivativoDe(long id) throws DaoException {
		return getPorDerivativoDeTicker(id);
	}
	public boolean excluiPorDerivativoDeTicker(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_ticker_dd = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinTicker_DerivativoDe() {
	//	return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_opcao_sisacao_g = " + tabelaSelect() + ".id_opcao_sisacao ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemOpcaoSisacaoSerie_PertenceA = false;
	public void setObtemOpcaoSisacaoSerie_PertenceA() {
		_obtemOpcaoSisacaoSerie_PertenceA = true;
	}
	protected String outterJoinOpcaoSisacaoSerie_PertenceA() {
		return " left outer join " + OpcaoSisacaoSerieDaoBase.tabelaSelect() + " on " + OpcaoSisacaoSerieDaoBase.tabelaSelect() + ".id_opcao_sisacao_serie = " + tabelaSelect() + ".id_opcao_sisacao_serie_pa ";  
	}
	public boolean atualizaPertenceAOpcaoSisacaoSerie(long idOpcaoSisacao, long idOpcaoSisacaoSeriePa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_opcao_sisacao_serie_pa  = " + idOpcaoSisacaoSeriePa +
        " where id_opcao_sisacao = " +  idOpcaoSisacao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinOpcaoSisacaoSerie_PertenceA() {
		return " inner join " + OpcaoSisacaoSerieDaoBase.tabelaSelect() + " on " + OpcaoSisacaoSerieDaoBase.tabelaSelect() + ".id_opcao_sisacao_serie = " + tabelaSelect() + ".id_opcao_sisacao_serie_pa ";  
	}
	
 	
	private boolean _obtemTicker_DerivativoDe = false;
	public void setObtemTicker_DerivativoDe() {
		_obtemTicker_DerivativoDe = true;
	}
	protected String outterJoinTicker_DerivativoDe() {
		return " left outer join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_dd ";  
	}
	public boolean atualizaDerivativoDeTicker(long idOpcaoSisacao, long idTickerDd) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_ticker_dd  = " + idTickerDd +
        " where id_opcao_sisacao = " +  idOpcaoSisacao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinTicker_DerivativoDe() {
		return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_dd ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemOpcaoSisacaoSerie_PertenceA?" , " +OpcaoSisacaoSerieDaoBase.camposOrdenados():"");
		saida += (this._obtemTicker_DerivativoDe?" , " +TickerDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemOpcaoSisacaoSerie_PertenceA = false;
		_obtemTicker_DerivativoDe = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemOpcaoSisacaoSerie_PertenceA? outterJoinOpcaoSisacaoSerie_PertenceA() + " ":"");
		saida += (this._obtemTicker_DerivativoDe? outterJoinTicker_DerivativoDe() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new OpcaoSisacaoMontador(), null);
		if (this._obtemOpcaoSisacaoSerie_PertenceA)
            montador.adicionaMontador(new OpcaoSisacaoSerieMontador(), "OpcaoSisacaoSerie_PertenceA");
		if (this._obtemTicker_DerivativoDe)
            montador.adicionaMontador(new TickerMontador(), "Ticker_DerivativoDe");
         return montador;
    }
	
	
}
