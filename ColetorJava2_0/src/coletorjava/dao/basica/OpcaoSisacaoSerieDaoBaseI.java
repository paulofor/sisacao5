package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface OpcaoSisacaoSerieDaoBaseI
 extends DaoI { 
	public void insereItem( OpcaoSisacaoSerie item )  throws  DaoException;
	public void insereItemCompleto( OpcaoSisacaoSerie item )  throws  DaoException;
	public boolean insereSeNaoExiste( OpcaoSisacaoSerie item )  throws  DaoException;
	public void insereItemLoad( OpcaoSisacaoSerie item )  throws  DaoException;
	public void alteraItem( OpcaoSisacaoSerie item )  throws  DaoException;
	public void excluiItem( OpcaoSisacaoSerie item )  throws  DaoException;
	public OpcaoSisacaoSerie obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( OpcaoSisacaoSerieFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( OpcaoSisacaoSerieFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;



	public List ListaNaoRelacionadaEmOpcaoSisacaoListaPossui( long idOpcaoSisacao )  throws  DaoException;

}
