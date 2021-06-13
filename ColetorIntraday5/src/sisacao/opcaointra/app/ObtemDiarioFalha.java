package sisacao.opcaointra.app;

import sisacao.opcaointra.importador.TransferidorObj;
import sisacao.opcaointra.parser.ParserDiarioObj;

public class ObtemDiarioFalha {

	private static TransferidorObj stTransf = new TransferidorObj();
	private static ParserDiarioObj stParse = new ParserDiarioObj();

	public static void main(String[] args) {
		TransferidorObj obj = new TransferidorObj();
		String dia = "10";
		String mes = "06";
		String ano = "21";
   		obj.main(mes + dia ,ano);
   		ParserDiarioObj objParse = new ParserDiarioObj();
   		objParse.inicio("20" + ano + mes + dia);
	}
	
}
