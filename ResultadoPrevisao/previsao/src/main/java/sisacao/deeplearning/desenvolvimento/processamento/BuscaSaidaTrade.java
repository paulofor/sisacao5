package sisacao.deeplearning.desenvolvimento.processamento;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.dao.PrevisaoTeste_AtualizaResultadoTeste;

public class BuscaSaidaTrade extends DaoBasePrevisao{

	
	
	
	@Override
	protected void executaImpl() {
		DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		TradePrevisao trade = ds.getTradeCorrente();
		System.out.println(trade.getPrevisao());
		List<DiaPregao> listaCotacao = ds.getListaCotacaoResultado();
		System.out.println("Tam:" + listaCotacao.size());
		for (DiaPregao dia : listaCotacao) {
			if (verificaSaida(dia,trade)) {
				System.out.println(trade.getPrevisao());
				//ds.adicionaTrade(trade);
				executaProximoSemFinalizar();
				break;
			}
		}
		finalizar();
	}
	
	

	private boolean verificaSaida(DiaPregao dia, TradePrevisao trade) {
		System.out.println("Data: " + dia.getDiaNum());
		if (dia.getCotacaoDiarioAcaos().size()<1) {
			return false;
		}
		CotacaoDiarioAcao cotacao = dia.getCotacaoDiarioAcaos().get(0);
		System.out.println(cotacao);
		if (trade.limiteInferior() <= dia.getMaximoDia() && trade.limiteInferior() >= dia.getMinimoDia()) {
			trade.saidaInferior(cotacao);
			return true;
		}
		if (trade.limiteSuperior() <= dia.getMaximoDia() && trade.limiteSuperior() >= dia.getMinimoDia()) {
			trade.saidaSuperior(cotacao);
			return true;
		}
		return false;
	}

	
	@Override
	protected DaoBase getProximo() {
		return new PrevisaoTeste_AtualizaResultadoTeste();
	}

}
