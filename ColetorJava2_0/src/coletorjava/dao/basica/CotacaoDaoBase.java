package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.Cotacao;
import coletorjava.regracolecao.filtro.CotacaoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class CotacaoDaoBase extends DaoAplicacao implements CotacaoDaoBaseI {
	
	
	public CotacaoDaoBase() {
		super();
	}
	public CotacaoDaoBase(DataFonte dataSource) {
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
		return new CotacaoMontador();
	}
	public static String tabelaSelect() {
		return " cotacao" ;
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
		return " order by " + tabelaSelect() + ".ult " ;
	}
	
	
	public static String camposOrdenados() {
		return " cotacao.id " 
		+ " ,cotacao.neg " 
		+ " , DATE_FORMAT(cotacao.data,'%d-%m-%Y') " 
		+ " ,cotacao.ult " 
		+ " , DATE_FORMAT(cotacao.hora_real,'%H:%i') " 
		+ " , DATE_FORMAT(cotacao.hora_neg,'%H:%i') " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id " 
		+ " , " + nomeTabela + ".neg " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".ult " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_real,'%H:%i') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_neg,'%H:%i') " 
		;
	}
	
	
	@Override
	public void insereItem(Cotacao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(Cotacao item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(Cotacao item) throws DaoException {
		Cotacao teste = this.obtemPorChave(item.getId());
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
	public void insereItemLoad(Cotacao item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setId(id);	
	}
	@Override
	public void alteraItem(Cotacao item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id = " + item.getId();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(Cotacao item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id = " + item.getId();
		executaSql(query);
	}
	@Override
	public Cotacao obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id = " + id;
        return (Cotacao) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(CotacaoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( CotacaoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(CotacaoFiltro filtro)
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
	
	
	protected String valoresInsert(Cotacao item) {
		return " ( '" + item.getId() + "'  " 
		+ " ,'" + item.getNeg() + "'  "
		+ " ," + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " ,'" +  DCConvert.ToDataBase(item.getUlt()) + "'  "
		+ " ," + (item.getHoraReal()==null?"null":"'" + item.getHoraReal() + "'") + "  "
		+ " ," + (item.getHoraNeg()==null?"null":"'" + item.getHoraNeg() + "'") + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id " 
		+ " ,neg " 
		+ " ,data " 
		+ " ,ult " 
		+ " ,hora_real " 
		+ " ,hora_neg " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(Cotacao item) {
		return " id = '" + item.getId() + "'  " 
		+ " , neg = '" + item.getNeg() + "'  "
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  "
		+ " , ult = '" +  DCConvert.ToDataBase(item.getUlt()) + "'  "
		+ " , hora_real = " + (item.getHoraReal()==null?"null":"'" + item.getHoraReal() + "'") + "  "
		+ " , hora_neg = " + (item.getHoraNeg()==null?"null":"'" + item.getHoraNeg() + "'") + "  "
		;
	}
	protected String camposValoresUpdateEdicao(Cotacao item) {
		return " id = '" + item.getId() + "'  " 
		+ " , neg = '" + item.getNeg() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , ult = '" +  DCConvert.ToDataBase(item.getUlt()) + "'  " 
		+ " , hora_real = " + (item.getHoraReal()==null?"null":"'" + item.getHoraReal() + "'") + "  " 
		+ " , hora_neg = " + (item.getHoraNeg()==null?"null":"'" + item.getHoraNeg() + "'") + "  " 
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
        montador.adicionaMontador(new CotacaoMontador(), null);
         return montador;
    }
	
	
}
