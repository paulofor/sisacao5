package br.inf.digicom.desen;

import br.inf.digicom.CotacaoRegraProjecaoValorObj;

public class CotacaoRegraProjecaoValorApp {

	public static void main(String[] args) {
		System.out.println("Inicialiando CotacaoRegraProjecaoApp");
		System.out.println("Versao: 15-01-2022");
		CotacaoRegraProjecaoValorObj obj = new CotacaoRegraProjecaoValorObj();
		String codigoRegra = args[0];
		String codigoGrupo = args[1];
		obj.executa(codigoRegra,codigoGrupo);
		System.out.println("Finalizacao");
		System.exit(0);
	}

}
