package sisacao.opcaointra.app;

import br.com.digicom.cotacao.handle.DaoThread;
import br.com.digicom.cotacao.handle.FabricaRegraI;
import br.com.digicom.lib.dao.DaoException;


public class ColetorOpcaoIntraApp {

	public static void main(String[] args) {
		ColetorOpcaoIntraObj obj = new ColetorOpcaoIntraObj();
		try {
			obj.executa();
		} catch (DaoException e) {
			System.out.println("Erro:" + e.getMessage());
			e.printStackTrace();
		}
	}
	
	

}
