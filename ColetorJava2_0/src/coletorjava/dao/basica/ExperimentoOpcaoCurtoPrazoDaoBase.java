package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.ExperimentoOpcaoCurtoPrazo;
import coletorjava.regracolecao.filtro.ExperimentoOpcaoCurtoPrazoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class ExperimentoOpcaoCurtoPrazoDaoBase extends DaoAplicacao implements ExperimentoOpcaoCurtoPrazoDaoBaseI {
	
	
	public ExperimentoOpcaoCurtoPrazoDaoBase() {
		super();
	}
	public ExperimentoOpcaoCurtoPrazoDaoBase(DataFonte dataSource) {
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
		return new ExperimentoOpcaoCurtoPrazoMontador();
	}
	public static String tabelaSelect() {
		return " experimento_opcao_curto_prazo" ;
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
		return " order by " + tabelaSelect() + ".descricao_experimento " ;
	}
	
	
	public static String camposOrdenados() {
		return " experimento_opcao_curto_prazo.id_experimento_opcao_curto_prazo " 
		+ " ,experimento_opcao_curto_prazo.descricao_experimento " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_experimento_opcao_curto_prazo " 
		+ " , " + nomeTabela + ".descricao_experimento " 
		;
	}
	
	
	@Override
	public void insereItem(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		ExperimentoOpcaoCurtoPrazo teste = this.obtemPorChave(item.getIdExperimentoOpcaoCurtoPrazo());
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
	public void insereItemLoad(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_experimento_opcao_curto_prazo) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdExperimentoOpcaoCurtoPrazo(id);	
	}
	@Override
	public void alteraItem(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_experimento_opcao_curto_prazo = " + item.getIdExperimentoOpcaoCurtoPrazo();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_experimento_opcao_curto_prazo = " + item.getIdExperimentoOpcaoCurtoPrazo();
		executaSql(query);
	}
	@Override
	public ExperimentoOpcaoCurtoPrazo obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_experimento_opcao_curto_prazo = " + id;
        return (ExperimentoOpcaoCurtoPrazo) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(ExperimentoOpcaoCurtoPrazoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( ExperimentoOpcaoCurtoPrazoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(ExperimentoOpcaoCurtoPrazoFiltro filtro)
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
	
	
	protected String valoresInsert(ExperimentoOpcaoCurtoPrazo item) {
		return " ( '" + item.getIdExperimentoOpcaoCurtoPrazo() + "'  " 
		+ " ,'" + item.getDescricaoExperimento() + "'  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_experimento_opcao_curto_prazo " 
		+ " ,descricao_experimento " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(ExperimentoOpcaoCurtoPrazo item) {
		return " id_experimento_opcao_curto_prazo = '" + item.getIdExperimentoOpcaoCurtoPrazo() + "'  " 
		+ " , descricao_experimento = '" + item.getDescricaoExperimento() + "'  "
		;
	}
	protected String camposValoresUpdateEdicao(ExperimentoOpcaoCurtoPrazo item) {
		return " id_experimento_opcao_curto_prazo = '" + item.getIdExperimentoOpcaoCurtoPrazo() + "'  " 
		+ " , descricao_experimento = '" + item.getDescricaoExperimento() + "'  " 
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
        montador.adicionaMontador(new ExperimentoOpcaoCurtoPrazoMontador(), null);
         return montador;
    }
	
	
}
