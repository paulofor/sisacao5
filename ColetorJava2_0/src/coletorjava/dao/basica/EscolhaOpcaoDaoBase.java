package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.EscolhaOpcao;
import coletorjava.regracolecao.filtro.EscolhaOpcaoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class EscolhaOpcaoDaoBase extends DaoAplicacao implements EscolhaOpcaoDaoBaseI {
	
	
	public EscolhaOpcaoDaoBase() {
		super();
	}
	public EscolhaOpcaoDaoBase(DataFonte dataSource) {
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
		return new EscolhaOpcaoMontador();
	}
	public static String tabelaSelect() {
		return " escolha_opcao" ;
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
		return " order by " + tabelaSelect() + ".data_referencia " ;
	}
	
	
	public static String camposOrdenados() {
		return " escolha_opcao.id_escolha_opcao " 
		+ " , DATE_FORMAT(escolha_opcao.data_referencia,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(escolha_opcao.hora_referencia,'%H:%i') " 
		+ " ,escolha_opcao.faixa_escolha " 
		+ " ,escolha_opcao.id_ticker_ra " 
		+ " ,escolha_opcao.id_opcao_sisacao_e " 
		+ " ,escolha_opcao.id_dia_pregao_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_escolha_opcao " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_referencia,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_referencia,'%H:%i') " 
		+ " , " + nomeTabela + ".faixa_escolha " 
		+ " , " + nomeTabela + ".id_ticker_ra " 
		+ " , " + nomeTabela + ".id_opcao_sisacao_e " 
		+ " , " + nomeTabela + ".id_dia_pregao_ra " 
		;
	}
	
	
	@Override
	public void insereItem(EscolhaOpcao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(EscolhaOpcao item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(EscolhaOpcao item) throws DaoException {
		EscolhaOpcao teste = this.obtemPorChave(item.getIdEscolhaOpcao());
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
	public void insereItemLoad(EscolhaOpcao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_escolha_opcao) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdEscolhaOpcao(id);	
	}
	@Override
	public void alteraItem(EscolhaOpcao item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_escolha_opcao = " + item.getIdEscolhaOpcao();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(EscolhaOpcao item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_escolha_opcao = " + item.getIdEscolhaOpcao();
		executaSql(query);
	}
	@Override
	public EscolhaOpcao obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_escolha_opcao = " + id;
        return (EscolhaOpcao) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(EscolhaOpcaoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( EscolhaOpcaoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoTickerReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_ticker_ra = " + filtro.getCodigoTickerReferenteA();
      	}
      	
		if (filtro.getCodigoOpcaoSisacaoEscolha() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_opcao_sisacao_e = " + filtro.getCodigoOpcaoSisacaoEscolha();
      	}
      	
		if (filtro.getCodigoDiaPregaoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_dia_pregao_ra = " + filtro.getCodigoDiaPregaoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(EscolhaOpcaoFiltro filtro)
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
	
	
	protected String valoresInsert(EscolhaOpcao item) {
		return " ( '" + item.getIdEscolhaOpcao() + "'  " 
		+ " ," + (item.getDataReferencia()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataReferencia()) ) + "  "
		+ " ," + (item.getHoraReferencia()==null?"null":"'" + item.getHoraReferencia() + "'") + "  "
		+ " ,'" + item.getFaixaEscolha() + "'  "
		+ " ," + item.getIdTickerRa() + "  "
		+ " ," + item.getIdOpcaoSisacaoE() + "  "
		+ " ," + item.getIdDiaPregaoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_escolha_opcao " 
		+ " ,data_referencia " 
		+ " ,hora_referencia " 
		+ " ,faixa_escolha " 
		+ " ,id_ticker_ra " 
		+ " ,id_opcao_sisacao_e " 
		+ " ,id_dia_pregao_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(EscolhaOpcao item) {
		return " id_escolha_opcao = '" + item.getIdEscolhaOpcao() + "'  " 
		+ " , data_referencia = " + (item.getDataReferencia()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataReferencia()) ) + "  "
		+ " , hora_referencia = " + (item.getHoraReferencia()==null?"null":"'" + item.getHoraReferencia() + "'") + "  "
		+ " , faixa_escolha = '" + item.getFaixaEscolha() + "'  "
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  "
		+ " , id_opcao_sisacao_e = " + item.getIdOpcaoSisacaoE() + "  "
		+ " , id_dia_pregao_ra = " + item.getIdDiaPregaoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(EscolhaOpcao item) {
		return " id_escolha_opcao = '" + item.getIdEscolhaOpcao() + "'  " 
		+ " , data_referencia = " + (item.getDataReferencia()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataReferencia()) ) + "  " 
		+ " , hora_referencia = " + (item.getHoraReferencia()==null?"null":"'" + item.getHoraReferencia() + "'") + "  " 
		+ " , faixa_escolha = '" + item.getFaixaEscolha() + "'  " 
		+ " , id_ticker_ra = " + item.getIdTickerRa() + "  " 
		+ " , id_opcao_sisacao_e = " + item.getIdOpcaoSisacaoE() + "  " 
		+ " , id_dia_pregao_ra = " + item.getIdDiaPregaoRa() + "  " 
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
	//	return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_escolha_opcao_p = " + tabelaSelect() + ".id_escolha_opcao ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorEscolhaOpcaoSisacao(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_opcao_sisacao_e = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorOpcaoSisacaoEscolha(long id) throws DaoException {
		return getPorEscolhaOpcaoSisacao(id);
	}
	public boolean excluiPorEscolhaOpcaoSisacao(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_opcao_sisacao_e = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinOpcaoSisacao_Escolha() {
	//	return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_escolha_opcao_e = " + tabelaSelect() + ".id_escolha_opcao ";  
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
	//	return " inner join " + DiaPregaoDaoBase.tabelaSelect() + " on " + DiaPregaoDaoBase.tabelaSelect() + ".id_escolha_opcao_p = " + tabelaSelect() + ".id_escolha_opcao ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemTicker_ReferenteA = false;
	public void setObtemTicker_ReferenteA() {
		_obtemTicker_ReferenteA = true;
	}
	protected String outterJoinTicker_ReferenteA() {
		return " left outer join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	public boolean atualizaReferenteATicker(long idEscolhaOpcao, long idTickerRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_ticker_ra  = " + idTickerRa +
        " where id_escolha_opcao = " +  idEscolhaOpcao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinTicker_ReferenteA() {
		return " inner join " + TickerDaoBase.tabelaSelect() + " on " + TickerDaoBase.tabelaSelect() + ".id_ticker = " + tabelaSelect() + ".id_ticker_ra ";  
	}
	
 	
	private boolean _obtemOpcaoSisacao_Escolha = false;
	public void setObtemOpcaoSisacao_Escolha() {
		_obtemOpcaoSisacao_Escolha = true;
	}
	protected String outterJoinOpcaoSisacao_Escolha() {
		return " left outer join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao = " + tabelaSelect() + ".id_opcao_sisacao_e ";  
	}
	public boolean atualizaEscolhaOpcaoSisacao(long idEscolhaOpcao, long idOpcaoSisacaoE) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_opcao_sisacao_e  = " + idOpcaoSisacaoE +
        " where id_escolha_opcao = " +  idEscolhaOpcao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinOpcaoSisacao_Escolha() {
		return " inner join " + OpcaoSisacaoDaoBase.tabelaSelect() + " on " + OpcaoSisacaoDaoBase.tabelaSelect() + ".id_opcao_sisacao = " + tabelaSelect() + ".id_opcao_sisacao_e ";  
	}
	
 	
	private boolean _obtemDiaPregao_ReferenteA = false;
	public void setObtemDiaPregao_ReferenteA() {
		_obtemDiaPregao_ReferenteA = true;
	}
	protected String outterJoinDiaPregao_ReferenteA() {
		return " left outer join " + DiaPregaoDaoBase.tabelaSelect() + " on " + DiaPregaoDaoBase.tabelaSelect() + ".id_dia_pregao = " + tabelaSelect() + ".id_dia_pregao_ra ";  
	}
	public boolean atualizaReferenteADiaPregao(long idEscolhaOpcao, long idDiaPregaoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_dia_pregao_ra  = " + idDiaPregaoRa +
        " where id_escolha_opcao = " +  idEscolhaOpcao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinDiaPregao_ReferenteA() {
		return " inner join " + DiaPregaoDaoBase.tabelaSelect() + " on " + DiaPregaoDaoBase.tabelaSelect() + ".id_dia_pregao = " + tabelaSelect() + ".id_dia_pregao_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemTicker_ReferenteA?" , " +TickerDaoBase.camposOrdenados():"");
		saida += (this._obtemOpcaoSisacao_Escolha?" , " +OpcaoSisacaoDaoBase.camposOrdenados():"");
		saida += (this._obtemDiaPregao_ReferenteA?" , " +DiaPregaoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemTicker_ReferenteA = false;
		_obtemOpcaoSisacao_Escolha = false;
		_obtemDiaPregao_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemTicker_ReferenteA? outterJoinTicker_ReferenteA() + " ":"");
		saida += (this._obtemOpcaoSisacao_Escolha? outterJoinOpcaoSisacao_Escolha() + " ":"");
		saida += (this._obtemDiaPregao_ReferenteA? outterJoinDiaPregao_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new EscolhaOpcaoMontador(), null);
		if (this._obtemTicker_ReferenteA)
            montador.adicionaMontador(new TickerMontador(), "Ticker_ReferenteA");
		if (this._obtemOpcaoSisacao_Escolha)
            montador.adicionaMontador(new OpcaoSisacaoMontador(), "OpcaoSisacao_Escolha");
		if (this._obtemDiaPregao_ReferenteA)
            montador.adicionaMontador(new DiaPregaoMontador(), "DiaPregao_ReferenteA");
         return montador;
    }
	
	
}
