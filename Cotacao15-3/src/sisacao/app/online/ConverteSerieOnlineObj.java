package sisacao.app.online;

import java.util.Timer;

import sisacao.app.thread.ThreadPai;

public class ConverteSerieOnlineObj {
	private static final int MINUTOS = 1;
	private static Timer timer;

	public void main() {
		int ms = 60000;
		timer = new Timer();
		ThreadPai principal = new ThreadPai();
		timer.schedule(principal, 0L, ms);
	}
}
