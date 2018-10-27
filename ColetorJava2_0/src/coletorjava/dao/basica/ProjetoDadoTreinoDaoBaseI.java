package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface ProjetoDadoTreinoDaoBaseI
 extends DaoI { 
	public void insereItem( ProjetoDadoTreino item )  throws  DaoException;
	public void insereItemCompleto( ProjetoDadoTreino item )  throws  DaoException;
	public boolean insereSeNaoExiste( ProjetoDadoTreino item )  throws  DaoException;
	public void insereItemLoad( ProjetoDadoTreino item )  throws  DaoException;
	public void alteraItem( ProjetoDadoTreino item )  throws  DaoException;
	public void excluiItem( ProjetoDadoTreino item )  throws  DaoException;
	public ProjetoDadoTreino obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ProjetoDadoTreinoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ProjetoDadoTreinoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorTickerReferenteA( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmDadoTreinoListaGerou( long idDadoTreino )  throws  DaoException;
	public List ListaNaoRelacionadaEmResultadoMesListaGerou( long idResultadoMes )  throws  DaoException;

}
