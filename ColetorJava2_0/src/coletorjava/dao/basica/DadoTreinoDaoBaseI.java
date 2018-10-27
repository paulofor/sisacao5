package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface DadoTreinoDaoBaseI
 extends DaoI { 
	public void insereItem( DadoTreino item )  throws  DaoException;
	public void insereItemCompleto( DadoTreino item )  throws  DaoException;
	public boolean insereSeNaoExiste( DadoTreino item )  throws  DaoException;
	public void insereItemLoad( DadoTreino item )  throws  DaoException;
	public void alteraItem( DadoTreino item )  throws  DaoException;
	public void excluiItem( DadoTreino item )  throws  DaoException;
	public DadoTreino obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( DadoTreinoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( DadoTreinoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProjetoDadoTreinoPossui( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmTreinoRedeListaGerou( long idTreinoRede )  throws  DaoException;

}
