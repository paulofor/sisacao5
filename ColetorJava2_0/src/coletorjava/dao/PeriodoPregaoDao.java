package coletorjava.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.PeriodoPregao;

public interface PeriodoPregaoDao
 extends PeriodoPregaoDaoBaseI {

	PeriodoPregao obtemPorDiaAAAAMMDD(String data) throws DaoException; 
}
