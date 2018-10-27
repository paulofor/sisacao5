package coletorjava.dao.basica;

import java.util.List;

import coletorjava.dao.montador.*;
import coletorjava.modelo.DispositivoUsuario;
import coletorjava.regracolecao.filtro.DispositivoUsuarioFiltro;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.lib.dao.MontadorDaoI;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.lib.dao.MontadorDaoComposite;



public abstract class DispositivoUsuarioDaoBase extends DaoAplicacao implements DispositivoUsuarioDaoBaseI {
	
	
	public DispositivoUsuarioDaoBase() {
		super();
	}
	public DispositivoUsuarioDaoBase(DataFonte dataSource) {
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
		return new DispositivoUsuarioMontador();
	}
	public static String tabelaSelect() {
		return " dispositivo_usuario" ;
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
		return " order by " + tabelaSelect() + ".numero_celular " ;
	}
	
	
	public static String camposOrdenados() {
		return " dispositivo_usuario.id_dispositivo_usuario " 
		+ " ,dispositivo_usuario.numero_celular " 
		+ " ,dispositivo_usuario.codigo_dispositivo " 
		+ " ,dispositivo_usuario.tipo_acesso " 
		+ " ,dispositivo_usuario.melhor_path " 
		+ " ,dispositivo_usuario.id_usuario_ra " 
		;
	}

	public static String camposOrdenadosAlias(String nomeTabela) {
		return  nomeTabela + ".id_dispositivo_usuario " 
		+ " , " + nomeTabela + ".numero_celular " 
		+ " , " + nomeTabela + ".codigo_dispositivo " 
		+ " , " + nomeTabela + ".tipo_acesso " 
		+ " , " + nomeTabela + ".melhor_path " 
		+ " , " + nomeTabela + ".id_usuario_ra " 
		;
	}
	
	
	@Override
	public void insereItem(DispositivoUsuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}
	@Override
	public void insereItemCompleto(DispositivoUsuario item) throws DaoException {
		// mesmo que anterior com a chave
		throw new UnsupportedOperationException ();
	}
	@Override
	public boolean insereSeNaoExiste(DispositivoUsuario item) throws DaoException {
		DispositivoUsuario teste = this.obtemPorChave(item.getIdDispositivoUsuario());
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
	public void insereItemLoad(DispositivoUsuario item) throws DaoException {
		String sql;
        sql = "insert into " + tabelaSelect() +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
        sql = " SELECT MAX(id_dispositivo_usuario) from " + tabelaSelect();
        long id = this.getValorLong(sql);
        item.setIdDispositivoUsuario(id);	
	}
	@Override
	public void alteraItem(DispositivoUsuario item) throws DaoException {
		String sql;
        sql = "update " + tabelaSelect() +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_dispositivo_usuario = " + item.getIdDispositivoUsuario();
        this.executaSql(sql);
 	}
	@Override
	public void excluiItem(DispositivoUsuario item) throws DaoException {
		String query = null;
		query = " delete from " + tabelaSelect() + " where id_dispositivo_usuario = " + item.getIdDispositivoUsuario();
		executaSql(query);
	}
	@Override
	public DispositivoUsuario obtemPorChave(long id) throws DaoException {
		setMontador(null);
		String sql;
        sql = "select " + camposOrdenados() + 
        	" from " + tabelaSelect() +
         	" where id_dispositivo_usuario = " + id;
        return (DispositivoUsuario) getObjeto(sql);
	}
	@Override
	public List ListaFiltro(DispositivoUsuarioFiltro filtro) throws DaoException {
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
	
	protected  String WhereFiltro( DispositivoUsuarioFiltro filtro ) {
    	String saida = "";
      	boolean primeiro;
      	primeiro = true;
      	
		if (filtro.getCodigoUsuarioReferenteA() != -1)
      	{
        	if (!primeiro) saida += " and ";
          	else primeiro = false;
          	saida += " " + tabelaSelect() + ".id_usuario_ra = " + filtro.getCodigoUsuarioReferenteA();
      	}
      	
      	return saida;
	}
	
	
	@Override
	public List ListaFiltroSimples(DispositivoUsuarioFiltro filtro)
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
	
	
	protected String valoresInsert(DispositivoUsuario item) {
		return " ( '" + item.getIdDispositivoUsuario() + "'  " 
		+ " ,'" + item.getNumeroCelular() + "'  "
		+ " ,'" + item.getCodigoDispositivo() + "'  "
		+ " ,'" + item.getTipoAcesso() + "'  "
		+ " ,'" + item.getMelhorPath() + "'  "
		+ " ," + item.getIdUsuarioRa() + "  "
		+ " ) ";
	}
	protected String camposInsert() 
	{
		return " ( id_dispositivo_usuario " 
		+ " ,numero_celular " 
		+ " ,codigo_dispositivo " 
		+ " ,tipo_acesso " 
		+ " ,melhor_path " 
		+ " ,id_usuario_ra " 
		 + " ) ";
	}
	
	protected String camposValoresUpdate(DispositivoUsuario item) {
		return " id_dispositivo_usuario = '" + item.getIdDispositivoUsuario() + "'  " 
		+ " , numero_celular = '" + item.getNumeroCelular() + "'  "
		+ " , codigo_dispositivo = '" + item.getCodigoDispositivo() + "'  "
		+ " , tipo_acesso = '" + item.getTipoAcesso() + "'  "
		+ " , melhor_path = '" + item.getMelhorPath() + "'  "
		+ " , id_usuario_ra = " + item.getIdUsuarioRa() + "  "
		;
	}
	protected String camposValoresUpdateEdicao(DispositivoUsuario item) {
		return " id_dispositivo_usuario = '" + item.getIdDispositivoUsuario() + "'  " 
		+ " , numero_celular = '" + item.getNumeroCelular() + "'  " 
		+ " , codigo_dispositivo = '" + item.getCodigoDispositivo() + "'  " 
		+ " , tipo_acesso = '" + item.getTipoAcesso() + "'  " 
		+ " , melhor_path = '" + item.getMelhorPath() + "'  " 
		+ " , id_usuario_ra = " + item.getIdUsuarioRa() + "  " 
		;
	}
	
	//** Lista Sem chave Estrangeira
	
	//** Final Lista Sem chave Estrangeira
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAUsuario(long id) throws DaoException {
		setMontador(null);
		String sql;
      	sql = "select " + camposOrdenadosJoin() + " from " + tabelaSelect() + 
        outterJoinAgrupado() +
       	" where id_usuario_ra = " + id + orderByLista() + " " + getLimite();
       	setMontador(getMontadorAgrupado());
      	return getListaSql(sql);
	}
	// Estavam no Extendida - Depois colocar como final (tratar order e limit) -> limite 08/01/2016
	public List ListaPorUsuarioReferenteA(long id) throws DaoException {
		return getPorReferenteAUsuario(id);
	}
	public boolean excluiPorReferenteAUsuario(long id) throws DaoException{
		setMontador(null);
		String sql;
      	sql = "delete from " + tabelaSelect() + 
       	" where id_usuario_ra = " + id;
       	this.executaSql(sql);
       	return true;
	}
	//public static String innerJoinUsuario_ReferenteA() {
	//	return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_dispositivo_usuario_u = " + tabelaSelect() + ".id_dispositivo_usuario ";  
	//}
	
	
	
	
	// Relacionamento onde esse objeto ? chave estrangeira de outro. ????
	
	private boolean _obtemUsuario_ReferenteA = false;
	public void setObtemUsuario_ReferenteA() {
		_obtemUsuario_ReferenteA = true;
	}
	protected String outterJoinUsuario_ReferenteA() {
		return " left outer join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_ra ";  
	}
	public boolean atualizaReferenteAUsuario(long idDispositivoUsuario, long idUsuarioRa) throws DaoException{
		String sql;
      	sql = "update " + tabelaSelect() + 
      	" set id_usuario_ra  = " + idUsuarioRa +
        " where id_dispositivo_usuario = " +  idDispositivoUsuario;
       	this.executaSql(sql);
       	return true;
	}
	
	public static String innerJoinUsuario_ReferenteA() {
		return " inner join " + UsuarioDaoBase.tabelaSelect() + " on " + UsuarioDaoBase.tabelaSelect() + ".id_usuario = " + tabelaSelect() + ".id_usuario_ra ";  
	}
	
 	
	// ********************************************************************	
	
	
	
	protected String camposOrdenadosJoin()
    {
        String saida = camposOrdenados();
		saida += (this._obtemUsuario_ReferenteA?" , " +UsuarioDaoBase.camposOrdenados():"");
        return saida;
    }
    
    public void limpaObtem()
    {
		_obtemUsuario_ReferenteA = false;
    }
    
	protected String outterJoinAgrupado()
    {
        String saida = " ";
		saida += (this._obtemUsuario_ReferenteA? outterJoinUsuario_ReferenteA() + " ":"");
        return saida;
    }
    protected MontadorDaoI getMontadorAgrupado()
    {
        MontadorDaoComposite montador = new MontadorDaoComposite();
        montador.adicionaMontador(new DispositivoUsuarioMontador(), null);
		if (this._obtemUsuario_ReferenteA)
            montador.adicionaMontador(new UsuarioMontador(), "Usuario_ReferenteA");
         return montador;
    }
	
	
}
