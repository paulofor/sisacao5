 package br.com.digicom.cotacao.callback;
 
 import br.com.digicom.cotacao.handle.CotacaoManipulador;
import br.com.digicom.cotacao.vo.Cotacao;
import br.com.digicom.parse.callback.CallbackParseXml;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.util.ArquivoLog;
import br.com.digicom.util.DatasUtils;
import java.io.PrintStream;
import java.net.CookieManager;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
 
 public class CallbackBovespa2Xml extends CallbackParseXml
   implements ICallbackCotacao
 {
   private String ticker;
/* 20 */   private Cotacao cotacao = null;
/* 21 */   private CotacaoManipulador cotacaoManipulador = null;
 
   public void setTicker(String ticker) {
/* 24 */     this.ticker = ticker;
   }
 
   public CallbackBovespa2Xml()
   {
   }
 
   public CallbackBovespa2Xml(String ticker)
   {
/* 33 */     this.ticker = ticker;
   }
 
   public URL getUrl() throws MalformedURLException {
/* 37 */     String saida = "http://www.bmfbovespa.com.br/Pregao-Online/ExecutaAcaoAjax.asp?CodigoPapel=" + this.ticker;
 
/* 40 */     return new URL(saida.toString());
   }
 
   public void startElement(String uri, String localName, String qName, Attributes atributos)
     throws SAXException
   {
/* 47 */     if (qName.compareToIgnoreCase("PAPEL") == 0) {
/* 48 */       this.cotacao = new Cotacao();
/* 49 */       this.cotacao.setTicker(this.ticker);
/* 50 */       this.cotacao.setHoraReal(DatasUtils.getHora());
/* 51 */       this.cotacao.setUlt(atributos.getValue("Ultimo"));
/* 52 */       this.cotacao.setNeg("0");
/* 53 */       String dataHora = atributos.getValue("Data");
/* 54 */       dataHora = dataHora.substring(dataHora.length() - 8);
/* 55 */       this.cotacao.setHoraNegocio(dataHora);
     }
   }
 
   public void finalizacaoErro()
   {
/* 62 */     if (this.cotacao.getUlt() != null) {
/* 63 */       this.cotacaoManipulador.setCotacao(this.cotacao);
/* 64 */       this.cotacaoManipulador.gravaCotacao();
/* 65 */       this.cotacao.setNeg("0");
/* 66 */       this.cotacao.setHoraNegocio("00:00:00");
     }
/* 68 */     ArquivoLog.getInstancia().salvaLog("Erro Callback - Ticker:" + this.cotacao.toString());
   }
 
   public void finalizacaoOk()
   {
/* 73 */     System.out.println(this.cotacao);
/* 74 */     this.cotacaoManipulador.setCotacao(this.cotacao);
/* 75 */     this.cotacaoManipulador.gravaCotacao();
   }
 
   public void setDados(IDadosParse dadosParse)
   {
/* 82 */     this.cotacaoManipulador = ((CotacaoManipulador)dadosParse);
   }
 
   public void inicializacao()
   {
/* 87 */     this.cotacao = new Cotacao();
/* 88 */     this.cotacao.setTicker(this.ticker);
   }
 
   public boolean getLoop()
   {
/* 93 */     return false;
   }

@Override
public boolean isPost() {
	// TODO Auto-generated method stub
	return false;
}

@Override
public List camposPost() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public void setCookies(CookieManager cookies) {
	// TODO Auto-generated method stub
	
}

@Override
public CookieManager getCookies() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public String getCharSet() {
	// TODO Auto-generated method stub
	return null;
}

@Override
public URL getJsonUrl() throws MalformedURLException {
	// TODO Auto-generated method stub
	return null;
}


 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.callback.CallbackBovespa2Xml
 * JD-Core Version:    0.6.0
 */