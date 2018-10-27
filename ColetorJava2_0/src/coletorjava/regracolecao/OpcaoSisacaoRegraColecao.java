package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class OpcaoSisacaoRegraColecao {
	
	public OpcaoSisacaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		OpcaoSisacaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private OpcaoSisacaoFiltro _filtro;

	public OpcaoSisacaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OpcaoSisacaoFiltro();
		return _filtro;
	}

	public void setFiltro(OpcaoSisacaoFiltro dado) {
		_filtro = dado;
	}

	private OpcaoSisacaoFiltro[] _listaEntrada;
	@Deprecated
	protected OpcaoSisacaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final OpcaoSisacaoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<OpcaoSisacao> _listaItem;
	protected List<OpcaoSisacao> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<OpcaoSisacao> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final OpcaoSisacao CriaSeNecessario() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaSeNecessario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao CriaSeNecessario(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> ListaIntradayDisponivelPorDataTicker() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaIntradayDisponivelPorDataTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> ListaIntradayDisponivelPorDataTicker(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao CriaParaColetaPorVolumeNegocioDiaAnterior() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaParaColetaPorVolumeNegocioDiaAnterior(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao CriaParaColetaPorVolumeNegocioDiaAnterior(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao ObtemPorCodigoMercadoEVencimento() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorCodigoMercadoEVencimento(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao ObtemPorCodigoMercadoEVencimento(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao CriaTabelaColetaIntraday() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaTabelaColetaIntraday(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao CriaTabelaColetaIntraday(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> ListaPorTickerMesAnoUso() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorTickerMesAnoUso(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> ListaPorTickerMesAnoUso(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> ListaSemDadosIntradayPorSerie() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaSemDadosIntradayPorSerie(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> ListaSemDadosIntradayPorSerie(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao ExisteDadoIntraday() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExisteDadoIntraday(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao ExisteDadoIntraday(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao MelhorEscolhaTickerData() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MelhorEscolhaTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao MelhorEscolhaTickerData(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> ListaPorSerieTicker() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorSerieTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> ListaPorSerieTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> Lista15MinutosPorDataTicker() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = Lista15MinutosPorDataTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> Lista15MinutosPorDataTicker(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao ObtemPorCodigoMercadoAno() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorCodigoMercadoAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao ObtemPorCodigoMercadoAno(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao ObtemPorCodigoMercado() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorCodigoMercado(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao ObtemPorCodigoMercado(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao ExcluiOpcaoTickerAnoIntradayZerado() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExcluiOpcaoTickerAnoIntradayZerado(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao ExcluiOpcaoTickerAnoIntradayZerado(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> ListaPorTickerMesAno() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorTickerMesAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> ListaPorTickerMesAno(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao EhValidaNoPeriodo15() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EhValidaNoPeriodo15(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao EhValidaNoPeriodo15(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao MelhorEscolhaTickerDataVenda() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MelhorEscolhaTickerDataVenda(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao MelhorEscolhaTickerDataVenda(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> MelhoresVolumesDiaAnteriorPorTicker() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MelhoresVolumesDiaAnteriorPorTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> MelhoresVolumesDiaAnteriorPorTicker(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacao ObtemPorDataCodigoTicker() throws DaoException {
		OpcaoSisacao saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorDataCodigoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacao ObtemPorDataCodigoTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacao> ListaOrdenadaNegocioPorTickerData() throws DaoException {
		List<OpcaoSisacao> saida;
		OpcaoSisacaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaOrdenadaNegocioPorTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacao> ListaOrdenadaNegocioPorTickerData(final DaoConexao conexao)
			throws DaoException;




	public static final OpcaoSisacaoDao getDao() {
		return DBB.getInstancia().getOpcaoSisacaoDao();
	}
	protected final OpcaoSisacaoDao getDao(final DaoConexao conexao) {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final OpcaoSisacaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OpcaoSisacao PreInsercao(OpcaoSisacao item) {
		return item;
	}

	public OpcaoSisacao PreAlteracao(OpcaoSisacao item) {
		return item;
	}

	public OpcaoSisacao obtemPorChave(long chave) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OpcaoSisacao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OpcaoSisacao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		OpcaoSisacao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public OpcaoSisacao excluiItem(OpcaoSisacao item) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacao saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacao excluiItem(OpcaoSisacao item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public OpcaoSisacao alteraItem(OpcaoSisacao item) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacao saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacao alteraItem(OpcaoSisacao item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public OpcaoSisacao insereItemLoad(OpcaoSisacao item) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacao saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacao insereItemLoad(OpcaoSisacao item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorPertenceAOpcaoSisacaoSerie(long id) throws DaoException {
		// Existe no DAO
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorOpcaoSisacaoSeriePertenceA(id);
	}
	public boolean excluiPorPertenceAOpcaoSisacaoSerie(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorPertenceAOpcaoSisacaoSerie(long id, DaoConexao conn) throws DaoException {
		OpcaoSisacaoDao dao = getDao(conn);
		return dao.ListaPorOpcaoSisacaoSeriePertenceA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorDerivativoDeTicker(long id) throws DaoException {
		// Existe no DAO
		OpcaoSisacaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorTickerDerivativoDe(id);
	}
	public boolean excluiPorDerivativoDeTicker(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorDerivativoDeTicker(long id, DaoConexao conn) throws DaoException {
		OpcaoSisacaoDao dao = getDao(conn);
		return dao.ListaPorTickerDerivativoDe(id);
	}
	
	
}
