/**
 * OpcaoSisacaoWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public interface OpcaoSisacaoWSSoap extends java.rmi.Remote {
    public OpcaoSisacaoObjetoWs[] listaCorrente() throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] insereOpcaoSisacao(OpcaoSisacaoObjetoWs opcaoSisacao, OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] alteraOpcaoSisacao(OpcaoSisacaoObjetoWs opcaoSisacao, OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] listaAtivoOpcao(OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] listaAtivoAnoComSerie(OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] listaPorTickerDerivativoDe(long idItem) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] listaPorOpcaoSisacaoSeriePertenceA(long idItem) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException;
}
