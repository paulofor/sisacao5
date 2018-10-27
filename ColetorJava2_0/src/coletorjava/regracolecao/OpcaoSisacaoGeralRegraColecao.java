package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class OpcaoSisacaoGeralRegraColecao {
	
	public OpcaoSisacaoGeralRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		OpcaoSisacaoGeralFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private OpcaoSisacaoGeralFiltro _filtro;

	public OpcaoSisacaoGeralFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OpcaoSisacaoGeralFiltro();
		return _filtro;
	}

	public void setFiltro(OpcaoSisacaoGeralFiltro dado) {
		_filtro = dado;
	}

	private OpcaoSisacaoGeralFiltro[] _listaEntrada;
	@Deprecated
	protected OpcaoSisacaoGeralFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final OpcaoSisacaoGeralFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<OpcaoSisacaoGeral> _listaItem;
	protected List<OpcaoSisacaoGeral> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<OpcaoSisacaoGeral> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<OpcaoSisacaoGeral> LeArquivoBDI() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = LeArquivoBDI(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> LeArquivoBDI(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoGeral AtualizaLista() throws DaoException {
		OpcaoSisacaoGeral saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = AtualizaLista(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoGeral AtualizaLista(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoGeral ExtraiOpcoesParaColeta() throws DaoException {
		OpcaoSisacaoGeral saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ExtraiOpcoesParaColeta(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoGeral ExtraiOpcoesParaColeta(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> ListaPorMesAnoComTickerPreco() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorMesAnoComTickerPreco(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> ListaPorMesAnoComTickerPreco(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoGeral RegistrarPorCotacaoDiario() throws DaoException {
		OpcaoSisacaoGeral saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = RegistrarPorCotacaoDiario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoGeral RegistrarPorCotacaoDiario(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> ListaPorMesAnoCodigoTicker() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorMesAnoCodigoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> ListaPorMesAnoCodigoTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> ListaPorDataCodigoTicker() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorDataCodigoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> ListaPorDataCodigoTicker(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoGeral EscolheOpcoes15Minutos() throws DaoException {
		OpcaoSisacaoGeral saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = EscolheOpcoes15Minutos(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoGeral EscolheOpcoes15Minutos(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> SelecionarParaColetaPorDataTicker() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = SelecionarParaColetaPorDataTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> SelecionarParaColetaPorDataTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> Lista15MinutosPorDataTicker() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = Lista15MinutosPorDataTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> Lista15MinutosPorDataTicker(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> MelhoresParaColeta() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MelhoresParaColeta(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> MelhoresParaColeta(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> MelhoresComLiquidezDiaAnterior() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = MelhoresComLiquidezDiaAnterior(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> MelhoresComLiquidezDiaAnterior(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> LeArquivoBDIDiaAnterior() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = LeArquivoBDIDiaAnterior(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> LeArquivoBDIDiaAnterior(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoGeral> ListaOrdenadaNegocioPorTickerData() throws DaoException {
		List<OpcaoSisacaoGeral> saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaOrdenadaNegocioPorTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoGeral> ListaOrdenadaNegocioPorTickerData(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoGeral ObtemPorDataCodigoTicker() throws DaoException {
		OpcaoSisacaoGeral saida;
		OpcaoSisacaoGeralDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorDataCodigoTicker(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoGeral ObtemPorDataCodigoTicker(final DaoConexao conexao)
			throws DaoException;




	public static final OpcaoSisacaoGeralDao getDao() {
		return DBB.getInstancia().getOpcaoSisacaoGeralDao();
	}
	protected final OpcaoSisacaoGeralDao getDao(final DaoConexao conexao) {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final OpcaoSisacaoGeralDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OpcaoSisacaoGeral PreInsercao(OpcaoSisacaoGeral item) {
		return item;
	}

	public OpcaoSisacaoGeral PreAlteracao(OpcaoSisacaoGeral item) {
		return item;
	}

	public OpcaoSisacaoGeral obtemPorChave(long chave) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OpcaoSisacaoGeral saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OpcaoSisacaoGeral obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		OpcaoSisacaoGeral saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public OpcaoSisacaoGeral excluiItem(OpcaoSisacaoGeral item) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacaoGeral saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacaoGeral excluiItem(OpcaoSisacaoGeral item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public OpcaoSisacaoGeral alteraItem(OpcaoSisacaoGeral item) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacaoGeral saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacaoGeral alteraItem(OpcaoSisacaoGeral item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public OpcaoSisacaoGeral insereItemLoad(OpcaoSisacaoGeral item) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacaoGeral saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacaoGeral insereItemLoad(OpcaoSisacaoGeral item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteATicker(long id) throws DaoException {
		// Existe no DAO
		OpcaoSisacaoGeralDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	public boolean excluiPorReferenteATicker(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteATicker(long id, DaoConexao conn) throws DaoException {
		OpcaoSisacaoGeralDao dao = getDao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	
	
}
