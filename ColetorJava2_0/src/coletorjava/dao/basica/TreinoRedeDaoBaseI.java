package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface TreinoRedeDaoBaseI
 extends DaoI { 
	public void insereItem( TreinoRede item )  throws  DaoException;
	public void insereItemCompleto( TreinoRede item )  throws  DaoException;
	public boolean insereSeNaoExiste( TreinoRede item )  throws  DaoException;
	public void insereItemLoad( TreinoRede item )  throws  DaoException;
	public void alteraItem( TreinoRede item )  throws  DaoException;
	public void excluiItem( TreinoRede item )  throws  DaoException;
	public TreinoRede obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( TreinoRedeFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( TreinoRedeFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorRedePertenceA( long idItem )  throws  DaoException;
	public List ListaPorDadoTreinoGeradoPor( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmDadoThetaListaResultado( long idDadoTheta )  throws  DaoException;

}
