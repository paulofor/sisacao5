/*  1:   */ package br.com.digicom.lib.util;
/*  2:   */ 
/*  3:   */ import java.util.Calendar;
/*  4:   */ 
/*  5:   */ public class DCConvert
/*  6:   */ {
/*  7:   */   public static String ToDataAAAA_MM_DD(String data_dd_mm_aaaaa)
/*  8:   */   {
/*  9: 9 */     if (data_dd_mm_aaaaa.length() < 10) {
/* 10: 9 */       return "";
/* 11:   */     }
/* 12:10 */     return 
/* 13:   */     
/* 14:12 */       data_dd_mm_aaaaa.substring(6, 10) + "-" + data_dd_mm_aaaaa.substring(3, 5) + "-" + data_dd_mm_aaaaa.substring(0, 2);
/* 15:   */   }
/* 16:   */   
/* 17:   */   public static String ToDataAAAA_MM_DD_HHMMSS(String data_dd_mm_aaaaa_hh_mm_ss)
/* 18:   */   {
/* 19:16 */     if (data_dd_mm_aaaaa_hh_mm_ss.length() < 10) {
/* 20:18 */       return "";
/* 21:   */     }
/* 22:20 */     return data_dd_mm_aaaaa_hh_mm_ss.substring(6, 10) + "-" + data_dd_mm_aaaaa_hh_mm_ss.substring(3, 5) + "-" + data_dd_mm_aaaaa_hh_mm_ss.substring(0, 2) + data_dd_mm_aaaaa_hh_mm_ss.substring(10);
/* 23:   */   }
/* 24:   */   
/* 25:   */   public static String ToDataBase(float valor)
/* 26:   */   {
/* 27:24 */     return String.valueOf(valor);
/* 28:   */   }
/* 29:   */   
/* 30:   */   public static String ToDataSqlAAAA_MM_DD(String data_dd_mm_aaaaa)
/* 31:   */   {
/* 32:29 */     if (data_dd_mm_aaaaa == null) {
/* 33:31 */       return "null";
/* 34:   */     }
/* 35:33 */     return "'" + ToDataAAAA_MM_DD(data_dd_mm_aaaaa) + "'";
/* 36:   */   }
/* 37:   */   
/* 38:   */   public static String ToDataSqlAAAA_MM_DD_HHMMSS(String data_dd_mm_aaaaa)
/* 39:   */   {
/* 40:41 */     if (data_dd_mm_aaaaa == null) {
/* 41:43 */       return "null";
/* 42:   */     }
/* 43:45 */     return "'" + ToDataAAAA_MM_DD_HHMMSS(data_dd_mm_aaaaa) + "'";
/* 44:   */   }
/* 45:   */   
/* 46:   */   public static String getDataDD_MM_AAAA()
/* 47:   */   {
/* 48:49 */     Calendar now = Calendar.getInstance();
/* 49:50 */     String data = colocaZeroEsquerda(now.get(5)) + "-" + 
/* 50:51 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/* 51:52 */       now.get(1);
/* 52:53 */     return data;
/* 53:   */   }
/* 54:   */   
/* 55:   */   public static String getDataAAAA_MM_DD()
/* 56:   */   {
/* 57:57 */     Calendar now = Calendar.getInstance();
/* 58:58 */     String data = now.get(1) + "-" + 
/* 59:59 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/* 60:60 */       colocaZeroEsquerda(now.get(5));
/* 61:61 */     return data;
/* 62:   */   }
/* 63:   */   
/* 64:   */   private static String colocaZeroEsquerda(int num)
/* 65:   */   {
/* 66:65 */     if (num > 9) {
/* 67:65 */       return "" +num;
/* 68:   */     }
/* 69:66 */     return "0" + num;
/* 70:   */   }
/* 71:   */ }


/* Location:           D:\Documentos de Projetos\Sisacao\ColetorJavaProducao\CotacaoJavaOpcao3.jar
 * Qualified Name:     br.com.digicom.lib.util.DCConvert
 * JD-Core Version:    0.7.0.1
 */