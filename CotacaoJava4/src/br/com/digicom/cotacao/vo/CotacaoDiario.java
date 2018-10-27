 package br.com.digicom.cotacao.vo;
 
 import br.com.digicom.lib.DCIObjetoDominio;
 import java.text.DecimalFormat;
 
 public class CotacaoDiario
   implements DCIObjetoDominio
 {
/*   9 */   protected String tipo = null;
/*  10 */   protected String ticker = null;
/*  11 */   protected String data = null;
/*  12 */   protected float abertura = 0.0F;
/*  13 */   protected float medio = 0.0F;
/*  14 */   protected float maximo = 0.0F;
/*  15 */   protected float minimo = 0.0F;
/*  16 */   protected float fechamento = 0.0F;
/*  17 */   protected long negocios = 0L;
/*  18 */   protected float volume = 0.0F;
/*  19 */   protected long qtdeTitulos = 0L;
/*  20 */   protected String codigoPapel = null;
 
/*  25 */   protected final int TIPOREG_INI = 1;
/*  26 */   protected final int TIPOREG_FIM = 2;
/*  27 */   private final int DATA_PREGAO_INI = 3;
/*  28 */   private final int DATA_PREGAO_FIM = 10;
/*  29 */   private final int COD_NEG_INI = 13;
/*  30 */   private final int COD_NEG_FIM = 24;
/*  31 */   private final int PREABE_INI = 57;
/*  32 */   private final int PREABE_FIM = 69;
/*  33 */   private final int PREMAX_INI = 70;
/*  34 */   private final int PREMAX_FIM = 82;
/*  35 */   private final int PREMIN_INI = 83;
/*  36 */   private final int PREMIN_FIM = 95;
/*  37 */   private final int PREMED_INI = 96;
/*  38 */   private final int PREMED_FIM = 108;
/*  39 */   private final int PREULT_INI = 109;
/*  40 */   private final int PREULT_FIM = 121;
/*  41 */   private final int TOTNEG_INI = 148;
/*  42 */   private final int TOTNEG_FIM = 152;
/*  43 */   private final int QUATOT_INI = 153;
/*  44 */   private final int QUATOT_FIM = 170;
/*  45 */   private final int VOLTOT_INI = 171;
/*  46 */   private final int VOLTOT_FIM = 188;
 
/*  49 */   protected final int TIPOREG_INI_D = 1;
/*  50 */   protected final int TIPOREG_FIM_D = 2;
/*  51 */   private final int COD_NEG_INI_D = 58;
/*  52 */   private final int COD_NEG_FIM_D = 69;
/*  53 */   private final int PREABE_INI_D = 91;
/*  54 */   private final int PREABE_FIM_D = 101;
/*  55 */   private final int PREMAX_INI_D = 102;
/*  56 */   private final int PREMAX_FIM_D = 112;
/*  57 */   private final int PREMIN_INI_D = 113;
/*  58 */   private final int PREMIN_FIM_D = 123;
/*  59 */   private final int PREMED_INI_D = 124;
/*  60 */   private final int PREMED_FIM_D = 134;
/*  61 */   private final int PREULT_INI_D = 135;
/*  62 */   private final int PREULT_FIM_D = 145;
/*  63 */   private final int TOTNEG_INI_D = 174;
/*  64 */   private final int TOTNEG_FIM_D = 178;
/*  65 */   private final int QUATOT_INI_D = 179;
/*  66 */   private final int QUATOT_FIM_D = 193;
/*  67 */   private final int VOLTOT_INI_D = 194;
/*  68 */   private final int VOLTOT_FIM_D = 210;
 
/*  71 */   private final int COD_NEG_INI_D_IND = 5;
/*  72 */   private final int COD_NEG_FIM_D_IND = 34;
/*  73 */   private final int PREABE_INI_D_IND = 35;
/*  74 */   private final int PREABE_FIM_D_IND = 40;
/*  75 */   private final int PREMAX_INI_D_IND = 47;
/*  76 */   private final int PREMAX_FIM_D_IND = 52;
/*  77 */   private final int PREMIN_INI_D_IND = 41;
/*  78 */   private final int PREMIN_FIM_D_IND = 46;
/*  79 */   private final int PREMED_INI_D_IND = 53;
/*  80 */   private final int PREMED_FIM_D_IND = 58;
/*  81 */   private final int PREULT_INI_D_IND = 93;
/*  82 */   private final int PREULT_FIM_D_IND = 98;
/*  83 */   private final int TOTNEG_INI_D_IND = 156;
/*  84 */   private final int TOTNEG_FIM_D_IND = 164;
/*  85 */   private final int QUATOT_INI_D_IND = 165;
/*  86 */   private final int QUATOT_FIM_D_IND = 179;
/*  87 */   private final int VOLTOT_INI_D_IND = 180;
/*  88 */   private final int VOLTOT_FIM_D_IND = 196;
 
   public void extraiLinhaArquivo(String linha) {
/*  91 */     this.tipo = linha.substring(0, 2);
/*  92 */     if (this.tipo.equals("01")) {
/*  93 */       this.ticker = linha.substring(12, 24).trim();
/*  94 */       this.data = linha.substring(2, 10).trim();
/*  95 */       this.abertura = extraiValor(57, 69, linha);
/*  96 */       this.maximo = extraiValor(70, 82, linha);
/*  97 */       this.minimo = extraiValor(83, 95, linha);
/*  98 */       this.medio = extraiValor(96, 108, linha);
/*  99 */       this.fechamento = extraiValor(109, 121, linha);
 
/* 101 */       this.negocios = extraiInteiro(148, 152, linha);
/* 102 */       this.volume = extraiValor(171, 188, linha);
/* 103 */       this.qtdeTitulos = extraiInteiro(153, 170, linha);
     } else {
/* 105 */       this.ticker = "";
     }
   }
 
   public void extraiLinhaArquivoDiario(String linha) {
/* 110 */     this.tipo = linha.substring(0, 2);
/* 111 */     if (this.tipo.equals("02")) {
/* 112 */       this.ticker = linha.substring(57, 69).trim();
 
/* 114 */       this.data = "";
/* 115 */       this.abertura = extraiValor(91, 101, linha);
/* 116 */       this.maximo = extraiValor(102, 112, linha);
/* 117 */       this.minimo = extraiValor(113, 123, linha);
/* 118 */       this.medio = extraiValor(124, 134, linha);
/* 119 */       this.fechamento = extraiValor(135, 145, linha);
 
/* 121 */       this.negocios = extraiInteiro(174, 178, linha);
/* 122 */       this.volume = extraiValor(194, 210, linha);
/* 123 */       this.qtdeTitulos = extraiInteiro(179, 193, linha);
 
/* 125 */       this.codigoPapel = linha.substring(69, 72).trim();
/* 126 */       return;
     }
/* 128 */     if (this.tipo.equals("01")) {
/* 129 */       this.ticker = linha.substring(4, 34).trim();
 
/* 131 */       this.data = "";
/* 132 */       this.abertura = extraiValorIndice(35, 40, linha);
/* 133 */       this.maximo = extraiValorIndice(47, 52, linha);
/* 134 */       this.minimo = extraiValorIndice(41, 46, linha);
/* 135 */       this.medio = extraiValorIndice(53, 58, linha);
/* 136 */       this.fechamento = extraiValorIndice(93, 98, linha);
 
/* 138 */       this.negocios = extraiInteiro(156, 164, linha);
/* 139 */       this.volume = extraiValor(180, 196, linha);
/* 140 */       this.qtdeTitulos = extraiInteiro(165, 179, linha);
 
/* 143 */       return;
     }
/* 145 */     this.ticker = "";
   }
 
   protected float extraiValor(int posicaoInicial, int posicaoFinal, String linha)
   {
/* 150 */     float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim()) / 100.0F;
 
/* 152 */     return saida;
   }
   protected float extraiValorIndice(int posicaoInicial, int posicaoFinal, String linha) {
/* 155 */     float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim());
 
/* 157 */     return saida;
   }
   protected long extraiInteiro(int posicaoInicial, int posicaoFinal, String linha) {
/* 160 */     long saida = Long.parseLong(linha.substring(posicaoInicial - 1, posicaoFinal).trim());
/* 161 */     return saida;
   }
 
   public void setTicker(String ticker) {
/* 165 */     this.ticker = ticker;
   }
   public String getTicker() {
/* 168 */     return this.ticker;
   }
   public String imprime() {
/* 171 */     return this.ticker + "(" + getDataBd() + ") : R$" + this.fechamento + " [Neg:" + this.negocios + " R$" + this.getVolumeStr() + "]";
   }
 
   public float getAbertura() {
/* 175 */     return this.abertura;
   }
   public float getMaximo() {
/* 178 */     return this.maximo;
   }
   public float getMinimo() {
/* 181 */     return this.minimo;
   }
   public float getFechamento() {
/* 184 */     return this.fechamento;
   }
   public long getNegocios() {
/* 187 */     return this.negocios;
   }
   public String getVolumeStr() {
     DecimalFormat df = new DecimalFormat("0.##");
     String numero = df.format(this.volume);
     numero = numero.replaceAll(",", ".");
     return numero;
   }
   
   public float getVolume() {
	   return this.volume;
   }
   public String getDataDD_MM_AAAA() {
	   return this.data.substring(6, 8) + "-" + this.data.substring(4, 6) + "-" + this.data.substring(0, 4);
   }
   
   public void setDataDD_MM_AAAA(String data) {
/* 196 */     this.data = 
/* 198 */       (data.substring(6, 10) + 
/* 197 */       data.substring(3, 5) + 
/* 198 */       data.substring(0, 2));
   }
 
   public String getDataBd()
   {
/* 203 */     return this.data.substring(0, 4) + "-" + this.data.substring(4, 6) + "-" + this.data.substring(6, 8);
   }
 
   public boolean candidatoAcompanhamento()
   {
/* 211 */     return (this.negocios > 50L) && (this.codigoPapel != null) && 
/* 210 */       (this.codigoPapel.equals("010")) && 
/* 211 */       (!this.ticker.equals("CRUZ3"));
   }
   public boolean isAcao() {
/* 214 */     return (this.codigoPapel != null) && (this.codigoPapel.equals("010"));
   }

@Override
public long getIdObj() {
	// TODO Auto-generated method stub
	return 0;
}
 }

