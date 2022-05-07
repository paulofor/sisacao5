package br.com.sisacao.coletor.indice.app;

import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.com.sisacao.coletor.indice.loopback.AtivoIndice_ListaNaoBovespa;

public class ColetorIndiceObj {

	public void executa() {
		DatasetColetorIndice ds = new DatasetColetorIndice();
		AtivoIndice_ListaNaoBovespa servico = new AtivoIndice_ListaNaoBovespa();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
