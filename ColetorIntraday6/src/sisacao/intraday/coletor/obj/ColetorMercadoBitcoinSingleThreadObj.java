package sisacao.intraday.coletor.obj;

import java.util.Timer;

import sisacao.intraday.coletor.thread.ThreadPaiBase;
import sisacao.intraday.coletor.thread.ThreadPrincipalMercadoBitcoinSingle;

public class ColetorMercadoBitcoinSingleThreadObj {
private Timer timer;
	
	public void executa() {
		criaThreadPrincipal();
	}

	public void criaThreadPrincipal() {
		int ms = 1000 * 60 * 1; // 20 minutos
		this.timer = new Timer();
		ThreadPaiBase principal = new ThreadPrincipalMercadoBitcoinSingle();
		System.out.println("Criou a thread principal ( " + (ms/1000/60) + " min) ");
		this.timer.schedule(principal, 0L, ms);
	}
}
