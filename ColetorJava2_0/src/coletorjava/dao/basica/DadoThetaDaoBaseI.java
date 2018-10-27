package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface DadoThetaDaoBaseI
 extends DaoI { 
	public void insereItem( DadoTheta item )  throws  DaoException;
	public void insereItemCompleto( DadoTheta item )  throws  DaoException;
	public boolean insereSeNaoExiste( DadoTheta item )  throws  DaoException;
	public void insereItemLoad( DadoTheta item )  throws  DaoException;
	public void alteraItem( DadoTheta item )  throws  DaoException;
	public void excluiItem( DadoTheta item )  throws  DaoException;
	public DadoTheta obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( DadoThetaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( DadoThetaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorTreinoRedeGeradoPor( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmResultadoPrevisaoListaGera( long idResultadoPrevisao )  throws  DaoException;

}
