package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;


public  class MesAnoDaoExtendida  extends MesAnoDaoBase implements MesAnoDao {

	

	@Override
	public List ListaPorAno(long ano) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where numero_ano = " + ano + " order by numero_mes";
		return this.getListaSql(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmResultadoPrevisaoListaGera(long idResultadoPrevisao) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmResultadoMesListaBasePara(long idResultadoMes) throws DaoException {
		throw new UnsupportedOperationException();
	} 
}
