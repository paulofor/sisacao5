package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class TreinoRedeRegraColecao {
	
	public TreinoRedeRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		TreinoRedeFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private TreinoRedeFiltro _filtro;

	public TreinoRedeFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new TreinoRedeFiltro();
		return _filtro;
	}

	public void setFiltro(TreinoRedeFiltro dado) {
		_filtro = dado;
	}

	private TreinoRedeFiltro[] _listaEntrada;
	@Deprecated
	protected TreinoRedeFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final TreinoRedeFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<TreinoRede> _listaItem;
	protected List<TreinoRede> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<TreinoRede> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final TreinoRedeDao getDao() {
		return DBB.getInstancia().getTreinoRedeDao();
	}
	protected final TreinoRedeDao getDao(final DaoConexao conexao) {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final TreinoRedeDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public TreinoRede PreInsercao(TreinoRede item) {
		return item;
	}

	public TreinoRede PreAlteracao(TreinoRede item) {
		return item;
	}

	public TreinoRede obtemPorChave(long chave) throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		TreinoRede saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public TreinoRede obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		TreinoRede saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public TreinoRede excluiItem(TreinoRede item) throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = null;
		TreinoRede saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public TreinoRede excluiItem(TreinoRede item, DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public TreinoRede alteraItem(TreinoRede item) throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = null;
		TreinoRede saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public TreinoRede alteraItem(TreinoRede item, DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public TreinoRede insereItemLoad(TreinoRede item) throws DaoException {
		TreinoRedeDao dao = getDao();
		DaoConexao conexao = null;
		TreinoRede saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public TreinoRede insereItemLoad(TreinoRede item, DaoConexao conexao) throws DaoException {
		TreinoRedeDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceARede(long id) throws DaoException {
		// Existe no DAO
		TreinoRedeDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorRedePertenceA(id);
	}
	public boolean excluiPorPertenceARede(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceARede(long id, DaoConexao conn) throws DaoException {
		TreinoRedeDao dao = getDao(conn);
		return dao.ListaPorRedePertenceA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoPorDadoTreino(long id) throws DaoException {
		// Existe no DAO
		TreinoRedeDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorDadoTreinoGeradoPor(id);
	}
	public boolean excluiPorGeradoPorDadoTreino(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorGeradoPorDadoTreino(long id, DaoConexao conn) throws DaoException {
		TreinoRedeDao dao = getDao(conn);
		return dao.ListaPorDadoTreinoGeradoPor(id);
	}
	
	
}
