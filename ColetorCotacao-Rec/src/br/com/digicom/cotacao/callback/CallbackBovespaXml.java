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
 
 public class CallbackBovespaXml extends CallbackParseXml
   implements ICallbackCotacao
 {
   private String ticker;
/* 20 */   private Cotacao cotacao = null;
/* 21 */   private CotacaoManipulador cotacaoManipulador = null;
 
   public void setTicker(String ticker) {
/* 24 */     this.ticker = ticker;
   }
 
   private CallbackBovespaXml()
   {
   }
 
   public CallbackBovespaXml(String ticker)
   {
/* 33 */     this.ticker = ticker;
   }
 
   public URL getUrl() throws MalformedURLException {
/* 37 */     String saida = "http://www.bovespa.com.br/Cotacoes2000/formCotacoesMobile.asp?codsocemi=" + this.ticker;
 
/* 39 */     return new URL(saida.toString());
   }
 
   public void startElement(String uri, String localName, String qName, Attributes atributos)
     throws SAXException
   {
/* 46 */     if (qName.compareTo("PAPEL") == 0) {
/* 47 */       this.cotacao = new Cotacao();
/* 48 */       this.cotacao.setTicker(this.ticker);
/* 49 */       this.cotacao.setHoraReal(DatasUtils.getHora());
/* 50 */       this.cotacao.setUlt(atributos.getValue("VALOR_ULTIMO"));
/* 51 */       this.cotacao.setNeg(atributos.getValue("QUANT_NEG"));
/* 52 */       this.cotacao.setHoraNegocio(atributos.getValue("HORA"));
     }
   }
 
   public void finalizacaoErro()
   {
/* 59 */     if (this.cotacao.getUlt() != null) {
/* 60 */       this.cotacaoManipulador.setCotacao(this.cotacao);
/* 61 */       this.cotacaoManipulador.gravaCotacao();
/* 62 */       this.cotacao.setNeg("0");
/* 63 */       this.cotacao.setHoraNegocio("00:00:00");
     }
/* 65 */     ArquivoLog.getInstancia().salvaLog("Erro Callback - Ticker:" + this.cotacao.toString());
   }
 
   public void finalizacaoOk()
   {
/* 70 */     System.out.println(this.cotacao);
 
/* 72 */     this.cotacaoManipulador.setCotacao(this.cotacao);
/* 73 */     this.cotacaoManipulador.gravaCotacao();
   }
 
   public void setDados(IDadosParse dadosParse)
   {
/* 80 */     this.cotacaoManipulador = ((CotacaoManipulador)dadosParse);
   }
 
   public void inicializacao()
   {
/* 85 */     this.cotacao = new Cotacao();
/* 86 */     this.cotacao.setTicker(this.ticker);
   }
 
   public boolean getLoop()
   {
/* 92 */     return false;
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
 * Qualified Name:     br.com.digicom.cotacao.callback.CallbackBovespaXml
 * JD-Core Version:    0.6.0
 */