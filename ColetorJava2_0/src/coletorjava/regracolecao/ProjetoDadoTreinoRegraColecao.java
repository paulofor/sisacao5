package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class ProjetoDadoTreinoRegraColecao {
	
	public ProjetoDadoTreinoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ProjetoDadoTreinoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ProjetoDadoTreinoFiltro _filtro;

	public ProjetoDadoTreinoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ProjetoDadoTreinoFiltro();
		return _filtro;
	}

	public void setFiltro(ProjetoDadoTreinoFiltro dado) {
		_filtro = dado;
	}

	private ProjetoDadoTreinoFiltro[] _listaEntrada;
	@Deprecated
	protected ProjetoDadoTreinoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ProjetoDadoTreinoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ProjetoDadoTreino> _listaItem;
	protected List<ProjetoDadoTreino> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ProjetoDadoTreino> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final ProjetoDadoTreino ObtemPorItem() throws DaoException {
		ProjetoDadoTreino saida;
		ProjetoDadoTreinoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorItem(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract ProjetoDadoTreino ObtemPorItem(final DaoConexao conexao)
			throws DaoException;




	public static final ProjetoDadoTreinoDao getDao() {
		return DBB.getInstancia().getProjetoDadoTreinoDao();
	}
	protected final ProjetoDadoTreinoDao getDao(final DaoConexao conexao) {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ProjetoDadoTreinoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ProjetoDadoTreino PreInsercao(ProjetoDadoTreino item) {
		return item;
	}

	public ProjetoDadoTreino PreAlteracao(ProjetoDadoTreino item) {
		return item;
	}

	public ProjetoDadoTreino obtemPorChave(long chave) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ProjetoDadoTreino saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ProjetoDadoTreino obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		ProjetoDadoTreino saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ProjetoDadoTreino excluiItem(ProjetoDadoTreino item) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		ProjetoDadoTreino saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProjetoDadoTreino excluiItem(ProjetoDadoTreino item, DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ProjetoDadoTreino alteraItem(ProjetoDadoTreino item) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		ProjetoDadoTreino saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProjetoDadoTreino alteraItem(ProjetoDadoTreino item, DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ProjetoDadoTreino insereItemLoad(ProjetoDadoTreino item) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		ProjetoDadoTreino saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ProjetoDadoTreino insereItemLoad(ProjetoDadoTreino item, DaoConexao conexao) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteATicker(long id) throws DaoException {
		// Existe no DAO
		ProjetoDadoTreinoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	public boolean excluiPorReferenteATicker(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteATicker(long id, DaoConexao conn) throws DaoException {
		ProjetoDadoTreinoDao dao = getDao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	
	
}
