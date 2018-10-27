package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class ExperimentoOpcaoCurtoPrazoRegraColecao {
	
	public ExperimentoOpcaoCurtoPrazoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		ExperimentoOpcaoCurtoPrazoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private ExperimentoOpcaoCurtoPrazoFiltro _filtro;

	public ExperimentoOpcaoCurtoPrazoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new ExperimentoOpcaoCurtoPrazoFiltro();
		return _filtro;
	}

	public void setFiltro(ExperimentoOpcaoCurtoPrazoFiltro dado) {
		_filtro = dado;
	}

	private ExperimentoOpcaoCurtoPrazoFiltro[] _listaEntrada;
	@Deprecated
	protected ExperimentoOpcaoCurtoPrazoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final ExperimentoOpcaoCurtoPrazoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<ExperimentoOpcaoCurtoPrazo> _listaItem;
	protected List<ExperimentoOpcaoCurtoPrazo> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<ExperimentoOpcaoCurtoPrazo> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}




	public static final ExperimentoOpcaoCurtoPrazoDao getDao() {
		return DBB.getInstancia().getExperimentoOpcaoCurtoPrazoDao();
	}
	protected final ExperimentoOpcaoCurtoPrazoDao getDao(final DaoConexao conexao) {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final ExperimentoOpcaoCurtoPrazoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public ExperimentoOpcaoCurtoPrazo PreInsercao(ExperimentoOpcaoCurtoPrazo item) {
		return item;
	}

	public ExperimentoOpcaoCurtoPrazo PreAlteracao(ExperimentoOpcaoCurtoPrazo item) {
		return item;
	}

	public ExperimentoOpcaoCurtoPrazo obtemPorChave(long chave) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		ExperimentoOpcaoCurtoPrazo saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public ExperimentoOpcaoCurtoPrazo obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		ExperimentoOpcaoCurtoPrazo saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public ExperimentoOpcaoCurtoPrazo excluiItem(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = null;
		ExperimentoOpcaoCurtoPrazo saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ExperimentoOpcaoCurtoPrazo excluiItem(ExperimentoOpcaoCurtoPrazo item, DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public ExperimentoOpcaoCurtoPrazo alteraItem(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = null;
		ExperimentoOpcaoCurtoPrazo saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ExperimentoOpcaoCurtoPrazo alteraItem(ExperimentoOpcaoCurtoPrazo item, DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public ExperimentoOpcaoCurtoPrazo insereItemLoad(ExperimentoOpcaoCurtoPrazo item) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		DaoConexao conexao = null;
		ExperimentoOpcaoCurtoPrazo saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public ExperimentoOpcaoCurtoPrazo insereItemLoad(ExperimentoOpcaoCurtoPrazo item, DaoConexao conexao) throws DaoException {
		ExperimentoOpcaoCurtoPrazoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
