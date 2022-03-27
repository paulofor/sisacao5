package br.inf.digicom;

import br.inf.digicom.loopback.DatasetComum;
import br.inf.digicom.simulacao.validacao.PeriodoExperimento_findById;

public class ValidacaoSelecionadosObj {
	
	public void executa(int i) {
		PeriodoExperimento_findById exec = new PeriodoExperimento_findById();
		
		DatasetComum ds = new DatasetComum();
		exec.setIdPeriodo(i);
		exec.setComum(ds);
		exec.executa();
	}
	
}
