package cotacaojava2.app;

import br.com.digicom.cotacao.dao.CotacaoDaoBaseI;
import br.com.digicom.cotacao.handle.DaoThread;
import br.com.digicom.cotacao.handle.FabricaRegraI;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import cotacaojava2.dao.DBB;
import cotacaojava2.regracolecao.FabricaRegra;

public class ColetorJava2App {
	public static void main(String[] args) {
		System.out.println("Ola Mundo !");
		InicializaConexaoDaoThread();
		InicializaRegraColecaoDaoThread();
		ColetorJava2Obj objeto = new ColetorJava2Obj();
		objeto.main();
	}

	private static void InicializaConexaoDaoThread() {
		try {
			CotacaoDaoBaseI dao = DBB.getInstancia().getCotacaoDao();
			DaoConexao conexao = dao.criaConexao();
			DaoThread.setConexao(conexao);
		} catch (DaoException e) {
			e.printStackTrace();
			System.out.println("Erro em InicializaConexaoDaoThread");
		}
	}

	private static void InicializaRegraColecaoDaoThread() {
		try {
			FabricaRegraI fabrica = FabricaRegra.getInstancia();
			DaoThread.setFabricaRegra(fabrica);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro em InicializaRegraColecaoDaoThread");
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\CotacaoJava2.jar Qualified Name:
 * cotacaojava2.app.ColetorJava2App -Core Version: 0.6.0
 */