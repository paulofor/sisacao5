package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.DadoTheta;
import coletorjava.regracolecao.filtro.DadoThetaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class DadoThetaDaoBase extends DaoAplicacao implements DadoThetaDaoBaseI {
	
	
	public DadoThetaDaoBase() {
		super();
	}
	public DadoThetaDaoBase(DataFonte dataSource) {
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
		return new DadoThetaMontador();
	}
	public static String tabelaSelect() {
		return " dado_theta" ;
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
		return " order by " + tabelaSelect() + ".nome_arquivo " ;
	}
	
	
	public static String camposOrdenados() {
		return " dado_theta.id_dado_theta " 
		+ " ,dado_theta.nome_arquivo " 
		+ " , DATE_FORMAT(dado_theta.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,dado_theta.id_treino_rede_gp " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_dado_theta " 
		+ " , " + nomeTabela + ".nome_arquivo " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_treino_rede_gp " 
		;
	}
	
	
	@Override
	public void insereItem(DadoTheta item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(DadoTheta item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(DadoTheta item) throws DaoException {
		DadoTheta teste = this.obtemPorChave(item.getIdDadoTheta());
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
	public void insereItemLoad(DadoTheta item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_dado_theta) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdDadoTheta(id);	
	}
	@Override
	public void alteraItem(DadoTheta item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_dado_theta = " + item.getIdDadoTheta();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(DadoTheta item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_dado_theta = " + item.getIdDadoTheta();
		executaSql(query);
	}
	@Override
	public DadoTheta obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_dado_theta = " + id;
        return (DadoTheta) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(DadoThetaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( DadoThetaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoTreinoRedeGeradoPor() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_treino_rede_gp = " + filtro.getCodigoTreinoRedeGeradoPor();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(DadoThetaFiltro filtro)
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
	
	
	protected String valoresInsert(DadoTheta item) {
		return " ( '" + item.getIdDadoTheta() + "'  " 
		+ " ,'" + item.getNomeArquivo() + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ," + item.getIdTreinoRedeGp() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_dado_theta " 
		+ " ,nome_arquivo " 
		+ " ,ultima_alteracao " 
		+ " ,id_treino_rede_gp " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(DadoTheta item) {
		return " id_dado_theta = '" + item.getIdDadoTheta() + "'  " 
		+ " , nome_arquivo = '" + item.getNomeArquivo() + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " , id_treino_rede_gp = " + item.getIdTreinoRedeGp() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(DadoTheta item) {
		return " id_dado_theta = '" + item.getIdDadoTheta() + "'  " 
		+ " , nome_arquivo = '" + item.getNomeArquivo() + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		+ " , id_treino_rede_gp = " + item.getIdTreinoRedeGp() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public DadoTheta obtemPorResultadoPrevisaoGera(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinResultadoPrevisao_Gera() + 
			" where id_resultado_previsao = " + id;
		return (DadoTheta) getObjeto(sql);
	}
	*/
	public static String innerJoinResultadoPrevisao_Gera() {
		return " inner join " + ResultadoPrevisaoDaoBase.tabelaSelect() + " on " + ResultadoPrevisaoDaoBase.tabelaSelect() + ".id_dado_theta_gd = " + tabelaSelect() + ".id_dado_theta ";  
	}
	public static String outerJoinResultadoPrevisao_Gera() {
		return " left outer join " + ResultadoPrevisaoDaoBase.tabelaSelect() + " on " + ResultadoPrevisaoDaoBase.tabelaSelect() + ".id_dado_theta_gd = " + tabelaSelect() + ".id_dado_theta ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoPorTreinoRede(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_treino_rede_gp = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorTreinoRedeGeradoPor(long id) throws DaoException {
		return getPorGeradoPorTreinoRede(id);
	}
	public boolean excluiPorGeradoPorTreinoRede(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_treino_rede_gp = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinTreinoRede_GeradoPor() {
	//	return " inner join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_dado_theta_r = " + tabelaSelect() + ".id_dado_theta ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemTreinoRede_GeradoPor = false;
	public void setObtemTreinoRede_GeradoPor() {
		_obtemTreinoRede_GeradoPor = true;
	}
	protected String outterJoinTreinoRede_GeradoPor() {
		return " left outer join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_treino_rede = " + tabelaSelect() + ".id_treino_rede_gp ";  
	}
	public boolean atualizaGeradoPorTreinoRede(long idDadoTheta, long idTreinoRedeGp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_treino_rede_gp  = " + idTreinoRedeGp +
        " where id_dado_theta = " +  idDadoTheta;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinTreinoRede_GeradoPor() {
		return " inner join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_treino_rede = " + tabelaSelect() + ".id_treino_rede_gp ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemTreinoRede_GeradoPor?" , " +TreinoRedeDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemTreinoRede_GeradoPor = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemTreinoRede_GeradoPor? outterJoinTreinoRede_GeradoPor() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new DadoThetaMontador(), null);
		if (this._obtemTreinoRede_GeradoPor)
            montador.adicionaMontador(new TreinoRedeMontador(), "TreinoRede_GeradoPor");
         return montador;
    }
	
	
}
