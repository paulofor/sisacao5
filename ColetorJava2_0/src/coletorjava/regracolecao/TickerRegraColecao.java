package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class TickerRegraColecao {
	
	public TickerRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		TickerFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private TickerFiltro _filtro;

	public TickerFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new TickerFiltro();
		return _filtro;
	}

	public void setFiltro(TickerFiltro dado) {
		_filtro = dado;
	}

	private TickerFiltro[] _listaEntrada;
	@Deprecated
	protected TickerFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final TickerFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<Ticker> _listaItem;
	protected List<Ticker> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<Ticker> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final Ticker ObtemPorOpcaoSisacaoGeral() throws DaoException {
		Ticker saida;
		TickerDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorOpcaoSisacaoGeral(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Ticker ObtemPorOpcaoSisacaoGeral(final DaoConexao conexao)
			throws DaoException;
	public final Ticker ObtemPorCotacaoDiarioOpcao() throws DaoException {
		Ticker saida;
		TickerDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorCotacaoDiarioOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Ticker ObtemPorCotacaoDiarioOpcao(final DaoConexao conexao)
			throws DaoException;
	public final Ticker CriaArquivoTreino15Minutos() throws DaoException {
		Ticker saida;
		TickerDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaArquivoTreino15Minutos(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Ticker CriaArquivoTreino15Minutos(final DaoConexao conexao)
			throws DaoException;
	public final Ticker ObtemPorCodigo() throws DaoException {
		Ticker saida;
		TickerDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorCodigo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract Ticker ObtemPorCodigo(final DaoConexao conexao)
			throws DaoException;




	public static final TickerDao getDao() {
		return DBB.getInstancia().getTickerDao();
	}
	protected final TickerDao getDao(final DaoConexao conexao) {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final TickerDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public Ticker PreInsercao(Ticker item) {
		return item;
	}

	public Ticker PreAlteracao(Ticker item) {
		return item;
	}

	public Ticker obtemPorChave(long chave) throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		Ticker saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public Ticker obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		Ticker saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public Ticker excluiItem(Ticker item) throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = null;
		Ticker saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Ticker excluiItem(Ticker item, DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public Ticker alteraItem(Ticker item) throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = null;
		Ticker saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Ticker alteraItem(Ticker item, DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public Ticker insereItemLoad(Ticker item) throws DaoException {
		TickerDao dao = getDao();
		DaoConexao conexao = null;
		Ticker saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public Ticker insereItemLoad(Ticker item, DaoConexao conexao) throws DaoException {
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
