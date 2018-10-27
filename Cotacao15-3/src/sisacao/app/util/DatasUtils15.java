package sisacao.app.util;

import java.text.DateFormat;
import java.util.Calendar;
import java.util.Date;

import coletorjava.modelo.CotacaoProcessada;

public class DatasUtils15 {
	public static String exibe(Date data) {
		DateFormat df = DateFormat.getTimeInstance();
		return df.format(data);
	}

	public static Date converteHH_MM_SS(String horario) {
		if (horario==null) throw new RuntimeException("Parâmetro de entrada é null");
		int hora = Integer.parseInt(horario.substring(0, 2));
		int minuto = Integer.parseInt(horario.substring(3, 5));

		return converteHoraMinuto(hora, minuto);
	}

	public static Date diaAtual() {
		Calendar cal = Calendar.getInstance();
		cal.set(11, 0);
		cal.set(12, 0);
		cal.set(13, 0);
		cal.set(14, 0);
		return cal.getTime();
	}

	private static Date horaAtual() {
		Calendar cal = Calendar.getInstance();
		return cal.getTime();
	}

	public static boolean fimSemana() {
		Calendar cal = Calendar.getInstance();

		return (cal.get(7) == 1) || (cal.get(7) == 7);
	}

	public static Date converteHoraMinuto(int hora, int minuto) {
		Calendar calendar = Calendar.getInstance();
		calendar.set(11, hora);
		calendar.set(12, minuto);
		calendar.set(13, 0);
		return calendar.getTime();
	}

	public static boolean jaPassou(CotacaoProcessada horario) {
		Date agora = horaAtual();
		Date horaCotacao = converteHH_MM_SS(horario.getHoraSerieTemporal());
		System.out.println("Cotacao:" + exibe(horaCotacao) + "Agora:" + exibe(agora));
		Date horaCotacao2 = new Date();
		horaCotacao2.setTime(horaCotacao.getTime() - 60000L);
		return horaCotacao.before(agora);
	}

	/*     */public static String retornaProximoDiaUtil(String dataAAAAMMDD) {
		/* 70 */int ano = Integer.parseInt(dataAAAAMMDD.substring(0, 4));
		/* 71 */int mes = Integer.parseInt(dataAAAAMMDD.substring(4, 6));
		/* 72 */int dia = Integer.parseInt(dataAAAAMMDD.substring(6, 8));
		/* 73 */Calendar data = Calendar.getInstance();
		/* 74 */data.set(ano, mes - 1, dia);
		/* 75 */data.add(5, 1);
		/* 76 */while ((data.get(7) == 7) ||
		/* 77 */(data.get(7) == 1))
		/*     */{
			/* 79 */data.add(5, 1);
			/*     */}
		/* 81 */String saida = data.get(1) + colocaZero(data.get(2) + 1) +
		/* 82 */colocaZero(data.get(5));
		/* 83 */return saida;
		/*     */}

	/*     */
	/*     */public static String colocaZero(int valor) {
		/* 87 */if (valor < 10)
			return "0" + valor;
		/* 88 */return "" + valor;
		/*     */}

	/*     */
	/*     */public static String getDataAAAA_MM_DD() {
		/* 92 */Calendar now = Calendar.getInstance();
		/* 93 */String data = colocaZeroEsquerda(now.get(1)) + "-" +
		/* 94 */colocaZeroEsquerda(now.get(2) + 1) + "-" +
		/* 95 */now.get(5);
		/* 96 */return data;
		/*     */}

	/*     */public static String getDataDD_MM_AAAA() {
		/* 99 */Calendar now = Calendar.getInstance();
		/* 100 */String data = colocaZeroEsquerda(now.get(5)) + "-" +
		/* 101 */colocaZeroEsquerda(now.get(2) + 1) + "-" +
		/* 102 */now.get(1);
		/* 103 */return data;
		/*     */}

	/*     */
	/*     */private static String colocaZeroEsquerda(int num) {
		/* 107 */if (num > 9)
			return "" + num;
		/* 108 */return "0" + num;
		/*     */}

	/*     */public static String getData() {
		/* 111 */Calendar now = Calendar.getInstance();
		/* 112 */String data = now.get(1) + "-" + (
		/* 113 */now.get(2) + 1) + "-" +
		/* 114 */now.get(5);
		/* 115 */return data;
		/*     */}

	/*     */public static String getHora() {
		/* 118 */Calendar cal = Calendar.getInstance();
		/* 119 */Date hoje = cal.getTime();
		/*     */
		/* 121 */DateFormat df = DateFormat.getTimeInstance();
		/* 122 */return df.format(hoje);
		/*     */}

	/*     */
	/*     */public static String converteAAAAMMDD2DD_MM_AAAA(String dataAAAAMMDD) {
		/* 126 */String ano = dataAAAAMMDD.substring(0, 4);
		/* 127 */String mes = dataAAAAMMDD.substring(4, 6);
		/* 128 */String dia = dataAAAAMMDD.substring(6);
		/* 129 */return dia + "-" + mes + "-" + ano;
		/*     */}
	/*     */

}

/*
 * Location: C:\Fontes\ProjetosJava2\Recuperacao-CotacaoJava15\Cotacao15\
 * Qualified Name: sisacaoweb2.util.DatasUtils JD-Core Version: 0.6.0
 */