package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.basica.MesAnoDaoBaseI;

public interface MesAnoDao
 extends MesAnoDaoBaseI {

	List ListaPorAno(long ano) throws DaoException; 
}
