package br.com.sisacao.principal;

import br.inf.digicom.loopback.comum.DaoBaseComum;

public class ColetorIBRX100App {

	
	public static void main(String[] args) {
		System.out.println("Ola mundo");
		DaoBaseComum.urlLoopback = "http://vps-40d69db1.vps.ovh.ca:23005/api";
		//DaoBaseComum.urlLoopback = "http://localhost:21046/api";
		ColetorIBRX100 testando = new ColetorIBRX100();
		testando.executa();
	}
}
