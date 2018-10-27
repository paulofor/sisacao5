package coletorjava.regracolecao.impl;


import java.util.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.dao.*;


import coletorjava.modelo.ProjetoDadoTreino;
import coletorjava.regracolecao.*;
import coletorjava.dao.*;


public  class ProjetoDadoTreinoRegraColecaoImpl  extends ProjetoDadoTreinoRegraColecao {

	@Override
	public ProjetoDadoTreino ObtemPorItem(DaoConexao conexao) throws DaoException {
		ProjetoDadoTreino pesquisa = this.getFiltro().validaItem();
		float target = pesquisa.getTarget();
		ProjetoDadoTreinoDao dao = getDao(conexao);
		
		ProjetoDadoTreino saida = dao.ObtemPorItem(pesquisa.getTarget(),pesquisa.getStop(),pesquisa.getPosicaoCompraVenda(),pesquisa.getIdTickerRa());
		return saida;
	} 
}
