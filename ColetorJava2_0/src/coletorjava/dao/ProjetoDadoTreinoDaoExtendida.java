package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.modelo.ProjetoDadoTreino;


public  class ProjetoDadoTreinoDaoExtendida  extends ProjetoDadoTreinoDaoBase implements ProjetoDadoTreinoDao {

	@Override
	public List ListaCorrenteAgrupada() throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaPorTickerReferenteA(long idItem) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmDadoTreinoListaGerou(long idDadoTreino) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmResultadoMesListaGerou(long idResultadoMes) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public ProjetoDadoTreino ObtemPorItem(float target, float stop, String posicaoCompraVenda, long idTickerRa) throws DaoException {
		String sql = "select " + camposOrdenados() + " from " + tabelaSelect() +
				" where target = " + String.format("%.2f", target).replaceAll(",",".") + 
				" and stop = " + String.format("%.2f", stop).replaceAll(",",".") +
				" and posicao_compra_venda = '" + posicaoCompraVenda + "' " +
				" and id_ticker_ra = " + idTickerRa;
		return (ProjetoDadoTreino) this.getObjeto(sql);
	} 
}
