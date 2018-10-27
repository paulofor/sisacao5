package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.CotacaoProcessadaOpcaoResultado;

public interface CotacaoProcessadaOpcaoResultadoDao
 extends CotacaoProcessadaOpcaoResultadoDaoBaseI {

	void ExluiDia(String nomeTicker, long faixa, String dataDb) throws DaoException;

	void IncluiDia(String nomeTicker, long faixa, CotacaoProcessadaOpcaoResultado cotacao) throws DaoException;

	void criaSeNecessario(String nomeTicker, long faixa) throws DaoException;

	List<CotacaoProcessadaOpcaoResultado> ListaPorIntervaloDataFaixaTicker(String dtInicioBd, String dtFinalBd, String nomeTicker, long faixa) throws DaoException;

	void AlteraItem(String nomeTicker, long faixa, CotacaoProcessadaOpcaoResultado item) throws DaoException;
}
