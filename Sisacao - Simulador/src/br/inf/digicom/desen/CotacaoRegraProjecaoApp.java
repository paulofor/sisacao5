package br.inf.digicom.desen;

import br.inf.digicom.CotacaoRegraProjecaoObj;

public class CotacaoRegraProjecaoApp {

	public static void main(String[] args) {
		System.out.println("Inicialiando CotacaoRegraProjecaoApp");
		System.out.println("Versao: 20-11-2021");
		CotacaoRegraProjecaoObj obj = new CotacaoRegraProjecaoObj();
		obj.executa();
		System.out.println("Finalizacao");
		System.exit(0);
	}

}
