package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.CotacaoDiario;

public interface CotacaoDiarioDao
 extends CotacaoDiarioDaoBaseI {

	CotacaoDiario ObtemMaisRecentePorTicker(String nome) throws DaoException;

	CotacaoDiario ObtemPorNomeTickerData(String dataBd, String nome) throws DaoException;

	void CriaTabela(String nome) throws DaoException;

	List<CotacaoDiario> ListaPorDatasTicker(String dataInicialBd, String dataFinalBd, String nomeTicker) throws DaoException;

	CotacaoDiario ObtemPorNomeTickerAnteriorData(String data, String ticker) throws DaoException;

	List<CotacaoDiario> ListaPorQuantidadeTickerRegressiva(String nomeAcao, String dataBd, int tickDiario) throws DaoException;
	
	
}
