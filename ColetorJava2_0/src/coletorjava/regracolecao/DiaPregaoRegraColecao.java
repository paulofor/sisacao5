package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class DiaPregaoRegraColecao {
	
	public DiaPregaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		DiaPregaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private DiaPregaoFiltro _filtro;

	public DiaPregaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new DiaPregaoFiltro();
		return _filtro;
	}

	public void setFiltro(DiaPregaoFiltro dado) {
		_filtro = dado;
	}

	private DiaPregaoFiltro[] _listaEntrada;
	@Deprecated
	protected DiaPregaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final DiaPregaoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<DiaPregao> _listaItem;
	protected List<DiaPregao> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<DiaPregao> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<DiaPregao> ListaSemCotacaoDiarioPorTickerData() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaSemCotacaoDiarioPorTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> ListaSemCotacaoDiarioPorTickerData(final DaoConexao conexao)
			throws DaoException;
	public final List<DiaPregao> ListaPorData() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> ListaPorData(final DaoConexao conexao)
			throws DaoException;
	public final DiaPregao DeslocaDias() throws DaoException {
		DiaPregao saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = DeslocaDias(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract DiaPregao DeslocaDias(final DaoConexao conexao)
			throws DaoException;
	public final DiaPregao ObtemDiaSomaData() throws DaoException {
		DiaPregao saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemDiaSomaData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract DiaPregao ObtemDiaSomaData(final DaoConexao conexao)
			throws DaoException;
	public final DiaPregao ObtemAnteriorData() throws DaoException {
		DiaPregao saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemAnteriorData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract DiaPregao ObtemAnteriorData(final DaoConexao conexao)
			throws DaoException;
	public final List<DiaPregao> ListaComCotacaoProcessadaPorTickerData() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaComCotacaoProcessadaPorTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> ListaComCotacaoProcessadaPorTickerData(final DaoConexao conexao)
			throws DaoException;
	public final DiaPregao VerificaTamanhoListaCotacaoProcessada() throws DaoException {
		DiaPregao saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = VerificaTamanhoListaCotacaoProcessada(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract DiaPregao VerificaTamanhoListaCotacaoProcessada(final DaoConexao conexao)
			throws DaoException;
	public final List<DiaPregao> ListaErroQtdeCotacaoProcessadaPorTickerPeriodo() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaErroQtdeCotacaoProcessadaPorTickerPeriodo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> ListaErroQtdeCotacaoProcessadaPorTickerPeriodo(final DaoConexao conexao)
			throws DaoException;
	public final List<DiaPregao> ListaPorDataMesAno() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaPorDataMesAno(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> ListaPorDataMesAno(final DaoConexao conexao)
			throws DaoException;
	public final List<DiaPregao> ObtemProximaSemana() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemProximaSemana(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> ObtemProximaSemana(final DaoConexao conexao)
			throws DaoException;
	public final List<DiaPregao> SextaAteVencimento() throws DaoException {
		List<DiaPregao> saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = SextaAteVencimento(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<DiaPregao> SextaAteVencimento(final DaoConexao conexao)
			throws DaoException;
	public final DiaPregao ObtemPorDataPesquisa() throws DaoException {
		DiaPregao saida;
		DiaPregaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorDataPesquisa(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract DiaPregao ObtemPorDataPesquisa(final DaoConexao conexao)
			throws DaoException;




	public static final DiaPregaoDao getDao() {
		return DBB.getInstancia().getDiaPregaoDao();
	}
	protected final DiaPregaoDao getDao(final DaoConexao conexao) {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final DiaPregaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public DiaPregao PreInsercao(DiaPregao item) {
		return item;
	}

	public DiaPregao PreAlteracao(DiaPregao item) {
		return item;
	}

	public DiaPregao obtemPorChave(long chave) throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		DiaPregao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public DiaPregao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		DiaPregao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public DiaPregao excluiItem(DiaPregao item) throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = null;
		DiaPregao saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DiaPregao excluiItem(DiaPregao item, DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public DiaPregao alteraItem(DiaPregao item) throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = null;
		DiaPregao saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DiaPregao alteraItem(DiaPregao item, DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public DiaPregao insereItemLoad(DiaPregao item) throws DaoException {
		DiaPregaoDao dao = getDao();
		DaoConexao conexao = null;
		DiaPregao saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public DiaPregao insereItemLoad(DiaPregao item, DaoConexao conexao) throws DaoException {
		DiaPregaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	
}
