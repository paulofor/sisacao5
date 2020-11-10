package sisacao.opcaointra.app;

import sisacao.opcaointra.importador.TransferidorObj;
import sisacao.opcaointra.parser.ParserDiarioObj;

public class ObtemDiarioBatch {
	
	private static TransferidorObj stTransf = new TransferidorObj();
	private static ParserDiarioObj stParse = new ParserDiarioObj();

	public static void main(String[] args) {
		
		atualizaDia("09","11","20");
		
		/*
		executaMes("19","01");
		executaMes("19","02");
		executaMes("19","03");
		executaMes("19","04");
		executaMes("19","05");
		executaMes("19","06");
		executaMes("19","07");
		executaMes("19","08");
		executaMes("19","09");
		executaMes("19","10");
		executaMes("19","11");
		executaMes("19","12");
		
		
		executaMes("20","01");
		executaMes("20","02");
		executaMes("20","03");
		executaMes("20","04");
		executaMes("20","05");
		*/
		
		//executaMes("20","06");
		//executaMes("20","07");
		//executaMes("20","08");
		//executaMes("20","09");
		//executaMes("20","10");
		//executaMes("20","11");
		//executaMes("20","12");
		
	}
	
	private static void executaMes(String ano, String mes) {
		downloadMes(ano,mes);
		parseInsert(ano,mes);
	}
	
	
	private static void parseInsert(String ano, String mes) {
		ParserDiarioObj objParse = new ParserDiarioObj();
   		objParse.inicio("20" + ano + mes + "01");
   		objParse.inicio("20" + ano + mes + "02");
   		objParse.inicio("20" + ano + mes + "03");
   		objParse.inicio("20" + ano + mes + "04");   		 
   		objParse.inicio("20" + ano + mes + "05");
   		objParse.inicio("20" + ano + mes + "06");   		
   		objParse.inicio("20" + ano + mes + "07");
   		objParse.inicio("20" + ano + mes + "08");
   		objParse.inicio("20" + ano + mes + "09");
   		objParse.inicio("20" + ano + mes + "10");
   		objParse.inicio("20" + ano + mes + "11");
   		objParse.inicio("20" + ano + mes + "12");
   		objParse.inicio("20" + ano + mes + "13");
   		objParse.inicio("20" + ano + mes + "14");
   		objParse.inicio("20" + ano + mes + "15");
   		objParse.inicio("20" + ano + mes + "16");
   		objParse.inicio("20" + ano + mes + "17");
   		objParse.inicio("20" + ano + mes + "18");
   		objParse.inicio("20" + ano + mes + "19");
   		objParse.inicio("20" + ano + mes + "20");
   		objParse.inicio("20" + ano + mes + "21");
   		objParse.inicio("20" + ano + mes + "22");
   		objParse.inicio("20" + ano + mes + "23");
   		objParse.inicio("20" + ano + mes + "24");
   		objParse.inicio("20" + ano + mes + "25");
   		objParse.inicio("20" + ano + mes + "26");
   		objParse.inicio("20" + ano + mes + "27");
   		objParse.inicio("20" + ano + mes + "28");
   		objParse.inicio("20" + ano + mes + "29");
   		objParse.inicio("20" + ano + mes + "30");
   		objParse.inicio("20" + ano + mes + "31");
   		
	}
	
	
	private static void downloadMes(String ano, String mes) {
		TransferidorObj obj = new TransferidorObj();
		
   		obj.main(mes + "01",ano);
   		obj.main(mes + "02",ano);
   		obj.main(mes + "03",ano);
   		obj.main(mes + "04",ano);
   		obj.main(mes + "05",ano);
   		obj.main(mes + "06",ano);
   		obj.main(mes + "07",ano);
   		obj.main(mes + "08",ano);
   		obj.main(mes + "09",ano);
   		obj.main(mes + "10",ano);
   		obj.main(mes + "11",ano);
   		obj.main(mes + "12",ano);
   		obj.main(mes + "13",ano);
   		obj.main(mes + "14",ano);
   		obj.main(mes + "15",ano);
   		obj.main(mes + "16",ano);
   		obj.main(mes + "17",ano);
   		obj.main(mes + "18",ano);
   		obj.main(mes + "19",ano);
   		obj.main(mes + "20",ano);
   		obj.main(mes + "21",ano);
   		obj.main(mes + "22",ano);
   		obj.main(mes + "23",ano);
   		obj.main(mes + "24",ano);
   		obj.main(mes + "25",ano);
   		obj.main(mes + "26",ano);
   		obj.main(mes + "27",ano);
   		obj.main(mes + "28",ano);
   		obj.main(mes + "29",ano);
   		obj.main(mes + "30",ano);
   		obj.main(mes + "31",ano);
	}

	
	private static void atualizaDia(String dia, String mes, String ano) {
		stTransf.main(mes + dia,ano);
		stParse.inicio("20" + ano + mes + dia);
	}
	
}
