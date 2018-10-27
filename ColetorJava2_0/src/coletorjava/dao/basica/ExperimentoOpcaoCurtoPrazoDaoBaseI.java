package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface ExperimentoOpcaoCurtoPrazoDaoBaseI
 extends DaoI { 
	public void insereItem( ExperimentoOpcaoCurtoPrazo item )  throws  DaoException;
	public void insereItemCompleto( ExperimentoOpcaoCurtoPrazo item )  throws  DaoException;
	public boolean insereSeNaoExiste( ExperimentoOpcaoCurtoPrazo item )  throws  DaoException;
	public void insereItemLoad( ExperimentoOpcaoCurtoPrazo item )  throws  DaoException;
	public void alteraItem( ExperimentoOpcaoCurtoPrazo item )  throws  DaoException;
	public void excluiItem( ExperimentoOpcaoCurtoPrazo item )  throws  DaoException;
	public ExperimentoOpcaoCurtoPrazo obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( ExperimentoOpcaoCurtoPrazoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( ExperimentoOpcaoCurtoPrazoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;




}
