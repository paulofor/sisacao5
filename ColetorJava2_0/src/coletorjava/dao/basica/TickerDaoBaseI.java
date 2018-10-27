package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface TickerDaoBaseI
 extends DaoI { 
	public void insereItem( Ticker item )  throws  DaoException;
	public void insereItemCompleto( Ticker item )  throws  DaoException;
	public boolean insereSeNaoExiste( Ticker item )  throws  DaoException;
	public void insereItemLoad( Ticker item )  throws  DaoException;
	public void alteraItem( Ticker item )  throws  DaoException;
	public void excluiItem( Ticker item )  throws  DaoException;
	public Ticker obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( TickerFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( TickerFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmOpcaoSisacaoGeralListaPossui( long idOpcaoSisacaoGeral )  throws  DaoException;
	public List ListaNaoRelacionadaEmOpcaoSisacaoListaGera( long idOpcaoSisacao )  throws  DaoException;
	public List ListaNaoRelacionadaEmEscolhaOpcaoListaPossui( long idEscolhaOpcao )  throws  DaoException;
	public List ListaNaoRelacionadaEmProjetoDadoTreinoListaGera( long idProjetoDadoTreino )  throws  DaoException;
	public List ListaNaoRelacionadaEmOpcaoReferenciaListaPossui( long idOpcaoReferencia )  throws  DaoException;

}
