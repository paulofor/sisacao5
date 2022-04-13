package sisacao.dataset.treino.obj;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.regraprojecao.RegraProjecao_ObtemPorCodigoRegra;
import sisacao.dataset.treino.dao.DatasetComum;
import sisacao.dataset.treino.dao.DiaPregao_ObtemIntradayResultadoDataset;

public class CriaExemploTreinoAcaoObj {

	private String grupoAcao = "Neg-100";
	private Integer diaNumInicio = 20210101;
	//private Integer diaNumInicio = 20210929;
	
	
	public void executa(String codigoRegra, int qtdeDias) {
		DatasetComum comum = new DatasetComum();
		RegraProjecao_ObtemPorCodigoRegra exec = new RegraProjecao_ObtemPorCodigoRegra();
		//comum.setTicker(ticker);
		comum.setCodigoGrupoAcao(grupoAcao);
		comum.setInicioPeriodo(diaNumInicio);
		comum.setCodigoRegraProjecao(codigoRegra);
		comum.setQuantidadeDiasX(3);
		exec.setComum(comum);
		trataProximo();
		exec.executa();
		System.out.println("Terminou CriaExemploTreinoAcaoObj");
	}
	
	private void trataProximo() {
		DaoBaseComum.setProximo(RegraProjecao_ObtemPorCodigoRegra.NOME, new AtivoAcao_ListaPorNomeGrupo());
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new DiaPregao_ObtemIntradayResultadoDataset());
	}
	


}
