package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface OpcaoSisacaoGeralDaoBaseI
 extends DaoI { 
	public void insereItem( OpcaoSisacaoGeral item )  throws  DaoException;
	public void insereItemCompleto( OpcaoSisacaoGeral item )  throws  DaoException;
	public boolean insereSeNaoExiste( OpcaoSisacaoGeral item )  throws  DaoException;
	public void insereItemLoad( OpcaoSisacaoGeral item )  throws  DaoException;
	public void alteraItem( OpcaoSisacaoGeral item )  throws  DaoException;
	public void excluiItem( OpcaoSisacaoGeral item )  throws  DaoException;
	public OpcaoSisacaoGeral obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( OpcaoSisacaoGeralFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( OpcaoSisacaoGeralFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorTickerReferenteA( long idItem )  throws  DaoException;



}
