package sisacao.deeplearning.execucao.previsao;

import br.inf.digicom.loopback.comum.DaoBaseComum;
import br.inf.digicom.loopback.comum.ativoacao.CotacaoDiarioAcao_ListaTickerDia;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.processamento.VerificaTradePrevisao;
import sisacao.deeplearning.execucao.dao.TreinoRede_ObtemSelecionadoComPeriodoExecucao;

public class ExecucaoTreinoRedeRecorrenteObj {

	public void executa() {
		DatasetResultadoPrevisao ds = new DatasetResultadoPrevisao();
		TreinoRede_ObtemSelecionadoComPeriodoExecucao exec = new TreinoRede_ObtemSelecionadoComPeriodoExecucao();
		exec.setComum(ds);
		trataProximo();
		exec.executa();

	}

	private void trataProximo() {
		DaoBaseComum.setProximo(CotacaoDiarioAcao_ListaTickerDia.NOME, new VerificaTradePrevisao());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerAteFinal.NOME, new BuscaSaidaTrade());
		//DaoBaseComum.setProximo(DiaPregao_ObtemIntradayResultadoTickerQuantidadeB3.NOME, new CriaDataSetEntrada());
	}

}
