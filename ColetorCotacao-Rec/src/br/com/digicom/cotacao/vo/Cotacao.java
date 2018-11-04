 package br.com.digicom.cotacao.vo;
 
 import br.com.digicom.lib.DCIObjetoDominio;
 
 public class Cotacao
   implements DCIObjetoDominio
 {
/* 11 */   private String ult = null;
/* 12 */   private String horaNegocio = null;
/* 13 */   private String neg = null;
/* 14 */   private String horaReal = null;
/* 15 */   private String ticker = null;
/* 16 */   private String data = null;
/* 17 */   private long idCotacao = 0L;
 
   public void setIdCotacao(long idCotacao) {
/* 20 */     this.idCotacao = idCotacao;
   }
   public long getIdCotacao() {
/* 23 */     return this.idCotacao;
   }
 
   public String toString()
   {
/* 47 */     return this.ticker + ":" + this.ult + "   ( " + this.horaNegocio + " neg:" + this.neg + " )";
   }
 
   public String getData() {
/* 51 */     return this.data;
   }
   public void setData(String data) {
/* 54 */     this.data = data;
   }
   public String getHoraNegocio() {
/* 57 */     return this.horaNegocio;
   }
   public void setHoraNegocio(String horaNegocio) {
/* 60 */     this.horaNegocio = horaNegocio;
   }
   public String getHoraReal() {
/* 63 */     return this.horaReal;
   }
   public void setHoraReal(String horaReal) {
/* 66 */     this.horaReal = horaReal;
   }
   public String getNeg() {
/* 69 */     return this.neg;
   }
   public void setNeg(String neg) {
/* 72 */     this.neg = neg;
   }
   public String getTicker() {
/* 75 */     return this.ticker;
   }
   public void setTicker(String ticker) {
/* 78 */     this.ticker = ticker;
   }
   public String getUlt() {
/* 81 */     return this.ult;
   }
 
   public void setUlt(String ult) {
/* 85 */     int posicVirgula = ult.indexOf(',');
/* 86 */     if (posicVirgula == -1)
     {
/* 88 */       this.ult = ult;
     }
     else {
/* 91 */       int posic = ult.indexOf('.');
/* 92 */       if (posic != -1) {
/* 93 */         this.ult = ult.substring(0, posic);
/* 94 */         this.ult += ult.substring(posic + 1);
       } else {
/* 96 */         this.ult = ult;
       }
     }
   }
@Override
public long getIdObj() {
	// TODO Auto-generated method stub
	return this.idCotacao;
}
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.vo.Cotacao
 * JD-Core Version:    0.6.0
 */