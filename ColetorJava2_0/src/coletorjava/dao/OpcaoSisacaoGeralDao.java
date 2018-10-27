package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.OpcaoSisacaoGeral;

public interface OpcaoSisacaoGeralDao
 extends OpcaoSisacaoGeralDaoBaseI {

	OpcaoSisacaoGeral ObtemPorTickerMesAno(String ticker, String mesAnoMySql) throws DaoException;

	List<OpcaoSisacaoGeral> ListaPorMesAnoComTicker(String dataBD) throws DaoException;

	OpcaoSisacaoGeral obtemPorMesAnoCodigoMercado(String mesAnoDb, String nomeTicker) throws DaoException;

	List<OpcaoSisacaoGeral> ListaPorMesAnoCodigoTicker(String mesAno, String codigoTicker) throws DaoException;

	List<OpcaoSisacaoGeral> Lista15MinutosPorDataTicker(String data, String ticker) throws DaoException;

	OpcaoSisacaoGeral ObtemPorAnoCodigoTicker(String ano, String ticker) throws DaoException;

	
}
