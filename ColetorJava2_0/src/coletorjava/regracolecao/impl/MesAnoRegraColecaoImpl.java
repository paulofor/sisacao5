package coletorjava.regracolecao.impl;


import java.util.List;

import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.MesAnoDao;
import coletorjava.modelo.MesAno;
import coletorjava.regracolecao.MesAnoRegraColecao;


public  class MesAnoRegraColecaoImpl  extends MesAnoRegraColecao { 
	public  List ListaPorAno( DaoConexao conexao )  throws  DaoException{
		MesAnoDao dao = getDao(conexao);
		long ano = getFiltro().getAnoPesquisa();
		return dao.ListaPorAno(ano);
	}
	public  List ListaSomenteAnos( DaoConexao conexao )  throws  DaoException{
		throw new RuntimeException("Metodo não implementado");
	}
	@Override
	public MesAno ObtemPorDataSimples(DaoConexao conexao) throws DaoException {
		throw new RuntimeException("Metodo não implementado.");
	}
	
}
