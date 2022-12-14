package sisacao.deeplearning.desenvolvimento.processamento;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.deeplearning.comum.TradeI;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.processamento.TradePrevisaoExecucao;

public class VerificaTradeSaida extends DaoBasePrevisao{



	
	
	public VerificaTradeSaida() {
		this.dummy = new DummyDaoBase();
	}
	
	
	
	@Override
	protected void executaImpl() {
		System.out.println("Verifica Saidas");
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		for (TradeI trade : ds.getListaTradeAberto()) {
			CotacaoDiarioAcao cotacao = this.getCotacaoDia(trade.getTicker());
			TradePrevisaoExecucao tradeExec = (TradePrevisaoExecucao) trade;
			if (!tradeExec.verificaSaida(cotacao)) {
				System.out.println(tradeExec.getTicker() + " na carteria " + tradeExec.getDias() + " dias.");
			}
			
		}
		executaProximo();
	}

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}
