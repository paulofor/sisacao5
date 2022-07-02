package br.com.sisacao.coletor.diario.legado;


import java.util.List;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.lib.dao.DaoI;

public interface CotacaoDiarioDaoBaseI
 extends DaoI { 
	public void insereItem( CotacaoDiario item )  throws  DaoException;
	public void insereItemCompleto( CotacaoDiario item )  throws  DaoException;
	public boolean insereSeNaoExiste( CotacaoDiario item )  throws  DaoException;
	public void insereItemLoad( CotacaoDiario item )  throws  DaoException;
	public void alteraItem( CotacaoDiario item )  throws  DaoException;
	public void excluiItem( CotacaoDiario item )  throws  DaoException;
	public CotacaoDiario obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CotacaoDiarioFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CotacaoDiarioFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
