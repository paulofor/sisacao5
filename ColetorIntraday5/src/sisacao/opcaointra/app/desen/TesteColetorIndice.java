package sisacao.opcaointra.app.desen;

import timer.AgregadorThreadColeta;

public class TesteColetorIndice {

	public static void main(String[] args) {
		AgregadorThreadColeta teste = new AgregadorThreadColeta();
		teste.disparaColetoresDiaIndice("01-10-2021");
	}

}
