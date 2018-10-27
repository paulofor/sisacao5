package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import coletorjava.dao.basica.OpcaoSisacaoDaoBase;
import coletorjava.dao.basica.OpcaoSisacaoSerieDaoBase;
import coletorjava.dao.montador.OpcaoSisacaoMontador;
import coletorjava.dao.montador.OpcaoSisacaoSerieMontador;
import coletorjava.modelo.OpcaoSisacao;


public  class OpcaoSisacaoDaoExtendida  extends OpcaoSisacaoDaoBase implements OpcaoSisacaoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new RuntimeException("Metodo não implementado");
	}


	@Override
	public OpcaoSisacao ObtemPorCodigoSerie(String codigoMercado, long idOpcaoSisacaoSeriePa) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				" where codigo_mercado = '" + codigoMercado + "' and id_opcao_sisacao_serie_pa = " + idOpcaoSisacaoSeriePa;
		return (OpcaoSisacao) this.getObjeto(sql);
	}

	@Override
	public OpcaoSisacao ObtemPorCodigoMercadoEVencimento(String dataVencimento, String codigoMercado) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinOpcaoSisacaoSerie_PertenceA() +
				" where codigo_mercado = '" + codigoMercado + "' and data_vencimento = '" + dataVencimento +   "' ";
		OpcaoSisacao saida = (OpcaoSisacao) this.getObjeto(sql);
		//if (saida==null) {
		//	System.out.println("Pesquisa: " + sql);
		//}
		return saida;
	}


	@Override
	public List ListaPorOpcaoSisacaoSeriePertenceA(long idItem) throws DaoException {
		return getPorPertenceAOpcaoSisacaoSerie(idItem);
	}


	@Override
	public List ListaPorTickerDerivativoDe(long idItem) throws DaoException {
		return super.getPorDerivativoDeTicker(idItem);
	}


	@Override
	public List ListaNaoRelacionadaEmEscolhaOpcaoListaEscolhida(long idEscolhaOpcao) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}


	@Override
	public List<OpcaoSisacao> ListaPorSerieTicker(long idObj, long idObj2) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where id_ticker_dd  = " + idObj2 + " and id_opcao_sisacao_serie_pa = " + idObj;
		return this.getListaSql(sql);
	}


	@Override
	public List ListaNaoRelacionadaEmCotacaoProcessadaOpcaoResultadoListaEstaEm(long idCotacaoProcessadaOpcaoResultado) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	} 
	
	
	@Override
	public List<OpcaoSisacao> Lista15MinutosPorDataTicker(String data, String codigoTicker) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinTicker_DerivativoDe() +
				this.innerJoinOpcaoSisacaoSerie_PertenceA() +
				" where opcao_sisacao_serie.data_vencimento >= '" + data + "' and " +
				" opcao_sisacao_serie.data_inicio_coleta <= '" + data + "'  and ticker.nome = '" + codigoTicker + "' " ;
				//+	" and opcao_sisacao_geral.possui_coleta_intraday = 'S'";
		return this.getListaSql(sql);
	}


	@Override
	public OpcaoSisacao ObtemPorCodigoMercadoAno(String ticker, String ano) throws DaoException {
		String dataInicio = ano + "-01-01";
		String dataFinal = ano + "-12-31";
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinOpcaoSisacaoSerie_PertenceA() +
				" where codigo_mercado = '" + ticker + "' and " +
				OpcaoSisacaoSerieDaoBase.tabelaSelect() + ".mes_ano >= '" + dataInicio + "' and " +
				OpcaoSisacaoSerieDaoBase.tabelaSelect() + ".mes_ano <= '" + dataFinal + "'";
		return (OpcaoSisacao) this.getObjeto(sql);
	}


	@Override
	public List<OpcaoSisacao> ListaPorTickerMesAno(long idTicker, String dataBd) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				this.innerJoinOpcaoSisacaoSerie_PertenceA() +
				" where id_ticker_dd = " + idTicker + " and mes_ano = '" + dataBd + "'";
		return this.getListaSql(sql);
	}

	@Override
	public OpcaoSisacao ObtemPorAnoCodigoTicker(String mesAnoDb, String ticker) throws DaoException {
		String sql = "select " + camposOrdenados() + " , " + OpcaoSisacaoSerieDaoExtendida.camposOrdenados() + 
				" from " + tabelaSelect() +
				this.innerJoinOpcaoSisacaoSerie_PertenceA() +
				" where codigo_mercado = '" + ticker + "' and mes_ano <= '" + mesAnoDb + "' order by mes_ano desc";
		//return (OpcaoSisacao) this..getObjeto(sql);
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new OpcaoSisacaoMontador(), null);
		montador.adicionaMontador(new OpcaoSisacaoSerieMontador(), "OpcaoSisacaoSeriePertenceA");
		this.setMontador(montador);
		return (OpcaoSisacao) getObjetoSqlInterno(sql);
	}


	@Override
	public List ListaNaoRelacionadaEmOpcaoReferenciaListaPossui(long idOpcaoReferencia) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}
	
}
