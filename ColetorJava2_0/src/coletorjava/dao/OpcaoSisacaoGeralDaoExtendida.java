package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.MontadorDaoComposite;
import coletorjava.dao.basica.OpcaoSisacaoGeralDaoBase;
import coletorjava.dao.basica.TickerDaoBase;
import coletorjava.dao.montador.OpcaoSisacaoGeralMontador;
import coletorjava.dao.montador.TickerMontador;
import coletorjava.modelo.OpcaoSisacaoGeral;


public  class OpcaoSisacaoGeralDaoExtendida  extends OpcaoSisacaoGeralDaoBase implements OpcaoSisacaoGeralDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public List ListaPorTickerReferenteA(long idItem) throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpcaoSisacaoGeral ObtemPorTickerMesAno(String ticker, String mesAnoMySql) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where codigo_mercado = '" + ticker + "' and mes_ano = '" + mesAnoMySql + "'";
		return (OpcaoSisacaoGeral) this.getObjeto(sql);
	}

	@Override
	public List<OpcaoSisacaoGeral> ListaPorMesAnoComTicker(String dataBD)
			throws DaoException {
		String sql = "select " + camposOrdenados() + " , " +
				TickerDaoBase.camposOrdenados() +
				" from " + tabelaSelect() +
				this.innerJoinTicker_ReferenteA() +
				" where mes_ano = '" + dataBD + "' ";
		MontadorDaoComposite montador = new MontadorDaoComposite();
		montador.adicionaMontador(new OpcaoSisacaoGeralMontador(), null);
		montador.adicionaMontador(new TickerMontador(), "TickerReferenteA");
		this.setMontador(montador);
		return this.getListaSqlListaInterna(sql);
	}

	@Override
	public OpcaoSisacaoGeral obtemPorMesAnoCodigoMercado(String mesAnoDb, String nomeTicker) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where codigo_mercado = '" + nomeTicker + "' and mes_ano = '" + mesAnoDb + "'";
		return (OpcaoSisacaoGeral) this.getObjeto(sql);
	}

	@Override
	public List<OpcaoSisacaoGeral> ListaPorMesAnoCodigoTicker(String mesAnoDb, String codigoTicker) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				innerJoinTicker_ReferenteA() +
				" where mes_ano = '" + mesAnoDb + "' and ticker.nome = '" + codigoTicker + "' order by preco_exercicio asc";
		return this.getListaSql(sql);
	}

	@Override
	public List<OpcaoSisacaoGeral> Lista15MinutosPorDataTicker(String data, String codigoTicker) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				innerJoinTicker_ReferenteA() +
				" inner join opcao_sisacao_serie on opcao_sisacao_serie.mes_ano = opcao_sisacao_geral.mes_ano " +
				" where opcao_sisacao_serie.data_vencimento >= '" + data + "' and " +
				" opcao_sisacao_serie.data_inicio_coleta <= '" + data + "'  and ticker.nome = '" + codigoTicker + "' " ;
				//+	" and opcao_sisacao_geral.possui_coleta_intraday = 'S'";
		return this.getListaSql(sql);
	}

	
	@Override
	public OpcaoSisacaoGeral ObtemPorAnoCodigoTicker(String mesAnoDb, String ticker) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where codigo_mercado = '" + ticker + "' and mes_ano <= '" + mesAnoDb + "' order by mes_ano desc";
		return (OpcaoSisacaoGeral) this.getObjeto(sql);
	}

	/*
	@Override
	public OpcaoSisacaoGeral obtemPorSerieTicker(long idSerie, String nomeTicker) {
		
	} 
	*/
}
