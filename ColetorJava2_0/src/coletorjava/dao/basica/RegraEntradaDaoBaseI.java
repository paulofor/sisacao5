package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface RegraEntradaDaoBaseI
 extends DaoI { 
	public void insereItem( RegraEntrada item )  throws  DaoException;
	public void insereItemCompleto( RegraEntrada item )  throws  DaoException;
	public boolean insereSeNaoExiste( RegraEntrada item )  throws  DaoException;
	public void insereItemLoad( RegraEntrada item )  throws  DaoException;
	public void alteraItem( RegraEntrada item )  throws  DaoException;
	public void excluiItem( RegraEntrada item )  throws  DaoException;
	public RegraEntrada obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( RegraEntradaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( RegraEntradaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
