package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.OpcaoReferencia;
import coletorjava.regracolecao.filtro.OpcaoReferenciaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OpcaoReferenciaDaoBase extends DaoAplicacao implements OpcaoReferenciaDaoBaseI {
	
	
	public OpcaoReferenciaDaoBase() {
		super();
	}
	public OpcaoReferenciaDaoBase(DataFonte dataSource) {
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
		return new OpcaoReferenciaMontador();
	}
	public static String tabelaSelect() {
		return " opcao_referencia" ;
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
		return " order by " + tabelaSelect() + ".id_opcao_referencia " ;
	}
	
	
	public static String camposOrdenados() {
		return " opcao_referencia.id_opcao_referencia " 
		+ " ,opcao_referencia.codigo_mercado " 
		+ " , DATE_FORMAT(opcao_referencia.data,'%d-%m-%Y') " 
		+ " ,opcao_referencia.id_ticker_ra " 
		+ " ,opcao_referencia.id_dia_pregao_ra " 
		+ " ,opcao_referencia.id_opcao_sisacao_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_opcao_referencia " 
		+ " , " + nomeTabela + ".codigo_mercado " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".id_ticker_ra " 
		+ " , " + nomeTabela + ".id_dia_pregao_ra " 
		+ " , " + nomeTabela + ".id_opcao_sisacao_ra " 
		;
	}
	
	
	@Override
	public void insereItem(OpcaoReferencia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OpcaoReferencia item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OpcaoReferencia item) throws DaoException {
		OpcaoReferencia teste = this.obtemPorChave(item.getIdOpcaoReferencia());
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
	public void insereItemLoad(OpcaoReferencia item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_opcao_referencia) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOpcaoReferencia(id);	
	}
	@Override
	public void alteraItem(OpcaoReferencia item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_opcao_referencia = " + item.getIdOpcaoReferencia();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OpcaoReferencia item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_opcao_referencia = " + item.getIdOpcaoReferencia();
		executaSql(query);
	}
	@Override
	public OpcaoReferencia obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_opcao_referencia = " + id;
        return (OpcaoReferencia) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OpcaoReferenciaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( OpcaoReferenciaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoTickerReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_ticker_ra = " + filtro.getCodigoTickerReferenteA();
      	}
      	
		if (filtro.getCodigoDiaPregaoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_dia_pregao_ra = " + filtro.getCodigoDiaPregaoReferenteA();
      	}
      	
		if (filtro.getCodigoOpcaoSisacaoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_opcao_sisacao_ra = " + filtro.getCodigoOpcaoSisacaoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(OpcaoReferenciaFiltro filtro)
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
	
	
	protected String valoresInsert(OpcaoReferencia item) {
		return " ( '" + item.getIdOpcaoReferencia() + "'  " 
		+ " ,'" + item.getCodigoMercado() + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ," + item.getIdTickerRa() + "  "
		+ " ," + item.getIdDiaPregaoRa() + "  "
		+ " ," + item.getIdOpcaoSisacaoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_opcao_referencia " 
		+ " ,codigo_mercado " 
		+ " ,data " 
		+ " ,id_ticker_ra " 
		+ " ,id_dia_pregao_ra " 
		+ " ,id_opcao_sisacao_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OpcaoReferencia item) {
		return " id_opcao_referencia = '" + item.getIdOpcaoReferencia() + "'  " 
		+ " , codigo_mercado = '" + item.getCodigoMercado() + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  "
		+ " , id_dia_pregao_ra = " + item.getIdDiaPregaoRa() + "  "
		+ " , id_opcao_sisacao_ra = " + item.getIdOpcaoSisacaoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(OpcaoReferencia item) {
		return " id_opcao_referencia = '" + item.getIdOpcaoReferencia() + "'  " 
		+ " , codigo_mercado = '" + item.getCodigoMercado() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  " 
		+ " , id_dia_pregao_ra = " + item.getIdDiaPregaoRa() + "  " 
		+ " , id_opcao_sisacao_ra = " + item.getIdOpcaoSisacaoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
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
	//	return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_opcao_referencia_p = " + tabelaSelect() + ".id_opcao_referencia ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteADiaPregao(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_dia_pregao_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorDiaPregaoReferenteA(long id) throws DaoException {
		return getPorReferenteADiaPregao(id);
	}
	public boolean excluiPorReferenteADiaPregao(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_dia_pregao_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinDiaPregao_ReferenteA() {
	//	return " inner join " + DiaPregaoDaoBase.tabelaSelect() + " on " + DiaPregaoDaoBase.tabelaSelect() + ".id_opcao_referencia_p = " + tabelaSelect() + ".id_opcao_referencia ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAOpcaoSisacao(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_opcao_sisacao_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorOpcaoSisacaoReferenteA(long id) throws DaoException {
		return getPorReferenteAOpcaoSisacao(id);
	}
	public boolean excluiPorReferenteAOpcaoSisacao(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_opcao_sisacao_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinOpcaoSisacao_ReferenteA() {
	//	return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_referencia_p = " + tabelaSelect() + ".id_opcao_referencia ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemTicker_ReferenteA = false;
	public void setObtemTicker_ReferenteA() {
		_obtemTicker_ReferenteA = true;
	}
	protected String outterJoinTicker_ReferenteA() {
		return " left outer join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	public boolean atualizaReferenteATicker(long idOpcaoReferencia, long idTickerRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_ticker_ra  = " + idTickerRa +
        " where id_opcao_referencia = " +  idOpcaoReferencia;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinTicker_ReferenteA() {
		return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	
 	
	private boolean _obtemDiaPregao_ReferenteA = false;
	public void setObtemDiaPregao_ReferenteA() {
		_obtemDiaPregao_ReferenteA = true;
	}
	protected String outterJoinDiaPregao_ReferenteA() {
		return " left outer join " + DiaPregaoDaoBase.tabelaSelect() + " on " + DiaPregaoDaoBase.tabelaSelect() + ".id_dia_pregao = " + tabelaSelect() + ".id_dia_pregao_ra ";  
	}
	public boolean atualizaReferenteADiaPregao(long idOpcaoReferencia, long idDiaPregaoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_dia_pregao_ra  = " + idDiaPregaoRa +
        " where id_opcao_referencia = " +  idOpcaoReferencia;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinDiaPregao_ReferenteA() {
		return " inner join " + DiaPregaoDaoBase.tabelaSelect() + " on " + DiaPregaoDaoBase.tabelaSelect() + ".id_dia_pregao = " + tabelaSelect() + ".id_dia_pregao_ra ";  
	}
	
 	
	private boolean _obtemOpcaoSisacao_ReferenteA = false;
	public void setObtemOpcaoSisacao_ReferenteA() {
		_obtemOpcaoSisacao_ReferenteA = true;
	}
	protected String outterJoinOpcaoSisacao_ReferenteA() {
		return " left outer join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao = " + tabelaSelect() + ".id_opcao_sisacao_ra ";  
	}
	public boolean atualizaReferenteAOpcaoSisacao(long idOpcaoReferencia, long idOpcaoSisacaoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_opcao_sisacao_ra  = " + idOpcaoSisacaoRa +
        " where id_opcao_referencia = " +  idOpcaoReferencia;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinOpcaoSisacao_ReferenteA() {
		return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao = " + tabelaSelect() + ".id_opcao_sisacao_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemTicker_ReferenteA?" , " +TickerDaoBase.camposOrdenados():"");
		saida += (this._obtemDiaPregao_ReferenteA?" , " +DiaPregaoDaoBase.camposOrdenados():"");
		saida += (this._obtemOpcaoSisacao_ReferenteA?" , " +OpcaoSisacaoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemTicker_ReferenteA = false;
		_obtemDiaPregao_ReferenteA = false;
		_obtemOpcaoSisacao_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemTicker_ReferenteA? outterJoinTicker_ReferenteA() + " ":"");
		saida += (this._obtemDiaPregao_ReferenteA? outterJoinDiaPregao_ReferenteA() + " ":"");
		saida += (this._obtemOpcaoSisacao_ReferenteA? outterJoinOpcaoSisacao_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new OpcaoReferenciaMontador(), null);
		if (this._obtemTicker_ReferenteA)
            montador.adicionaMontador(new TickerMontador(), "Ticker_ReferenteA");
		if (this._obtemDiaPregao_ReferenteA)
            montador.adicionaMontador(new DiaPregaoMontador(), "DiaPregao_ReferenteA");
		if (this._obtemOpcaoSisacao_ReferenteA)
            montador.adicionaMontador(new OpcaoSisacaoMontador(), "OpcaoSisacao_ReferenteA");
         return montador;
    }
	
	
}
