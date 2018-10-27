package coletorjava.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.Ticker;

public interface TickerDao
 extends TickerDaoBaseI {

	Ticker ObtemPorEmpresaTipo(String nomeEmpresa, String tipoAcao) throws DaoException;

	Ticker ObtemPorCodigo(String codigo) throws DaoException;
 
}
