package br.com.sisacao.coletor.imobiliario.app;

import br.com.sisacao.coletor.imobiliario.daobase.DatasetColetorImobiliario;
import br.com.sisacao.coletor.imobiliario.loopback.FundoImobiliario_ListaIntradayFundo;

public class ColetorIntradayImobiliarioObj {

	public void executa() {
		DatasetColetorImobiliario ds = new DatasetColetorImobiliario();
		FundoImobiliario_ListaIntradayFundo servico = new FundoImobiliario_ListaIntradayFundo();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}

}
