package sisacao.intraday.coletor.obj;

import java.util.Timer;

import sisacao.intraday.coletor.thread.ThreadPaiBase;
import sisacao.intraday.coletor.thread.ThreadPrincipalFoxbit;

public class ColetorFoxbitObj {

	private Timer timer;
	
	public void executa() {
		criaThreadPrincipal();
	}
	
	public void criaThreadPrincipal() {
		int ms = 1000 * 60 * 20; // 20 minutos
		this.timer = new Timer();
		ThreadPaiBase principal = new ThreadPrincipalFoxbit();
		System.out.println("Criou a thread principal (" + (ms/1000) + "segs)");
		this.timer.schedule(principal, 0L, ms);
	}

}
