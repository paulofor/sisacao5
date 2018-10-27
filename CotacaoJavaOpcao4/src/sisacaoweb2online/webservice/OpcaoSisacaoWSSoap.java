package sisacaoweb2online.webservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

public abstract interface OpcaoSisacaoWSSoap
  extends Remote
{
  public abstract OpcaoSisacaoObjetoWs[] listaCorrente()
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] insereOpcaoSisacao(OpcaoSisacaoObjetoWs paramOpcaoSisacaoObjetoWs, OpcaoSisacaoFiltro paramOpcaoSisacaoFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] alteraOpcaoSisacao(OpcaoSisacaoObjetoWs paramOpcaoSisacaoObjetoWs, OpcaoSisacaoFiltro paramOpcaoSisacaoFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] listaAtivoOpcao(OpcaoSisacaoFiltro paramOpcaoSisacaoFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] listaAtivoAnoComSerie(OpcaoSisacaoFiltro paramOpcaoSisacaoFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] listaPorTickerDerivativoDe(long paramLong)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] listaPorOpcaoSisacaoSeriePertenceA(long paramLong)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs[] listaPorFiltroObjeto(OpcaoSisacaoFiltro paramOpcaoSisacaoFiltro)
    throws RemoteException;
  
  public abstract OpcaoSisacaoObjetoWs obtemPorChave(long paramLong)
    throws RemoteException;
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoWSSoap
 * JD-Core Version:    0.7.0.1
 */