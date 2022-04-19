package br.inf.digicom.atualizaProximo;

import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.validacao.PontoEntradaSimulacao_PreparaProximoDia;

public class AtualizaProximoDiaMonitoradoObj {

	public void executa(int i) {
		
		

		
		
		AtualizaProximoPeriodoExperimento exec = new AtualizaProximoPeriodoExperimento();
		
		DatasetComum ds = new DatasetComum();
		ds.setIdPeriodo(i);
		exec.setComum(ds);
		exec.executa();
		/*
		while (!exec.getConcluido()) {
			try {
				Thread.sleep(120000);
				System.out.println(exec.getClass().getSimpleName() + " não terminou...");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		*/
		System.out.println("Iniciando proximo dia");
		PontoEntradaSimulacao_PreparaProximoDia exec2 = new PontoEntradaSimulacao_PreparaProximoDia();
		exec2.executa();
		System.out.println("Finalizando proximo dia");
		
	}

	

}
