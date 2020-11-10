 package br.com.digicom.cotacao.threads;
 
 import br.com.digicom.parse.RestricaoTempo;
 import java.util.Date;
 
 public class Tempo extends RestricaoTempo
 {
   Date inicioLeilao = null;
   Date finalLeilao = null;
   
   public void inicializaHorarios(int horaIni, int minIni, int horaFinal, int minFinal) {
	   setHorarioDia(RestricaoTempo.ConverteHoraMinuto(horaIni, minIni), RestricaoTempo.ConverteHoraMinuto(horaFinal, minFinal));
	   //setHorarioLeilao(RestricaoTempo.ConverteHoraMinuto(horaFinal, 16), RestricaoTempo.ConverteHoraMinuto(horaFinal, 17));

   }
 
   public void inicializaHorarios(int horaInicial, int horaFinal) {
     setHorarioDia(RestricaoTempo.ConverteHoraMinuto(horaInicial, 25), RestricaoTempo.ConverteHoraMinuto(horaFinal, 45));
     setHorarioLeilao(RestricaoTempo.ConverteHoraMinuto(horaFinal, 16), RestricaoTempo.ConverteHoraMinuto(horaFinal, 39));
   }
 
   public void setHorarioLeilao(Date inicioLeilao, Date finalLeilao)
   {
     this.finalLeilao = finalLeilao;
     this.inicioLeilao = inicioLeilao;
   }
 
   protected boolean testaAcesso(Date horaCorrente)
   {
     return (this.inicioLeilao == null) || (this.finalLeilao == null) || 
       (!horaCorrente.after(atualizaDia(this.inicioLeilao))) || (!horaCorrente.before(atualizaDia(this.finalLeilao)));
   }
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.threads.Tempo
 * JD-Core Version:    0.6.0
 */