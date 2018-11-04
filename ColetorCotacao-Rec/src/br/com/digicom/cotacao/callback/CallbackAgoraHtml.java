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
/*     */ 
/*     */ public class CallbackAgoraHtml extends CallbackParseHtml
/*     */   implements ICallbackCotacao
/*     */ {
/*     */   private String ticker;
/*  17 */   private Cotacao cotacao = null;
/*  18 */   private CotacaoManipulador cotacaoManipulador = null;
/*     */ 
/*  20 */   boolean ligaNegocio = false;
/*  21 */   boolean ligaUlt = false;
/*  22 */   boolean ligaHora = false;
/*     */   int contPontos;
/*     */ 
/*     */   public void setTicker(String ticker)
/*     */   {
/*  26 */     this.ticker = ticker;
/*     */   }
/*     */ 
/*     */   private CallbackAgoraHtml(String ticker)
/*     */   {
/*  33 */     this.ticker = ticker;
/*     */   }
/*     */ 
			public CallbackAgoraHtml() {
				
			}
/*     */   public void handleText(char[] data, int pos)
/*     */   {
/*  39 */     super.handleText(data, pos);
/*  40 */     String dado = String.copyValueOf(data);
/*     */ 
/*  42 */     if (this.ligaUlt)
/*     */     {
/*  44 */       this.cotacao.setUlt(dado);
/*  45 */       this.cotacao.setNeg("0");
/*  46 */       this.ligaUlt = false;
/*     */     }
/*  48 */     if (this.ligaHora) {
/*  49 */       this.cotacao = new Cotacao();
/*  50 */       this.cotacao.setTicker(this.ticker);
/*  51 */       this.cotacao.setHoraReal(DatasUtils.getHora());
/*  52 */       if ("ltimo".equals(dado.substring(1)))
/*  53 */         this.cotacao.setHoraNegocio("00:00");
/*     */       else {
/*  55 */         this.cotacao.setHoraNegocio(dado.substring(1));
/*     */       }
/*  57 */       this.ligaHora = false;
/*     */     }
/*  59 */     if (dado.indexOf("ltimo") != -1) this.ligaUlt = true;
/*  60 */     if ("::".equals(dado))
/*  61 */       this.contPontos += 1;
/*  62 */     if (this.contPontos == 2) {
/*  63 */       this.ligaHora = true;
/*  64 */       this.contPontos += 1;
/*     */     }
/*     */   }
/*     */ 
/*     */   public void finalizacaoErro()
/*     */   {
/*  72 */     if (this.cotacao.getUlt() != null) {
/*  73 */       this.cotacaoManipulador.setCotacao(this.cotacao);
/*  74 */       this.cotacaoManipulador.gravaCotacao();
/*  75 */       this.cotacao.setNeg("0");
/*  76 */       this.cotacao.setHoraNegocio("00:00:00");
/*     */     }
/*  78 */     ArquivoLog.getInstancia().salvaLog("Erro Callback - Ticker:" + this.cotacao.toString());
/*     */   }
/*     */ 
/*     */   public void finalizacaoOk()
/*     */   {
/*  83 */     System.out.println(this.cotacao);
/*  84 */     this.cotacaoManipulador.setCotacao(this.cotacao);
/*  85 */     this.cotacaoManipulador.gravaCotacao();
/*     */   }
/*     */ 
/*     */   public URL getUrl()
/*     */     throws MalformedURLException
/*     */   {
/*  91 */     String saida = "https://www.agorainvest.com.br/ferramenta/snapshot/snapshot.asp?COD_ATIVO=" + this.ticker;
/*     */ 
/*  94 */     return new URL(saida.toString());
/*     */   }
/*     */ 
/*     */   public void inicializacao()
/*     */   {
/*  99 */     this.cotacao = new Cotacao();
/* 100 */     this.cotacao.setTicker(this.ticker);
/* 101 */     this.contPontos = 0;
/*     */   }
/*     */ 
/*     */   public boolean getLoop()
/*     */   {
/* 106 */     return false;
/*     */   }
/*     */ 
/*     */   public void setDados(IDadosParse dadosParse)
/*     */   {
/* 111 */     this.cotacaoManipulador = ((CotacaoManipulador)dadosParse);
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
 * Qualified Name:     br.com.digicom.cotacao.callback.CallbackAgoraHtml
 * JD-Core Version:    0.6.0
 */