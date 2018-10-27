package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface ResultadoMesDaoBaseI
 extends DaoI { 
	public void insereItem( ResultadoMes item )  throws  DaoException;
	public void insereItemCompleto( ResultadoMes item )  throws  DaoException;
	public boolean insereSeNaoExiste( ResultadoMes item )  throws  DaoException;
	public void insereItemLoad( ResultadoMes item )  throws  DaoException;
	public void alteraItem( ResultadoMes item )  throws  DaoException;
	public void excluiItem( ResultadoMes item )  throws  DaoException;
	public ResultadoMes obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ResultadoMesFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ResultadoMesFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorProjetoDadoTreinoGeradoPor( long idItem )  throws  DaoException;
	public List ListaPorMesAnoReferenteA( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmResultadoPrevisaoListaSemelhante( long idResultadoPrevisao )  throws  DaoException;

}
