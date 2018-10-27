package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.TreinoRede;
import coletorjava.regracolecao.filtro.TreinoRedeFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class TreinoRedeDaoBase extends DaoAplicacao implements TreinoRedeDaoBaseI {
	
	
	public TreinoRedeDaoBase() {
		super();
	}
	public TreinoRedeDaoBase(DataFonte dataSource) {
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
		return new TreinoRedeMontador();
	}
	public static String tabelaSelect() {
		return " treino_rede" ;
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
		return " order by " + tabelaSelect() + ".id_treino_rede " ;
	}
	
	
	public static String camposOrdenados() {
		return " treino_rede.id_treino_rede " 
		+ " ,treino_rede.lambda " 
		+ " ,treino_rede.iteracoes " 
		+ " , DATE_FORMAT(treino_rede.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,treino_rede.id_rede_pa " 
		+ " ,treino_rede.id_dado_treino_gp " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_treino_rede " 
		+ " , " + nomeTabela + ".lambda " 
		+ " , " + nomeTabela + ".iteracoes " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_rede_pa " 
		+ " , " + nomeTabela + ".id_dado_treino_gp " 
		;
	}
	
	
	@Override
	public void insereItem(TreinoRede item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(TreinoRede item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(TreinoRede item) throws DaoException {
		TreinoRede teste = this.obtemPorChave(item.getIdTreinoRede());
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
	public void insereItemLoad(TreinoRede item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_treino_rede) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdTreinoRede(id);	
	}
	@Override
	public void alteraItem(TreinoRede item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_treino_rede = " + item.getIdTreinoRede();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(TreinoRede item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_treino_rede = " + item.getIdTreinoRede();
		executaSql(query);
	}
	@Override
	public TreinoRede obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_treino_rede = " + id;
        return (TreinoRede) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(TreinoRedeFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( TreinoRedeFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoRedePertenceA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_rede_pa = " + filtro.getCodigoRedePertenceA();
      	}
      	
		if (filtro.getCodigoDadoTreinoGeradoPor() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_dado_treino_gp = " + filtro.getCodigoDadoTreinoGeradoPor();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(TreinoRedeFiltro filtro)
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
	
	
	protected String valoresInsert(TreinoRede item) {
		return " ( '" + item.getIdTreinoRede() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getLambda()) + "'  "
		+ " ,'" + item.getIteracoes() + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ," + item.getIdRedePa() + "  "
		+ " ," + item.getIdDadoTreinoGp() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_treino_rede " 
		+ " ,lambda " 
		+ " ,iteracoes " 
		+ " ,ultima_alteracao " 
		+ " ,id_rede_pa " 
		+ " ,id_dado_treino_gp " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(TreinoRede item) {
		return " id_treino_rede = '" + item.getIdTreinoRede() + "'  " 
		+ " , lambda = '" +  DCConvert.ToDataBase(item.getLambda()) + "'  "
		+ " , iteracoes = '" + item.getIteracoes() + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " , id_rede_pa = " + item.getIdRedePa() + "  "
		+ " , id_dado_treino_gp = " + item.getIdDadoTreinoGp() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(TreinoRede item) {
		return " id_treino_rede = '" + item.getIdTreinoRede() + "'  " 
		+ " , lambda = '" +  DCConvert.ToDataBase(item.getLambda()) + "'  " 
		+ " , iteracoes = '" + item.getIteracoes() + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		+ " , id_rede_pa = " + item.getIdRedePa() + "  " 
		+ " , id_dado_treino_gp = " + item.getIdDadoTreinoGp() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public TreinoRede obtemPorDadoThetaResultado(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinDadoTheta_Resultado() + 
			" where id_dado_theta = " + id;
		return (TreinoRede) getObjeto(sql);
	}
	*/
	public static String innerJoinDadoTheta_Resultado() {
		return " inner join " + DadoThetaDaoBase.tabelaSelect() + " on " + DadoThetaDaoBase.tabelaSelect() + ".id_treino_rede_gp = " + tabelaSelect() + ".id_treino_rede ";  
	}
	public static String outerJoinDadoTheta_Resultado() {
		return " left outer join " + DadoThetaDaoBase.tabelaSelect() + " on " + DadoThetaDaoBase.tabelaSelect() + ".id_treino_rede_gp = " + tabelaSelect() + ".id_treino_rede ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceARede(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_rede_pa = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorRedePertenceA(long id) throws DaoException {
		return getPorPertenceARede(id);
	}
	public boolean excluiPorPertenceARede(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_rede_pa = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinRede_PertenceA() {
	//	return " inner join " + RedeDaoBase.tabelaSelect() + " on " + RedeDaoBase.tabelaSelect() + ".id_treino_rede_g = " + tabelaSelect() + ".id_treino_rede ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoPorDadoTreino(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_dado_treino_gp = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorDadoTreinoGeradoPor(long id) throws DaoException {
		return getPorGeradoPorDadoTreino(id);
	}
	public boolean excluiPorGeradoPorDadoTreino(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_dado_treino_gp = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinDadoTreino_GeradoPor() {
	//	return " inner join " + DadoTreinoDaoBase.tabelaSelect() + " on " + DadoTreinoDaoBase.tabelaSelect() + ".id_treino_rede_g = " + tabelaSelect() + ".id_treino_rede ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemRede_PertenceA = false;
	public void setObtemRede_PertenceA() {
		_obtemRede_PertenceA = true;
	}
	protected String outterJoinRede_PertenceA() {
		return " left outer join " + RedeDaoBase.tabelaSelect() + " on " + RedeDaoBase.tabelaSelect() + ".id_rede = " + tabelaSelect() + ".id_rede_pa ";  
	}
	public boolean atualizaPertenceARede(long idTreinoRede, long idRedePa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_rede_pa  = " + idRedePa +
        " where id_treino_rede = " +  idTreinoRede;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinRede_PertenceA() {
		return " inner join " + RedeDaoBase.tabelaSelect() + " on " + RedeDaoBase.tabelaSelect() + ".id_rede = " + tabelaSelect() + ".id_rede_pa ";  
	}
	
 	
	private boolean _obtemDadoTreino_GeradoPor = false;
	public void setObtemDadoTreino_GeradoPor() {
		_obtemDadoTreino_GeradoPor = true;
	}
	protected String outterJoinDadoTreino_GeradoPor() {
		return " left outer join " + DadoTreinoDaoBase.tabelaSelect() + " on " + DadoTreinoDaoBase.tabelaSelect() + ".id_dado_treino = " + tabelaSelect() + ".id_dado_treino_gp ";  
	}
	public boolean atualizaGeradoPorDadoTreino(long idTreinoRede, long idDadoTreinoGp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_dado_treino_gp  = " + idDadoTreinoGp +
        " where id_treino_rede = " +  idTreinoRede;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinDadoTreino_GeradoPor() {
		return " inner join " + DadoTreinoDaoBase.tabelaSelect() + " on " + DadoTreinoDaoBase.tabelaSelect() + ".id_dado_treino = " + tabelaSelect() + ".id_dado_treino_gp ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemRede_PertenceA?" , " +RedeDaoBase.camposOrdenados():"");
		saida += (this._obtemDadoTreino_GeradoPor?" , " +DadoTreinoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemRede_PertenceA = false;
		_obtemDadoTreino_GeradoPor = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemRede_PertenceA? outterJoinRede_PertenceA() + " ":"");
		saida += (this._obtemDadoTreino_GeradoPor? outterJoinDadoTreino_GeradoPor() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new TreinoRedeMontador(), null);
		if (this._obtemRede_PertenceA)
            montador.adicionaMontador(new RedeMontador(), "Rede_PertenceA");
		if (this._obtemDadoTreino_GeradoPor)
            montador.adicionaMontador(new DadoTreinoMontador(), "DadoTreino_GeradoPor");
         return montador;
    }
	
	
}
