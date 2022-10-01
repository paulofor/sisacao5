package sisacao.tesourodireto.app;

import sisacao.tesourodireto.daobase.DatasetColetorTesouro;
import sisacao.tesourodireto.processamento.ExecutaTesouroDireto;

public class ColetorTesouroDiretoObj {

	public void executa() {
		DatasetColetorTesouro ds = new DatasetColetorTesouro();
		ExecutaTesouroDireto servico = new ExecutaTesouroDireto();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}
}
