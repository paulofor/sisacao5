package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.DadoTreino;
import coletorjava.regracolecao.filtro.DadoTreinoFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class DadoTreinoDaoBase extends DaoAplicacao implements DadoTreinoDaoBaseI {
	
	
	public DadoTreinoDaoBase() {
		super();
	}
	public DadoTreinoDaoBase(DataFonte dataSource) {
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
		return new DadoTreinoMontador();
	}
	public static String tabelaSelect() {
		return " dado_treino" ;
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
		return " order by " + tabelaSelect() + ".nome_arquivo_x " ;
	}
	
	
	public static String camposOrdenados() {
		return " dado_treino.id_dado_treino " 
		+ " ,dado_treino.nome_arquivo_x " 
		+ " ,dado_treino.dias_entrada_diario " 
		+ " ,dado_treino.dias_entrada_intraday " 
		+ " ,dado_treino.tipo_periodo " 
		+ " ,dado_treino.qtde_neuronio_entrada " 
		+ " ,dado_treino.codigo_faixa " 
		+ " , DATE_FORMAT(dado_treino.ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " ,dado_treino.qtde_tick_intraday " 
		+ " ,dado_treino.nome_arquivo_y " 
		+ " ,dado_treino.ano " 
		+ " ,dado_treino.contador_por_ano " 
		+ " ,dado_treino.minutos_intraday " 
		+ " ,dado_treino.id_projeto_dado_treino_p " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_dado_treino " 
		+ " , " + nomeTabela + ".nome_arquivo_x " 
		+ " , " + nomeTabela + ".dias_entrada_diario " 
		+ " , " + nomeTabela + ".dias_entrada_intraday " 
		+ " , " + nomeTabela + ".tipo_periodo " 
		+ " , " + nomeTabela + ".qtde_neuronio_entrada " 
		+ " , " + nomeTabela + ".codigo_faixa " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".ultima_alteracao,'%d-%m-%Y %H:%i:%s') " 
		+ " , " + nomeTabela + ".qtde_tick_intraday " 
		+ " , " + nomeTabela + ".nome_arquivo_y " 
		+ " , " + nomeTabela + ".ano " 
		+ " , " + nomeTabela + ".contador_por_ano " 
		+ " , " + nomeTabela + ".minutos_intraday " 
		+ " , " + nomeTabela + ".id_projeto_dado_treino_p " 
		;
	}
	
	
	@Override
	public void insereItem(DadoTreino item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(DadoTreino item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(DadoTreino item) throws DaoException {
		DadoTreino teste = this.obtemPorChave(item.getIdDadoTreino());
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
	public void insereItemLoad(DadoTreino item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_dado_treino) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdDadoTreino(id);	
	}
	@Override
	public void alteraItem(DadoTreino item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_dado_treino = " + item.getIdDadoTreino();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(DadoTreino item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_dado_treino = " + item.getIdDadoTreino();
		executaSql(query);
	}
	@Override
	public DadoTreino obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_dado_treino = " + id;
        return (DadoTreino) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(DadoTreinoFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( DadoTreinoFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoProjetoDadoTreinoPossui() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_projeto_dado_treino_p = " + filtro.getCodigoProjetoDadoTreinoPossui();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(DadoTreinoFiltro filtro)
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
	
	
	protected String valoresInsert(DadoTreino item) {
		return " ( '" + item.getIdDadoTreino() + "'  " 
		+ " ,'" + item.getNomeArquivoX() + "'  "
		+ " ,'" + item.getDiasEntradaDiario() + "'  "
		+ " ,'" + item.getDiasEntradaIntraday() + "'  "
		+ " ,'" + item.getTipoPeriodo() + "'  "
		+ " ,'" + item.getQtdeNeuronioEntrada() + "'  "
		+ " ,'" + item.getCodigoFaixa() + "'  "
		+ " ," + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " ,'" + item.getQtdeTickIntraday() + "'  "
		+ " ,'" + item.getNomeArquivoY() + "'  "
		+ " ,'" + item.getAno() + "'  "
		+ " ,'" + item.getContadorPorAno() + "'  "
		+ " ,'" + item.getMinutosIntraday() + "'  "
		+ " ," + item.getIdProjetoDadoTreinoP() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_dado_treino " 
		+ " ,nome_arquivo_x " 
		+ " ,dias_entrada_diario " 
		+ " ,dias_entrada_intraday " 
		+ " ,tipo_periodo " 
		+ " ,qtde_neuronio_entrada " 
		+ " ,codigo_faixa " 
		+ " ,ultima_alteracao " 
		+ " ,qtde_tick_intraday " 
		+ " ,nome_arquivo_y " 
		+ " ,ano " 
		+ " ,contador_por_ano " 
		+ " ,minutos_intraday " 
		+ " ,id_projeto_dado_treino_p " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(DadoTreino item) {
		return " id_dado_treino = '" + item.getIdDadoTreino() + "'  " 
		+ " , nome_arquivo_x = '" + item.getNomeArquivoX() + "'  "
		+ " , dias_entrada_diario = '" + item.getDiasEntradaDiario() + "'  "
		+ " , dias_entrada_intraday = '" + item.getDiasEntradaIntraday() + "'  "
		+ " , tipo_periodo = '" + item.getTipoPeriodo() + "'  "
		+ " , qtde_neuronio_entrada = '" + item.getQtdeNeuronioEntrada() + "'  "
		+ " , codigo_faixa = '" + item.getCodigoFaixa() + "'  "
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  "
		+ " , qtde_tick_intraday = '" + item.getQtdeTickIntraday() + "'  "
		+ " , nome_arquivo_y = '" + item.getNomeArquivoY() + "'  "
		+ " , ano = '" + item.getAno() + "'  "
		+ " , contador_por_ano = '" + item.getContadorPorAno() + "'  "
		+ " , minutos_intraday = '" + item.getMinutosIntraday() + "'  "
		+ " , id_projeto_dado_treino_p = " + item.getIdProjetoDadoTreinoP() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(DadoTreino item) {
		return " id_dado_treino = '" + item.getIdDadoTreino() + "'  " 
		+ " , nome_arquivo_x = '" + item.getNomeArquivoX() + "'  " 
		+ " , dias_entrada_diario = '" + item.getDiasEntradaDiario() + "'  " 
		+ " , dias_entrada_intraday = '" + item.getDiasEntradaIntraday() + "'  " 
		+ " , tipo_periodo = '" + item.getTipoPeriodo() + "'  " 
		+ " , qtde_neuronio_entrada = '" + item.getQtdeNeuronioEntrada() + "'  " 
		+ " , codigo_faixa = '" + item.getCodigoFaixa() + "'  " 
		+ " , ultima_alteracao = " + (item.getUltimaAlteracao()==null?"null": DCConvert.ToDataSqlAAAA_MM_DD_HHMMSS(item.getUltimaAlteracao()) ) + "  " 
		+ " , qtde_tick_intraday = '" + item.getQtdeTickIntraday() + "'  " 
		+ " , nome_arquivo_y = '" + item.getNomeArquivoY() + "'  " 
		+ " , ano = '" + item.getAno() + "'  " 
		+ " , contador_por_ano = '" + item.getContadorPorAno() + "'  " 
		+ " , minutos_intraday = '" + item.getMinutosIntraday() + "'  " 
		+ " , id_projeto_dado_treino_p = " + item.getIdProjetoDadoTreinoP() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	/*
	public DadoTreino obtemPorTreinoRedeGerou(long id) {
		string sql;
		sql = "select " + camposOrdenados() +
			" from " + tabelaSelect() +
			innerJoinTreinoRede_Gerou() + 
			" where id_treino_rede = " + id;
		return (DadoTreino) getObjeto(sql);
	}
	*/
	public static String innerJoinTreinoRede_Gerou() {
		return " inner join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_dado_treino_gp = " + tabelaSelect() + ".id_dado_treino ";  
	}
	public static String outerJoinTreinoRede_Gerou() {
		return " left outer join " + TreinoRedeDaoBase.tabelaSelect() + " on " + TreinoRedeDaoBase.tabelaSelect() + ".id_dado_treino_gp = " + tabelaSelect() + ".id_dado_treino ";  
	}
 	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPossuiProjetoDadoTreino(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_projeto_dado_treino_p = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorProjetoDadoTreinoPossui(long id) throws DaoException {
		return getPorPossuiProjetoDadoTreino(id);
	}
	public boolean excluiPorPossuiProjetoDadoTreino(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_projeto_dado_treino_p = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinProjetoDadoTreino_Possui() {
	//	return " inner join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_dado_treino_g = " + tabelaSelect() + ".id_dado_treino ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemProjetoDadoTreino_Possui = false;
	public void setObtemProjetoDadoTreino_Possui() {
		_obtemProjetoDadoTreino_Possui = true;
	}
	protected String outterJoinProjetoDadoTreino_Possui() {
		return " left outer join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_projeto_dado_treino = " + tabelaSelect() + ".id_projeto_dado_treino_p ";  
	}
	public boolean atualizaPossuiProjetoDadoTreino(long idDadoTreino, long idProjetoDadoTreinoP) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_projeto_dado_treino_p  = " + idProjetoDadoTreinoP +
        " where id_dado_treino = " +  idDadoTreino;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinProjetoDadoTreino_Possui() {
		return " inner join " + ProjetoDadoTreinoDaoBase.tabelaSelect() + " on " + ProjetoDadoTreinoDaoBase.tabelaSelect() + ".id_projeto_dado_treino = " + tabelaSelect() + ".id_projeto_dado_treino_p ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemProjetoDadoTreino_Possui?" , " +ProjetoDadoTreinoDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemProjetoDadoTreino_Possui = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemProjetoDadoTreino_Possui? outterJoinProjetoDadoTreino_Possui() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new DadoTreinoMontador(), null);
		if (this._obtemProjetoDadoTreino_Possui)
            montador.adicionaMontador(new ProjetoDadoTreinoMontador(), "ProjetoDadoTreino_Possui");
         return montador;
    }
	
	
}
