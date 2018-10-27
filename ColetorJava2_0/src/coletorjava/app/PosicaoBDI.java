package coletorjava.app;

import java.text.DecimalFormat;

public class PosicaoBDI {
	// Opcao
	public static final int PREEXE_INI_D = 211;
	public static final int PREEXE_FIM_D = 221;
	public static final int DATVEN_INI_D = 222;
	public static final int DATVEN_FIM_D = 229;
	
	// Geral
	public static final int TIPOREG_INI = 1;
	public static final int TIPOREG_FIM = 2;
	public static final int DATA_PREGAO_INI = 3;
	public static final int DATA_PREGAO_FIM = 10;
	public static final int COD_NEG_INI = 13;
	public static final int COD_NEG_FIM = 24;
	public static final int PREABE_INI = 57;
	public static final int PREABE_FIM = 69;
	public static final int PREMAX_INI = 70;
	public static final int PREMAX_FIM = 82;
	public static final int PREMIN_INI = 83;
	public static final int PREMIN_FIM = 95;
	public static final int PREMED_INI = 96;
	public static final int PREMED_FIM = 108;
	public static final int PREULT_INI = 109;
	public static final int PREULT_FIM = 121;
	public static final int TOTNEG_INI = 148;
	public static final int TOTNEG_FIM = 152;
	public static final int QUATOT_INI = 153;
	public static final int QUATOT_FIM = 170;
	public static final int VOLTOT_INI = 171;
	public static final int VOLTOT_FIM = 188;
	 
	public static final int TIPOREG_INI_D = 1;
	public static final int TIPOREG_FIM_D = 2;
	public static final int COD_NEG_INI_D = 58;
	public static final int COD_NEG_FIM_D = 69;
	public static final int PREABE_INI_D = 91;
	public static final int PREABE_FIM_D = 101;
	public static final int PREMAX_INI_D = 102;
	public static final int PREMAX_FIM_D = 112;
	public static final int PREMIN_INI_D = 113;
	public static final int PREMIN_FIM_D = 123;
	public static final int PREMED_INI_D = 124;
	public static final int PREMED_FIM_D = 134;
	public static final int PREULT_INI_D = 135;
	public static final int PREULT_FIM_D = 145;
	public static final int TOTNEG_INI_D = 174;
	public static final int TOTNEG_FIM_D = 178;
	public static final int QUATOT_INI_D = 179;
	public static final int QUATOT_FIM_D = 193;
	public static final int VOLTOT_INI_D = 194;
	public static final int VOLTOT_FIM_D = 210;
	
	public static final int INDCAR_INI_D = 57;
	public static final int INDCAR_FIM_D = 57;
	public static final int DESBDI_INI_D = 5;
	public static final int DESBDI_FIM_D = 34;
	public static final int NOMERES_INI_D = 35;
	public static final int NOMERES_FIM_D = 46;
	public static final int ESPECI_INI_D = 47;
	public static final int ESPECI_FIM_D = 56;
	
	
	 
	public static final int COD_NEG_INI_D_IND = 5;
	public static final int COD_NEG_FIM_D_IND = 34;
	public static final int PREABE_INI_D_IND = 35;
	public static final int PREABE_FIM_D_IND = 40;
	public static final int PREMAX_INI_D_IND = 47;
	public static final int PREMAX_FIM_D_IND = 52;
	public static final int PREMIN_INI_D_IND = 41;
	public static final int PREMIN_FIM_D_IND = 46;
	public static final int PREMED_INI_D_IND = 53;
	public static final int PREMED_FIM_D_IND = 58;
	public static final int PREULT_INI_D_IND = 93;
	public static final int PREULT_FIM_D_IND = 98;
	public static final int TOTNEG_INI_D_IND = 156;
	public static final int TOTNEG_FIM_D_IND = 164;
	public static final int QUATOT_INI_D_IND = 165;
	public static final int QUATOT_FIM_D_IND = 179;
	public static final int VOLTOT_INI_D_IND = 180;
	public static final int VOLTOT_FIM_D_IND = 196;
	
	public static float extraiValor(int posicaoInicial, int posicaoFinal, String linha) {
		float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim()) / 100.0F;
		return saida;
	}
	public static float extraiValorIndice(int posicaoInicial, int posicaoFinal, String linha) {
		float saida = Float.parseFloat(linha.substring(posicaoInicial - 1, posicaoFinal).trim());
		return saida;
	}
	public static long extraiInteiro(int posicaoInicial, int posicaoFinal, String linha) {
		long saida = Long.parseLong(linha.substring(posicaoInicial - 1, posicaoFinal).trim());
		return saida;
	}
	public static String getVolumeStr(String volume) {
	     DecimalFormat df = new DecimalFormat("0.##");
	     String numero = df.format(volume);
	     numero = numero.replaceAll(",", ".");
	     return numero;
	}
	   
	public static String getDataDD_MM_AAAA(int posicaoInicial, int posicaoFinal, String linha) {
		String data = linha.substring(posicaoInicial - 1, posicaoFinal).trim();
		return data.substring(6, 8) + "-" + data.substring(4, 6) + "-" + data.substring(0, 4);
	}
}
