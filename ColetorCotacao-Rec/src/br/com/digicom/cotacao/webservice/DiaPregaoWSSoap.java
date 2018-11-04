/**
 * DiaPregaoWSSoap.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package br.com.digicom.cotacao.webservice;

public interface DiaPregaoWSSoap extends java.rmi.Remote {
    public DiaPregaoObjetoWs[] listaCorrente() throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] insereDiaPregao(DiaPregaoObjetoWs diaPregao, DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] alteraDiaPregao(DiaPregaoObjetoWs diaPregao, DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] montaEstruturaCotacao(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs obtemPorDiaPregaoData(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] listaFeriado(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] alteraFeriado(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs deslocaDias(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] listaErros15Minutos(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] listaErrosDiario(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] listaNaoRelacionadaEmCotacaoProcessadaListaPossui(long idCotacaoProcessada) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs[] listaPorFiltroObjeto(DiaPregaoFiltro filtro) throws java.rmi.RemoteException;
    public DiaPregaoObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException;
}
