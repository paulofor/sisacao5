package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class ResultadoMesRegraColecao {
	
	public ResultadoMesRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ResultadoMesFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ResultadoMesFiltro _filtro;

	public ResultadoMesFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ResultadoMesFiltro();
		return _filtro;
	}

	public void setFiltro(ResultadoMesFiltro dado) {
		_filtro = dado;
	}

	private ResultadoMesFiltro[] _listaEntrada;
	@Deprecated
	protected ResultadoMesFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ResultadoMesFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ResultadoMes> _listaItem;
	protected List<ResultadoMes> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ResultadoMes> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final ResultadoMesDao getDao() {
		return DBB.getInstancia().getResultadoMesDao();
	}
	protected final ResultadoMesDao getDao(final DaoConexao conexao) {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ResultadoMesDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ResultadoMes PreInsercao(ResultadoMes item) {
		return item;
	}

	public ResultadoMes PreAlteracao(ResultadoMes item) {
		return item;
	}

	public ResultadoMes obtemPorChave(long chave) throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ResultadoMes saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ResultadoMes obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		ResultadoMes saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ResultadoMes excluiItem(ResultadoMes item) throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = null;
		ResultadoMes saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ResultadoMes excluiItem(ResultadoMes item, DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ResultadoMes alteraItem(ResultadoMes item) throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = null;
		ResultadoMes saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ResultadoMes alteraItem(ResultadoMes item, DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ResultadoMes insereItemLoad(ResultadoMes item) throws DaoException {
		ResultadoMesDao dao = getDao();
		DaoConexao conexao = null;
		ResultadoMes saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ResultadoMes insereItemLoad(ResultadoMes item, DaoConexao conexao) throws DaoException {
		ResultadoMesDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoPorProjetoDadoTreino(long id) throws DaoException {
		// Existe no DAO
		ResultadoMesDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorProjetoDadoTreinoGeradoPor(id);
	}
	public boolean excluiPorGeradoPorProjetoDadoTreino(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorGeradoPorProjetoDadoTreino(long id, DaoConexao conn) throws DaoException {
		ResultadoMesDao dao = getDao(conn);
		return dao.ListaPorProjetoDadoTreinoGeradoPor(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAMesAno(long id) throws DaoException {
		// Existe no DAO
		ResultadoMesDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorMesAnoReferenteA(id);
	}
	public boolean excluiPorReferenteAMesAno(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAMesAno(long id, DaoConexao conn) throws DaoException {
		ResultadoMesDao dao = getDao(conn);
		return dao.ListaPorMesAnoReferenteA(id);
	}
	
	
}
