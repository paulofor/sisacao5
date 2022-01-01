package br.inf.digicom.desen;

import br.inf.digicom.CotacaoRegraProjecaoValorObj;

public class CotacaoRegraProjecaoValorApp {

	public static void main(String[] args) {
		System.out.println("Inicialiando CotacaoRegraProjecaoApp");
		System.out.println("Versao: 30-12-2021");
		CotacaoRegraProjecaoValorObj obj = new CotacaoRegraProjecaoValorObj();
		int idRegra = Integer.parseInt(args[0]);
		int idGrupo = Integer.parseInt(args[1]);
		obj.executa(idRegra,idGrupo);
		System.out.println("Finalizacao");
		System.exit(0);
	}

}
