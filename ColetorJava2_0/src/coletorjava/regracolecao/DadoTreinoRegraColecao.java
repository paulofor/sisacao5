package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class DadoTreinoRegraColecao {
	
	public DadoTreinoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		DadoTreinoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private DadoTreinoFiltro _filtro;

	public DadoTreinoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new DadoTreinoFiltro();
		return _filtro;
	}

	public void setFiltro(DadoTreinoFiltro dado) {
		_filtro = dado;
	}

	private DadoTreinoFiltro[] _listaEntrada;
	@Deprecated
	protected DadoTreinoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final DadoTreinoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<DadoTreino> _listaItem;
	protected List<DadoTreino> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<DadoTreino> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final DadoTreinoDao getDao() {
		return DBB.getInstancia().getDadoTreinoDao();
	}
	protected final DadoTreinoDao getDao(final DaoConexao conexao) {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final DadoTreinoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public DadoTreino PreInsercao(DadoTreino item) {
		return item;
	}

	public DadoTreino PreAlteracao(DadoTreino item) {
		return item;
	}

	public DadoTreino obtemPorChave(long chave) throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		DadoTreino saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public DadoTreino obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		DadoTreino saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public DadoTreino excluiItem(DadoTreino item) throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		DadoTreino saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DadoTreino excluiItem(DadoTreino item, DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public DadoTreino alteraItem(DadoTreino item) throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		DadoTreino saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DadoTreino alteraItem(DadoTreino item, DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public DadoTreino insereItemLoad(DadoTreino item) throws DaoException {
		DadoTreinoDao dao = getDao();
		DaoConexao conexao = null;
		DadoTreino saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DadoTreino insereItemLoad(DadoTreino item, DaoConexao conexao) throws DaoException {
		DadoTreinoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPossuiProjetoDadoTreino(long id) throws DaoException {
		// Existe no DAO
		DadoTreinoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProjetoDadoTreinoPossui(id);
	}
	public boolean excluiPorPossuiProjetoDadoTreino(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPossuiProjetoDadoTreino(long id, DaoConexao conn) throws DaoException {
		DadoTreinoDao dao = getDao(conn);
		return dao.ListaPorProjetoDadoTreinoPossui(id);
	}
	
	
}
