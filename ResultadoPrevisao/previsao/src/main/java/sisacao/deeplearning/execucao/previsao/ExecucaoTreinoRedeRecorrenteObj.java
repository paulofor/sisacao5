package sisacao.deeplearning.execucao.previsao;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.CotacaoDiarioAcao_CotacaoDia;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.dao.TradeTreinoRede_AtualizaTrade;
import sisacao.deeplearning.execucao.dao.TreinoRede_ObtemSelecionadoComPeriodoExecucao;
import sisacao.deeplearning.execucao.processamento.VerificaTrade;

public class ExecucaoTreinoRedeRecorrenteObj {

	public void executa() {
		DatasetResultadoPrevisao ds = new DatasetResultadoPrevisao();
		TreinoRede_ObtemSelecionadoComPeriodoExecucao exec = new TreinoRede_ObtemSelecionadoComPeriodoExecucao();
		exec.setComum(ds);
		trataProximo();
		exec.executa();

	}

	private void trataProximo() {
		//DaoBaseComum.setProximo(CotacaoDiarioAcao_CotacaoDia.NOME, new VerificaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new BuscaSaidaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}

}
