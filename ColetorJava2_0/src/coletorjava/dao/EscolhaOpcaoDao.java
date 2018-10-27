package coletorjava.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.EscolhaOpcao;

public interface EscolhaOpcaoDao
 extends EscolhaOpcaoDaoBaseI {

	public EscolhaOpcao obtemPorTickerDia(long idTicker, long idDia) throws DaoException;

	public EscolhaOpcao ObtemPorIdTickerDiaComOpcao(long codigoTickerReferenteA, long codigoDiaPregaoReferenteA) throws DaoException;


}
