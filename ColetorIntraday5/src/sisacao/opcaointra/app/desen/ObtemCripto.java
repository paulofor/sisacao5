package sisacao.opcaointra.app.desen;

import sisacao.atualizador.AtualizaCriptomoedaFacade;

public class ObtemCripto {

	public static void main(String[] args) {
		System.out.println("ObtemCripto");
		AtualizaCriptomoedaFacade srv = new AtualizaCriptomoedaFacade();
		srv.obtemListaCripomoeda();
	}

}
