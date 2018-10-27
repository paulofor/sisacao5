package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.Cotacao;

public interface CotacaoDao
 extends CotacaoDaoBaseI {

	List<Cotacao> listaPorDataTicker(String dataBd, String nomeTicker) throws DaoException;

	List<Cotacao> listaPorDataTickerOpcao(String dataBd, String nomeTicker) throws DaoException;

	List<Cotacao> AnteriorDataPesquisaQuantidadeOpcao(String data, String ticker, int quantidade)  throws DaoException;

	void criaTabelaIntradayOpcao(String codigoMercado) throws DaoException;

	Cotacao obtemMaisRecente(String ticker) throws DaoException;

	void insereCotacao(Cotacao cotacao, String nomeTicker) throws DaoException;
}
