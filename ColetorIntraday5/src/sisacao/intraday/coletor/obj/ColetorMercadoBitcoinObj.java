package sisacao.intraday.coletor.obj;

import java.util.Timer;

import br.com.digicom.lib.dao.DaoException;
import sisacao.opcaointra.thread.ThreadPaiBase;
import sisacao.opcaointra.thread.ThreadPrincipalCripto;

public class ColetorMercadoBitcoinObj {

	private Timer timer;
	
	public void executa() throws DaoException {
		criaThreadPrincipal();
	}
	
	public void criaThreadPrincipal() {
		int ms = 1000 * 60 * 20; // 20 minutos
		this.timer = new Timer();
		ThreadPaiBase principal = new ThreadPrincipalCripto();
		System.out.println("Criou a thread principal (" + (ms/1000) + "segs)");
		this.timer.schedule(principal, 0L, ms);
	}

}
