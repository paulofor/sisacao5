/*     */ package br.com.digicom.parse.log;
/*     */ 
/*     */ import java.text.DateFormat;
/*     */ import java.util.Calendar;
/*     */ import java.util.Date;
/*     */ 
/*     */ public class DatasUtils
/*     */ {
/*     */   public static String exibe(Date data)
/*     */   {
/*  11 */     DateFormat df = DateFormat.getTimeInstance();
/*  12 */     return df.format(data);
/*     */   }
/*     */   
/*     */   public static Date converteHH_MM_SS(String horario) {
/*  16 */     int hora = Integer.parseInt(horario.substring(0, 2));
/*  17 */     int minuto = Integer.parseInt(horario.substring(3, 5));
/*     */     
/*  19 */     return converteHoraMinuto(hora, minuto);
/*     */   }
/*     */   
/*     */   public static Date diaAtual() {
/*  23 */     Calendar cal = Calendar.getInstance();
/*  24 */     cal.set(11, 0);
/*  25 */     cal.set(12, 0);
/*  26 */     cal.set(13, 0);
/*  27 */     cal.set(14, 0);
/*  28 */     return cal.getTime();
/*     */   }
/*     */   
/*     */   private static Date horaAtual() {
/*  32 */     Calendar cal = Calendar.getInstance();
/*  33 */     return cal.getTime();
/*     */   }
/*     */   
/*     */   public static boolean fimSemana() {
/*  37 */     Calendar cal = Calendar.getInstance();
/*     */     
/*  39 */     return (cal.get(7) == 1) || 
/*  40 */       (cal.get(7) == 7);
/*     */   }
/*     */   
/*     */   public static Date converteHoraMinuto(int hora, int minuto) {
/*  44 */     Calendar calendar = Calendar.getInstance();
/*  45 */     calendar.set(11, hora);
/*  46 */     calendar.set(12, minuto);
/*  47 */     calendar.set(13, 0);
/*  48 */     return calendar.getTime();
/*     */   }
/*     */   
/*     */ 
/*     */   public static String retornaProximoDiaUtil(String dataAAAAMMDD)
/*     */   {
/*  54 */     int ano = Integer.parseInt(dataAAAAMMDD.substring(0, 4));
/*  55 */     int mes = Integer.parseInt(dataAAAAMMDD.substring(4, 6));
/*  56 */     int dia = Integer.parseInt(dataAAAAMMDD.substring(6, 8));
/*  57 */     Calendar data = Calendar.getInstance();
/*  58 */     data.set(ano, mes - 1, dia);
/*  59 */     data.add(5, 1);
/*  60 */     while ((data.get(7) == 7) || 
/*  61 */       (data.get(7) == 1))
/*     */     {
/*  63 */       data.add(5, 1);
/*     */     }
/*  65 */     String saida = data.get(1) + colocaZero(data.get(2) + 1) + 
/*  66 */       colocaZero(data.get(5));
/*  67 */     return saida;
/*     */   }
/*     */   
/*     */   public static String colocaZero(int valor) {
/*  71 */     if (valor < 10) return "0" + valor;
/*  72 */     return "" + valor;
/*     */   }
/*     */   
/*     */   public static String getDataAAAA_MM_DD() {
/*  76 */     Calendar now = Calendar.getInstance();
/*  77 */     String data = colocaZeroEsquerda(now.get(1)) + "-" + 
/*  78 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/*  79 */       now.get(5);
/*  80 */     return data;
/*     */   }
/*     */   
/*  83 */   public static String getDataDD_MM_AAAA() { Calendar now = Calendar.getInstance();
/*  84 */     String data = colocaZeroEsquerda(now.get(5)) + "-" + 
/*  85 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/*  86 */       now.get(1);
/*  87 */     return data;
/*     */   }
/*     */   
/*     */   public static String getDataHoraVO()
/*     */   {
/*  92 */     return getDataDD_MM_AAAA() + " " + getHora();
/*     */   }
/*     */   
/*     */   private static String colocaZeroEsquerda(int num) {
/*  96 */     if (num > 9) return "" + num;
/*  97 */     return "0" + num;
/*     */   }
/*     */   
/* 100 */   public static String getData() { Calendar now = Calendar.getInstance();
/* 101 */     String data = now.get(1) + "-" + (
/* 102 */       now.get(2) + 1) + "-" + 
/* 103 */       now.get(5);
/* 104 */     return data;
/*     */   }
/*     */   
/* 107 */   public static String getHora() { Calendar cal = Calendar.getInstance();
/* 108 */     Date hoje = cal.getTime();
/*     */     
/* 110 */     DateFormat df = DateFormat.getTimeInstance();
/* 111 */     return df.format(hoje);
/*     */   }
/*     */   
/*     */   public static String converteAAAAMMDD2DD_MM_AAAA(String dataAAAAMMDD) {
/* 115 */     String ano = dataAAAAMMDD.substring(0, 4);
/* 116 */     String mes = dataAAAAMMDD.substring(4, 6);
/* 117 */     String dia = dataAAAAMMDD.substring(6);
/* 118 */     return dia + "-" + mes + "-" + ano;
/*     */   }
/*     */   
/*     */ 
/*     */   public static String converteAAAA_MM_DD2DD_MM_AAAA(String data)
/*     */   {
/* 124 */     String ano = data.substring(0, 4);
/* 125 */     String mes = data.substring(5, 7);
/* 126 */     String dia = data.substring(8);
/* 127 */     return dia + "-" + mes + "-" + ano;
/*     */   }
/*     */   
/*     */   public static String converteDD_MM_AAAA2AAAA_MM_DD(String data)
/*     */   {
/* 132 */     String ano = data.substring(6);
/* 133 */     String mes = data.substring(3, 5);
/* 134 */     String dia = data.substring(0, 2);
/* 135 */     return ano + "-" + mes + "-" + dia;
/*     */   }
/*     */   
/* 138 */   public static long converteDD_MM_AAAA2Inteiro(String data) { String ano = data.substring(6);
/* 139 */     String mes = data.substring(3, 5);
/* 140 */     String dia = data.substring(0, 2);
/* 141 */     long saida = Integer.parseInt(ano + mes + dia);
/* 142 */     return saida;
/*     */   }
/*     */   
/*     */   public static String getDataAAAA_MM_DD_Add(int diasDiferenca)
/*     */   {
/* 147 */     Calendar now = Calendar.getInstance();
/* 148 */     now.add(6, diasDiferenca);
/* 149 */     String data = colocaZeroEsquerda(now.get(1)) + "-" + 
/* 150 */       colocaZeroEsquerda(now.get(2) + 1) + "-" + 
/* 151 */       colocaZeroEsquerda(now.get(5));
/* 152 */     return data;
/*     */   }
/*     */ }


/* Location:              D:\RobotWeb\ColetorGeralPrecos_1.0.jar!\br\com\digicom\parse\log\DatasUtils.class
 * Java compiler version: 7 (51.0)
 * JD-Core Version:       0.7.1
 */