package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.modelo.OpcaoSisacaoSerie;


public  class OpcaoSisacaoSerieDaoExtendida  extends OpcaoSisacaoSerieDaoBase implements OpcaoSisacaoSerieDao {

	@Override
	public List ListaNaoRelacionadaEmOpcaoSisacaoListaPossui(long idOpcaoSisacao)
			throws DaoException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OpcaoSisacaoSerie ObtemPorMesAno(String dataMesAno) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where mes_ano = '" + dataMesAno + "' ";
		return (OpcaoSisacaoSerie) this.getObjeto(sql);
	}

	@Override
	public List<OpcaoSisacaoSerie> SerieAtivasPorData(String data) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data_inicio_coleta <= '" + data + "' and data_vencimento >= '" + data + "'";
		return this.getListaSql(sql);
	}

	@Override
	public List<OpcaoSisacaoSerie> ListaPorDatas(String dataInicialBd, String dataFinalBd) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where mes_ano >= '" + dataInicialBd + "' and mes_ano <= '" + dataFinalBd + "' order by mes_ano";
		return this.getListaSql(sql);
	}

	
}
