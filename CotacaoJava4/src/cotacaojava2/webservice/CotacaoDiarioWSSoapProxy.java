package cotacaojava2.webservice;

public class CotacaoDiarioWSSoapProxy implements CotacaoDiarioWSSoap {
  private String _endpoint = null;
  private CotacaoDiarioWSSoap cotacaoDiarioWSSoap = null;
  
  public CotacaoDiarioWSSoapProxy() {
    _initCotacaoDiarioWSSoapProxy();
  }
  
  public CotacaoDiarioWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initCotacaoDiarioWSSoapProxy();
  }
  
  private void _initCotacaoDiarioWSSoapProxy() {
    try {
      cotacaoDiarioWSSoap = (new CotacaoDiarioWSLocator()).getCotacaoDiarioWSSoap();
      if (cotacaoDiarioWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)cotacaoDiarioWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)cotacaoDiarioWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (cotacaoDiarioWSSoap != null)
      ((javax.xml.rpc.Stub)cotacaoDiarioWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public CotacaoDiarioWSSoap getCotacaoDiarioWSSoap() {
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap;
  }
  
  public CotacaoDiarioObjetoWs[] listaCorrente() throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.listaCorrente();
  }
  
  public CotacaoDiarioObjetoWs[] insereCotacaoDiario(CotacaoDiarioObjetoWs cotacaoDiario, CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.insereCotacaoDiario(cotacaoDiario, filtro);
  }
  
  public CotacaoDiarioObjetoWs[] alteraCotacaoDiario(CotacaoDiarioObjetoWs cotacaoDiario, CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.alteraCotacaoDiario(cotacaoDiario, filtro);
  }
  
  public CotacaoDiarioObjetoWs insereCotacaoDia(CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.insereCotacaoDia(filtro);
  }
  
  public CotacaoDiarioObjetoWs obtemCotacaoDia(CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.obtemCotacaoDia(filtro);
  }
  
  public CotacaoDiarioObjetoWs[] listaPorFiltroObjeto(CotacaoDiarioFiltro filtro) throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.listaPorFiltroObjeto(filtro);
  }
  
  public CotacaoDiarioObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException{
    if (cotacaoDiarioWSSoap == null)
      _initCotacaoDiarioWSSoapProxy();
    return cotacaoDiarioWSSoap.obtemPorChave(id);
  }
  
  
}