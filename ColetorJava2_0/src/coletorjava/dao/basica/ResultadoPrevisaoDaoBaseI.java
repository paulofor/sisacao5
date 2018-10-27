package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface ResultadoPrevisaoDaoBaseI
 extends DaoI { 
	public void insereItem( ResultadoPrevisao item )  throws  DaoException;
	public void insereItemCompleto( ResultadoPrevisao item )  throws  DaoException;
	public boolean insereSeNaoExiste( ResultadoPrevisao item )  throws  DaoException;
	public void insereItemLoad( ResultadoPrevisao item )  throws  DaoException;
	public void alteraItem( ResultadoPrevisao item )  throws  DaoException;
	public void excluiItem( ResultadoPrevisao item )  throws  DaoException;
	public ResultadoPrevisao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ResultadoPrevisaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ResultadoPrevisaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorDadoThetaGeradoDe( long idItem )  throws  DaoException;
	public List ListaPorResultadoMesMesmoPeriodo( long idItem )  throws  DaoException;
	public List ListaPorMesAnoReferenteA( long idItem )  throws  DaoException;



}
