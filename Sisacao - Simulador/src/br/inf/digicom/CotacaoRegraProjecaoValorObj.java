package br.inf.digicom;

import br.inf.digicom.simulacao.regraProjecao.RegraProjecao_ObtemProcessando;

public class CotacaoRegraProjecaoValorObj {

	public void executa() {
		RegraProjecao_ObtemProcessando servico = new RegraProjecao_ObtemProcessando();
		servico.executa();
		System.out.println("Terminou obj");
	}
	
	public void executa(Integer idRegraProjecao, Integer idGrupoAcao) {
		RegraProjecao_ObtemProcessando servico = new RegraProjecao_ObtemProcessando();
		servico.executa(idRegraProjecao,idGrupoAcao);
		System.out.println("Terminou obj");
	}
}
