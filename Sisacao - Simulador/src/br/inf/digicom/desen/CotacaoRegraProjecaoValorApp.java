package br.inf.digicom.desen;

import br.inf.digicom.CotacaoRegraProjecaoValorObj;

public class CotacaoRegraProjecaoValorApp {

	public static void main(String[] args) {
		System.out.println("Inicialiando CotacaoRegraProjecaoApp");
		System.out.println("Versao: 25-12-2021");
		CotacaoRegraProjecaoValorObj obj = new CotacaoRegraProjecaoValorObj();
		Integer idRegra = 1;
		Integer idGrupo = 0;
		obj.executa(idRegra,idGrupo);
		System.out.println("Finalizacao");
		System.exit(0);
	}

}
