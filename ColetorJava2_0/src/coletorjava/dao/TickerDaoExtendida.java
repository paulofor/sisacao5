package coletorjava.dao;


import java.util.*;

import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.dao.*;
import coletorjava.dao.basica.*;
import coletorjava.modelo.Ticker;


public  class TickerDaoExtendida  extends TickerDaoBase implements TickerDao {

	@Override
	public List ListaNaoRelacionadaEmOpcaoSisacaoGeralListaPossui(long idOpcaoSisacaoGeral) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public Ticker ObtemPorEmpresaTipo(String nomeEmpresa, String tipoAcao) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				" where tipo_acao = '" + tipoAcao + "' and nome like '" + nomeEmpresa + "%'";
		return (Ticker) this.getObjeto(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmOpcaoSisacaoListaGera(long idOpcaoSisacao)
			throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public List ListaNaoRelacionadaEmEscolhaOpcaoListaPossui(long idEscolhaOpcao) throws DaoException {
		throw new RuntimeException("Metodo nao implementado");
	}

	@Override
	public Ticker ObtemPorCodigo(String codigo) throws DaoException {
		String sql = " select " + camposOrdenados() + " from " + tabelaSelect() +
				" where nome = '" + codigo + "'";
		return (Ticker) this.getObjeto(sql);
	}

	@Override
	public List ListaNaoRelacionadaEmProjetoDadoTreinoListaGera(long idProjetoDadoTreino) throws DaoException {
		throw new UnsupportedOperationException();
	}

	@Override
	public List ListaNaoRelacionadaEmOpcaoReferenciaListaPossui(long idOpcaoReferencia) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	} 
}
