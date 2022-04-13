package br.inf.digicom.atualizaProximo;

import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.loopback.DatasetComum;

public class AtualizaProximoDiaMonitoradoObj {

	public void executa(int i) {
		AtualizaProximoPeriodoExperimento exec = new AtualizaProximoPeriodoExperimento();
		
		DatasetComum ds = new DatasetComum();
		ds.setIdPeriodo(i);
		exec.setComum(ds);
		exec.executa();
		while (!exec.getConcluido()) {
			try {
				Thread.sleep(120000);
				System.out.println(exec.getClass().getSimpleName() + " não terminou...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	

}
