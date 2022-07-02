package br.com.sisacao.coletor.diario.app;

import br.com.sisacao.coletor.diario.daobase.DatasetColetorDiario;
import br.com.sisacao.coletor.diario.loopback.DiaPregao_ObtemAtualB3;

public class ColetorDiarioIndividualObj {

	public void executa() {
		DatasetColetorDiario ds = new DatasetColetorDiario();
		DiaPregao_ObtemAtualB3 servico = new DiaPregao_ObtemAtualB3();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
