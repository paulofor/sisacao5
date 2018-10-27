/**
 * CotacaoDiarioWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package cotacaojava2.webservice;

public interface CotacaoDiarioWSSoap extends java.rmi.Remote {
    public CotacaoDiarioObjetoWs[] listaCorrente() throws java.rmi.RemoteException;
    public CotacaoDiarioObjetoWs[] insereCotacaoDiario(CotacaoDiarioObjetoWs cotacaoDiario, CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException;
    public CotacaoDiarioObjetoWs[] alteraCotacaoDiario(CotacaoDiarioObjetoWs cotacaoDiario, CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException;
    public CotacaoDiarioObjetoWs insereCotacaoDia(CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException;
    public CotacaoDiarioObjetoWs obtemCotacaoDia(CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException;
    public CotacaoDiarioObjetoWs[] listaPorFiltroObjeto(CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException;
    public CotacaoDiarioObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException;
}
