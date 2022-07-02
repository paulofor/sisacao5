package br.com.sisacao.coletor.b3;

import java.util.Calendar;

public abstract class B3DadosParseBase {

	public String getAAAA_MM_DD() {
		 Calendar now = Calendar.getInstance();
		 String data = colocaZeroEsquerda(now.get(1)) + "-" + 
		        colocaZeroEsquerda(now.get(2) + 1) + "-" + 
		        colocaZeroEsquerda(now.get(5));
		 return data;
	}
	private static String colocaZeroEsquerda(int num) {
		if (num > 9) return "" + num;
		      return "0" + num;
	}
	protected abstract String getTicker();
	protected abstract void enviaValor(Double valor, String horario);
}
