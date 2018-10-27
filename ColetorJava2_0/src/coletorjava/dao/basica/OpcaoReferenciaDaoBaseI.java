package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface OpcaoReferenciaDaoBaseI
 extends DaoI { 
	public void insereItem( OpcaoReferencia item )  throws  DaoException;
	public void insereItemCompleto( OpcaoReferencia item )  throws  DaoException;
	public boolean insereSeNaoExiste( OpcaoReferencia item )  throws  DaoException;
	public void insereItemLoad( OpcaoReferencia item )  throws  DaoException;
	public void alteraItem( OpcaoReferencia item )  throws  DaoException;
	public void excluiItem( OpcaoReferencia item )  throws  DaoException;
	public OpcaoReferencia obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( OpcaoReferenciaFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( OpcaoReferenciaFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorTickerReferenteA( long idItem )  throws  DaoException;
	public List ListaPorDiaPregaoReferenteA( long idItem )  throws  DaoException;
	public List ListaPorOpcaoSisacaoReferenteA( long idItem )  throws  DaoException;



}
