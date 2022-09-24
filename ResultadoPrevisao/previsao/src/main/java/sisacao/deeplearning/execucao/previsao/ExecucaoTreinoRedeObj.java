package sisacao.deeplearning.execucao.previsao;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.dao.TreinoRede_ObtemListaPrevisaoTeste;
import sisacao.deeplearning.desenvolvimento.processamento.BuscaSaidaTrade;
import sisacao.deeplearning.execucao.dao.PrevisaoTeste_ListaComDiarioExecucao;

public class ExecucaoTreinoRedeObj {

	public void executa() {
		DatasetResultadoPrevisao ds = new DatasetResultadoPrevisao();
 		TreinoRede_ObtemListaPrevisaoTeste exec = new TreinoRede_ObtemListaPrevisaoTeste();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}

	private void trataProximo() {
		DaoBaseComum.setProximo(TreinoRede_ObtemListaPrevisaoTeste.NOME, new PrevisaoTeste_ListaComDiarioExecucao());
		DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new BuscaSaidaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}

}
