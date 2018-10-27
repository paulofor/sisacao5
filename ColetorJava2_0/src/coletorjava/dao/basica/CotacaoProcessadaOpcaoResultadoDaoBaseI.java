package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface CotacaoProcessadaOpcaoResultadoDaoBaseI
 extends DaoI { 
	public void insereItem( CotacaoProcessadaOpcaoResultado item )  throws  DaoException;
	public void insereItemCompleto( CotacaoProcessadaOpcaoResultado item )  throws  DaoException;
	public boolean insereSeNaoExiste( CotacaoProcessadaOpcaoResultado item )  throws  DaoException;
	public void insereItemLoad( CotacaoProcessadaOpcaoResultado item )  throws  DaoException;
	public void alteraItem( CotacaoProcessadaOpcaoResultado item )  throws  DaoException;
	public void excluiItem( CotacaoProcessadaOpcaoResultado item )  throws  DaoException;
	public CotacaoProcessadaOpcaoResultado obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( CotacaoProcessadaOpcaoResultadoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( CotacaoProcessadaOpcaoResultadoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorOpcaoSisacaoReferenteA( long idItem )  throws  DaoException;



}
