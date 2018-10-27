package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class CotacaoProcessadaOpcaoResultadoRegraColecao {
	
	public CotacaoProcessadaOpcaoResultadoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CotacaoProcessadaOpcaoResultadoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CotacaoProcessadaOpcaoResultadoFiltro _filtro;

	public CotacaoProcessadaOpcaoResultadoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CotacaoProcessadaOpcaoResultadoFiltro();
		return _filtro;
	}

	public void setFiltro(CotacaoProcessadaOpcaoResultadoFiltro dado) {
		_filtro = dado;
	}

	private CotacaoProcessadaOpcaoResultadoFiltro[] _listaEntrada;
	@Deprecated
	protected CotacaoProcessadaOpcaoResultadoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CotacaoProcessadaOpcaoResultadoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CotacaoProcessadaOpcaoResultado> _listaItem;
	protected List<CotacaoProcessadaOpcaoResultado> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CotacaoProcessadaOpcaoResultado> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final CotacaoProcessadaOpcaoResultado CalcularPeriodoTicker() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalcularPeriodoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado CalcularPeriodoTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraRegistros() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraRegistros(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraRegistros(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado CalculaResultados() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CalculaResultados(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado CalculaResultados(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado ExcluiPorListaDataTickerFaixa() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExcluiPorListaDataTickerFaixa(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado ExcluiPorListaDataTickerFaixa(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado IncluiPorListTickerFaixa() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = IncluiPorListTickerFaixa(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado IncluiPorListTickerFaixa(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoProcessadaOpcaoResultado> ListaPorIntervaloDataFaixaTicker() throws DaoException {
		List<CotacaoProcessadaOpcaoResultado> saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorIntervaloDataFaixaTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoProcessadaOpcaoResultado> ListaPorIntervaloDataFaixaTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado TestaPeriodoTicker() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = TestaPeriodoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado TestaPeriodoTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraArquivoTreino() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraArquivoTreino(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraArquivoTreino(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraScriptOctave() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraScriptOctave(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraScriptOctave(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraRegistroPorTickerPeriodoOpcao() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraRegistroPorTickerPeriodoOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraRegistroPorTickerPeriodoOpcao(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraArquivoTreinoValorOpcao() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraArquivoTreinoValorOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraArquivoTreinoValorOpcao(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraArquivoPlanilhaEstudo() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraArquivoPlanilhaEstudo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraArquivoPlanilhaEstudo(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoProcessadaOpcaoResultado GeraArquivoTreinoOpcaoIndicadores() throws DaoException {
		CotacaoProcessadaOpcaoResultado saida;
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraArquivoTreinoOpcaoIndicadores(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoProcessadaOpcaoResultado GeraArquivoTreinoOpcaoIndicadores(final DaoConexao conexao)
			throws DaoException;




	public static final CotacaoProcessadaOpcaoResultadoDao getDao() {
		return DBB.getInstancia().getCotacaoProcessadaOpcaoResultadoDao();
	}
	protected final CotacaoProcessadaOpcaoResultadoDao getDao(final DaoConexao conexao) {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CotacaoProcessadaOpcaoResultadoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CotacaoProcessadaOpcaoResultado PreInsercao(CotacaoProcessadaOpcaoResultado item) {
		return item;
	}

	public CotacaoProcessadaOpcaoResultado PreAlteracao(CotacaoProcessadaOpcaoResultado item) {
		return item;
	}

	public CotacaoProcessadaOpcaoResultado obtemPorChave(long chave) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CotacaoProcessadaOpcaoResultado saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CotacaoProcessadaOpcaoResultado obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		CotacaoProcessadaOpcaoResultado saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CotacaoProcessadaOpcaoResultado excluiItem(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoProcessadaOpcaoResultado saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoProcessadaOpcaoResultado excluiItem(CotacaoProcessadaOpcaoResultado item, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public CotacaoProcessadaOpcaoResultado alteraItem(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoProcessadaOpcaoResultado saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoProcessadaOpcaoResultado alteraItem(CotacaoProcessadaOpcaoResultado item, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CotacaoProcessadaOpcaoResultado insereItemLoad(CotacaoProcessadaOpcaoResultado item) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoProcessadaOpcaoResultado saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoProcessadaOpcaoResultado insereItemLoad(CotacaoProcessadaOpcaoResultado item, DaoConexao conexao) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAOpcaoSisacao(long id) throws DaoException {
		// Existe no DAO
		CotacaoProcessadaOpcaoResultadoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorOpcaoSisacaoReferenteA(id);
	}
	public boolean excluiPorReferenteAOpcaoSisacao(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAOpcaoSisacao(long id, DaoConexao conn) throws DaoException {
		CotacaoProcessadaOpcaoResultadoDao dao = getDao(conn);
		return dao.ListaPorOpcaoSisacaoReferenteA(id);
	}
	
	
}
