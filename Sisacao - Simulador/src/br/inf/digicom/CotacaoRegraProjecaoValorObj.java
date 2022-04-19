package br.inf.digicom;

import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegra;
import br.inf.digicom.simulacao.regraProjecao.DatasetRegraProjecao;

public class CotacaoRegraProjecaoValorObj {

	
	
	public void executa(String codigoRegra, String codigoGrupo) {
		DatasetRegraProjecao ds = new DatasetRegraProjecao();
		ds.setCodigoRegraProjecao(codigoRegra);
		ds.setCodigoGrupoAcao(codigoGrupo);
		RegraProjecao_ObtemPorCodigoRegra servico = new RegraProjecao_ObtemPorCodigoRegra();
		servico.setComum(ds);
		servico.executa();
		System.out.println("Terminou obj");
	}
	
	
}
