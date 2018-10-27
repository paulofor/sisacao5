package coletorjava.regracolecao;



import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.dao.*;
import coletorjava.modelo.*;
import coletorjava.regracolecao.filtro.*;


public abstract class OpcaoReferenciaRegraColecao {
	
	public OpcaoReferenciaRegraColecao() {
		_filtro = null;
	}

	public List ListaCorrente(DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaCorrente();
		return saida;
		/*
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = null;
		OpcaoReferenciaFiltro filtroWork = getFiltro();
		if (filtroWork.getCodigoLinhaProdutoEstaEm() != -1) {
			saida = dao.ListaPorLinhaProdutoEstaEm(filtroWork
					.getCodigoLinhaProdutoEstaEm());
			return saida;
		}
		saida = dao.ListaCorrenteAgrupada();
		return saida;
		*/
	}

	private OpcaoReferenciaFiltro _filtro;

	public OpcaoReferenciaFiltro getFiltro() {
		if (_filtro == null)
			_filtro = new OpcaoReferenciaFiltro();
		return _filtro;
	}

	public void setFiltro(OpcaoReferenciaFiltro dado) {
		_filtro = dado;
	}

	private OpcaoReferenciaFiltro[] _listaEntrada;
	@Deprecated
	protected OpcaoReferenciaFiltro[] getListaEntrada() {
		return _listaEntrada;
	}
	@Deprecated
	public void setListaEntrada(final OpcaoReferenciaFiltro[] dado) {
		_listaEntrada = dado;
	}
	private List<OpcaoReferencia> _listaItem;
	protected List<OpcaoReferencia> getListaEntradaItem() {
		return _listaItem;
	}
	public void setListaEntradaItem(final List<OpcaoReferencia> dado) {
		_listaItem = dado;
	}
	private List _listaGenerica;
	protected List getListaEntradaGenerica() {
		return _listaGenerica;
	}
	public void setListaEntradaGenerica(final List dado) {
		_listaGenerica = dado;
	}
	public final OpcaoReferencia CriaSemanaPorTickerData() throws DaoException {
		OpcaoReferencia saida;
		OpcaoReferenciaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = CriaSemanaPorTickerData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoReferencia CriaSemanaPorTickerData(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoReferencia GeraReferenciaDia() throws DaoException {
		OpcaoReferencia saida;
		OpcaoReferenciaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraReferenciaDia(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoReferencia GeraReferenciaDia(final DaoConexao conexao)
			throws DaoException;
	public final OpcaoReferencia GeraReferenciaPeriodo() throws DaoException {
		OpcaoReferencia saida;
		OpcaoReferenciaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = GeraReferenciaPeriodo(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract OpcaoReferencia GeraReferenciaPeriodo(final DaoConexao conexao)
			throws DaoException;
	public final List<OpcaoReferencia> ListaAtivoParaColetaNaData() throws DaoException {
		List<OpcaoReferencia> saida;
		OpcaoReferenciaDao dao = getDao();
		preparaDaoParaConexao(dao);
		DaoConexao conexao = null;
		conexao = dao.criaConexao();
		saida = ListaAtivoParaColetaNaData(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public abstract List<OpcaoReferencia> ListaAtivoParaColetaNaData(final DaoConexao conexao)
			throws DaoException;




	public static final OpcaoReferenciaDao getDao() {
		return DBB.getInstancia().getOpcaoReferenciaDao();
	}
	protected final OpcaoReferenciaDao getDao(final DaoConexao conexao) {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		return dao;
	}

	protected void preparaDaoParaConexao(final OpcaoReferenciaDao dao) throws DaoException {
	}

	public List ListaFiltro() throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltro(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}
	public List ListaFiltro(DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltro(getFiltro());
		return saida;
	}

	public List ListaFiltroSimples() throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		List saida = null;
		saida = dao.ListaFiltroSimples(getFiltro());
		dao.liberaConexao(conexao);
		return saida;
	}

	public List ListaFiltroSimples(DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		List saida = dao.ListaFiltroSimples(getFiltro());
		return saida;
	}

	public OpcaoReferencia PreInsercao(OpcaoReferencia item) {
		return item;
	}

	public OpcaoReferencia PreAlteracao(OpcaoReferencia item) {
		return item;
	}

	public OpcaoReferencia obtemPorChave(long chave) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		dao.setConexao(conexao);
		OpcaoReferencia saida = obtemPorChave(chave, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}

	public OpcaoReferencia obtemPorChave(long chave, DaoConexao conexao)
			throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		OpcaoReferencia saida = dao.obtemPorChave(chave);
		return saida;
	}

	public DaoConexao CriaConexao() throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = dao.criaConexao();
		return conexao;
	}

	public void LiberaConexao(DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.liberaConexao(conexao);
	}

	public List ListaCorrente() throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = null;
		List saida = null;
		conexao = dao.criaConexao();
		saida = ListaCorrente(conexao);
		dao.liberaConexao(conexao);
		return saida;
	}


	public OpcaoReferencia excluiItem(OpcaoReferencia item) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoReferencia saida = null;
		conexao = dao.criaConexao();
		saida = excluiItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoReferencia excluiItem(OpcaoReferencia item, DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		dao.excluiItem(item);
		return item;
	}
	

	public OpcaoReferencia alteraItem(OpcaoReferencia item) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoReferencia saida = null;
		conexao = dao.criaConexao();
		saida = alteraItem(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoReferencia alteraItem(OpcaoReferencia item, DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		dao.alteraItem(item);
		return item;
	}
	
	public OpcaoReferencia insereItemLoad(OpcaoReferencia item) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conexao = null;
		OpcaoReferencia saida = null;
		conexao = dao.criaConexao();
		saida = insereItemLoad(item, conexao);
		dao.liberaConexao(conexao);
		return saida;
	}
	public OpcaoReferencia insereItemLoad(OpcaoReferencia item, DaoConexao conexao) throws DaoException {
		OpcaoReferenciaDao dao = getDao();
		dao.setConexao(conexao);
		dao.insereItemLoad(item);
		return item;
	}
	
	
	
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteATicker(long id) throws DaoException {
		// Existe no DAO
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	public boolean excluiPorReferenteATicker(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteATicker(long id, DaoConexao conn) throws DaoException {
		OpcaoReferenciaDao dao = getDao(conn);
		return dao.ListaPorTickerReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteADiaPregao(long id) throws DaoException {
		// Existe no DAO
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorDiaPregaoReferenteA(id);
	}
	public boolean excluiPorReferenteADiaPregao(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteADiaPregao(long id, DaoConexao conn) throws DaoException {
		OpcaoReferenciaDao dao = getDao(conn);
		return dao.ListaPorDiaPregaoReferenteA(id);
	}
	
	// Tratamento de objetos que possuem FK nesse objeto para objetos nao associativos
	public List getPorReferenteAOpcaoSisacao(long id) throws DaoException {
		// Existe no DAO
		OpcaoReferenciaDao dao = getDao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		return dao.ListaPorOpcaoSisacaoReferenteA(id);
	}
	public boolean excluiPorReferenteAOpcaoSisacao(long id) throws DaoException{
		// Existe no DAO
       	return true;
	}
	public List getPorReferenteAOpcaoSisacao(long id, DaoConexao conn) throws DaoException {
		OpcaoReferenciaDao dao = getDao(conn);
		return dao.ListaPorOpcaoSisacaoReferenteA(id);
	}
	
	
}
