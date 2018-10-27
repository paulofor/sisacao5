package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class CotacaoDiarioRegraColecao {
	
	public CotacaoDiarioRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		CotacaoDiarioFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private CotacaoDiarioFiltro _filtro;

	public CotacaoDiarioFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new CotacaoDiarioFiltro();
		return _filtro;
	}

	public void setFiltro(CotacaoDiarioFiltro dado) {
		_filtro = dado;
	}

	private CotacaoDiarioFiltro[] _listaEntrada;
	@Deprecated
	protected CotacaoDiarioFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final CotacaoDiarioFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<CotacaoDiario> _listaItem;
	protected List<CotacaoDiario> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<CotacaoDiario> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final CotacaoDiario CotacaoMaisRecentePorTicker() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CotacaoMaisRecentePorTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario CotacaoMaisRecentePorTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario ObtemPorNomeTickerData() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorNomeTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario ObtemPorNomeTickerData(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario CorrigeAnoHistoricoTicker() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CorrigeAnoHistoricoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario CorrigeAnoHistoricoTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoDiario> HistoricoCompletoTodasOpcaoAno() throws DaoException {
		List<CotacaoDiario> saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = HistoricoCompletoTodasOpcaoAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoDiario> HistoricoCompletoTodasOpcaoAno(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario InsereSeNaoExisteOpcao() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = InsereSeNaoExisteOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario InsereSeNaoExisteOpcao(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario CorrigeAnoHistoricoOpcaoGeral() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CorrigeAnoHistoricoOpcaoGeral(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario CorrigeAnoHistoricoOpcaoGeral(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoDiario> IdentificadorSplitAno() throws DaoException {
		List<CotacaoDiario> saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = IdentificadorSplitAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoDiario> IdentificadorSplitAno(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoDiario> ListaPorAnoTicker() throws DaoException {
		List<CotacaoDiario> saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorAnoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoDiario> ListaPorAnoTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<CotacaoDiario> MelhoresPorNegocioDiaAnteriorTicker() throws DaoException {
		List<CotacaoDiario> saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MelhoresPorNegocioDiaAnteriorTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<CotacaoDiario> MelhoresPorNegocioDiaAnteriorTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario ObtemPorNomeTickerAnteriorData() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorNomeTickerAnteriorData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario ObtemPorNomeTickerAnteriorData(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario CorrigeAnoHistoricoOpcaoPorTicker() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CorrigeAnoHistoricoOpcaoPorTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario CorrigeAnoHistoricoOpcaoPorTicker(final DaoConexao conexao)
			throws DaoException;
	public final CotacaoDiario ExtraiLinhaArquivoDiario() throws DaoException {
		CotacaoDiario saida;
		CotacaoDiarioDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExtraiLinhaArquivoDiario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract CotacaoDiario ExtraiLinhaArquivoDiario(final DaoConexao conexao)
			throws DaoException;




	public static final CotacaoDiarioDao getDao() {
		return DBB.getInstancia().getCotacaoDiarioDao();
	}
	protected final CotacaoDiarioDao getDao(final DaoConexao conexao) {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final CotacaoDiarioDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public CotacaoDiario PreInsercao(CotacaoDiario item) {
		return item;
	}

	public CotacaoDiario PreAlteracao(CotacaoDiario item) {
		return item;
	}

	public CotacaoDiario obtemPorChave(long chave) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		CotacaoDiario saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public CotacaoDiario obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		CotacaoDiario saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public CotacaoDiario excluiItem(CotacaoDiario item) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoDiario saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoDiario excluiItem(CotacaoDiario item, DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public CotacaoDiario alteraItem(CotacaoDiario item) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoDiario saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoDiario alteraItem(CotacaoDiario item, DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public CotacaoDiario insereItemLoad(CotacaoDiario item) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		DaoConexao conexao = null;
		CotacaoDiario saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public CotacaoDiario insereItemLoad(CotacaoDiario item, DaoConexao conexao) throws DaoException {
		CotacaoDiarioDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
