package coletorjava.dao;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.basica.*;
import coletorjava.modelo.ProjetoDadoTreino;

public interface ProjetoDadoTreinoDao
 extends ProjetoDadoTreinoDaoBaseI {

	ProjetoDadoTreino ObtemPorItem(float target, float stop, String posicaoCompraVenda, long idTickerRa) throws DaoException; 
}
