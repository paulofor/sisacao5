package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface PeriodoPregaoDaoBaseI
 extends DaoI { 
	public void insereItem( PeriodoPregao item )  throws  DaoException;
	public void insereItemCompleto( PeriodoPregao item )  throws  DaoException;
	public boolean insereSeNaoExiste( PeriodoPregao item )  throws  DaoException;
	public void insereItemLoad( PeriodoPregao item )  throws  DaoException;
	public void alteraItem( PeriodoPregao item )  throws  DaoException;
	public void excluiItem( PeriodoPregao item )  throws  DaoException;
	public PeriodoPregao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( PeriodoPregaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( PeriodoPregaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
