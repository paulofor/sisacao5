package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class PeriodoPregaoRegraColecao {
	
	public PeriodoPregaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		PeriodoPregaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private PeriodoPregaoFiltro _filtro;

	public PeriodoPregaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new PeriodoPregaoFiltro();
		return _filtro;
	}

	public void setFiltro(PeriodoPregaoFiltro dado) {
		_filtro = dado;
	}

	private PeriodoPregaoFiltro[] _listaEntrada;
	@Deprecated
	protected PeriodoPregaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final PeriodoPregaoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<PeriodoPregao> _listaItem;
	protected List<PeriodoPregao> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<PeriodoPregao> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final PeriodoPregao PesquisaPorDia() throws DaoException {
		PeriodoPregao saida;
		PeriodoPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = PesquisaPorDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract PeriodoPregao PesquisaPorDia(final DaoConexao conexao)
			throws DaoException;




	public static final PeriodoPregaoDao getDao() {
		return DBB.getInstancia().getPeriodoPregaoDao();
	}
	protected final PeriodoPregaoDao getDao(final DaoConexao conexao) {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final PeriodoPregaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public PeriodoPregao PreInsercao(PeriodoPregao item) {
		return item;
	}

	public PeriodoPregao PreAlteracao(PeriodoPregao item) {
		return item;
	}

	public PeriodoPregao obtemPorChave(long chave) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		PeriodoPregao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public PeriodoPregao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		PeriodoPregao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public PeriodoPregao excluiItem(PeriodoPregao item) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = null;
		PeriodoPregao saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PeriodoPregao excluiItem(PeriodoPregao item, DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public PeriodoPregao alteraItem(PeriodoPregao item) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = null;
		PeriodoPregao saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PeriodoPregao alteraItem(PeriodoPregao item, DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public PeriodoPregao insereItemLoad(PeriodoPregao item) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		DaoConexao conexao = null;
		PeriodoPregao saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public PeriodoPregao insereItemLoad(PeriodoPregao item, DaoConexao conexao) throws DaoException {
		PeriodoPregaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
