/**
 * OpcaoSisacaoSerieTickerWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public interface OpcaoSisacaoSerieTickerWSSoap extends java.rmi.Remote {
    public OpcaoSisacaoSerieTickerObjetoWs[] listaCorrente() throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs[] insereOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs opcaoSisacaoSerieTicker, OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs[] alteraOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs opcaoSisacaoSerieTicker, OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs criaOpcaoSisacaoTicker(OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs[] alteracaoLoteOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs[] listaInsercao, OpcaoSisacaoSerieTickerObjetoWs[] listaRemocao, int codigoPerfil, int codigoParaRetorno) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs[] listaPorTickerReferenteA(long idItem) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs[] listaPorOpcaoSisacaoSerieReferenteA(long idItem) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException;
    public OpcaoSisacaoSerieTickerObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException;
}
