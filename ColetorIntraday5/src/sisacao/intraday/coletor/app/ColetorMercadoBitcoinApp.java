package sisacao.intraday.coletor.app;

import br.com.digicom.lib.dao.DaoException;
import sisacao.intraday.coletor.obj.ColetorMercadoBitcoinObj;

public class ColetorMercadoBitcoinApp {

	public static void main(String[] args) {
		System.out.println("ColetorMercadoBitcoinApp");
		System.out.println("26-11-2021");
		ColetorMercadoBitcoinObj obj = new ColetorMercadoBitcoinObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
