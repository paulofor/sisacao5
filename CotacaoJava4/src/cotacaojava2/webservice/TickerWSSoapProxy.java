package cotacaojava2.webservice;

public class TickerWSSoapProxy implements TickerWSSoap {
  private String _endpoint = null;
  private TickerWSSoap tickerWSSoap = null;
  
  public TickerWSSoapProxy() {
    _initTickerWSSoapProxy();
  }
  
  public TickerWSSoapProxy(String endpoint) {
    _endpoint = endpoint;
    _initTickerWSSoapProxy();
  }
  
  private void _initTickerWSSoapProxy() {
    try {
      tickerWSSoap = (new TickerWSLocator()).getTickerWSSoap();
      if (tickerWSSoap != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)tickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)tickerWSSoap)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (tickerWSSoap != null)
      ((javax.xml.rpc.Stub)tickerWSSoap)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public TickerWSSoap getTickerWSSoap() {
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap;
  }
  
  public TickerObjetoWs[] listaCorrente() throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaCorrente();
  }
  
  public TickerObjetoWs[] insereTicker(TickerObjetoWs ticker, TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.insereTicker(ticker, filtro);
  }
  
  public TickerObjetoWs[] alteraTicker(TickerObjetoWs ticker, TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.alteraTicker(ticker, filtro);
  }
  
  public TickerObjetoWs[] listaAtivoOpcao(TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaAtivoOpcao(filtro);
  }
  
  public TickerObjetoWs obtemPorNomeTicker(TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.obtemPorNomeTicker(filtro);
  }
  
  public TickerObjetoWs[] listaAtivo(TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaAtivo(filtro);
  }
  
  public TickerObjetoWs[] listaDiarioOnline(TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaDiarioOnline(filtro);
  }
  
  public TickerObjetoWs[] listaNaoRelacionadaEmCombinacaoExecucaoCompraListaGerou(long idCombinacaoExecucaoCompra) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaNaoRelacionadaEmCombinacaoExecucaoCompraListaGerou(idCombinacaoExecucaoCompra);
  }
  
  public TickerObjetoWs[] listaNaoRelacionadaEmSplitListaPossui(long idSplit) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaNaoRelacionadaEmSplitListaPossui(idSplit);
  }
  
  public TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoListaGera(long idOpcaoSisacao) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaNaoRelacionadaEmOpcaoSisacaoListaGera(idOpcaoSisacao);
  }
  
  public TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoSerieTickerListaRelacionadoCom(long idOpcaoSisacaoSerie) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaNaoRelacionadaEmOpcaoSisacaoSerieTickerListaRelacionadoCom(idOpcaoSisacaoSerie);
  }
  
  public TickerObjetoWs[] listaPorFiltroObjeto(TickerFiltro filtro) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.listaPorFiltroObjeto(filtro);
  }
  
  public TickerObjetoWs obtemPorChave(long id) throws java.rmi.RemoteException{
    if (tickerWSSoap == null)
      _initTickerWSSoapProxy();
    return tickerWSSoap.obtemPorChave(id);
  }
  
  
}