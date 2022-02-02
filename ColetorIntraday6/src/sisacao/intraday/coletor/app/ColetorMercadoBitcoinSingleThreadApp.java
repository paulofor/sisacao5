package sisacao.intraday.coletor.app;

import sisacao.intraday.coletor.obj.ColetorMercadoBitcoinSingleThreadObj;

public class ColetorMercadoBitcoinSingleThreadApp {

	public static void main(String[] args) {
		System.out.print("ColetorMercadoBitcoinSingleThreadApp");
		System.out.println("(28-01-2022)");
		ColetorMercadoBitcoinSingleThreadObj obj = new ColetorMercadoBitcoinSingleThreadObj();
		obj.executa();

	}

}
