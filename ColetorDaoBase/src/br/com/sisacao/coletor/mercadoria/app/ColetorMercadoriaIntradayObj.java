package br.com.sisacao.coletor.mercadoria.app;

import br.com.sisacao.coletor.mercadoria.daobase.DatasetColetorMercadoria;
import br.com.sisacao.coletor.mercadoria.loopback.AtivoMercadoria_ListaColetaIntraday;

public class ColetorMercadoriaIntradayObj {

	public void executa() {
		DatasetColetorMercadoria ds = new DatasetColetorMercadoria();
		AtivoMercadoria_ListaColetaIntraday servico = new AtivoMercadoria_ListaColetaIntraday();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
