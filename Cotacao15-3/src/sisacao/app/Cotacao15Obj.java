package sisacao.app;

import java.util.Timer;

import sisacao.app.thread.ThreadPai;

public class Cotacao15Obj {
	
	//private static final int MINUTOS = 10;
	private static Timer timer;

	public void principal() {
		int ms = 1000 * 60 * 60; // 1 hora 
		timer = new Timer();
		ThreadPai principal = new ThreadPai();
		timer.schedule(principal, 0L, ms);
	}

}
