package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface RedeDaoBaseI
 extends DaoI { 
	public void insereItem( Rede item )  throws  DaoException;
	public void insereItemCompleto( Rede item )  throws  DaoException;
	public boolean insereSeNaoExiste( Rede item )  throws  DaoException;
	public void insereItemLoad( Rede item )  throws  DaoException;
	public void alteraItem( Rede item )  throws  DaoException;
	public void excluiItem( Rede item )  throws  DaoException;
	public Rede obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( RedeFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( RedeFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmTreinoRedeListaGerou( long idTreinoRede )  throws  DaoException;

}
