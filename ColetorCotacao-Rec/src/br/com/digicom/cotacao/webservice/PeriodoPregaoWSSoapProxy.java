package br.com.digicom.cotacao.webservice;

public class PeriodoPregaoWSSoapProxy implements PeriodoPregaoWSSoap {
  private String _endpoint = null;
  private PeriodoPregaoWSSoap periodoPregaoWSSoap = null;
  
  public PeriodoPregaoWSSoapProxy() {
    _initPeriodoPregaoWSSoapProxy();
  }
  
  public PeriodoPregaoWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initPeriodoPregaoWSSoapProxy();
  }
  
  private void _initPeriodoPregaoWSSoapProxy() {
    try {
      periodoPregaoWSSoap = (new PeriodoPregaoWSLocator()).getPeriodoPregaoWSSoap();
      if (periodoPregaoWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)periodoPregaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)periodoPregaoWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (periodoPregaoWSSoap != null)
      ((javax.xml.rpc.Stub)periodoPregaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public PeriodoPregaoWSSoap getPeriodoPregaoWSSoap() {
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap;
  }
  
  public PeriodoPregaoObjetoWs[] listaCorrente() throws java.rmi.RemoteException{
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap.listaCorrente();
  }
  
  public PeriodoPregaoObjetoWs[] inserePeriodoPregao(PeriodoPregaoObjetoWs periodoPregao, PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap.inserePeriodoPregao(periodoPregao, filtro);
  }
  
  public PeriodoPregaoObjetoWs[] alteraPeriodoPregao(PeriodoPregaoObjetoWs periodoPregao, PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap.alteraPeriodoPregao(periodoPregao, filtro);
  }
  
  public PeriodoPregaoObjetoWs pesquisaPorDia(PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap.pesquisaPorDia(filtro);
  }
  
  public PeriodoPregaoObjetoWs[] listaPorFiltroObjeto(PeriodoPregaoFiltro filtro) throws java.rmi.RemoteException{
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap.listaPorFiltroObjeto(filtro);
  }
  
  public PeriodoPregaoObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException{
    if (periodoPregaoWSSoap == null)
      _initPeriodoPregaoWSSoapProxy();
    return periodoPregaoWSSoap.obtemPorChave(id);
  }
  
  
}