package coletorjava.dao;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.basica.DadoThetaDaoBase;


public  class DadoThetaDaoExtendida  extends DadoThetaDaoBase implements DadoThetaDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaPorTreinoRedeGeradoPor(long idItem) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmResultadoPrevisaoListaGera(long idResultadoPrevisao) throws DaoException {
		throw new UnsupportedOperationException();
	} 
}
