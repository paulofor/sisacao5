package br.com.sisacao.coletor.diario.legado;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;


public interface CotacaoDiarioDao
 extends CotacaoDiarioDaoBaseI {

	CotacaoDiario ObtemMaisRecentePorTicker(String nome) throws DaoException;

	CotacaoDiario ObtemPorNomeTickerData(String dataBd, String nome) throws DaoException;

	void CriaTabela(String nome) throws DaoException;

	List<CotacaoDiario> ListaPorDatasTicker(String dataInicialBd, String dataFinalBd, String nomeTicker) throws DaoException;

	CotacaoDiario ObtemPorNomeTickerAnteriorData(String data, String ticker) throws DaoException;

	List<CotacaoDiario> ListaPorQuantidadeTickerRegressiva(String nomeAcao, String dataBd, int tickDiario) throws DaoException;
	
	
}
