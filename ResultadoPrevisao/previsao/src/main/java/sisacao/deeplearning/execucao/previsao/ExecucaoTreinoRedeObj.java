package sisacao.deeplearning.execucao.previsao;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.dao.TreinoRede_ObtemListaPrevisaoTeste;
import sisacao.deeplearning.desenvolvimento.processamento.BuscaSaidaTrade;
import sisacao.deeplearning.execucao.dao.PrevisaoTeste_ObtemPorDiaTreinoSelecionada;
import sisacao.deeplearning.execucao.dao.TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto;

public class ExecucaoTreinoRedeObj {

	public void executa(int diaNum) {
		DatasetResultadoPrevisao ds = new DatasetResultadoPrevisao();
		ds.setDiaNumExecucao(diaNum);
		TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto exec = new TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
	}

	private void trataProximo() {
		//DaoBaseComum.setProximo(TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto.NOME, new PrevisaoTeste_ObtemPorDiaTreinoSelecionada());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new BuscaSaidaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}

}
