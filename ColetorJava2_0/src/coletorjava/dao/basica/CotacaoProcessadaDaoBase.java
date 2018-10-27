package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.regracolecao.filtro.CotacaoProcessadaFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CotacaoProcessadaDaoBase extends DaoAplicacao implements CotacaoProcessadaDaoBaseI {
	
	
	public CotacaoProcessadaDaoBase() {
		super();
	}
	public CotacaoProcessadaDaoBase(DataFonte dataSource) {
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
		return new CotacaoProcessadaMontador();
	}
	public static String tabelaSelect() {
		return " cotacao_processada" ;
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
		return " order by " + tabelaSelect() + ".valor_corrigido " ;
	}
	
	
	public static String camposOrdenados() {
		return " cotacao_processada.id_cotacao_processada " 
		+ " , DATE_FORMAT(cotacao_processada.hora_cotacao_tempo_real,'%H:%i') " 
		+ " ,cotacao_processada.valor_tempo_real " 
		+ " ,cotacao_processada.valor_corrigido " 
		+ " ,cotacao_processada.contador_dia " 
		+ " , DATE_FORMAT(cotacao_processada.data,'%d-%m-%Y') " 
		+ " , DATE_FORMAT(cotacao_processada.hora_serie_temporal,'%H:%i') " 
		+ " , DATE_FORMAT(cotacao_processada.hora_cotacao,'%H:%i') " 
		+ " ,cotacao_processada.negocios " 
		+ " ,cotacao_processada.valor " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_cotacao_processada " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_cotacao_tempo_real,'%H:%i') " 
		+ " , " + nomeTabela + ".valor_tempo_real " 
		+ " , " + nomeTabela + ".valor_corrigido " 
		+ " , " + nomeTabela + ".contador_dia " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_serie_temporal,'%H:%i') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_cotacao,'%H:%i') " 
		+ " , " + nomeTabela + ".negocios " 
		+ " , " + nomeTabela + ".valor " 
		;
	}
	
	
	@Override
	public void insereItem(CotacaoProcessada item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CotacaoProcessada item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CotacaoProcessada item) throws DaoException {
		CotacaoProcessada teste = this.obtemPorChave(item.getIdCotacaoProcessada());
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
	public void insereItemLoad(CotacaoProcessada item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_cotacao_processada) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCotacaoProcessada(id);	
	}
	@Override
	public void alteraItem(CotacaoProcessada item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_cotacao_processada = " + item.getIdCotacaoProcessada();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CotacaoProcessada item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_cotacao_processada = " + item.getIdCotacaoProcessada();
		executaSql(query);
	}
	@Override
	public CotacaoProcessada obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_cotacao_processada = " + id;
        return (CotacaoProcessada) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CotacaoProcessadaFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CotacaoProcessadaFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CotacaoProcessadaFiltro filtro)
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
	
	
	protected String valoresInsert(CotacaoProcessada item) {
		return " ( '" + item.getIdCotacaoProcessada() + "'  " 
		+ " ," + (item.getHoraCotacaoTempoReal()==null?"null":"'" + item.getHoraCotacaoTempoReal() + "'") + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorTempoReal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValorCorrigido()) + "'  "
		+ " ,'" + item.getContadorDia() + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ," + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  "
		+ " ," + (item.getHoraCotacao()==null?"null":"'" + item.getHoraCotacao() + "'") + "  "
		+ " ,'" + item.getNegocios() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getValor()) + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_cotacao_processada " 
		+ " ,hora_cotacao_tempo_real " 
		+ " ,valor_tempo_real " 
		+ " ,valor_corrigido " 
		+ " ,contador_dia " 
		+ " ,data " 
		+ " ,hora_serie_temporal " 
		+ " ,hora_cotacao " 
		+ " ,negocios " 
		+ " ,valor " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CotacaoProcessada item) {
		return " id_cotacao_processada = '" + item.getIdCotacaoProcessada() + "'  " 
		+ " , hora_cotacao_tempo_real = " + (item.getHoraCotacaoTempoReal()==null?"null":"'" + item.getHoraCotacaoTempoReal() + "'") + "  "
		+ " , valor_tempo_real = '" +  DCConvert.ToDataBase(item.getValorTempoReal()) + "'  "
		+ " , valor_corrigido = '" +  DCConvert.ToDataBase(item.getValorCorrigido()) + "'  "
		+ " , contador_dia = '" + item.getContadorDia() + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , hora_serie_temporal = " + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  "
		+ " , hora_cotacao = " + (item.getHoraCotacao()==null?"null":"'" + item.getHoraCotacao() + "'") + "  "
		+ " , negocios = '" + item.getNegocios() + "'  "
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(CotacaoProcessada item) {
		return " id_cotacao_processada = '" + item.getIdCotacaoProcessada() + "'  " 
		+ " , hora_cotacao_tempo_real = " + (item.getHoraCotacaoTempoReal()==null?"null":"'" + item.getHoraCotacaoTempoReal() + "'") + "  " 
		+ " , valor_tempo_real = '" +  DCConvert.ToDataBase(item.getValorTempoReal()) + "'  " 
		+ " , valor_corrigido = '" +  DCConvert.ToDataBase(item.getValorCorrigido()) + "'  " 
		+ " , contador_dia = '" + item.getContadorDia() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , hora_serie_temporal = " + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  " 
		+ " , hora_cotacao = " + (item.getHoraCotacao()==null?"null":"'" + item.getHoraCotacao() + "'") + "  " 
		+ " , negocios = '" + item.getNegocios() + "'  " 
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  " 
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
        montador.adicionaMontador(new CotacaoProcessadaMontador(), null);
         return montador;
    }
	
	
}
