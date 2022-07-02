package br.com.sisacao.coletor.diario.legado;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DataFonte;
import br.com.digicom.parse.log.DatasUtils;


public  class CotacaoDiarioDaoExtendida  extends CotacaoDiarioDaoBase implements CotacaoDiarioDao {
	
	public CotacaoDiarioDaoExtendida(DataFonte dataSource) {
		super(dataSource);

	}

	private String tabela(String nomeTicker) {
		return nomeTicker.toUpperCase() + "_DIARIO";
	}

	@Override
	public CotacaoDiario ObtemMaisRecentePorTicker(String nome) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(tabela(nome)) + " from " + tabela(nome) +
				" where data = (select max(data) from " + tabela(nome) + ")";
		return (CotacaoDiario) this.getObjeto(sql);
	}

	@Override
	public CotacaoDiario ObtemPorNomeTickerData(String dataBd, String nome) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(tabela(nome)) + " from " + tabela(nome) +
				" where data = '" + dataBd + "'";
		return (CotacaoDiario) this.getObjeto(sql);
	}

	@Override
	public void insereItem(CotacaoDiario item) throws DaoException {
		String sql;
        sql = "insert into " + tabela(item.getNomeTicker()) +
            camposInsert() + " values " + valoresInsert(item);
        this.executaSql(sql);
	}

	@Override
	public boolean insereSeNaoExiste(CotacaoDiario item) throws DaoException {
		String dataBd = DatasUtils.converteDD_MM_AAAA2AAAA_MM_DD(item.getData());
		String ticker = item.getNomeTicker();
		CotacaoDiario cotacao = this.ObtemPorNomeTickerData(dataBd, ticker);
		if (cotacao==null) {
			insereItem(item);
			return true;
		} else {
			return false;
		}
	}

	@Override
	public void CriaTabela(String nome) throws DaoException {
		// TODO Auto-generated method stub
		String sql = "create table if not exists " + this.tabela(nome) + "  " +
				" (" +
				" id_cotacao_diario integer unsigned not null auto_increment, " +
				" abertura_original decimal(10,2), " +
				" maximo_original decimal(10,2), " +
				" minimo_original decimal(10,2), " +
				" fechamento_original decimal(10,2), " +
				" negocios integer unsigned, " +
				" volume decimal(10,2), " +
				" data date, " +
				" abertura_corrigido decimal(10,2), " +
				" maximo_corrigido decimal(10,2), " +
				" minimo_corrigido decimal(10,2), " +
				" fechamento_corrigido decimal(10,2), " +
				" PRIMARY KEY (id_cotacao_diario), " +
				" INDEX (data) " +
				" ) " +
				" ENGINE = MYISAM ";
		this.executaSql(sql);
		
	}

	@Override
	public List<CotacaoDiario> ListaPorDatasTicker(String dataInicialBd, String dataFinalBd, String nomeTicker) throws DaoException {
		String sql = "select " +  camposOrdenadosAlias(tabela(nomeTicker))  + " from " + this.tabela(nomeTicker) +
				" where data >= '" + dataInicialBd + "' and data <= '" + dataFinalBd + "' order by data";
		return this.getListaSql(sql);
	}

	@Override
	public CotacaoDiario ObtemPorNomeTickerAnteriorData(String data, String nomeTicker) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(tabela(nomeTicker)) + " from " + this.tabela(nomeTicker) +
				" where data < '" + data + "' order by data desc limit 1";
		return (CotacaoDiario) this.getObjeto(sql);
	}

	@Override
	public List<CotacaoDiario> ListaPorQuantidadeTickerRegressiva(String nomeAcao, String dataBd, int tickDiario) throws DaoException {
		String sql = "select " + camposOrdenadosAlias(tabela(nomeAcao)) + " from " + this.tabela(nomeAcao) +
				" where data < '" + dataBd + "' order by data desc limit " + tickDiario;
		return this.getListaSql(sql);
	}

	
	
}
