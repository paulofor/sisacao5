package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface DiaPregaoDaoBaseI
 extends DaoI { 
	public void insereItem( DiaPregao item )  throws  DaoException;
	public void insereItemCompleto( DiaPregao item )  throws  DaoException;
	public boolean insereSeNaoExiste( DiaPregao item )  throws  DaoException;
	public void insereItemLoad( DiaPregao item )  throws  DaoException;
	public void alteraItem( DiaPregao item )  throws  DaoException;
	public void excluiItem( DiaPregao item )  throws  DaoException;
	public DiaPregao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( DiaPregaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( DiaPregaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmEscolhaOpcaoListaPossui( long idEscolhaOpcao )  throws  DaoException;
	public List ListaNaoRelacionadaEmOpcaoReferenciaListaPossui( long idOpcaoReferencia )  throws  DaoException;

}
