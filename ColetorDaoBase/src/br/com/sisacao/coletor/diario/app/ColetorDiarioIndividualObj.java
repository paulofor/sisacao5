package br.com.sisacao.coletor.diario.app;

import br.com.sisacao.coletor.diario.daobase.DatasetColetorDiario;
import br.com.sisacao.coletor.indice.loopback.AtivoIndice_ListaColetaIntraday;

public class ColetorDiarioIndividualObj {

	public void executa() {
		DatasetColetorDiario ds = new DatasetColetorDiario();
		AtivoIndice_ListaColetaIntraday servico = new AtivoIndice_ListaColetaIntraday();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
