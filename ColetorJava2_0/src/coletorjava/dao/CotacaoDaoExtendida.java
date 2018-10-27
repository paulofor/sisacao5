package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.basica.CotacaoDaoBase;
import coletorjava.dao.basica.DataSourceLocalIntraday;
import coletorjava.dao.basica.DataSourceLocalIntradayOpcao;
import coletorjava.modelo.Cotacao;


public  class CotacaoDaoExtendida  extends CotacaoDaoBase implements CotacaoDao {
	

	public static String camposOrdenadosAliasOpcao(String nomeTabela) {
		return  nomeTabela + ".id_opcao_cotacao " 
		+ " , " + nomeTabela + ".neg " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".data,'%d-%m-%Y') " 
		+ " , " + nomeTabela + ".ult " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_real,'%H:%i') " 
		+ " , " +  "DATE_FORMAT(" + nomeTabela + ".hora_neg,'%H:%i') " 
		;
	}
	
	public CotacaoDaoExtendida() {
		super(new DataSourceLocalIntraday());
	}
	
	public void setIntraday() {
		this.setDataSource(new DataSourceLocalIntraday());
	}
	public void setIntradayOpcao() {
		this.setDataSource(new DataSourceLocalIntradayOpcao());
	}

	@Override
	public List<Cotacao> listaPorDataTicker(String dataBd, String nomeTicker) throws DaoException {
		String nomeTabela = nomeTicker.toUpperCase();
		String sql  = "select " + camposOrdenadosAlias(nomeTabela) + " from " + nomeTabela +
				" where data = '" + dataBd + "' order by hora_real";
		return this.getListaSql(sql);
	}

	@Override
	public List<Cotacao> listaPorDataTickerOpcao(String dataBd, String nomeTicker) throws DaoException {
		String nomeTabela = nomeTicker.toUpperCase();
		String sql  = "select " + camposOrdenadosAliasOpcao(nomeTabela) + " from " + nomeTabela +
				" where data = '" + dataBd + "' order by hora_real";
		return this.getListaSql(sql);
	}

	public List<Cotacao> listaPorPeriodoTickerOpcao(String dataInicialBd, String dataFinalBd, String nomeTicker) throws DaoException{
		String nomeTabela = nomeTicker.toUpperCase();
		String sql  = "select " + camposOrdenadosAliasOpcao(nomeTabela) + " from " + nomeTabela +
				" where data >= '" + dataInicialBd + "' and data < '" + dataFinalBd + "' order by data, hora_real";
		return this.getListaSql(sql);
	}

	public long quantidadeRegistros(String codigo, String dataInicial, String dataFinal) throws DaoException {
		String sql = "select count(*) from " + codigo + " where data >= '" + dataInicial + "' and data <= '" + dataFinal + "' ";
		long saida = 0;
		try {
			saida = this.getValorLong(sql);
		} catch (DaoException e) {
			System.out.println(sql);
			if (e.getMessage().contains("doesn't exist")) { 
				saida = 0; 
			} else {
				throw e;
			}
		}
		return saida;
	}
	
	
	public List<Cotacao> AnteriorDataPesquisaQuantidadeOpcao(String dataBd, String nomeTicker, int quantidade) throws DaoException{
		String nomeTabela = nomeTicker.toUpperCase();
		String sql  = "select " + camposOrdenadosAliasOpcao(nomeTabela) + " from " + nomeTabela +
				" where data < '" + dataBd + "' order by data desc, hora_real desc limit " + quantidade;
		return this.getListaSql(sql);
	}

	public void criaTabelaIntradayOpcao(String codigoMercado) throws DaoException {
		String sql = "CREATE TABLE if not exists `" + codigoMercado + "` ( " +
				  " `id_opcao_cotacao` int(10) unsigned NOT NULL AUTO_INCREMENT, " +
				  " `neg` int(10) unsigned DEFAULT NULL,  " +
				  " `data` date DEFAULT NULL, " +
				  " `ult` decimal(6,2) DEFAULT NULL, " +
				  " `ultstr` varchar(10) DEFAULT NULL, " +
				  " `hora_real` time DEFAULT NULL, " +
				  " `hora_neg` time DEFAULT NULL, " +
				  " PRIMARY KEY (`id_opcao_cotacao`) " +
				  " ) ENGINE=MyISAM";
		this.executaSql(sql);
	}

	@Override
	public Cotacao obtemMaisRecente(String ticker) throws DaoException {
		String nomeTabela = ticker.toUpperCase();
		String sql  = "select " + camposOrdenadosAliasOpcao(nomeTabela) + " from " + nomeTabela +
				" order by data desc, hora_real desc limit 1";
		System.out.println("SQL:" + sql);
		return (Cotacao) this.getObjeto(sql);
	}
}
