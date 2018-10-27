package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.OpcaoSisacaoGeral;
import coletorjava.regracolecao.filtro.OpcaoSisacaoGeralFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class OpcaoSisacaoGeralDaoBase extends DaoAplicacao implements OpcaoSisacaoGeralDaoBaseI {
	
	
	public OpcaoSisacaoGeralDaoBase() {
		super();
	}
	public OpcaoSisacaoGeralDaoBase(DataFonte dataSource) {
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
		return new OpcaoSisacaoGeralMontador();
	}
	public static String tabelaSelect() {
		return " opcao_sisacao_geral" ;
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
		return " opcao_sisacao_geral.id_opcao_sisacao_geral " 
		+ " ,opcao_sisacao_geral.codigo_mercado " 
		+ " ,opcao_sisacao_geral.preco_exercicio " 
		+ " , DATE_FORMAT(opcao_sisacao_geral.data_inclusao,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(opcao_sisacao_geral.mes_ano,'%d-%m-%Y') " 
		+ " ,opcao_sisacao_geral.descricao_bdi " 
		+ " ,opcao_sisacao_geral.coleta_diario " 
		+ " ,opcao_sisacao_geral.possui_coleta_intraday " 
		+ " ,opcao_sisacao_geral.possui_15minutos " 
		+ " ,opcao_sisacao_geral.id_ticker_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_opcao_sisacao_geral " 
		+ " , " + nomeTabela + ".codigo_mercado " 
		+ " , " + nomeTabela + ".preco_exercicio " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inclusao,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".mes_ano,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".descricao_bdi " 
		+ " , " + nomeTabela + ".coleta_diario " 
		+ " , " + nomeTabela + ".possui_coleta_intraday " 
		+ " , " + nomeTabela + ".possui_15minutos " 
		+ " , " + nomeTabela + ".id_ticker_ra " 
		;
	}
	
	
	@Override
	public void insereItem(OpcaoSisacaoGeral item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(OpcaoSisacaoGeral item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(OpcaoSisacaoGeral item) throws DaoException {
		OpcaoSisacaoGeral teste = this.obtemPorChave(item.getIdOpcaoSisacaoGeral());
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
	public void insereItemLoad(OpcaoSisacaoGeral item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_opcao_sisacao_geral) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdOpcaoSisacaoGeral(id);	
	}
	@Override
	public void alteraItem(OpcaoSisacaoGeral item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_opcao_sisacao_geral = " + item.getIdOpcaoSisacaoGeral();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(OpcaoSisacaoGeral item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_opcao_sisacao_geral = " + item.getIdOpcaoSisacaoGeral();
		executaSql(query);
	}
	@Override
	public OpcaoSisacaoGeral obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_opcao_sisacao_geral = " + id;
        return (OpcaoSisacaoGeral) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(OpcaoSisacaoGeralFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( OpcaoSisacaoGeralFiltro filtro ) {
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
	public List ListaFiltroSimples(OpcaoSisacaoGeralFiltro filtro)
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
	
	
	protected String valoresInsert(OpcaoSisacaoGeral item) {
		return " ( '" + item.getIdOpcaoSisacaoGeral() + "'  " 
		+ " ,'" + item.getCodigoMercado() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPrecoExercicio()) + "'  "
		+ " ," + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " ," + (item.getMesAno()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAno()) ) + "  "
		+ " ,'" + item.getDescricaoBdi() + "'  "
		+ " ,'" + (item.getColetaDiario()?"S":"N") + "'  "
		+ " ,'" + (item.getPossuiColetaIntraday()?"S":"N") + "'  "
		+ " ,'" + (item.getPossui15minutos()?"S":"N") + "'  "
		+ " ," + item.getIdTickerRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_opcao_sisacao_geral " 
		+ " ,codigo_mercado " 
		+ " ,preco_exercicio " 
		+ " ,data_inclusao " 
		+ " ,mes_ano " 
		+ " ,descricao_bdi " 
		+ " ,coleta_diario " 
		+ " ,possui_coleta_intraday " 
		+ " ,possui_15minutos " 
		+ " ,id_ticker_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(OpcaoSisacaoGeral item) {
		return " id_opcao_sisacao_geral = '" + item.getIdOpcaoSisacaoGeral() + "'  " 
		+ " , codigo_mercado = '" + item.getCodigoMercado() + "'  "
		+ " , preco_exercicio = '" +  DCConvert.ToDataBase(item.getPrecoExercicio()) + "'  "
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  "
		+ " , mes_ano = " + (item.getMesAno()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAno()) ) + "  "
		+ " , descricao_bdi = '" + item.getDescricaoBdi() + "'  "
		+ " , coleta_diario = '" + (item.getColetaDiario()?"S":"N") + "'  "
		+ " , possui_coleta_intraday = '" + (item.getPossuiColetaIntraday()?"S":"N") + "'  "
		+ " , possui_15minutos = '" + (item.getPossui15minutos()?"S":"N") + "'  "
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(OpcaoSisacaoGeral item) {
		return " id_opcao_sisacao_geral = '" + item.getIdOpcaoSisacaoGeral() + "'  " 
		+ " , codigo_mercado = '" + item.getCodigoMercado() + "'  " 
		+ " , preco_exercicio = '" +  DCConvert.ToDataBase(item.getPrecoExercicio()) + "'  " 
		+ " , data_inclusao = " + (item.getDataInclusao()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInclusao()) ) + "  " 
		+ " , mes_ano = " + (item.getMesAno()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getMesAno()) ) + "  " 
		+ " , descricao_bdi = '" + item.getDescricaoBdi() + "'  " 
		+ " , coleta_diario = '" + (item.getColetaDiario()?"S":"N") + "'  " 
		+ " , possui_coleta_intraday = '" + (item.getPossuiColetaIntraday()?"S":"N") + "'  " 
		+ " , possui_15minutos = '" + (item.getPossui15minutos()?"S":"N") + "'  " 
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  " 
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
	//	return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_opcao_sisacao_geral_p = " + tabelaSelect() + ".id_opcao_sisacao_geral ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemTicker_ReferenteA = false;
	public void setObtemTicker_ReferenteA() {
		_obtemTicker_ReferenteA = true;
	}
	protected String outterJoinTicker_ReferenteA() {
		return " left outer join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	public boolean atualizaReferenteATicker(long idOpcaoSisacaoGeral, long idTickerRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_ticker_ra  = " + idTickerRa +
        " where id_opcao_sisacao_geral = " +  idOpcaoSisacaoGeral;
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
        montador.adicionaMontador(new OpcaoSisacaoGeralMontador(), null);
		if (this._obtemTicker_ReferenteA)
            montador.adicionaMontador(new TickerMontador(), "Ticker_ReferenteA");
         return montador;
    }
	
	
}
