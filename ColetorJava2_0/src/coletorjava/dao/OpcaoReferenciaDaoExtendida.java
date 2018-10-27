package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.modelo.OpcaoReferencia;


public  class OpcaoReferenciaDaoExtendida  extends OpcaoReferenciaDaoBase implements OpcaoReferenciaDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public List ListaPorTickerReferenteA(long idItem) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public List ListaPorDiaPregaoReferenteA(long idItem) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public List ListaPorOpcaoSisacaoReferenteA(long idItem) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public List<OpcaoReferencia> ListaAtivoParaColetaNaData(String dataBd) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data = '" + dataBd + "' ";
		return this.getListaSql(sql);
	}

	
}
