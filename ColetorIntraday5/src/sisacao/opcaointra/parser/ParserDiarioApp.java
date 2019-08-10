package sisacao.opcaointra.parser;

public class ParserDiarioApp {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println("Ola Parser");
		ParserDiarioObj obj = new ParserDiarioObj();
		obj.inicio("20190808");
	}
	
	
	private void executaJan() {
		ParserDiarioObj obj = new ParserDiarioObj();
		obj.inicio("20190102");
	}

}
