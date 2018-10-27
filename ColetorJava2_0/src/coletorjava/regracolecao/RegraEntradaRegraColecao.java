package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class RegraEntradaRegraColecao {
	
	public RegraEntradaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		RegraEntradaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private RegraEntradaFiltro _filtro;

	public RegraEntradaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new RegraEntradaFiltro();
		return _filtro;
	}

	public void setFiltro(RegraEntradaFiltro dado) {
		_filtro = dado;
	}

	private RegraEntradaFiltro[] _listaEntrada;
	@Deprecated
	protected RegraEntradaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final RegraEntradaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<RegraEntrada> _listaItem;
	protected List<RegraEntrada> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<RegraEntrada> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final RegraEntradaDao getDao() {
		return DBB.getInstancia().getRegraEntradaDao();
	}
	protected final RegraEntradaDao getDao(final DaoConexao conexao) {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final RegraEntradaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public RegraEntrada PreInsercao(RegraEntrada item) {
		return item;
	}

	public RegraEntrada PreAlteracao(RegraEntrada item) {
		return item;
	}

	public RegraEntrada obtemPorChave(long chave) throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		RegraEntrada saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public RegraEntrada obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		RegraEntrada saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public RegraEntrada excluiItem(RegraEntrada item) throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = null;
		RegraEntrada saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public RegraEntrada excluiItem(RegraEntrada item, DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public RegraEntrada alteraItem(RegraEntrada item) throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = null;
		RegraEntrada saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public RegraEntrada alteraItem(RegraEntrada item, DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public RegraEntrada insereItemLoad(RegraEntrada item) throws DaoException {
		RegraEntradaDao dao = getDao();
		DaoConexao conexao = null;
		RegraEntrada saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public RegraEntrada insereItemLoad(RegraEntrada item, DaoConexao conexao) throws DaoException {
		RegraEntradaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
