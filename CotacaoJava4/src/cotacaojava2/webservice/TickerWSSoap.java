/**
 * TickerWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public interface TickerWSSoap extends java.rmi.Remote {
    public TickerObjetoWs[] listaCorrente() throws java.rmi.RemoteException;
    public TickerObjetoWs[] insereTicker(TickerObjetoWs ticker, TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs[] alteraTicker(TickerObjetoWs ticker, TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaAtivoOpcao(TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs obtemPorNomeTicker(TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaAtivo(TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaDiarioOnline(TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaNaoRelacionadaEmCombinacaoExecucaoCompraListaGerou(long idCombinacaoExecucaoCompra) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaNaoRelacionadaEmSplitListaPossui(long idSplit) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoListaGera(long idOpcaoSisacao) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoSerieTickerListaRelacionadoCom(long idOpcaoSisacaoSerie) throws java.rmi.RemoteException;
    public TickerObjetoWs[] listaPorFiltroObjeto(TickerFiltro filtro) throws java.rmi.RemoteException;
    public TickerObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException;
}
