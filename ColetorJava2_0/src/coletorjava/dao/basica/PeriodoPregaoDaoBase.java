package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.PeriodoPregao;
import coletorjava.regracolecao.filtro.PeriodoPregaoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class PeriodoPregaoDaoBase extends DaoAplicacao implements PeriodoPregaoDaoBaseI {
	
	
	public PeriodoPregaoDaoBase() {
		super();
	}
	public PeriodoPregaoDaoBase(DataFonte dataSource) {
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
		return new PeriodoPregaoMontador();
	}
	public static String tabelaSelect() {
		return " periodo_pregao" ;
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
		return " order by " + tabelaSelect() + ".hora_inicio " ;
	}
	
	
	public static String camposOrdenados() {
		return " periodo_pregao.id_periodo_pregao " 
		+ " , DATE_FORMAT(periodo_pregao.hora_inicio,'%H:%i') " 
		+ " , DATE_FORMAT(periodo_pregao.hora_termino,'%H:%i') " 
		+ " , DATE_FORMAT(periodo_pregao.data_inicio_periodo,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(periodo_pregao.data_termino_periodo,'%d-%m-%Y') " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_periodo_pregao " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_inicio,'%H:%i') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_termino,'%H:%i') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_inicio_periodo,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data_termino_periodo,'%d-%m-%Y') " 
		;
	}
	
	
	@Override
	public void insereItem(PeriodoPregao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(PeriodoPregao item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(PeriodoPregao item) throws DaoException {
		PeriodoPregao teste = this.obtemPorChave(item.getIdPeriodoPregao());
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
	public void insereItemLoad(PeriodoPregao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_periodo_pregao) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdPeriodoPregao(id);	
	}
	@Override
	public void alteraItem(PeriodoPregao item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_periodo_pregao = " + item.getIdPeriodoPregao();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(PeriodoPregao item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_periodo_pregao = " + item.getIdPeriodoPregao();
		executaSql(query);
	}
	@Override
	public PeriodoPregao obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_periodo_pregao = " + id;
        return (PeriodoPregao) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(PeriodoPregaoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( PeriodoPregaoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(PeriodoPregaoFiltro filtro)
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
	
	
	protected String valoresInsert(PeriodoPregao item) {
		return " ( '" + item.getIdPeriodoPregao() + "'  " 
		+ " ," + (item.getHoraInicio()==null?"null":"'" + item.getHoraInicio() + "'") + "  "
		+ " ," + (item.getHoraTermino()==null?"null":"'" + item.getHoraTermino() + "'") + "  "
		+ " ," + (item.getDataInicioPeriodo()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPeriodo()) ) + "  "
		+ " ," + (item.getDataTerminoPeriodo()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataTerminoPeriodo()) ) + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_periodo_pregao " 
		+ " ,hora_inicio " 
		+ " ,hora_termino " 
		+ " ,data_inicio_periodo " 
		+ " ,data_termino_periodo " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(PeriodoPregao item) {
		return " id_periodo_pregao = '" + item.getIdPeriodoPregao() + "'  " 
		+ " , hora_inicio = " + (item.getHoraInicio()==null?"null":"'" + item.getHoraInicio() + "'") + "  "
		+ " , hora_termino = " + (item.getHoraTermino()==null?"null":"'" + item.getHoraTermino() + "'") + "  "
		+ " , data_inicio_periodo = " + (item.getDataInicioPeriodo()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPeriodo()) ) + "  "
		+ " , data_termino_periodo = " + (item.getDataTerminoPeriodo()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataTerminoPeriodo()) ) + "  "
		;
	}
	protected String camposValoresUpdateEdicao(PeriodoPregao item) {
		return " id_periodo_pregao = '" + item.getIdPeriodoPregao() + "'  " 
		+ " , hora_inicio = " + (item.getHoraInicio()==null?"null":"'" + item.getHoraInicio() + "'") + "  " 
		+ " , hora_termino = " + (item.getHoraTermino()==null?"null":"'" + item.getHoraTermino() + "'") + "  " 
		+ " , data_inicio_periodo = " + (item.getDataInicioPeriodo()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataInicioPeriodo()) ) + "  " 
		+ " , data_termino_periodo = " + (item.getDataTerminoPeriodo()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getDataTerminoPeriodo()) ) + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
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
        montador.adicionaMontador(new PeriodoPregaoMontador(), null);
         return montador;
    }
	
	
}
