package coletorjava.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.CotacaoDao;
import coletorjava.dao.CotacaoDaoExtendida;
import coletorjava.modelo.Cotacao;
import coletorjava.modelo.DiaPregao;
import coletorjava.regracolecao.CotacaoRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;


public  class CotacaoRegraColecaoImpl  extends CotacaoRegraColecao {

	@Override
	public List<Cotacao> ListaPorDataTicker(DaoConexao conexao) throws DaoException {
		List<Cotacao> listaSaida = null;
		this.getFiltro().validaDataPesquisa();
		this.getFiltro().validaNomeTicker();
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().getDataPesquisa());
		CotacaoDaoExtendida dao = (CotacaoDaoExtendida) getDao();
		dao.setIntraday();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		listaSaida = dao.listaPorDataTicker(dataBd,this.getFiltro().getNomeTicker());
		return listaSaida;
	}

	@Override
	public List<Cotacao> ListaPorDataTickerOpcao(DaoConexao conexao) throws DaoException {
		List<Cotacao> listaSaida = null;
		this.getFiltro().validaDataPesquisa();
		this.getFiltro().validaNomeTicker();
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().getDataPesquisa());
		CotacaoDaoExtendida dao = (CotacaoDaoExtendida) getDao();
		dao.setIntradayOpcao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		listaSaida = dao.listaPorDataTickerOpcao(dataBd,this.getFiltro().getNomeTicker());
		return listaSaida;
	}

	@Override
	public List<Cotacao> ListaPorPeriodoTickerOpcao(DaoConexao conexao) throws DaoException {
		List<Cotacao> listaSaida = null;
		this.getFiltro().validaDataInicial();
		this.getFiltro().validaDataFinal();
		this.getFiltro().validaNomeTicker();
		String dataInicialBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().validaDataInicial());
		String dataFinalBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().validaDataFinal());
		CotacaoDaoExtendida dao = (CotacaoDaoExtendida) getDao();
		dao.setIntradayOpcao();
		DaoConexao conn = dao.criaConexao();
		dao.setConexao(conn);
		listaSaida = dao.listaPorPeriodoTickerOpcao(dataInicialBd,dataFinalBd, this.getFiltro().getNomeTicker());
		return listaSaida;
	}

	@Override
	public Cotacao AnteriorDataPesquisaQuantidadeOpcao(DaoConexao conexao) throws DaoException {
		DiaPregaoRegraColecao diaSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		String dataPesquisa = this.getFiltro().validaDataPesquisa();
		diaSrv.getFiltro().setDataDeslocamento(dataPesquisa);
		diaSrv.getFiltro().setDiasDeslocamento(-1);
		DiaPregao dia = diaSrv.DeslocaDias();
		
		String data =  DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(dia.getData());
		String ticker = this.getFiltro().validaNomeTicker();
		
		CotacaoDao dao = getDao();
		((CotacaoDaoExtendida)dao).setIntradayOpcao();
		dao.setConexao(dao.criaConexao());
		try {
			List<Cotacao> lista = dao.listaPorDataTickerOpcao(data,ticker);
			return (lista.size()>0?lista.get(lista.size()-1):null);
		} catch (DaoException e) {
			//e.printStackTrace();
			return null;
		}
	}

	@Override
	public Cotacao ObtemMaisRecente(DaoConexao conexao) throws DaoException {
		String ticker = this.getFiltro().validaNomeTicker();
		CotacaoDao dao = getDao();
		((CotacaoDaoExtendida)dao).setIntradayOpcao();
		dao.setConexao(dao.criaConexao());
		Cotacao cotacao = dao.obtemMaisRecente(ticker);
		return cotacao;
	}

	@Override
	public Cotacao InsereCotacao(DaoConexao conexao) throws DaoException {
		CotacaoDao dao = getDao();
		dao.setConexao(conexao);
		Cotacao cotacao = getFiltro().getCotacao();
		String nomeTicker = getFiltro().getNomeTicker();
		dao.insereCotacao(cotacao, nomeTicker);
		return cotacao;
	}
	
	
	
}
