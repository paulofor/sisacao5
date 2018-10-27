package sisacaoweb2online.webservice;

import java.net.URL;
import javax.xml.rpc.Service;
import javax.xml.rpc.ServiceException;

public abstract interface OpcaoSisacaoWS
  extends Service
{
  public abstract String getOpcaoSisacaoWSSoapAddress();
  
  public abstract OpcaoSisacaoWSSoap getOpcaoSisacaoWSSoap()
    throws ServiceException;
  
  public abstract OpcaoSisacaoWSSoap getOpcaoSisacaoWSSoap(URL paramURL)
    throws ServiceException;
}


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     sisacaoweb2online.webservice.OpcaoSisacaoWS
 * JD-Core Version:    0.7.0.1
 */