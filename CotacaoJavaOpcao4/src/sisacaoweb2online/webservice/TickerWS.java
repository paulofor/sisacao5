package sisacaoweb2online.webservice;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface TickerWS
  extends Service
{
  public abstract String getTickerWSSoapAddress();
  
  public abstract TickerWSSoap getTickerWSSoap()
    throws ServiceException;
  
  public abstract TickerWSSoap getTickerWSSoap(URL paramURL)
    throws ServiceException;
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.TickerWS
 * JD-Core Version:    0.7.0.1
 */