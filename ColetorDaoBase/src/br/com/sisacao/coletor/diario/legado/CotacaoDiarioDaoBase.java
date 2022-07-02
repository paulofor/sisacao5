package br.com.sisacao.coletor.diario.legado;

import java.util.List;

import br.com.digicom.cotacao.dao.DaoAplicacao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;





public abstract class CotacaoDiarioDaoBase extends DaoAplicacao implements CotacaoDiarioDaoBaseI {
	
	
	
	public CotacaoDiarioDaoBase(DataFonte dataSource) {
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
		return new CotacaoDiarioMontador();
	}
	public static String tabelaSelect() {
		return " cotacao_diario" ;
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
		return " order by " + tabelaSelect() + ".fechamento_original " ;
	}
	
	
	public static String camposOrdenados() {
		return " cotacao_diario.id_cotacao_diario " 
		+ " ,cotacao_diario.minimo_corrigido " 
		+ " ,cotacao_diario.maximo_corrigido " 
		+ " ,cotacao_diario.abertura_corrigido " 
		+ " , DATE_FORMAT(cotacao_diario.data,'%d-%m-%Y') " 
		+ " ,cotacao_diario.volume " 
		+ " ,cotacao_diario.negocios " 
		+ " ,cotacao_diario.fechamento_original " 
		+ " ,cotacao_diario.minimo_original " 
		+ " ,cotacao_diario.maximo_original " 
		+ " ,cotacao_diario.abertura_original " 
		+ " ,cotacao_diario.fechamento_corrigido " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_cotacao_diario " 
		+ " , " + nomeTabela + ".minimo_corrigido " 
		+ " , " + nomeTabela + ".maximo_corrigido " 
		+ " , " + nomeTabela + ".abertura_corrigido " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".volume " 
		+ " , " + nomeTabela + ".negocios " 
		+ " , " + nomeTabela + ".fechamento_original " 
		+ " , " + nomeTabela + ".minimo_original " 
		+ " , " + nomeTabela + ".maximo_original " 
		+ " , " + nomeTabela + ".abertura_original " 
		+ " , " + nomeTabela + ".fechamento_corrigido " 
		;
	}
	
	
	@Override
	public void insereItem(CotacaoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(CotacaoDiario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(CotacaoDiario item) throws DaoException {
		CotacaoDiario teste = this.obtemPorChave(item.getIdCotacaoDiario());
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
	public void insereItemLoad(CotacaoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_cotacao_diario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdCotacaoDiario(id);	
	}
	@Override
	public void alteraItem(CotacaoDiario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_cotacao_diario = " + item.getIdCotacaoDiario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(CotacaoDiario item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_cotacao_diario = " + item.getIdCotacaoDiario();
		executaSql(query);
	}
	@Override
	public CotacaoDiario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_cotacao_diario = " + id;
        return (CotacaoDiario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CotacaoDiarioFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CotacaoDiarioFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CotacaoDiarioFiltro filtro)
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
	
	
	protected String valoresInsert(CotacaoDiario item) {
		return " ( '" + item.getIdCotacaoDiario() + "'  " 
		+ " ,'" +  DCConvert.ToDataBase(item.getMinimoCorrigido()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMaximoCorrigido()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getAberturaCorrigido()) + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getVolume()) + "'  "
		+ " ,'" + item.getNegocios() + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getFechamentoOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMinimoOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getMaximoOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getAberturaOriginal()) + "'  "
		+ " ,'" +  DCConvert.ToDataBase(item.getFechamentoCorrigido()) + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_cotacao_diario " 
		+ " ,minimo_corrigido " 
		+ " ,maximo_corrigido " 
		+ " ,abertura_corrigido " 
		+ " ,data " 
		+ " ,volume " 
		+ " ,negocios " 
		+ " ,fechamento_original " 
		+ " ,minimo_original " 
		+ " ,maximo_original " 
		+ " ,abertura_original " 
		+ " ,fechamento_corrigido " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(CotacaoDiario item) {
		return " id_cotacao_diario = '" + item.getIdCotacaoDiario() + "'  " 
		+ " , minimo_corrigido = '" +  DCConvert.ToDataBase(item.getMinimoCorrigido()) + "'  "
		+ " , maximo_corrigido = '" +  DCConvert.ToDataBase(item.getMaximoCorrigido()) + "'  "
		+ " , abertura_corrigido = '" +  DCConvert.ToDataBase(item.getAberturaCorrigido()) + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , volume = '" +  DCConvert.ToDataBase(item.getVolume()) + "'  "
		+ " , negocios = '" + item.getNegocios() + "'  "
		+ " , fechamento_original = '" +  DCConvert.ToDataBase(item.getFechamentoOriginal()) + "'  "
		+ " , minimo_original = '" +  DCConvert.ToDataBase(item.getMinimoOriginal()) + "'  "
		+ " , maximo_original = '" +  DCConvert.ToDataBase(item.getMaximoOriginal()) + "'  "
		+ " , abertura_original = '" +  DCConvert.ToDataBase(item.getAberturaOriginal()) + "'  "
		+ " , fechamento_corrigido = '" +  DCConvert.ToDataBase(item.getFechamentoCorrigido()) + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(CotacaoDiario item) {
		return " id_cotacao_diario = '" + item.getIdCotacaoDiario() + "'  " 
		+ " , minimo_corrigido = '" +  DCConvert.ToDataBase(item.getMinimoCorrigido()) + "'  " 
		+ " , maximo_corrigido = '" +  DCConvert.ToDataBase(item.getMaximoCorrigido()) + "'  " 
		+ " , abertura_corrigido = '" +  DCConvert.ToDataBase(item.getAberturaCorrigido()) + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , volume = '" +  DCConvert.ToDataBase(item.getVolume()) + "'  " 
		+ " , negocios = '" + item.getNegocios() + "'  " 
		+ " , fechamento_original = '" +  DCConvert.ToDataBase(item.getFechamentoOriginal()) + "'  " 
		+ " , minimo_original = '" +  DCConvert.ToDataBase(item.getMinimoOriginal()) + "'  " 
		+ " , maximo_original = '" +  DCConvert.ToDataBase(item.getMaximoOriginal()) + "'  " 
		+ " , abertura_original = '" +  DCConvert.ToDataBase(item.getAberturaOriginal()) + "'  " 
		+ " , fechamento_corrigido = '" +  DCConvert.ToDataBase(item.getFechamentoCorrigido()) + "'  " 
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
        montador.adicionaMontador(new CotacaoDiarioMontador(), null);
         return montador;
    }
	
	
}
