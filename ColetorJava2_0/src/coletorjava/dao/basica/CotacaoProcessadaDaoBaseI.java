package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface CotacaoProcessadaDaoBaseI
 extends DaoI { 
	public void insereItem( CotacaoProcessada item )  throws  DaoException;
	public void insereItemCompleto( CotacaoProcessada item )  throws  DaoException;
	public boolean insereSeNaoExiste( CotacaoProcessada item )  throws  DaoException;
	public void insereItemLoad( CotacaoProcessada item )  throws  DaoException;
	public void alteraItem( CotacaoProcessada item )  throws  DaoException;
	public void excluiItem( CotacaoProcessada item )  throws  DaoException;
	public CotacaoProcessada obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CotacaoProcessadaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CotacaoProcessadaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
