 package br.com.digicom.cotacao.threads;
 
 import java.util.Timer;
 
 public abstract class ExecutorObjBase
 {
/*  9 */   private final int MINUTOS = 1;
   private Timer timer;
 
   public void main()
   {
/* 13 */     int ms = 60000;
/* 14 */     this.timer = new Timer();
/* 15 */     ThreadPaiBase principal = criaThreadPai();
/* 16 */     this.timer.schedule(principal, 0L, ms);
   }
 
   protected abstract ThreadPaiBase criaThreadPai();
 }

/* Location:           D:\Java-Recuperacao\coletorcotacao.jar
 * Qualified Name:     br.com.digicom.cotacao.threads.ExecutorObjBase
 * JD-Core Version:    0.6.0
 */