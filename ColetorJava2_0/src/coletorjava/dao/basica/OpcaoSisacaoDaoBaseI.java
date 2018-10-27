package coletorjava.dao.basica;


import java.util.*;
import br.com.digicom.lib.dao.*;
import br.com.digicom.lib.*;
import br.com.digicom.lib.util.*;


import coletorjava.modelo.*;
import coletorjava.dao.*;
import coletorjava.regracolecao.filtro.*;

public interface OpcaoSisacaoDaoBaseI
 extends DaoI { 
	public void insereItem( OpcaoSisacao item )  throws  DaoException;
	public void insereItemCompleto( OpcaoSisacao item )  throws  DaoException;
	public boolean insereSeNaoExiste( OpcaoSisacao item )  throws  DaoException;
	public void insereItemLoad( OpcaoSisacao item )  throws  DaoException;
	public void alteraItem( OpcaoSisacao item )  throws  DaoException;
	public void excluiItem( OpcaoSisacao item )  throws  DaoException;
	public OpcaoSisacao obtemPorChave( long item )  throws  DaoException;
	public List ListaFiltro( OpcaoSisacaoFiltro filtro )  throws  DaoException;
	public List ListaFiltroSimples( OpcaoSisacaoFiltro filtro )  throws  DaoException;
	public List ListaCorrente()  throws  DaoException;
	public List ListaCorrenteAgrupada()  throws  DaoException;

	public List ListaPorOpcaoSisacaoSeriePertenceA( long idItem )  throws  DaoException;
	public List ListaPorTickerDerivativoDe( long idItem )  throws  DaoException;


	public List ListaNaoRelacionadaEmEscolhaOpcaoListaEscolhida( long idEscolhaOpcao )  throws  DaoException;
	public List ListaNaoRelacionadaEmCotacaoProcessadaOpcaoResultadoListaEstaEm( long idCotacaoProcessadaOpcaoResultado )  throws  DaoException;
	public List ListaNaoRelacionadaEmOpcaoReferenciaListaPossui( long idOpcaoReferencia )  throws  DaoException;

}
