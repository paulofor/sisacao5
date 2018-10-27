package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.CotacaoProcessada;

public interface CotacaoProcessadaDao
 extends CotacaoProcessadaDaoBaseI {

	void insereItem(CotacaoProcessada cotacao, String nomeTicker) throws DaoException;

	void CriaTabela(String nomeTicker) throws DaoException;

	List<CotacaoProcessada> ListaPorDataTicker(String dataBd, String ticker) throws DaoException; 
	//public void criaTabelaIntradayOpcao(String codigoMercado) throws DaoException;

	List<CotacaoProcessada> AnteriorDataPesquisaQuantidadeOpcao(String data, String ticker, int quantidade) throws DaoException;

	List<CotacaoProcessada> ListaPorPeriodoTicker(String dataIniBd, String dataFimBd, String ticker) throws DaoException;

	void insereOuAtualiza(CotacaoProcessada cotacao, String nomeTicker) throws DaoException;

	void atualizaItem(CotacaoProcessada cotacao, String nomeTicker) throws DaoException;

	int QuantidadeZerados(String dataInicial, String dataFinal, String nomeTicker) throws DaoException;

	List<CotacaoProcessada> ListaPorQuantidadeTickerRegressiva(String ticker, String data, String horaSerieTemporal, int i) throws DaoException;
}
