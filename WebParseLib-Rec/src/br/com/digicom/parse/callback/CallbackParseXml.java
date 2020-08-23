 package br.com.digicom.parse.callback;
 
 import org.xml.sax.helpers.DefaultHandler;

import br.com.digicom.parse.ParserThread;
import br.com.digicom.parse.ParserXmlTh;
 
 public abstract class CallbackParseXml extends DefaultHandler
   implements ICallbackParse
 {
   public ParserThread criaParse()
   {
     ParserXmlTh parser = new ParserXmlTh();
     parser.setCallback(this);
     return parser;
   }
 }

/* Location:           D:\Java-Recuperacao\webparse.jar
 * Qualified Name:     br.com.digicom.parse.callback.CallbackParseXml
 * JD-Core Version:    0.6.0
 */