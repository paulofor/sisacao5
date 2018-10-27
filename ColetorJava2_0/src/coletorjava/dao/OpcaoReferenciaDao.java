package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;

import coletorjava.dao.basica.OpcaoReferenciaDaoBaseI;
import coletorjava.modelo.OpcaoReferencia;

public interface OpcaoReferenciaDao
 extends OpcaoReferenciaDaoBaseI {

	List<OpcaoReferencia> ListaAtivoParaColetaNaData(String dataBd) throws DaoException; 
}
