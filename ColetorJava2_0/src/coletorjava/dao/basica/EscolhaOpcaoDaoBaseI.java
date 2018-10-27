package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface EscolhaOpcaoDaoBaseI
 extends DaoI { 
	public void insereItem( EscolhaOpcao item )  throws  DaoException;
	public void insereItemCompleto( EscolhaOpcao item )  throws  DaoException;
	public boolean insereSeNaoExiste( EscolhaOpcao item )  throws  DaoException;
	public void insereItemLoad( EscolhaOpcao item )  throws  DaoException;
	public void alteraItem( EscolhaOpcao item )  throws  DaoException;
	public void excluiItem( EscolhaOpcao item )  throws  DaoException;
	public EscolhaOpcao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( EscolhaOpcaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( EscolhaOpcaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorTickerReferenteA( long idItem )  throws  DaoException;
	public List ListaPorOpcaoSisacaoEscolha( long idItem )  throws  DaoException;
	public List ListaPorDiaPregaoReferenteA( long idItem )  throws  DaoException;



}
