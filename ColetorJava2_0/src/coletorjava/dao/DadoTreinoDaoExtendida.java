package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;


public  class DadoTreinoDaoExtendida  extends DadoTreinoDaoBase implements DadoTreinoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaPorProjetoDadoTreinoPossui(long idItem) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmTreinoRedeListaGerou(long idTreinoRede) throws DaoException {
		throw new UnsupportedOperationException();
	} 
}
