package sisacao.dataset.treino.entrada.app;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3;
import sisacao.dataset.treino.dao.DatasetExemplo;

public class InsereExemploTreinoAcaoEntradaObj {

	public void executa(int posicaoEntrada, int qtdeDias,String codigo) {
		DatasetExemplo ds = new DatasetExemplo();
		ds.setPosicaoDia(posicaoEntrada);
		ds.setQtdeDia(qtdeDias);
		ds.setCodigoGrupoAcao(codigo);
		AtivoAcao_ListaPorNomeGrupo exec = new AtivoAcao_ListaPorNomeGrupo();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}

	private void trataProximo() {
		
		DaoBaseComum.setProximo(AtivoAcao_ListaPorNomeGrupo.NOME, new DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}
}
