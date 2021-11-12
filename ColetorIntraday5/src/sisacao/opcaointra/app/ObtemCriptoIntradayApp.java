package sisacao.opcaointra.app;

import br.com.digicom.lib.dao.DaoException;

public class ObtemCriptoIntradayApp {

	public static void main(String[] args) {
		ObtemCriptoIntradayObj obj = new ObtemCriptoIntradayObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}

}
