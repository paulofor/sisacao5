package coletorjava.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.TickerDao;
import coletorjava.modelo.CotacaoProcessada;
import coletorjava.modelo.DiaPregao;
import coletorjava.modelo.Ticker;
import coletorjava.regracolecao.CotacaoProcessadaRegraColecao;
import coletorjava.regracolecao.DiaPregaoRegraColecao;
import coletorjava.regracolecao.FabricaRegra;
import coletorjava.regracolecao.TickerRegraColecao;


public  class TickerRegraColecaoImpl  extends TickerRegraColecao {

	@Override
	public Ticker ObtemPorOpcaoSisacaoGeral(DaoConexao conexao) throws DaoException {
		getFiltro().validaOpcaoArquivo();
		String especificacao = getFiltro().getOpcaoArquivo().getEspecificacao();
		String nomeRes = getFiltro().getOpcaoArquivo().getNomeRes().substring(0,4);
		return ObtemTicker(nomeRes,especificacao,conexao);
	}
	
	

	@Override
	public Ticker ObtemPorCotacaoDiarioOpcao(DaoConexao conexao) throws DaoException {
		getFiltro().validaCotacaoDiarioOpcao();
		return ObtemTicker(getFiltro().getCotacaoDiarioOpcao().getNomeResArquivo(),getFiltro().getCotacaoDiarioOpcao().getEspecificacaoArquivo(),conexao);
	}

	private Ticker ObtemTicker(String nomeRes, String especificacao, DaoConexao conexao) throws DaoException {
		// Coloquei por causa do Historico
		String[] nomes = nomeRes.split(" ");
		String nomeEmpresa = nomes[0];
		//
		String[] tipo = especificacao.split(" ");
		String tipoAcao = tipo[0];
		TickerDao dao = getDao();
		dao.setConexao(conexao);
		Ticker saida = dao.ObtemPorEmpresaTipo(nomeEmpresa,tipoAcao);
		return saida;
	}



	@Override
	public Ticker CriaArquivoTreino15Minutos(DaoConexao conexao) throws DaoException {
		/*
		CotacaoDiarioRegraColecao cotacaoDiarioSrv = FabricaRegra.getInstancia().getCotacaoDiarioRegraColecao();
		cotacaoDiarioSrv.getFiltro().setCodigoTicker("BBDC4");
		cotacaoDiarioSrv.getFiltro().setAno("2013");
		List<CotacaoDiario> listaDiario = cotacaoDiarioSrv.ListaPorAnoTicker(conexao);
		for (CotacaoDiario cotaDia : listaDiario) {
			
		}
		*/
		
		String nomeTicker = this.getFiltro().getCodigoEmpresa();
		String nomeArquivo = "Treino15_" + nomeTicker;
		String dataInicial = "01-11-2012";
		String dataFinal = "31-01-2013";
		
		DiaPregaoRegraColecao diaSrv = FabricaRegra.getInstancia().getDiaPregaoRegraColecao();
		diaSrv.getFiltro().setDataInicialPesquisa(dataInicial);
		diaSrv.getFiltro().setDataFinalPesquisa(dataFinal);
		List<DiaPregao> listaDia = diaSrv.ListaPorData(conexao);
		String linhaTreino = null;
		
		//  Vai ser uma matriz imensa.
		CotacaoProcessadaRegraColecao cotacaoSrv = FabricaRegra.getInstancia().getCotacaoProcessadaRegraColecao();
		cotacaoSrv.getFiltro().setNomeTicker(nomeTicker);
		
		DiaPregao diaPregaoAnt = null;
		for (DiaPregao dia : listaDia) {
			if (dia.getFeriado()) continue;
			dia.setAnterior(diaPregaoAnt);
			diaPregaoAnt = dia;
			cotacaoSrv.getFiltro().setDiaPregao(dia.getData());
			
			CotacaoProcessada cotacaoAnt = null;
			List<CotacaoProcessada> lista = cotacaoSrv.ListaPorDataTicker(conexao);
			if (lista.size()==0) {
				System.out.println("Dia " + dia.getData() + " está sem cotações de " + nomeTicker);
			}
			dia.setUltimaCotacaoProcessada(lista.get(lista.size()-1));
			for (CotacaoProcessada cotacao : lista) {
				
				cotacao.setAnterior(cotacaoAnt);
				cotacaoAnt = cotacao;
				cotacao.setDiaPregao(dia);
				long dataNum = dia.getDataInteiro();
				System.out.println(dataNum);
				if (dataNum >= 20130101) {
					linhaTreino = cotacao.getLinhaTreino();
					System.out.println(linhaTreino);
				}
			}
			
		}
		
		
		return null;
	}



	@Override
	public Ticker ObtemPorCodigo(DaoConexao conexao) throws DaoException {
		String codigo = this.getFiltro().validaCodigoEmpresa();
		TickerDao dao = getDao(conexao);
		return dao.ObtemPorCodigo(codigo);
	}

	
	
}
