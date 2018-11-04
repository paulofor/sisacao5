package br.com.digicom.parse.dom;

import java.io.IOException;
import java.net.MalformedURLException;

import br.com.digicom.parse.callback.ICallbackParse;

public abstract interface IDomParser
  extends ICallbackParse
{
  public abstract void executaPagina() throws MalformedURLException, IOException;
}


/* Location:              D:\RobotWeb\ColetorGeralPrecos_1.0.jar!\br\com\digicom\parse\dom\IDomParser.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */