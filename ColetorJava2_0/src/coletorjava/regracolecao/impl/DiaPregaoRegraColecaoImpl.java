package coletorjava.regracolecao.impl;


import java.text.ParseException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.util.DCConvert;
import br.com.digicom.parse.log.DatasUtils;
import coletorjava.dao.DiaPregaoDao;
import coletorjava.modelo.CotacaoDiario;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.FabricaVo;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoDiarioRegraColecao;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.util.UtilData;


public  class DiaPregaoRegraColecaoImpl  extends DiaPregaoRegraColecao { 
	public  List ListaSemCotacaoDiarioPorTickerData( DaoConexao conexao )  throws  DaoException{
		CotacaoDiarioRegraColecao cotacaoDiarioSrv =FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao(); 
		List saida = new ArrayList();
		if (this.getFiltro().getDataInicialPesquisa() == null) {
			throw new RuntimeException("DataInicialPesquisa é nula");
		}
		if (this.getFiltro().getDataFinalPesquisa() == null) {
			throw new RuntimeException("DataFinalPesquisa é nula");
		}
		if (this.getFiltro().getNomeTicker() == null) {
			throw new RuntimeException("NomeTicker é nula");
		}
		List<DiaPregao> listaTotal = ListaPorData(conexao);
		Ticker ticker = FabricaVo.criaTicker();
		ticker.setNome(this.getFiltro().getNomeTicker());
		cotacaoDiarioSrv.getFiltro().setTicker(ticker);
		for (DiaPregao dia : listaTotal) {
			if (!dia.getFeriado()) {
				cotacaoDiarioSrv.getFiltro().setData(dia.getData());
				CotacaoDiario cotacao = cotacaoDiarioSrv.ObtemPorNomeTickerData(conexao);
				if (cotacao==null) {
					saida.add(dia);
				}
			}
		}
		return saida;
	}
	public  List ListaPorData( DaoConexao conexao )  throws  DaoException{
		List saida = null;
		if (this.getFiltro().getDataInicialPesquisa() == null) {
			throw new RuntimeException("DataInicialPesquisa é nula");
		}
		if (this.getFiltro().getDataFinalPesquisa() == null) {
			throw new RuntimeException("DataFinalPesquisa é nula");
		}
		String data1 = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().getDataInicialPesquisa());
		String data2 = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(this.getFiltro().getDataFinalPesquisa());
		DiaPregaoDao dao = getDao(conexao);
		saida = dao.ListaPorData(data1,data2);
		return saida;
	}
	@Override
	public DiaPregao DeslocaDias(DaoConexao conexao) throws DaoException {
		DiaPregao saida = null;
		DiaPregaoDao dao = getDao(conexao);
		getFiltro().validaDataDeslocamento();
		getFiltro().validaDiasDeslocamento();
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(getFiltro().getDataDeslocamento());
		saida = dao.DeslocaDias(dataBd,getFiltro().getDiasDeslocamento());
		return saida;
	}
	@Override
	public DiaPregao ObtemDiaSomaData(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}
	@Override
	public DiaPregao ObtemAnteriorData(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}
	@Override
	public List<DiaPregao> ListaComCotacaoProcessadaPorTickerData(DaoConexao conexao) throws DaoException {
		CotacaoProcessadaRegraColecao cotacaoProcessadaSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		List<DiaPregao> lista = this.ListaPorData(conexao);
		cotacaoProcessadaSrv.getFiltro().setNomeTicker(this.getFiltro().getNomeTicker());
		for (DiaPregao dia : lista) {
			cotacaoProcessadaSrv.getFiltro().setDiaPregao(dia.getData());
			List<CotacaoProcessada> listaCotacao = cotacaoProcessadaSrv.ListaPorDataTicker(conexao);
			dia.setListaCotacaoProcessada(listaCotacao);
		}
		return lista;
	}
	@Override
	public DiaPregao VerificaTamanhoListaCotacaoProcessada(DaoConexao conexao) throws DaoException {
		DiaPregao item = this.getFiltro().validaItem();
		long dataNum = item.getDataInteiro();
		int QTDE = (dataNum<20121201?30:32);
		if (!item.getFeriado() && item.getListaCotacaoProcessada().size()!=QTDE) {
			return null;
		}	else {
			return item;
		}
	}
	
	
	@Override
	public List<DiaPregao> ListaErroQtdeCotacaoProcessadaPorTickerPeriodo(DaoConexao conexao) throws DaoException {
		List<DiaPregao> saida = new LinkedList<DiaPregao>();
		List<DiaPregao> dias = ListaComCotacaoProcessadaPorTickerData(conexao);
		for (DiaPregao dia : dias) {
			if (!dia.getFeriado()) {
				getFiltro().setItem(dia);
				if (VerificaTamanhoListaCotacaoProcessada(null)==null) {
					saida.add(dia);
				}
			}
		}
		return saida;
	}
	@Override
	public List<DiaPregao> ListaPorDataMesAno(DaoConexao conexao) throws DaoException {
		String dataInicial = this.getFiltro().validaDataMesAno();
		String dtIniBd = DCConvert.ToDataAAAA_MM_DD(dataInicial);
		// AAAA-MM-DD
		// 0123456789
		String dtFimBd = dtIniBd.substring(0,8) + "31";
		DiaPregaoDao dao = getDao(conexao);
		return dao.ListaPorData(dtIniBd, dtFimBd);
	}
	
	
	@Override
	public List<DiaPregao> ObtemProximaSemana(DaoConexao conexao) throws DaoException {
		List<DiaPregao> listaData = null;
		String dataSexta = this.getFiltro().getDataSexta();
		try {
			String proximaSexta = UtilData.obtemProximaSexta(dataSexta);
			String data1 = DCConvert.ToDataAAAA_MM_DD(dataSexta);
			String data2 = DCConvert.ToDataAAAA_MM_DD(proximaSexta);
			DiaPregaoDao dao = getDao(conexao);
			listaData = dao.ListaPorDataSemFeriado(data1, data2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return listaData;
		
	}
	@Override
	public List<DiaPregao> SextaAteVencimento(DaoConexao conexao) throws DaoException {
		List<DiaPregao> listaData = null;
		String dataSexta = this.getFiltro().getDataSexta();
		String dataVencimento = this.getFiltro().getOpcaoVencimento().getOpcaoSisacaoSeriePertenceA(true).getDataVencimento();
		try {
			String proximaSexta = UtilData.obtemProximaSexta(dataSexta);
			String data1 = DCConvert.ToDataAAAA_MM_DD(dataSexta);
			String data2 = DCConvert.ToDataAAAA_MM_DD(dataVencimento);
			DiaPregaoDao dao = getDao(conexao);
			listaData = dao.ListaPorDataSemFeriado(data1, data2);
		} catch (ParseException e) {
			e.printStackTrace();
		}
		return listaData;
	}
	@Override
	public DiaPregao ObtemPorDataPesquisa(DaoConexao conexao) throws DaoException {
		DiaPregao dia = null;
		String data = DCConvert.ToDataAAAA_MM_DD(this.getFiltro().validaDataPesquisa());
		DiaPregaoDao dao = getDao(conexao);
		dia = dao.ObtemPorDataPesquisa(data);
		return dia;
	}
}
