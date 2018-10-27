package sisacaoweb2online.webservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface TickerWSSoap
  extends Remote
{
  public abstract TickerObjetoWs[] listaCorrente()
    throws RemoteException;
  
  public abstract TickerObjetoWs[] insereTicker(TickerObjetoWs paramTickerObjetoWs, TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] alteraTicker(TickerObjetoWs paramTickerObjetoWs, TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaAtivoOpcao(TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs obtemPorNomeTicker(TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaAtivo(TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaDiarioOnline(TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaNaoRelacionadaEmCombinacaoExecucaoCompraListaGerou(long paramLong)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaNaoRelacionadaEmSplitListaPossui(long paramLong)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoListaGera(long paramLong)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaNaoRelacionadaEmOpcaoSisacaoSerieTickerListaRelacionadoCom(long paramLong)
    throws RemoteException;
  
  public abstract TickerObjetoWs[] listaPorFiltroObjeto(TickerFiltro paramTickerFiltro)
    throws RemoteException;
  
  public abstract TickerObjetoWs obtemPorChave(long paramLong)
    throws RemoteException;
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.TickerWSSoap
 * JD-Core Version:    0.7.0.1
 */