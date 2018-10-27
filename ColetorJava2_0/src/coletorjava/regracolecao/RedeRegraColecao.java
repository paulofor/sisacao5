package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class RedeRegraColecao {
	
	public RedeRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		RedeFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private RedeFiltro _filtro;

	public RedeFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new RedeFiltro();
		return _filtro;
	}

	public void setFiltro(RedeFiltro dado) {
		_filtro = dado;
	}

	private RedeFiltro[] _listaEntrada;
	@Deprecated
	protected RedeFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final RedeFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Rede> _listaItem;
	protected List<Rede> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Rede> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final RedeDao getDao() {
		return DBB.getInstancia().getRedeDao();
	}
	protected final RedeDao getDao(final DaoConexao conexao) {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final RedeDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Rede PreInsercao(Rede item) {
		return item;
	}

	public Rede PreAlteracao(Rede item) {
		return item;
	}

	public Rede obtemPorChave(long chave) throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Rede saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Rede obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		Rede saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Rede excluiItem(Rede item) throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = null;
		Rede saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Rede excluiItem(Rede item, DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Rede alteraItem(Rede item) throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = null;
		Rede saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Rede alteraItem(Rede item, DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Rede insereItemLoad(Rede item) throws DaoException {
		RedeDao dao = getDao();
		DaoConexao conexao = null;
		Rede saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Rede insereItemLoad(Rede item, DaoConexao conexao) throws DaoException {
		RedeDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
