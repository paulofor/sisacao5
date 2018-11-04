/*     */ package br.com.digicom.cotacao.callback;
/*     */ 
/*     */ import br.com.digicom.cotacao.handle.CotacaoManipulador;
/*     */ import br.com.digicom.cotacao.vo.Cotacao;
/*     */ import br.com.digicom.parse.callback.CallbackParseHtml;
/*     */ import br.com.digicom.parse.callback.IDadosParse;
/*     */ import br.com.digicom.util.ArquivoLog;
/*     */ import br.com.digicom.util.DatasUtils;
/*     */ import java.io.PrintStream;
/*     */ import java.net.MalformedURLException;
/*     */ import java.net.URL;
import java.util.List;

/*     */ import org.xml.sax.Attributes;
/*     */ import org.xml.sax.SAXException;
/*     */ 
/*     */ public class CallbackBovespaHtml extends CallbackParseHtml
/*     */   implements ICallbackCotacao
/*     */ {
/*     */   private String ticker;
/*  21 */   private Cotacao cotacao = null;
/*  22 */   private CotacaoManipulador cotacaoManipulador = null;
/*     */ 
/*  24 */   boolean ligaNegocio = false;
/*  25 */   boolean ligaUlt = false;
/*  26 */   boolean ligaHora = false;
/*     */ 
/*     */   public void setTicker(String ticker) {
/*  29 */     this.ticker = ticker;
/*     */   }
/*     */ 
/*     */   public void handleText(char[] data, int pos) {
/*  33 */     super.handleText(data, pos);
/*  34 */     String dado = String.copyValueOf(data);
/*  35 */     if (dado.indexOf("R$") == 0) {
/*  36 */       this.cotacao = new Cotacao();
/*  37 */       this.cotacao.setTicker(this.ticker);
/*  38 */       this.cotacao.setHoraReal(DatasUtils.getHora());
/*  39 */       this.cotacao.setUlt(dado.substring(3));
/*  40 */       this.cotacao.setNeg("0");
/*  41 */       this.cotacao.setHoraNegocio("00:00:00");
/*     */     }
/*     */   }
/*     */ 
/*     */   public CallbackBovespaHtml(String ticker)
/*     */   {
/*  49 */     this.ticker = ticker;
/*     */   }
			public CallbackBovespaHtml()
/*     */   {
/*     */   }
			
/*     */ 
/*     */   public void startElement(String uri, String localName, String qName, Attributes atributos)
/*     */     throws SAXException
/*     */   {
/*  55 */     System.out.println("Iniciou elemento:" + qName);
/*     */ 
/*  57 */     if (qName.compareTo("PAPEL") == 0) {
/*  58 */       this.cotacao = new Cotacao();
/*  59 */       this.cotacao.setTicker(this.ticker);
/*  60 */       this.cotacao.setHoraReal(DatasUtils.getHora());
/*  61 */       this.cotacao.setUlt(atributos.getValue("VALOR_ULTIMO"));
/*  62 */       this.cotacao.setNeg(atributos.getValue("QUANT_NEG"));
/*  63 */       this.cotacao.setHoraNegocio(atributos.getValue("HORA"));
/*     */     }
/*     */   }
/*     */ 
/*     */   public void finalizacaoErro()
/*     */   {
/*  70 */     if (this.cotacao.getUlt() != null) {
/*  71 */       this.cotacaoManipulador.setCotacao(this.cotacao);
/*  72 */       this.cotacaoManipulador.gravaCotacao();
/*  73 */       this.cotacao.setNeg("0");
/*  74 */       this.cotacao.setHoraNegocio("00:00:00");
/*     */     }
/*  76 */     ArquivoLog.getInstancia().salvaLog("Erro Callback - Ticker:" + this.cotacao.toString());
/*     */   }
/*     */ 
/*     */   public void finalizacaoOk()
/*     */   {
/*  81 */     System.out.println(this.cotacao);
/*  82 */     this.cotacaoManipulador.setCotacao(this.cotacao);
/*  83 */     this.cotacaoManipulador.gravaCotacao();
/*     */   }
/*     */ 
/*     */   public URL getUrl()
/*     */     throws MalformedURLException
/*     */   {
/*  89 */     String saida = "http://www.bmfbovespa.com.br/cotacao-rapida/cotacaorapida.aspx?codigoAtivo=" + this.ticker + "&idioma=pt-br";
/*  90 */     return new URL(saida.toString());
/*     */   }
/*     */ 
/*     */   public void inicializacao()
/*     */   {
/*  95 */     this.cotacao = new Cotacao();
/*  96 */     this.cotacao.setTicker(this.ticker);
/*     */   }
/*     */ 
/*     */   public boolean getLoop()
/*     */   {
/* 101 */     return false;
/*     */   }
/*     */ 
/*     */   public void setDados(IDadosParse dadosParse)
/*     */   {
/* 106 */     this.cotacaoManipulador = ((CotacaoManipulador)dadosParse);
/*     */   }
/*     */
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
 * Qualified Name:     br.com.digicom.cotacao.callback.CallbackBovespaHtml
 * JD-Core Version:    0.6.0
 */