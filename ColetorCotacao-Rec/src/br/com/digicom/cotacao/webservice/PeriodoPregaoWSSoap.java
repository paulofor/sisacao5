/**
 * PeriodoPregaoWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.digicom.cotacao.webservice;

public interface PeriodoPregaoWSSoap extends java.rmi.Remote {
    public PeriodoPregaoObjetoWs[] listaCorrente() throws java.rmi.RemoteException;
    public PeriodoPregaoObjetoWs[] inserePeriodoPregao(PeriodoPregaoObjetoWs periodoPregao, PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException;
    public PeriodoPregaoObjetoWs[] alteraPeriodoPregao(PeriodoPregaoObjetoWs periodoPregao, PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException;
    public PeriodoPregaoObjetoWs pesquisaPorDia(PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException;
    public PeriodoPregaoObjetoWs[] listaPorFiltroObjeto(PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException;
    public PeriodoPregaoObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException;
}
