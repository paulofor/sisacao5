package sisacao.opcaointra.app;

import java.util.Timer;

import sisacao.opcaointra.thread.ThreadPaiBase;
import sisacao.opcaointra.thread.ThreadPrincipal;
import timer.AgregadorThreadColeta;
import br.com.digicom.cotacao.handle.DaoThread;
import br.com.digicom.cotacao.handle.FabricaRegraI;
import br.com.digicom.lib.dao.DaoConexao;
import br.com.digicom.lib.dao.DaoException;
import coletorjava.dao.CotacaoDao;
import coletorjava.dao.DBB;
import coletorjava.regracolecao.FabricaRegra;

public class ColetorOpcaoIntraObj {


	private Timer timer;
	

	public void executa() throws DaoException {
		System.out.println("Ola Mundo ! ");
		criaThreadPrincipal();
		//InicializaConexaoDaoThread();
		//odouDia();
		
	}
	
	private static void InicializaConexaoDaoThread() {
		try {
			CotacaoDao dao = DBB.getInstancia().getCotacaoDao();
			DaoConexao conexao = dao.criaConexao();
			DaoThread.setConexao(conexao);
		} catch (DaoException e) {
			e.printStackTrace();
			System.out.println("Erro em InicializaConexaoDaoThread");
		}
	}
	
	/*
	private static void InicializaRegraColecaoDaoThread() {
		try {
			FabricaRegraI fabrica = FabricaRegra.getInstancia();
			DaoThread.setFabricaRegra(fabrica);
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro em InicializaRegraColecaoDaoThread");
		}
	}
	*/
	
	
	
	public void criaThreadPrincipal() {
		int ms = 1000 * 60 * 15; // 15 minutos
		this.timer = new Timer();
		ThreadPaiBase principal = new ThreadPrincipal();
		this.timer.schedule(principal, 0L, ms);
	}
	
	public void mudouDia() {
		AgregadorThreadColeta agregador = new AgregadorThreadColeta();
		//agregador.limpaColetoresAtual();
   		agregador.disparaColetoresDia("0123");
	}
	
}
