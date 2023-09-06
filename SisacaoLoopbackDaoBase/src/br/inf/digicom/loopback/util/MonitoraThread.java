package br.inf.digicom.loopback.util;

import java.lang.management.ManagementFactory;
import java.util.Timer;
import java.util.TimerTask;



public class MonitoraThread {

	private Timer timer;
	
	public final void inicializa(int segundos) {
		timer = new Timer();
		timer.schedule(new RemindTask(), 0, segundos * 1000);
	}

	class RemindTask extends TimerTask {
		public void run() {
			System.out.println("Threads: " + ManagementFactory.getThreadMXBean().getThreadCount());
			
		}
	}
}
