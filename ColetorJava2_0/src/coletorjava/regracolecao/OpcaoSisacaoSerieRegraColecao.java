package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class OpcaoSisacaoSerieRegraColecao {
	
	public OpcaoSisacaoSerieRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		OpcaoSisacaoSerieFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private OpcaoSisacaoSerieFiltro _filtro;

	public OpcaoSisacaoSerieFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OpcaoSisacaoSerieFiltro();
		return _filtro;
	}

	public void setFiltro(OpcaoSisacaoSerieFiltro dado) {
		_filtro = dado;
	}

	private OpcaoSisacaoSerieFiltro[] _listaEntrada;
	@Deprecated
	protected OpcaoSisacaoSerieFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final OpcaoSisacaoSerieFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<OpcaoSisacaoSerie> _listaItem;
	protected List<OpcaoSisacaoSerie> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<OpcaoSisacaoSerie> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final OpcaoSisacaoSerie ObtemCriaSeNecessario() throws DaoException {
		OpcaoSisacaoSerie saida;
		OpcaoSisacaoSerieDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemCriaSeNecessario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoSerie ObtemCriaSeNecessario(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoSerie ObtemOuCriaPorCotacaoDiario() throws DaoException {
		OpcaoSisacaoSerie saida;
		OpcaoSisacaoSerieDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemOuCriaPorCotacaoDiario(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoSerie ObtemOuCriaPorCotacaoDiario(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoSerie> SeriesAtivasPorData() throws DaoException {
		List<OpcaoSisacaoSerie> saida;
		OpcaoSisacaoSerieDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = SeriesAtivasPorData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoSerie> SeriesAtivasPorData(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoSisacaoSerie> ListaPorAno() throws DaoException {
		List<OpcaoSisacaoSerie> saida;
		OpcaoSisacaoSerieDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoSisacaoSerie> ListaPorAno(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoSisacaoSerie ObtemPorMesAnoEstudo() throws DaoException {
		OpcaoSisacaoSerie saida;
		OpcaoSisacaoSerieDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorMesAnoEstudo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoSisacaoSerie ObtemPorMesAnoEstudo(final DaoConexao conexao)
			throws DaoException;




	public static final OpcaoSisacaoSerieDao getDao() {
		return DBB.getInstancia().getOpcaoSisacaoSerieDao();
	}
	protected final OpcaoSisacaoSerieDao getDao(final DaoConexao conexao) {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final OpcaoSisacaoSerieDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OpcaoSisacaoSerie PreInsercao(OpcaoSisacaoSerie item) {
		return item;
	}

	public OpcaoSisacaoSerie PreAlteracao(OpcaoSisacaoSerie item) {
		return item;
	}

	public OpcaoSisacaoSerie obtemPorChave(long chave) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OpcaoSisacaoSerie saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OpcaoSisacaoSerie obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		OpcaoSisacaoSerie saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public OpcaoSisacaoSerie excluiItem(OpcaoSisacaoSerie item) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacaoSerie saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacaoSerie excluiItem(OpcaoSisacaoSerie item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public OpcaoSisacaoSerie alteraItem(OpcaoSisacaoSerie item) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacaoSerie saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacaoSerie alteraItem(OpcaoSisacaoSerie item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public OpcaoSisacaoSerie insereItemLoad(OpcaoSisacaoSerie item) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoSisacaoSerie saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoSisacaoSerie insereItemLoad(OpcaoSisacaoSerie item, DaoConexao conexao) throws DaoException {
		OpcaoSisacaoSerieDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
