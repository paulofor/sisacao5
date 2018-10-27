package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class EscolhaOpcaoRegraColecao {
	
	public EscolhaOpcaoRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		EscolhaOpcaoFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private EscolhaOpcaoFiltro _filtro;

	public EscolhaOpcaoFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new EscolhaOpcaoFiltro();
		return _filtro;
	}

	public void setFiltro(EscolhaOpcaoFiltro dado) {
		_filtro = dado;
	}

	private EscolhaOpcaoFiltro[] _listaEntrada;
	@Deprecated
	protected EscolhaOpcaoFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final EscolhaOpcaoFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<EscolhaOpcao> _listaItem;
	protected List<EscolhaOpcao> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<EscolhaOpcao> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final List<EscolhaOpcao> CriaPorNomeTickerAnoFaixa1() throws DaoException {
		List<EscolhaOpcao> saida;
		EscolhaOpcaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaPorNomeTickerAnoFaixa1(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<EscolhaOpcao> CriaPorNomeTickerAnoFaixa1(final DaoConexao conexao)
			throws DaoException;
	public final List<EscolhaOpcao> CriaPorNomeTickerAnoFaixa2() throws DaoException {
		List<EscolhaOpcao> saida;
		EscolhaOpcaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaPorNomeTickerAnoFaixa2(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<EscolhaOpcao> CriaPorNomeTickerAnoFaixa2(final DaoConexao conexao)
			throws DaoException;
	public final EscolhaOpcao Atualiza() throws DaoException {
		EscolhaOpcao saida;
		EscolhaOpcaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = Atualiza(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract EscolhaOpcao Atualiza(final DaoConexao conexao)
			throws DaoException;
	public final EscolhaOpcao ObtemPorIdTickerDiaComOpcao() throws DaoException {
		EscolhaOpcao saida;
		EscolhaOpcaoDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ObtemPorIdTickerDiaComOpcao(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract EscolhaOpcao ObtemPorIdTickerDiaComOpcao(final DaoConexao conexao)
			throws DaoException;




	public static final EscolhaOpcaoDao getDao() {
		return DBB.getInstancia().getEscolhaOpcaoDao();
	}
	protected final EscolhaOpcaoDao getDao(final DaoConexao conexao) {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final EscolhaOpcaoDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public EscolhaOpcao PreInsercao(EscolhaOpcao item) {
		return item;
	}

	public EscolhaOpcao PreAlteracao(EscolhaOpcao item) {
		return item;
	}

	public EscolhaOpcao obtemPorChave(long chave) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		EscolhaOpcao saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public EscolhaOpcao obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		EscolhaOpcao saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public EscolhaOpcao excluiItem(EscolhaOpcao item) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = null;
		EscolhaOpcao saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public EscolhaOpcao excluiItem(EscolhaOpcao item, DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public EscolhaOpcao alteraItem(EscolhaOpcao item) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = null;
		EscolhaOpcao saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public EscolhaOpcao alteraItem(EscolhaOpcao item, DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public EscolhaOpcao insereItemLoad(EscolhaOpcao item) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conexao = null;
		EscolhaOpcao saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public EscolhaOpcao insereItemLoad(EscolhaOpcao item, DaoConexao conexao) throws DaoException {
		EscolhaOpcaoDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteATicker(long id) throws DaoException {
		// Existe no DAO
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	public boolean excluiPorReferenteATicker(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteATicker(long id, DaoConexao conn) throws DaoException {
		EscolhaOpcaoDao dao = getDao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorEscolhaOpcaoSisacao(long id) throws DaoException {
		// Existe no DAO
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorOpcaoSisacaoEscolha(id);
	}
	public boolean excluiPorEscolhaOpcaoSisacao(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorEscolhaOpcaoSisacao(long id, DaoConexao conn) throws DaoException {
		EscolhaOpcaoDao dao = getDao(conn);
		return dao.ListaPorOpcaoSisacaoEscolha(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteADiaPregao(long id) throws DaoException {
		// Existe no DAO
		EscolhaOpcaoDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorDiaPregaoReferenteA(id);
	}
	public boolean excluiPorReferenteADiaPregao(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteADiaPregao(long id, DaoConexao conn) throws DaoException {
		EscolhaOpcaoDao dao = getDao(conn);
		return dao.ListaPorDiaPregaoReferenteA(id);
	}
	
	
}
