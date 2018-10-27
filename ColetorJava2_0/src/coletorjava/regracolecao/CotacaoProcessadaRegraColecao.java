package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class CotacaoProcessadaRegraColecao {
	
	public CotacaoProcessadaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CotacaoProcessadaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CotacaoProcessadaFiltro _filtro;

	public CotacaoProcessadaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CotacaoProcessadaFiltro();
		return _filtro;
	}

	public void setFiltro(CotacaoProcessadaFiltro dado) {
		_filtro = dado;
	}

	private CotacaoProcessadaFiltro[] _listaEntrada;
	@Deprecated
	protected CotacaoProcessadaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CotacaoProcessadaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CotacaoProcessada> _listaItem;
	protected List<CotacaoProcessada> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CotacaoProcessada> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final CotacaoProcessada CriaHistorico15PorTickerPeriodo() throws DaoException {
		CotacaoProcessada saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaHistorico15PorTickerPeriodo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessada CriaHistorico15PorTickerPeriodo(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessada> CalculaHorariosTick() throws DaoException {
		List<CotacaoProcessada> saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaHorariosTick(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessada> CalculaHorariosTick(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessada> MontaDiaTicker() throws DaoException {
		List<CotacaoProcessada> saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MontaDiaTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessada> MontaDiaTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessada InsereListaBase() throws DaoException {
		CotacaoProcessada saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = InsereListaBase(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessada InsereListaBase(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessada CriaHistorico15OpcaoPorTickerPeriodo() throws DaoException {
		CotacaoProcessada saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaHistorico15OpcaoPorTickerPeriodo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessada CriaHistorico15OpcaoPorTickerPeriodo(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessada> ListaPorDataTicker() throws DaoException {
		List<CotacaoProcessada> saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorDataTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessada> ListaPorDataTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessada VerificadorOpcao15PorPeriodoTicker() throws DaoException {
		CotacaoProcessada saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = VerificadorOpcao15PorPeriodoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessada VerificadorOpcao15PorPeriodoTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessada> AnteriorDataPesquisaQuantidadeOpcao() throws DaoException {
		List<CotacaoProcessada> saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AnteriorDataPesquisaQuantidadeOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessada> AnteriorDataPesquisaQuantidadeOpcao(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessada> ListaPorPeriodoTicker() throws DaoException {
		List<CotacaoProcessada> saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorPeriodoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessada> ListaPorPeriodoTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessada> ListaHorarios15Minutos() throws DaoException {
		List<CotacaoProcessada> saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaHorarios15Minutos(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessada> ListaHorarios15Minutos(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessada InsereItemOnline() throws DaoException {
		CotacaoProcessada saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = InsereItemOnline(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessada InsereItemOnline(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessada CriaObjetoOnline() throws DaoException {
		CotacaoProcessada saida;
		CotacaoProcessadaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaObjetoOnline(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessada CriaObjetoOnline(final DaoConexao conexao)
			throws DaoException;




	public static final CotacaoProcessadaDao getDao() {
		return DBB.getInstancia().getCotacaoProcessadaDao();
	}
	protected final CotacaoProcessadaDao getDao(final DaoConexao conexao) {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CotacaoProcessadaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CotacaoProcessada PreInsercao(CotacaoProcessada item) {
		return item;
	}

	public CotacaoProcessada PreAlteracao(CotacaoProcessada item) {
		return item;
	}

	public CotacaoProcessada obtemPorChave(long chave) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CotacaoProcessada saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CotacaoProcessada obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		CotacaoProcessada saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CotacaoProcessada excluiItem(CotacaoProcessada item) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoProcessada saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoProcessada excluiItem(CotacaoProcessada item, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public CotacaoProcessada alteraItem(CotacaoProcessada item) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoProcessada saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoProcessada alteraItem(CotacaoProcessada item, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CotacaoProcessada insereItemLoad(CotacaoProcessada item) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoProcessada saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoProcessada insereItemLoad(CotacaoProcessada item, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
