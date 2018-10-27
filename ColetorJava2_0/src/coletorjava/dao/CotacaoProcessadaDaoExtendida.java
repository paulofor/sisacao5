package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.log.ArquivoLog;
import coletorjava.modelo.CotacaoProcessada;


public  class CotacaoProcessadaDaoExtendida  extends CotacaoProcessadaDaoBase implements CotacaoProcessadaDao {

	public CotacaoProcessadaDaoExtendida() {
		super(new DataSourceOnline());
	}
	public CotacaoProcessadaDaoExtendida(DataFonte dataSource) {
		super(dataSource);
	}
	
	
	private String getNomeTabela(String nomeTicker) {
		return nomeTicker.toUpperCase() + "_15";
	}
	
	@Override
	public void insereItem(CotacaoProcessada cotacao, String nomeTicker) throws DaoException {
		String sql;
        sql = "insert into " + getNomeTabela(nomeTicker) +
            camposInsert() + " values " + valoresInsert(cotacao);
        System.out.println(sql);
        ArquivoLog.getInstancia().salvaLog(sql);
        this.executaSql(sql); 
	} 
	
	protected String camposValoresUpdateEdicaoSemChave(CotacaoProcessada item) {
		return " hora_cotacao_tempo_real = " + (item.getHoraCotacaoTempoReal()==null?"null":"'" + item.getHoraCotacaoTempoReal() + "'") + "  " 
		+ " , valor_tempo_real = '" +  DCConvert.ToDataBase(item.getValorTempoReal()) + "'  " 
		+ " , valor_corrigido = '" +  DCConvert.ToDataBase(item.getValorCorrigido()) + "'  " 
		+ " , contador_dia = '" + item.getContadorDia() + "'  " 
		+ " , data = " + (item.getData()==null?"null":DCConvert.ToDataSqlAAAA_MM_DD(item.getData()) ) + "  " 
		+ " , hora_serie_temporal = " + (item.getHoraSerieTemporal()==null?"null":"'" + item.getHoraSerieTemporal() + "'") + "  " 
		+ " , hora_cotacao = " + (item.getHoraCotacao()==null?"null":"'" + item.getHoraCotacao() + "'") + "  " 
		+ " , negocios = '" + item.getNegocios() + "'  " 
		+ " , valor = '" +  DCConvert.ToDataBase(item.getValor()) + "'  " 
		;
	}
	
	
	@Override
	public void atualizaItem(CotacaoProcessada cotacao, String nomeTicker) throws DaoException {
		// TODO Auto-generated method stub
		String sql;
        sql = "update " + getNomeTabela(nomeTicker) +
            " set " + camposValoresUpdateEdicaoSemChave(cotacao) + 
            " where data = " + DCConvert.ToDataSqlAAAA_MM_DD(cotacao.getData()) + " and hora_serie_temporal = '" + cotacao.getHoraSerieTemporal() + "'";
        this.executaSql(sql);
	}
	
	
	@Override
	public void insereOuAtualiza(CotacaoProcessada cotacao, String nomeTicker) throws DaoException {
		// TODO Auto-generated method stub
		try {
			insereItem(cotacao,nomeTicker);
		} catch (DaoException e) {
			atualizaItem(cotacao,nomeTicker);
		}
	}
	
	
	@Override
	public void CriaTabela(String nomeTicker) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "create table if not exists " + getNomeTabela(nomeTicker) + "  " +
					" ( " +
					" id_cotacao_processada integer unsigned NOT NULL AUTO_INCREMENT, " +
					" valor decimal(10,2) , " +
					" negocios integer unsigned, " + 
					" hora_cotacao time , " +
					" hora_serie_temporal time, " +
					" data date , " +
					" contador_dia integer unsigned , " +
					" valor_corrigido decimal(10,2) , " +
					" id_dia_pregao_ra integer unsigned, " +
					" hora_cotacao_tempo_real time , " +
					" valor_tempo_real decimal(10,2) , " +
					" pontuacao_6semanas decimal(8,6) , " +
					" PRIMARY KEY (id_cotacao_processada), " +
					" UNIQUE KEY data_hora (data,hora_serie_temporal) " +
					" ) " + 
					" ENGINE=MyISAM "; 
		this.executaSql(sql);
		
	}

	@Override
	public List<CotacaoProcessada> ListaPorDataTicker(String dataBd, String ticker) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(getNomeTabela(ticker)) + " from " + getNomeTabela(ticker) +
				" where data = '" + dataBd + "' order by hora_serie_temporal";
		return this.getListaSql(sql);
	}
	
	
	@Override
	public List<CotacaoProcessada> AnteriorDataPesquisaQuantidadeOpcao(String dataBd, String ticker, int quantidade) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(getNomeTabela(ticker)) + " from " + getNomeTabela(ticker) +
				" where data < '" + dataBd + "' order by data desc, hora_serie_temporal desc limit " + quantidade;
		//System.out.println(sql);
		return this.getListaSql(sql);
	}
	@Override
	public List<CotacaoProcessada> ListaPorPeriodoTicker(String dataIniBd, String dataFimBd, String ticker) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(getNomeTabela(ticker)) + " from " + getNomeTabela(ticker) +
				" where data >= '" + dataIniBd + "' and data <= '" + dataFimBd + "' order by data, hora_serie_temporal";
		return this.getListaSql(sql);
	}
	@Override
	public int QuantidadeZerados(String dataInicial, String dataFinal, String nomeTicker) throws DaoException {
		String sql = "select count(*) from " + getNomeTabela(nomeTicker) + " where data >= '" + dataInicial + "' and data < '" + dataFinal + "' and valor = 0";
		int saida = this.getValorInt(sql);
		return saida;
	}
	@Override
	public List<CotacaoProcessada> ListaPorQuantidadeTickerRegressiva(String ticker, String data, String horaSerieTemporal, int i) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(getNomeTabela(ticker)) + " from " + getNomeTabela(ticker) +
				" where concat((CAST(data AS char)), \" \" , hora_serie_temporal) <= '" + data + " " + horaSerieTemporal + ":00' "  +
				" and data >= DATE_SUB('" + data + "',INTERVAL 6 MONTH) " +
				" order by data desc, hora_serie_temporal desc limit " + i;
		return this.getListaSql(sql);
	}
	
	
}
