package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class MesAnoRegraColecao {
	
	public MesAnoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		MesAnoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private MesAnoFiltro _filtro;

	public MesAnoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new MesAnoFiltro();
		return _filtro;
	}

	public void setFiltro(MesAnoFiltro dado) {
		_filtro = dado;
	}

	private MesAnoFiltro[] _listaEntrada;
	@Deprecated
	protected MesAnoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final MesAnoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<MesAno> _listaItem;
	protected List<MesAno> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<MesAno> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<MesAno> ListaPorAno() throws DaoException {
		List<MesAno> saida;
		MesAnoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<MesAno> ListaPorAno(final DaoConexao conexao)
			throws DaoException;
	public final MesAno ObtemPorDataSimples() throws DaoException {
		MesAno saida;
		MesAnoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorDataSimples(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract MesAno ObtemPorDataSimples(final DaoConexao conexao)
			throws DaoException;




	public static final MesAnoDao getDao() {
		return DBB.getInstancia().getMesAnoDao();
	}
	protected final MesAnoDao getDao(final DaoConexao conexao) {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final MesAnoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public MesAno PreInsercao(MesAno item) {
		return item;
	}

	public MesAno PreAlteracao(MesAno item) {
		return item;
	}

	public MesAno obtemPorChave(long chave) throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		MesAno saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public MesAno obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		MesAno saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public MesAno excluiItem(MesAno item) throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = null;
		MesAno saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public MesAno excluiItem(MesAno item, DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public MesAno alteraItem(MesAno item) throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = null;
		MesAno saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public MesAno alteraItem(MesAno item, DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public MesAno insereItemLoad(MesAno item) throws DaoException {
		MesAnoDao dao = getDao();
		DaoConexao conexao = null;
		MesAno saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public MesAno insereItemLoad(MesAno item, DaoConexao conexao) throws DaoException {
		MesAnoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
