package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class DispositivoUsuarioRegraColecao {
	
	public DispositivoUsuarioRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		DispositivoUsuarioFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private DispositivoUsuarioFiltro _filtro;

	public DispositivoUsuarioFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new DispositivoUsuarioFiltro();
		return _filtro;
	}

	public void setFiltro(DispositivoUsuarioFiltro dado) {
		_filtro = dado;
	}

	private DispositivoUsuarioFiltro[] _listaEntrada;
	@Deprecated
	protected DispositivoUsuarioFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final DispositivoUsuarioFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<DispositivoUsuario> _listaItem;
	protected List<DispositivoUsuario> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<DispositivoUsuario> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final DispositivoUsuarioDao getDao() {
		return DBB.getInstancia().getDispositivoUsuarioDao();
	}
	protected final DispositivoUsuarioDao getDao(final DaoConexao conexao) {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final DispositivoUsuarioDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public DispositivoUsuario PreInsercao(DispositivoUsuario item) {
		return item;
	}

	public DispositivoUsuario PreAlteracao(DispositivoUsuario item) {
		return item;
	}

	public DispositivoUsuario obtemPorChave(long chave) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		DispositivoUsuario saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public DispositivoUsuario obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		DispositivoUsuario saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public DispositivoUsuario excluiItem(DispositivoUsuario item) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = null;
		DispositivoUsuario saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DispositivoUsuario excluiItem(DispositivoUsuario item, DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public DispositivoUsuario alteraItem(DispositivoUsuario item) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = null;
		DispositivoUsuario saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DispositivoUsuario alteraItem(DispositivoUsuario item, DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public DispositivoUsuario insereItemLoad(DispositivoUsuario item) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conexao = null;
		DispositivoUsuario saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DispositivoUsuario insereItemLoad(DispositivoUsuario item, DaoConexao conexao) throws DaoException {
		DispositivoUsuarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAUsuario(long id) throws DaoException {
		// Existe no DAO
		DispositivoUsuarioDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorUsuarioReferenteA(id);
	}
	public boolean excluiPorReferenteAUsuario(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAUsuario(long id, DaoConexao conn) throws DaoException {
		DispositivoUsuarioDao dao = getDao(conn);
		return dao.ListaPorUsuarioReferenteA(id);
	}
	
	
}
