package sisacaoweb2online.webservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface OpcaoSisacaoSerieTickerWSSoap
  extends Remote
{
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] listaCorrente()
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] insereOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs paramOpcaoSisacaoSerieTickerObjetoWs, OpcaoSisacaoSerieTickerFiltro paramOpcaoSisacaoSerieTickerFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] alteraOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs paramOpcaoSisacaoSerieTickerObjetoWs, OpcaoSisacaoSerieTickerFiltro paramOpcaoSisacaoSerieTickerFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs criaOpcaoSisacaoTicker(OpcaoSisacaoSerieTickerFiltro paramOpcaoSisacaoSerieTickerFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] alteracaoLoteOpcaoSisacaoSerieTicker(OpcaoSisacaoSerieTickerObjetoWs[] paramArrayOfOpcaoSisacaoSerieTickerObjetoWs1, OpcaoSisacaoSerieTickerObjetoWs[] paramArrayOfOpcaoSisacaoSerieTickerObjetoWs2, int paramInt1, int paramInt2)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] listaPorTickerReferenteA(long paramLong)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] listaPorOpcaoSisacaoSerieReferenteA(long paramLong)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoSerieTickerFiltro paramOpcaoSisacaoSerieTickerFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoSerieTickerObjetoWs obtemPorChave(long paramLong)
    throws RemoteException;
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerWSSoap
 * JD-Core Version:    0.7.0.1
 */