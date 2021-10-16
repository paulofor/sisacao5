package br.inf.digicom.desen;

import br.inf.digicom.PesquisaTrendCompraObj;
import br.inf.digicom.simulacao.RepositorioCotacao;

public class PesquisaTrendCompraApp {

	public static void main(String[] args) {
		System.out.println("PesquisaTrendCompra");
		//RepositorioCotacao.carregaAtivoResultado("AZUL4", 20210101);
		//System.out.println("Chegou aqui");
		PesquisaTrendCompraObj obj = new PesquisaTrendCompraObj();
		obj.executa("AZUL4");
		System.exit(0);
	}

}
