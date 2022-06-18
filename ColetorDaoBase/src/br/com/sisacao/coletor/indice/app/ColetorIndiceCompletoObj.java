package br.com.sisacao.coletor.indice.app;

import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.com.sisacao.coletor.indice.loopback.AtivoIndice_ListaColetaIntraday;

public class ColetorIndiceCompletoObj {

	public void executa() {
		DatasetColetorIndice ds = new DatasetColetorIndice();
		AtivoIndice_ListaColetaIntraday servico = new AtivoIndice_ListaColetaIntraday();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
