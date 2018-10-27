package sisacaoweb2online.webservice;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface OpcaoSisacaoSerieTickerWS
  extends Service
{
  public abstract String getOpcaoSisacaoSerieTickerWSSoapAddress();
  
  public abstract OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap()
    throws ServiceException;
  
  public abstract OpcaoSisacaoSerieTickerWSSoap getOpcaoSisacaoSerieTickerWSSoap(URL paramURL)
    throws ServiceException;
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoSerieTickerWS
 * JD-Core Version:    0.7.0.1
 */