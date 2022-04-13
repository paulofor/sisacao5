package br.inf.digicom;

import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.validacao.PeriodoExperimento_findById;

public class ValidacaoSelecionadosObj {
	
	public void executa(int i) {
		PeriodoExperimento_findById exec = new PeriodoExperimento_findById();
		
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
