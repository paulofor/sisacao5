package sisacao.coletor.uniswap.app;

import sisacao.coletor.uniswap.daobase.DatasetColetorUniswap;
import sisacao.coletor.uniswap.processamento.ExecutaColetaUniswap;

public class ColetorUniswapObj {

	public void executa() {
		DatasetColetorUniswap ds = new DatasetColetorUniswap();
		ExecutaColetaUniswap servico = new ExecutaColetaUniswap();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}
}
