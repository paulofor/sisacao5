package sisacao.opcaointra.parser;

import sisacao.opcaointra.importador.TransferidorObj;

public class ParserDiarioApp {

	
	static ParserDiarioObj obj = new ParserDiarioObj();
	static TransferidorObj transf = new TransferidorObj();
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		ParserDiarioObj objParse = new ParserDiarioObj();
   		objParse.inicio("20210111");
		
   		/*
		System.out.println("Ola Parser");

		executaMes("201801");
		executaMes("201802");
		executaMes("201803");
		executaMes("201804");
		executaMes("201805");
		executaMes("201806");
		executaMes("201807");
		executaMes("201808");
		executaMes("201809");
		executaMes("201810");
		executaMes("201811");
		executaMes("201812");
		*/
	}
	
	
	private static void executaMes(String anoMes) {
		processaDia(anoMes + "01");
		processaDia(anoMes + "02");
		processaDia(anoMes + "03");
		processaDia(anoMes + "04");
		processaDia(anoMes + "05");
		processaDia(anoMes + "06");
		processaDia(anoMes + "07");
		processaDia(anoMes + "08");
		processaDia(anoMes + "09");
		processaDia(anoMes + "10");
		processaDia(anoMes + "11");
		processaDia(anoMes + "12");
		processaDia(anoMes + "13");
		processaDia(anoMes + "14");
		processaDia(anoMes + "15");
		processaDia(anoMes + "16");
		processaDia(anoMes + "17");
		processaDia(anoMes + "18");
		processaDia(anoMes + "19");
		processaDia(anoMes + "20");
		processaDia(anoMes + "21");
		processaDia(anoMes + "22");
		processaDia(anoMes + "23");
		processaDia(anoMes + "24");
		processaDia(anoMes + "25");
		processaDia(anoMes + "26");
		processaDia(anoMes + "27");
		processaDia(anoMes + "28");
		processaDia(anoMes + "29");
		processaDia(anoMes + "30");
		processaDia(anoMes + "31");
	}

	private static void processaDia(String dia) {
		transf.unzipFiles("/home/usuario/sisacao5/AplicacoesAtivas/Diarios", "PR" + dia.substring(2)+ ".zip", "/home/usuario/sisacao5/AplicacoesAtivas/ColetorIntraday5/download");
		obj.inicio(dia);
	}
	
}
