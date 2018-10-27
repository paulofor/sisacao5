package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class CotacaoRegraColecao {
	
	public CotacaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CotacaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CotacaoFiltro _filtro;

	public CotacaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CotacaoFiltro();
		return _filtro;
	}

	public void setFiltro(CotacaoFiltro dado) {
		_filtro = dado;
	}

	private CotacaoFiltro[] _listaEntrada;
	@Deprecated
	protected CotacaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CotacaoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Cotacao> _listaItem;
	protected List<Cotacao> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Cotacao> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<Cotacao> ListaPorDataTicker() throws DaoException {
		List<Cotacao> saida;
		CotacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorDataTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Cotacao> ListaPorDataTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<Cotacao> ListaPorDataTickerOpcao() throws DaoException {
		List<Cotacao> saida;
		CotacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorDataTickerOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Cotacao> ListaPorDataTickerOpcao(final DaoConexao conexao)
			throws DaoException;
	public final List<Cotacao> ListaPorPeriodoTickerOpcao() throws DaoException {
		List<Cotacao> saida;
		CotacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorPeriodoTickerOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<Cotacao> ListaPorPeriodoTickerOpcao(final DaoConexao conexao)
			throws DaoException;
	public final Cotacao AnteriorDataPesquisaQuantidadeOpcao() throws DaoException {
		Cotacao saida;
		CotacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AnteriorDataPesquisaQuantidadeOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Cotacao AnteriorDataPesquisaQuantidadeOpcao(final DaoConexao conexao)
			throws DaoException;
	public final Cotacao ObtemMaisRecente() throws DaoException {
		Cotacao saida;
		CotacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemMaisRecente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Cotacao ObtemMaisRecente(final DaoConexao conexao)
			throws DaoException;
	public final Cotacao InsereCotacao() throws DaoException {
		Cotacao saida;
		CotacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = InsereCotacao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Cotacao InsereCotacao(final DaoConexao conexao)
			throws DaoException;




	public static final CotacaoDao getDao() {
		return DBB.getInstancia().getCotacaoDao();
	}
	protected final CotacaoDao getDao(final DaoConexao conexao) {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CotacaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Cotacao PreInsercao(Cotacao item) {
		return item;
	}

	public Cotacao PreAlteracao(Cotacao item) {
		return item;
	}

	public Cotacao obtemPorChave(long chave) throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Cotacao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Cotacao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		Cotacao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Cotacao excluiItem(Cotacao item) throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = null;
		Cotacao saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Cotacao excluiItem(Cotacao item, DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Cotacao alteraItem(Cotacao item) throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = null;
		Cotacao saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Cotacao alteraItem(Cotacao item, DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Cotacao insereItemLoad(Cotacao item) throws DaoException {
		CotacaoDao dao = getDao();
		DaoConexao conexao = null;
		Cotacao saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Cotacao insereItemLoad(Cotacao item, DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
