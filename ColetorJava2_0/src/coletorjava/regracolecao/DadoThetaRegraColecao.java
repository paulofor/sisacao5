package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class DadoThetaRegraColecao {
	
	public DadoThetaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		DadoThetaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private DadoThetaFiltro _filtro;

	public DadoThetaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new DadoThetaFiltro();
		return _filtro;
	}

	public void setFiltro(DadoThetaFiltro dado) {
		_filtro = dado;
	}

	private DadoThetaFiltro[] _listaEntrada;
	@Deprecated
	protected DadoThetaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final DadoThetaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<DadoTheta> _listaItem;
	protected List<DadoTheta> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<DadoTheta> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final DadoThetaDao getDao() {
		return DBB.getInstancia().getDadoThetaDao();
	}
	protected final DadoThetaDao getDao(final DaoConexao conexao) {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final DadoThetaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public DadoTheta PreInsercao(DadoTheta item) {
		return item;
	}

	public DadoTheta PreAlteracao(DadoTheta item) {
		return item;
	}

	public DadoTheta obtemPorChave(long chave) throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		DadoTheta saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public DadoTheta obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		DadoTheta saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public DadoTheta excluiItem(DadoTheta item) throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = null;
		DadoTheta saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DadoTheta excluiItem(DadoTheta item, DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public DadoTheta alteraItem(DadoTheta item) throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = null;
		DadoTheta saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DadoTheta alteraItem(DadoTheta item, DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public DadoTheta insereItemLoad(DadoTheta item) throws DaoException {
		DadoThetaDao dao = getDao();
		DaoConexao conexao = null;
		DadoTheta saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DadoTheta insereItemLoad(DadoTheta item, DaoConexao conexao) throws DaoException {
		DadoThetaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorGeradoPorTreinoRede(long id) throws DaoException {
		// Existe no DAO
		DadoThetaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorTreinoRedeGeradoPor(id);
	}
	public boolean excluiPorGeradoPorTreinoRede(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorGeradoPorTreinoRede(long id, DaoConexao conn) throws DaoException {
		DadoThetaDao dao = getDao(conn);
		return dao.ListaPorTreinoRedeGeradoPor(id);
	}
	
	
}
