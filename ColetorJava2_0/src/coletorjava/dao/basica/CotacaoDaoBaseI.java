package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface CotacaoDaoBaseI
 extends DaoI { 
	public void insereItem( Cotacao item )  throws  DaoException;
	public void insereItemCompleto( Cotacao item )  throws  DaoException;
	public boolean insereSeNaoExiste( Cotacao item )  throws  DaoException;
	public void insereItemLoad( Cotacao item )  throws  DaoException;
	public void alteraItem( Cotacao item )  throws  DaoException;
	public void excluiItem( Cotacao item )  throws  DaoException;
	public Cotacao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CotacaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CotacaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
