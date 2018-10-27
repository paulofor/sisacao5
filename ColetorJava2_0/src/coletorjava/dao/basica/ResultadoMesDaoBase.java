package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.ResultadoMes;
import coletorjava.regracolecao.filtro.ResultadoMesFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ResultadoMesDaoBase extends DaoAplicacao implements ResultadoMesDaoBaseI {
	
	
	public ResultadoMesDaoBase() {
		super();
	}
	public ResultadoMesDaoBase(DataFonte dataSource) {
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
		return new ResultadoMesMontador();
	}
	public static String tabelaSelect() {
		return " resultado_mes" ;
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
		return " order by " + tabelaSelect() + ".percentual_sucesso " ;
	}
	
	
	public static String camposOrdenados() {
		return " resultado_mes.id_resultado_mes " 
		+ " ,resultado_mes.qtde_total " 
		+ " ,resultado_mes.qtde_sucesso " 
		+ " ,resultado_mes.qtde_fracasso " 
		+ " ,resultado_mes.qtde_neutro " 
		+ " ,resultado_mes.percentual_sucesso " 
		+ " , DATE_FORMAT(resultado_mes.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,resultado_mes.id_projeto_dado_treino_gp " 
		+ " ,resultado_mes.id_mes_ano_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_resultado_mes " 
		+ " , " + nomeTabela + ".qtde_total " 
		+ " , " + nomeTabela + ".qtde_sucesso " 
		+ " , " + nomeTabela + ".qtde_fracasso " 
		+ " , " + nomeTabela + ".qtde_neutro " 
		+ " , " + nomeTabela + ".percentual_sucesso " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_projeto_dado_treino_gp " 
		+ " , " + nomeTabela + ".id_mes_ano_ra " 
		;
	}
	
	
	@Override
	public void insereItem(ResultadoMes item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ResultadoMes item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ResultadoMes item) throws DaoException {
		ResultadoMes teste = this.obtemPorChave(item.getIdResultadoMes());
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
	public void insereItemLoad(ResultadoMes item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_resultado_mes) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdResultadoMes(id);	
	}
	@Override
	public void alteraItem(ResultadoMes item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_resultado_mes = " + item.getIdResultadoMes();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ResultadoMes item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_resultado_mes = " + item.getIdResultadoMes();
		executaSql(query);
	}
	@Override
	public ResultadoMes obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_resultado_mes = " + id;
        return (ResultadoMes) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ResultadoMesFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ResultadoMesFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProjetoDadoTreinoGeradoPor() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_projeto_dado_treino_gp = " + filtro.getCodigoProjetoDadoTreinoGeradoPor();
      	}
      	
		if (filtro.getCodigoMesAnoReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_mes_ano_ra = " + filtro.getCodigoMesAnoReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ResultadoMesFiltro filtro)
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
	
	
	protected String valoresInsert(ResultadoMes item) {
		return " ( '" + item.getIdResultadoMes() + "'  " 
		+ " ,'" + item.getQtdeTotal() + "'  "
		+ " ,'" + item.getQtdeSucesso() + "'  "
		+ " ,'" + item.getQtdeFracasso() + "'  "
		+ " ,'" + item.getQtdeNeutro() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualSucesso()) + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ," + item.getIdProjetoDadoTreinoGp() + "  "
		+ " ," + item.getIdMesAnoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_resultado_mes " 
		+ " ,qtde_total " 
		+ " ,qtde_sucesso " 
		+ " ,qtde_fracasso " 
		+ " ,qtde_neutro " 
		+ " ,percentual_sucesso " 
		+ " ,ultima_alteracao " 
		+ " ,id_projeto_dado_treino_gp " 
		+ " ,id_mes_ano_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ResultadoMes item) {
		return " id_resultado_mes = '" + item.getIdResultadoMes() + "'  " 
		+ " , qtde_total = '" + item.getQtdeTotal() + "'  "
		+ " , qtde_sucesso = '" + item.getQtdeSucesso() + "'  "
		+ " , qtde_fracasso = '" + item.getQtdeFracasso() + "'  "
		+ " , qtde_neutro = '" + item.getQtdeNeutro() + "'  "
		+ " , percentual_sucesso = '" +  DCConvert.ToDataBase(item.getPercentualSucesso()) + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " , id_projeto_dado_treino_gp = " + item.getIdProjetoDadoTreinoGp() + "  "
		+ " , id_mes_ano_ra = " + item.getIdMesAnoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(ResultadoMes item) {
		return " id_resultado_mes = '" + item.getIdResultadoMes() + "'  " 
		+ " , qtde_total = '" + item.getQtdeTotal() + "'  " 
		+ " , qtde_sucesso = '" + item.getQtdeSucesso() + "'  " 
		+ " , qtde_fracasso = '" + item.getQtdeFracasso() + "'  " 
		+ " , qtde_neutro = '" + item.getQtdeNeutro() + "'  " 
		+ " , percentual_sucesso = '" +  DCConvert.ToDataBase(item.getPercentualSucesso()) + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		+ " , id_projeto_dado_treino_gp = " + item.getIdProjetoDadoTreinoGp() + "  " 
		+ " , id_mes_ano_ra = " + item.getIdMesAnoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public ResultadoMes obtemPorResultadoPrevisaoSemelhante(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinResultadoPrevisao_Semelhante() + 
			" where id_resultado_previsao = " + id;
		return (ResultadoMes) getObjeto(sql);
	}
	*/
	public static String innerJoinResultadoPrevisao_Semelhante() {
		return " inner join " + ResultadoPrevisaoDaoBase.tabelaSelect() + " on " + ResultadoPrevisaoDaoBase.tabelaSelect() + ".id_resultado_mes_mp = " + tabelaSelect() + ".id_resultado_mes ";  
	}
	public static String outerJoinResultadoPrevisao_Semelhante() {
		return " left outer join " + ResultadoPrevisaoDaoBase.tabelaSelect() + " on " + ResultadoPrevisaoDaoBase.tabelaSelect() + ".id_resultado_mes_mp = " + tabelaSelect() + ".id_resultado_mes ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoPorProjetoDadoTreino(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_projeto_dado_treino_gp = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProjetoDadoTreinoGeradoPor(long id) throws DaoException {
		return getPorGeradoPorProjetoDadoTreino(id);
	}
	public boolean excluiPorGeradoPorProjetoDadoTreino(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_projeto_dado_treino_gp = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProjetoDadoTreino_GeradoPor() {
	//	return " inner join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_resultado_mes_g = " + tabelaSelect() + ".id_resultado_mes ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAMesAno(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_mes_ano_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorMesAnoReferenteA(long id) throws DaoException {
		return getPorReferenteAMesAno(id);
	}
	public boolean excluiPorReferenteAMesAno(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_mes_ano_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinMesAno_ReferenteA() {
	//	return " inner join " + MesAnoDaoBase.tabelaSelect() + " on " + MesAnoDaoBase.tabelaSelect() + ".id_resultado_mes_bp = " + tabelaSelect() + ".id_resultado_mes ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProjetoDadoTreino_GeradoPor = false;
	public void setObtemProjetoDadoTreino_GeradoPor() {
		_obtemProjetoDadoTreino_GeradoPor = true;
	}
	protected String outterJoinProjetoDadoTreino_GeradoPor() {
		return " left outer join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_projeto_dado_treino = " + tabelaSelect() + ".id_projeto_dado_treino_gp ";  
	}
	public boolean atualizaGeradoPorProjetoDadoTreino(long idResultadoMes, long idProjetoDadoTreinoGp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_projeto_dado_treino_gp  = " + idProjetoDadoTreinoGp +
        " where id_resultado_mes = " +  idResultadoMes;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProjetoDadoTreino_GeradoPor() {
		return " inner join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_projeto_dado_treino = " + tabelaSelect() + ".id_projeto_dado_treino_gp ";  
	}
	
 	
	private boolean _obtemMesAno_ReferenteA = false;
	public void setObtemMesAno_ReferenteA() {
		_obtemMesAno_ReferenteA = true;
	}
	protected String outterJoinMesAno_ReferenteA() {
		return " left outer join " + MesAnoDaoBase.tabelaSelect() + " on " + MesAnoDaoBase.tabelaSelect() + ".id_mes_ano = " + tabelaSelect() + ".id_mes_ano_ra ";  
	}
	public boolean atualizaReferenteAMesAno(long idResultadoMes, long idMesAnoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_mes_ano_ra  = " + idMesAnoRa +
        " where id_resultado_mes = " +  idResultadoMes;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinMesAno_ReferenteA() {
		return " inner join " + MesAnoDaoBase.tabelaSelect() + " on " + MesAnoDaoBase.tabelaSelect() + ".id_mes_ano = " + tabelaSelect() + ".id_mes_ano_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProjetoDadoTreino_GeradoPor?" , " +ProjetoDadoTreinoDaoBase.camposOrdenados():"");
		saida += (this._obtemMesAno_ReferenteA?" , " +MesAnoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProjetoDadoTreino_GeradoPor = false;
		_obtemMesAno_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProjetoDadoTreino_GeradoPor? outterJoinProjetoDadoTreino_GeradoPor() + " ":"");
		saida += (this._obtemMesAno_ReferenteA? outterJoinMesAno_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ResultadoMesMontador(), null);
		if (this._obtemProjetoDadoTreino_GeradoPor)
            montador.adicionaMontador(new ProjetoDadoTreinoMontador(), "ProjetoDadoTreino_GeradoPor");
		if (this._obtemMesAno_ReferenteA)
            montador.adicionaMontador(new MesAnoMontador(), "MesAno_ReferenteA");
         return montador;
    }
	
	
}
