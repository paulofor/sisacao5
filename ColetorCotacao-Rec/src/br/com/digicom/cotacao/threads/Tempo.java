 package br.com.digicom.cotacao.threads;
 
 import br.com.digicom.parse.RestricaoTempo;
 import java.util.Date;
 
 public class Tempo extends RestricaoTempo
 {
/* 12 */   Date inicioLeilao = null;
/* 13 */   Date finalLeilao = null;
 
   public void inicializaHorarios(int horaInicial, int horaFinal) {
/* 16 */     setHorarioDia(RestricaoTempo.ConverteHoraMinuto(horaInicial, 25), RestricaoTempo.ConverteHoraMinuto(horaFinal, 45));
/* 17 */     setHorarioLeilao(RestricaoTempo.ConverteHoraMinuto(horaFinal, 16), RestricaoTempo.ConverteHoraMinuto(horaFinal, 39));
   }
 
   public void setHorarioLeilao(Date inicioLeilao, Date finalLeilao)
   {
/* 22 */     this.finalLeilao = finalLeilao;
/* 23 */     this.inicioLeilao = inicioLeilao;
   }
 
   protected boolean testaAcesso(Date horaCorrente)
   {
/* 29 */     return (this.inicioLeilao == null) || (this.finalLeilao == null) || 
/* 28 */       (!horaCorrente.after(atualizaDia(this.inicioLeilao))) || (!horaCorrente.before(atualizaDia(this.finalLeilao)));
   }
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.threads.Tempo
 * JD-Core Version:    0.6.0
 */