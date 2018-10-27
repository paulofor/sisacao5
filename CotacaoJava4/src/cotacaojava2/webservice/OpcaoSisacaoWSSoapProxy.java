package cotacaojava2.webservice;

public class OpcaoSisacaoWSSoapProxy implements OpcaoSisacaoWSSoap {
  private String _endpoint = null;
  private OpcaoSisacaoWSSoap opcaoSisacaoWSSoap = null;
  
  public OpcaoSisacaoWSSoapProxy() {
    _initOpcaoSisacaoWSSoapProxy();
  }
  
  public OpcaoSisacaoWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initOpcaoSisacaoWSSoapProxy();
  }
  
  private void _initOpcaoSisacaoWSSoapProxy() {
    try {
      opcaoSisacaoWSSoap = (new OpcaoSisacaoWSLocator()).getOpcaoSisacaoWSSoap();
      if (opcaoSisacaoWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)opcaoSisacaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)opcaoSisacaoWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (opcaoSisacaoWSSoap != null)
      ((javax.xml.rpc.Stub)opcaoSisacaoWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public OpcaoSisacaoWSSoap getOpcaoSisacaoWSSoap() {
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap;
  }
  
  public OpcaoSisacaoObjetoWs[] listaCorrente() throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.listaCorrente();
  }
  
  public OpcaoSisacaoObjetoWs[] insereOpcaoSisacao(OpcaoSisacaoObjetoWs opcaoSisacao, OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.insereOpcaoSisacao(opcaoSisacao, filtro);
  }
  
  public OpcaoSisacaoObjetoWs[] alteraOpcaoSisacao(OpcaoSisacaoObjetoWs opcaoSisacao, OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.alteraOpcaoSisacao(opcaoSisacao, filtro);
  }
  
  public OpcaoSisacaoObjetoWs[] listaAtivoOpcao(OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.listaAtivoOpcao(filtro);
  }
  
  public OpcaoSisacaoObjetoWs[] listaAtivoAnoComSerie(OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.listaAtivoAnoComSerie(filtro);
  }
  
  public OpcaoSisacaoObjetoWs[] listaPorTickerDerivativoDe(long idItem) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.listaPorTickerDerivativoDe(idItem);
  }
  
  public OpcaoSisacaoObjetoWs[] listaPorOpcaoSisacaoSeriePertenceA(long idItem) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.listaPorOpcaoSisacaoSeriePertenceA(idItem);
  }
  
  public OpcaoSisacaoObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.listaPorFiltroObjeto(filtro);
  }
  
  public OpcaoSisacaoObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException{
    if (opcaoSisacaoWSSoap == null)
      _initOpcaoSisacaoWSSoapProxy();
    return opcaoSisacaoWSSoap.obtemPorChave(id);
  }
  
  
}