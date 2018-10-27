package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.modelo.DiaPregao;


public  class DiaPregaoDaoExtendida  extends DiaPregaoDaoBase implements DiaPregaoDao {

	@Override
	public List ListaPorData(String data1, String data2) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data >= '" + data1 + "' and data <= '" + data2 + "' order by data";
		return this.getListaSql(sql);
	}

	@Override
	public List ListaPorDataSemFeriado(String data1, String data2) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data > '" + data1 + "' and data <= '" + data2 + "' order by data";
		return this.getListaSql(sql);
	}

	
	@Override
	public DiaPregao DeslocaDias(String dataBd, long diasDeslocamento) throws DaoException {
		String sql = null;
		if (diasDeslocamento>=0) {
			sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data >= '" + dataBd + "' and feriado = 'N' " + 
				" order by data asc " + " limit " + (diasDeslocamento+1);
		} else {
			sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data < '" + dataBd + "' and feriado = 'N' " + 
				" order by data desc " + " limit " + (diasDeslocamento*-1);
		}
		List listaResultado = this.getListaSql(sql);
		return (DiaPregao) listaResultado.get(listaResultado.size()-1);
	}

	@Override
	public List ListaNaoRelacionadaEmEscolhaOpcaoListaPossui(long idEscolhaOpcao) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public List ListaNaoRelacionadaEmOpcaoReferenciaListaPossui(long idOpcaoReferencia) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}

	@Override
	public DiaPregao ObtemPorDataPesquisa(String data) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where data = '" + data + "'";
		return (DiaPregao) this.getObjeto(sql);
		
	}

	
}
