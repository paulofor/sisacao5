package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.ResultadoPrevisao;
import coletorjava.regracolecao.filtro.ResultadoPrevisaoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ResultadoPrevisaoDaoBase extends DaoAplicacao implements ResultadoPrevisaoDaoBaseI {
	
	
	public ResultadoPrevisaoDaoBase() {
		super();
	}
	public ResultadoPrevisaoDaoBase(DataFonte dataSource) {
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
		return new ResultadoPrevisaoMontador();
	}
	public static String tabelaSelect() {
		return " resultado_previsao" ;
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
		return " order by " + tabelaSelect() + ".percentual_precisao " ;
	}
	
	
	public static String camposOrdenados() {
		return " resultado_previsao.id_resultado_previsao " 
		+ " ,resultado_previsao.qtde_verdadeiro_postivo " 
		+ " ,resultado_previsao.qtde_falso_positivo " 
		+ " ,resultado_previsao.qtde_total " 
		+ " ,resultado_previsao.percentual_sucesso_previsao " 
		+ " ,resultado_previsao.percentual_precisao " 
		+ " , DATE_FORMAT(resultado_previsao.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,resultado_previsao.id_dado_theta_gd " 
		+ " ,resultado_previsao.id_resultado_mes_mp " 
		+ " ,resultado_previsao.id_mes_ano_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_resultado_previsao " 
		+ " , " + nomeTabela + ".qtde_verdadeiro_postivo " 
		+ " , " + nomeTabela + ".qtde_falso_positivo " 
		+ " , " + nomeTabela + ".qtde_total " 
		+ " , " + nomeTabela + ".percentual_sucesso_previsao " 
		+ " , " + nomeTabela + ".percentual_precisao " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".id_dado_theta_gd " 
		+ " , " + nomeTabela + ".id_resultado_mes_mp " 
		+ " , " + nomeTabela + ".id_mes_ano_ra " 
		;
	}
	
	
	@Override
	public void insereItem(ResultadoPrevisao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ResultadoPrevisao item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ResultadoPrevisao item) throws DaoException {
		ResultadoPrevisao teste = this.obtemPorChave(item.getIdResultadoPrevisao());
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
	public void insereItemLoad(ResultadoPrevisao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_resultado_previsao) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdResultadoPrevisao(id);	
	}
	@Override
	public void alteraItem(ResultadoPrevisao item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_resultado_previsao = " + item.getIdResultadoPrevisao();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ResultadoPrevisao item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_resultado_previsao = " + item.getIdResultadoPrevisao();
		executaSql(query);
	}
	@Override
	public ResultadoPrevisao obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_resultado_previsao = " + id;
        return (ResultadoPrevisao) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ResultadoPrevisaoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ResultadoPrevisaoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoDadoThetaGeradoDe() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_dado_theta_gd = " + filtro.getCodigoDadoThetaGeradoDe();
      	}
      	
		if (filtro.getCodigoResultadoMesMesmoPeriodo() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_resultado_mes_mp = " + filtro.getCodigoResultadoMesMesmoPeriodo();
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
	public List ListaFiltroSimples(ResultadoPrevisaoFiltro filtro)
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
	
	
	protected String valoresInsert(ResultadoPrevisao item) {
		return " ( '" + item.getIdResultadoPrevisao() + "'  " 
		+ " ,'" + item.getQtdeVerdadeiroPostivo() + "'  "
		+ " ,'" + item.getQtdeFalsoPositivo() + "'  "
		+ " ,'" + item.getQtdeTotal() + "'  "
		+ " ,'" + item.getPercentualSucessoPrevisao() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getPercentualPrecisao()) + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ," + item.getIdDadoThetaGd() + "  "
		+ " ," + item.getIdResultadoMesMp() + "  "
		+ " ," + item.getIdMesAnoRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_resultado_previsao " 
		+ " ,qtde_verdadeiro_postivo " 
		+ " ,qtde_falso_positivo " 
		+ " ,qtde_total " 
		+ " ,percentual_sucesso_previsao " 
		+ " ,percentual_precisao " 
		+ " ,ultima_alteracao " 
		+ " ,id_dado_theta_gd " 
		+ " ,id_resultado_mes_mp " 
		+ " ,id_mes_ano_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ResultadoPrevisao item) {
		return " id_resultado_previsao = '" + item.getIdResultadoPrevisao() + "'  " 
		+ " , qtde_verdadeiro_postivo = '" + item.getQtdeVerdadeiroPostivo() + "'  "
		+ " , qtde_falso_positivo = '" + item.getQtdeFalsoPositivo() + "'  "
		+ " , qtde_total = '" + item.getQtdeTotal() + "'  "
		+ " , percentual_sucesso_previsao = '" + item.getPercentualSucessoPrevisao() + "'  "
		+ " , percentual_precisao = '" +  DCConvert.ToDataBase(item.getPercentualPrecisao()) + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " , id_dado_theta_gd = " + item.getIdDadoThetaGd() + "  "
		+ " , id_resultado_mes_mp = " + item.getIdResultadoMesMp() + "  "
		+ " , id_mes_ano_ra = " + item.getIdMesAnoRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(ResultadoPrevisao item) {
		return " id_resultado_previsao = '" + item.getIdResultadoPrevisao() + "'  " 
		+ " , qtde_verdadeiro_postivo = '" + item.getQtdeVerdadeiroPostivo() + "'  " 
		+ " , qtde_falso_positivo = '" + item.getQtdeFalsoPositivo() + "'  " 
		+ " , qtde_total = '" + item.getQtdeTotal() + "'  " 
		+ " , percentual_sucesso_previsao = '" + item.getPercentualSucessoPrevisao() + "'  " 
		+ " , percentual_precisao = '" +  DCConvert.ToDataBase(item.getPercentualPrecisao()) + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		+ " , id_dado_theta_gd = " + item.getIdDadoThetaGd() + "  " 
		+ " , id_resultado_mes_mp = " + item.getIdResultadoMesMp() + "  " 
		+ " , id_mes_ano_ra = " + item.getIdMesAnoRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoDeDadoTheta(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_dado_theta_gd = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorDadoThetaGeradoDe(long id) throws DaoException {
		return getPorGeradoDeDadoTheta(id);
	}
	public boolean excluiPorGeradoDeDadoTheta(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_dado_theta_gd = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinDadoTheta_GeradoDe() {
	//	return " inner join " + DadoThetaDaoBase.tabelaSelect() + " on " + DadoThetaDaoBase.tabelaSelect() + ".id_resultado_previsao_g = " + tabelaSelect() + ".id_resultado_previsao ";  
	//}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorMesmoPeriodoResultadoMes(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_resultado_mes_mp = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorResultadoMesMesmoPeriodo(long id) throws DaoException {
		return getPorMesmoPeriodoResultadoMes(id);
	}
	public boolean excluiPorMesmoPeriodoResultadoMes(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_resultado_mes_mp = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinResultadoMes_MesmoPeriodo() {
	//	return " inner join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_resultado_previsao_s = " + tabelaSelect() + ".id_resultado_previsao ";  
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
	//	return " inner join " + MesAnoDaoBase.tabelaSelect() + " on " + MesAnoDaoBase.tabelaSelect() + ".id_resultado_previsao_g = " + tabelaSelect() + ".id_resultado_previsao ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemDadoTheta_GeradoDe = false;
	public void setObtemDadoTheta_GeradoDe() {
		_obtemDadoTheta_GeradoDe = true;
	}
	protected String outterJoinDadoTheta_GeradoDe() {
		return " left outer join " + DadoThetaDaoBase.tabelaSelect() + " on " + DadoThetaDaoBase.tabelaSelect() + ".id_dado_theta = " + tabelaSelect() + ".id_dado_theta_gd ";  
	}
	public boolean atualizaGeradoDeDadoTheta(long idResultadoPrevisao, long idDadoThetaGd) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_dado_theta_gd  = " + idDadoThetaGd +
        " where id_resultado_previsao = " +  idResultadoPrevisao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinDadoTheta_GeradoDe() {
		return " inner join " + DadoThetaDaoBase.tabelaSelect() + " on " + DadoThetaDaoBase.tabelaSelect() + ".id_dado_theta = " + tabelaSelect() + ".id_dado_theta_gd ";  
	}
	
 	
	private boolean _obtemResultadoMes_MesmoPeriodo = false;
	public void setObtemResultadoMes_MesmoPeriodo() {
		_obtemResultadoMes_MesmoPeriodo = true;
	}
	protected String outterJoinResultadoMes_MesmoPeriodo() {
		return " left outer join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_resultado_mes = " + tabelaSelect() + ".id_resultado_mes_mp ";  
	}
	public boolean atualizaMesmoPeriodoResultadoMes(long idResultadoPrevisao, long idResultadoMesMp) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_resultado_mes_mp  = " + idResultadoMesMp +
        " where id_resultado_previsao = " +  idResultadoPrevisao;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinResultadoMes_MesmoPeriodo() {
		return " inner join " + ResultadoMesDaoBase.tabelaSelect() + " on " + ResultadoMesDaoBase.tabelaSelect() + ".id_resultado_mes = " + tabelaSelect() + ".id_resultado_mes_mp ";  
	}
	
 	
	private boolean _obtemMesAno_ReferenteA = false;
	public void setObtemMesAno_ReferenteA() {
		_obtemMesAno_ReferenteA = true;
	}
	protected String outterJoinMesAno_ReferenteA() {
		return " left outer join " + MesAnoDaoBase.tabelaSelect() + " on " + MesAnoDaoBase.tabelaSelect() + ".id_mes_ano = " + tabelaSelect() + ".id_mes_ano_ra ";  
	}
	public boolean atualizaReferenteAMesAno(long idResultadoPrevisao, long idMesAnoRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_mes_ano_ra  = " + idMesAnoRa +
        " where id_resultado_previsao = " +  idResultadoPrevisao;
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
		saida += (this._obtemDadoTheta_GeradoDe?" , " +DadoThetaDaoBase.camposOrdenados():"");
		saida += (this._obtemResultadoMes_MesmoPeriodo?" , " +ResultadoMesDaoBase.camposOrdenados():"");
		saida += (this._obtemMesAno_ReferenteA?" , " +MesAnoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemDadoTheta_GeradoDe = false;
		_obtemResultadoMes_MesmoPeriodo = false;
		_obtemMesAno_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemDadoTheta_GeradoDe? outterJoinDadoTheta_GeradoDe() + " ":"");
		saida += (this._obtemResultadoMes_MesmoPeriodo? outterJoinResultadoMes_MesmoPeriodo() + " ":"");
		saida += (this._obtemMesAno_ReferenteA? outterJoinMesAno_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new ResultadoPrevisaoMontador(), null);
		if (this._obtemDadoTheta_GeradoDe)
            montador.adicionaMontador(new DadoThetaMontador(), "DadoTheta_GeradoDe");
		if (this._obtemResultadoMes_MesmoPeriodo)
            montador.adicionaMontador(new ResultadoMesMontador(), "ResultadoMes_MesmoPeriodo");
		if (this._obtemMesAno_ReferenteA)
            montador.adicionaMontador(new MesAnoMontador(), "MesAno_ReferenteA");
         return montador;
    }
	
	
}
