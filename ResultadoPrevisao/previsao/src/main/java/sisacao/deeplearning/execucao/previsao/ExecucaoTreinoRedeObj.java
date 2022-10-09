package sisacao.deeplearning.execucao.previsao;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.CotacaoDiarioAcao_CotacaoDia;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.dao.TradeTreinoRede_AtualizaTrade;
import sisacao.deeplearning.execucao.dao.TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto;
import sisacao.deeplearning.execucao.processamento.VerificaTrade;

public class ExecucaoTreinoRedeObj {

	public void executa(int diaNum) {
		DatasetResultadoPrevisao ds = new DatasetResultadoPrevisao();
		ds.setDiaNumExecucao(diaNum);
		TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto exec = new TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto();
		exec.setComum(ds);
		trataProximo();
		exec.executa();
		
		TradeTreinoRede_AtualizaTrade exec2 = new TradeTreinoRede_AtualizaTrade();
		exec2.setComum(ds);
		exec2.executa();
	}

	private void trataProximo() {
		DaoBaseComum.setProximo(CotacaoDiarioAcao_CotacaoDia.NOME, new VerificaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new BuscaSaidaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}

}
