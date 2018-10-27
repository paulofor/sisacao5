package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.OpcaoSisacaoSerie;

public interface OpcaoSisacaoSerieDao
 extends OpcaoSisacaoSerieDaoBaseI {

	OpcaoSisacaoSerie ObtemPorMesAno(String dataMesAno) throws DaoException;

	List<OpcaoSisacaoSerie> SerieAtivasPorData(String data) throws DaoException;

	List<OpcaoSisacaoSerie> ListaPorDatas(String dataInicialBd, String dataFinalBd) throws DaoException;

	
}
