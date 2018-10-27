package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.modelo.CotacaoProcessadaOpcaoResultado;


public  class CotacaoProcessadaOpcaoResultadoDaoExtendida  extends CotacaoProcessadaOpcaoResultadoDaoBase implements CotacaoProcessadaOpcaoResultadoDao {

	public CotacaoProcessadaOpcaoResultadoDaoExtendida() {
		super(new DataSourceOnline());
	}
	
	private String tabelaSelect(String nomeTicker, long faixa) {
		return nomeTicker.toUpperCase() + "_F" + faixa;
	}
	
	@Override
	public void ExluiDia(String nomeTicker, long faixa, String dataDb) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "delete from " + tabelaSelect(nomeTicker, faixa) +
				" where data = " + dataDb + " ";
		this.executaSql(sql);
	}

	@Override
	public void IncluiDia(String nomeTicker, long faixa, CotacaoProcessadaOpcaoResultado cotacao) throws DaoException {
		// TODO Auto-generated method stub
		String sql;
        sql = "insert into " + tabelaSelect(nomeTicker, faixa) +
            camposInsert() + " values " + valoresInsert(cotacao);
        this.executaSql(sql);
	} 
	
	@Override
	public void AlteraItem(String nomeTicker, long faixa, CotacaoProcessadaOpcaoResultado item) throws DaoException {
		// TODO Auto-generated method stub
		String sql;
        sql = "update " + tabelaSelect(nomeTicker, faixa) +
            " set " + camposValoresUpdateEdicao(item) + 
            " where id_cotacao_processada_opcao_resultado = " + item.getIdCotacaoProcessadaOpcaoResultado();
        this.executaSql(sql);
	} 
	
	public void criaSeNecessario(String nomeTicker, long faixa) throws DaoException {
		String sql = 
		" create table if not exists " + tabelaSelect(nomeTicker, faixa) +
		" ( " +
		" id_cotacao_processada_opcao_resultado integer unsigned not null auto_increment,  " +
		" valor_saida_t60_s60 decimal(10,2), " +
		" valor_saida_t70_s60 decimal(10,2), " +
		" valor_saida_t40_s50 decimal(10,2), " +
		" valor_saida_t50_s50 decimal(10,2), " +
		" valor_saida_t60_s50 decimal(10,2), " +
		" valor_saida_t70_s50 decimal(10,2), " +
		" data_hora_saida_t40_s60 datetime, " +
		" data_hora_saida_t50_s60 datetime, " +
		" data_hora_saida_t60_s60 datetime, " +
		" data_hora_saida_t70_s60 datetime, " +
		" data_hora_saida_t40_s50 datetime, " +
		" data_hora_saida_t50_s50 datetime, " +
		" data_hora_saida_t60_s50 datetime, " +
		" valor_saida_t50_s60 decimal(10,2), " +
		" valor_saida_t40_s60 decimal(10,2), " +
		" data date, " +
		" hora_serie_temporal time, " +
		" contador_dia integer unsigned, " +
		" codigo_mercado_opcao varchar(60), " +
		" valor_opcao decimal(10,2), " +
		" resultado_t70_s60 tinyint, " +
		" resultado_t60_s60 tinyint, " +
		" resultado_t50_s60 tinyint, " +
		" resultado_t40_s60 tinyint, " +
		" resultado_t70_s50 tinyint, " +
		" resultado_t60_s50 tinyint, " +
		" resultado_t50_s50 tinyint, " +
		" resultado_t40_s50 tinyint, " +
		" data_hora_saida_t70_s50 datetime, " +
		" valor_acao decimal(10,2), " +
		" id_opcao_sisacao_ra integer unsigned, " +
		" INDEX (data) , " +
		" INDEX (data, hora_serie_temporal), " +
		" PRIMARY KEY (id_cotacao_processada_opcao_resultado) " +
		" ) " +
		" ENGINE = MYISAM ";
		this.executaSql(sql);
	}

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaPorOpcaoSisacaoReferenteA(long idItem) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List<CotacaoProcessadaOpcaoResultado> ListaPorIntervaloDataFaixaTicker(String dtInicioBd, String dtFinalBd, String nomeTicker, long faixa)
			throws DaoException {
		String nomeTabela = this.tabelaSelect(nomeTicker, faixa);
		String sql = "select " + camposOrdenadosAlias(nomeTabela) + " from " + nomeTabela +
				" where data >= " + dtInicioBd + " and data <= " + dtFinalBd + " " +
				" order by data, hora_serie_temporal ";
		return this.getListaSql(sql);
	}
}
