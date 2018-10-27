package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface MesAnoDaoBaseI
 extends DaoI { 
	public void insereItem( MesAno item )  throws  DaoException;
	public void insereItemCompleto( MesAno item )  throws  DaoException;
	public boolean insereSeNaoExiste( MesAno item )  throws  DaoException;
	public void insereItemLoad( MesAno item )  throws  DaoException;
	public void alteraItem( MesAno item )  throws  DaoException;
	public void excluiItem( MesAno item )  throws  DaoException;
	public MesAno obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( MesAnoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( MesAnoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmResultadoPrevisaoListaGera( long idResultadoPrevisao )  throws  DaoException;
	public List ListaNaoRelacionadaEmResultadoMesListaBasePara( long idResultadoMes )  throws  DaoException;

}
