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
		System.out.println("Ola Mundo ! (10-11-2020) ");
		criaThreadPrincipal();
		//InicializaConexaoDaoThread();
		//mudouDia();
		
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
		int ms = 1000 * 60 * 20; // 20 minutos
		this.timer = new Timer();
		ThreadPaiBase principal = new ThreadPrincipal();
		System.out.println("Criou a thread principal (" + (ms/1000) + "segs)");
		this.timer.schedule(principal, 0L, ms);
	}
	
	
	
}
