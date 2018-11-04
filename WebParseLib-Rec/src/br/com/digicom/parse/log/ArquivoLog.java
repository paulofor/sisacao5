/*    */ package br.com.digicom.parse.log;
/*    */ 
/*    */ import java.io.FileOutputStream;
/*    */ import java.io.FileWriter;
/*    */ import java.io.IOException;
/*    */ import java.io.PrintStream;
/*    */ 
/*    */ 
/*    */ 
/*    */ public class ArquivoLog
/*    */ {
/*    */   private static ArquivoLog _arquivoLog;
/* 13 */   private String _nomeArquivo = "WebParse-Erro.log";
/*    */   
/*    */   public static ArquivoLog getInstancia()
/*    */   {
/* 17 */     if (_arquivoLog == null) _arquivoLog = new ArquivoLog();
/* 18 */     return _arquivoLog;
/*    */   }
/*    */   
/*    */   public void setArquivo(String nomeArquivo) {
/* 22 */     this._nomeArquivo = nomeArquivo;
/*    */   }
/*    */   
/*    */   public void salvaLog(String input) {
/*    */     try {
/* 27 */       FileWriter arq = new FileWriter(this._nomeArquivo, true);
/* 28 */       arq.write(input + "(" + DatasUtils.getData() + " " + DatasUtils.getHora() + ") \r\n");
/* 29 */       arq.close();
/*    */     } catch (IOException e) {
/* 31 */       System.out.println("*** Erro arquivo Logs ***" + e);
/*    */     }
/*    */   }
/*    */   
/*    */   public void salvaErro(Exception erro) {
/*    */     try {
/* 37 */       FileOutputStream arq = new FileOutputStream(this._nomeArquivo, true);
/* 38 */       PrintStream ps = new PrintStream(arq, true);
/* 39 */       ps.print("(" + DatasUtils.getData() + " " + DatasUtils.getHora() + ") - ");
/* 40 */       erro.printStackTrace(ps);
/* 41 */       arq.close();
/*    */     }
/*    */     catch (IOException e) {
/* 44 */       System.out.println("*** Erro arquivo Logs ***" + e);
/*    */     }
/*    */   }
/*    */ }


/* Location:              D:\RobotWeb\ColetorGeralPrecos_1.0.jar!\br\com\digicom\parse\log\ArquivoLog.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */