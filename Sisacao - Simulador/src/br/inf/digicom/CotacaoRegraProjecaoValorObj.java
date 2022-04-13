package br.inf.digicom;

import br.inf.digicom.simulacao.regraProjecao.DatasetRegraProjecao;
import br.inf.digicom.simulacao.regraProjecao.RegraProjecao_ObtemProcessando;

public class CotacaoRegraProjecaoValorObj {

	
	
	public void executa(String codigoRegra, String codigoGrupo) {
		DatasetRegraProjecao ds = new DatasetRegraProjecao();
		ds.setCodigoRegra(codigoRegra);
		ds.setCodigoGrupo(codigoGrupo);
		RegraProjecao_ObtemProcessando servico = new RegraProjecao_ObtemProcessando();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}
}
