package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface UsuarioDaoBaseI
 extends DaoI { 
	public void insereItem( Usuario item )  throws  DaoException;
	public void insereItemCompleto( Usuario item )  throws  DaoException;
	public boolean insereSeNaoExiste( Usuario item )  throws  DaoException;
	public void insereItemLoad( Usuario item )  throws  DaoException;
	public void alteraItem( Usuario item )  throws  DaoException;
	public void excluiItem( Usuario item )  throws  DaoException;
	public Usuario obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( UsuarioFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( UsuarioFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmDispositivoUsuarioListaUsa( long idDispositivoUsuario )  throws  DaoException;

}
