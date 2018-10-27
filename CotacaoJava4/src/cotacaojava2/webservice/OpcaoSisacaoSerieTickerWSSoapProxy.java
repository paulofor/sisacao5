package cotacaojava2.webservice;

public class OpcaoSisacaoSerieTickerWSSoapProxy implements OpcaoSisacaoSerieTickerWSSoap {
  private String _endpoint = null;
  private OpcaoSisacaoSerieTickerWSSoap opcaoSisacaoSerieTickerWSSoap = null;
  
  public OpcaoSisacaoSerieTickerWSSoapProxy() {
    _initOpcaoSisacaoSerieTickerWSSoapProxy();
  }
  
  public OpcaoSisacaoSerieTickerWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initOpcaoSisacaoSerieTickerWSSoapProxy();
  }
  
  private void _initOpcaoSisacaoSerieTickerWSSoapProxy() {
    try {
      opcaoSisacaoSerieTickerWSSoap = (new OpcaoSisacaoSerieTickerWSLocator()).getOpcaoSisacaoSerieTickerWSSoap();
      if (opcaoSisacaoSerieTickerWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)opcaoSisacaoSerieTickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)opcaoSisacaoSerieTickerWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (opcaoSisacaoSerieTickerWSSoap != null)
      ((javax.xml.rpc.Stub)opcaoSisacaoSerieTickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap() {
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap;
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] listaCorrente() throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.listaCorrente();
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] insereOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs opcaoSisacaoSerieTicker, OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.insereOpcaoSisacaoSerieTicker(opcaoSisacaoSerieTicker, filtro);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] alteraOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs opcaoSisacaoSerieTicker, OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.alteraOpcaoSisacaoSerieTicker(opcaoSisacaoSerieTicker, filtro);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs criaOpcaoSisacaoTicker(OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.criaOpcaoSisacaoTicker(filtro);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] alteracaoLoteOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs[] listaInsercao, OpcaoSisacaoSerieTickerObjetoWs[] listaRemocao, int codigoPerfil, int codigoParaRetorno) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.alteracaoLoteOpcaoSisacaoSerieTicker(listaInsercao, listaRemocao, codigoPerfil, codigoParaRetorno);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] listaPorTickerReferenteA(long idItem) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.listaPorTickerReferenteA(idItem);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] listaPorOpcaoSisacaoSerieReferenteA(long idItem) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.listaPorOpcaoSisacaoSerieReferenteA(idItem);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoSerieTickerFiltro filtro) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.listaPorFiltroObjeto(filtro);
  }
  
  public OpcaoSisacaoSerieTickerObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException{
    if (opcaoSisacaoSerieTickerWSSoap == null)
      _initOpcaoSisacaoSerieTickerWSSoapProxy();
    return opcaoSisacaoSerieTickerWSSoap.obtemPorChave(id);
  }
  
  
}