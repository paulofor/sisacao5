package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.OpcaoSisacao;

public interface OpcaoSisacaoDao
 extends OpcaoSisacaoDaoBaseI {

	OpcaoSisacao ObtemPorCodigoSerie(String codigoMercado,	long idOpcaoSisacaoSeriePa) throws DaoException;

	OpcaoSisacao ObtemPorCodigoMercadoEVencimento(String dataVencimento, String codigoMercado) throws DaoException;

	List<OpcaoSisacao> ListaPorSerieTicker(long idObj, long idObj2) throws DaoException;

	List<OpcaoSisacao> Lista15MinutosPorDataTicker(String data, String ticker) throws DaoException;

	OpcaoSisacao ObtemPorCodigoMercadoAno(String ticker, String dataBd) throws DaoException;

	List<OpcaoSisacao> ListaPorTickerMesAno(long idTicker, String dataBd) throws DaoException;

	OpcaoSisacao ObtemPorAnoCodigoTicker(String ano, String ticker) throws DaoException;

}
