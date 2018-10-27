package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.basica.DiaPregaoDaoBaseI;
import coletorjava.modelo.DiaPregao;

public interface DiaPregaoDao
 extends DiaPregaoDaoBaseI {

	List ListaPorData(String data1, String data2) throws DaoException;
	List ListaPorDataSemFeriado(String data1, String data2) throws DaoException;

	DiaPregao DeslocaDias(String dataBd, long diasDeslocamento) throws DaoException;
	DiaPregao ObtemPorDataPesquisa(String data) throws DaoException; 
}
