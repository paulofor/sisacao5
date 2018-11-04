package br.com.digicom.cotacao.webservice;

public class DiaPregaoWSSoapProxy implements DiaPregaoWSSoap {
  private String _endpoint = null;
  private DiaPregaoWSSoap diaPregaoWSSoap = null;
  
  public DiaPregaoWSSoapProxy() {
    _initDiaPregaoWSSoapProxy();
  }
  
  public DiaPregaoWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initDiaPregaoWSSoapProxy();
  }
  
  private void _initDiaPregaoWSSoapProxy() {
    try {
      diaPregaoWSSoap = (new DiaPregaoWSLocator()).getDiaPregaoWSSoap();
      if (diaPregaoWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)diaPregaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)diaPregaoWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (diaPregaoWSSoap != null)
      ((javax.xml.rpc.Stub)diaPregaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public DiaPregaoWSSoap getDiaPregaoWSSoap() {
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap;
  }
  
  public DiaPregaoObjetoWs[] listaCorrente() throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.listaCorrente();
  }
  
  public DiaPregaoObjetoWs[] insereDiaPregao(DiaPregaoObjetoWs diaPregao, DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.insereDiaPregao(diaPregao, filtro);
  }
  
  public DiaPregaoObjetoWs[] alteraDiaPregao(DiaPregaoObjetoWs diaPregao, DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.alteraDiaPregao(diaPregao, filtro);
  }
  
  public DiaPregaoObjetoWs[] montaEstruturaCotacao(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.montaEstruturaCotacao(filtro);
  }
  
  public DiaPregaoObjetoWs obtemPorDiaPregaoData(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.obtemPorDiaPregaoData(filtro);
  }
  
  public DiaPregaoObjetoWs[] listaFeriado(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.listaFeriado(filtro);
  }
  
  public DiaPregaoObjetoWs[] alteraFeriado(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.alteraFeriado(filtro);
  }
  
  public DiaPregaoObjetoWs deslocaDias(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.deslocaDias(filtro);
  }
  
  public DiaPregaoObjetoWs[] listaErros15Minutos(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.listaErros15Minutos(filtro);
  }
  
  public DiaPregaoObjetoWs[] listaErrosDiario(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.listaErrosDiario(filtro);
  }
  
  public DiaPregaoObjetoWs[] listaNaoRelacionadaEmCotacaoProcessadaListaPossui(long idCotacaoProcessada) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.listaNaoRelacionadaEmCotacaoProcessadaListaPossui(idCotacaoProcessada);
  }
  
  public DiaPregaoObjetoWs[] listaPorFiltroObjeto(DiaPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.listaPorFiltroObjeto(filtro);
  }
  
  public DiaPregaoObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException{
    if (diaPregaoWSSoap == null)
      _initDiaPregaoWSSoapProxy();
    return diaPregaoWSSoap.obtemPorChave(id);
  }
  
  
}