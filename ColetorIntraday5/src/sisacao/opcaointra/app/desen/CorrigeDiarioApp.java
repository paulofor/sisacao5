package sisacao.opcaointra.app.desen;

import sisacao.opcaointra.importador.TransferidorObj;
import sisacao.opcaointra.parser.ParserDiarioObj;

public class CorrigeDiarioApp {

	//static String ano = "2020";
	//static String mesDia = "0929";
	
	public static void main(String[] args) {
		
		
		String dataAnterior = "13-12-2022";
		if (args.length == 1) {
			dataAnterior = args[0];
		}
		
		String mesDia = dataAnterior.substring(3, 5) + dataAnterior.substring(0, 2);
		String ano = dataAnterior.substring(8);
		TransferidorObj obj = new TransferidorObj();
   		obj.main(mesDia,ano);
   		ParserDiarioObj objParse = new ParserDiarioObj();
   		objParse.inicio("20" + ano + mesDia);
	}

}
