package br.com.sisacao.coletor.ativo.app;

import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.com.sisacao.coletor.ativo.loopback.AtivoAcao_ListaColetaIntraday;

public class ColetorIntradayAtivoObj {

	public void executa() {
		DatasetColetorAcao ds = new DatasetColetorAcao();
		AtivoAcao_ListaColetaIntraday servico = new AtivoAcao_ListaColetaIntraday();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
