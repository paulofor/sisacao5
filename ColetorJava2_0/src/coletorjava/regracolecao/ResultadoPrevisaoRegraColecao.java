package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class ResultadoPrevisaoRegraColecao {
	
	public ResultadoPrevisaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ResultadoPrevisaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ResultadoPrevisaoFiltro _filtro;

	public ResultadoPrevisaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ResultadoPrevisaoFiltro();
		return _filtro;
	}

	public void setFiltro(ResultadoPrevisaoFiltro dado) {
		_filtro = dado;
	}

	private ResultadoPrevisaoFiltro[] _listaEntrada;
	@Deprecated
	protected ResultadoPrevisaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ResultadoPrevisaoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ResultadoPrevisao> _listaItem;
	protected List<ResultadoPrevisao> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ResultadoPrevisao> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final ResultadoPrevisaoDao getDao() {
		return DBB.getInstancia().getResultadoPrevisaoDao();
	}
	protected final ResultadoPrevisaoDao getDao(final DaoConexao conexao) {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ResultadoPrevisaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ResultadoPrevisao PreInsercao(ResultadoPrevisao item) {
		return item;
	}

	public ResultadoPrevisao PreAlteracao(ResultadoPrevisao item) {
		return item;
	}

	public ResultadoPrevisao obtemPorChave(long chave) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ResultadoPrevisao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ResultadoPrevisao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		ResultadoPrevisao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ResultadoPrevisao excluiItem(ResultadoPrevisao item) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = null;
		ResultadoPrevisao saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ResultadoPrevisao excluiItem(ResultadoPrevisao item, DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ResultadoPrevisao alteraItem(ResultadoPrevisao item) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = null;
		ResultadoPrevisao saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ResultadoPrevisao alteraItem(ResultadoPrevisao item, DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ResultadoPrevisao insereItemLoad(ResultadoPrevisao item) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conexao = null;
		ResultadoPrevisao saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ResultadoPrevisao insereItemLoad(ResultadoPrevisao item, DaoConexao conexao) throws DaoException {
		ResultadoPrevisaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoDeDadoTheta(long id) throws DaoException {
		// Existe no DAO
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorDadoThetaGeradoDe(id);
	}
	public boolean excluiPorGeradoDeDadoTheta(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorGeradoDeDadoTheta(long id, DaoConexao conn) throws DaoException {
		ResultadoPrevisaoDao dao = getDao(conn);
		return dao.ListaPorDadoThetaGeradoDe(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorMesmoPeriodoResultadoMes(long id) throws DaoException {
		// Existe no DAO
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorResultadoMesMesmoPeriodo(id);
	}
	public boolean excluiPorMesmoPeriodoResultadoMes(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorMesmoPeriodoResultadoMes(long id, DaoConexao conn) throws DaoException {
		ResultadoPrevisaoDao dao = getDao(conn);
		return dao.ListaPorResultadoMesMesmoPeriodo(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAMesAno(long id) throws DaoException {
		// Existe no DAO
		ResultadoPrevisaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorMesAnoReferenteA(id);
	}
	public boolean excluiPorReferenteAMesAno(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAMesAno(long id, DaoConexao conn) throws DaoException {
		ResultadoPrevisaoDao dao = getDao(conn);
		return dao.ListaPorMesAnoReferenteA(id);
	}
	
	
}
