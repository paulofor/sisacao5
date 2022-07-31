package sisacao.deeplearning.desenvolvimento.processamento;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultado;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.dao.PrevisaoRede_AtualizaResultado;

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
		CotacaoDiarioAcao cotacao = dia.getCotacaoDiarioAcaos().get(0);
		System.out.println(cotacao);
		if (trade.limiteInferior() <= obtemMaximo(dia) && trade.limiteInferior() >= obtemMinimo(dia)) {
			trade.saidaInferior(cotacao);
			return true;
		}
		if (trade.limiteSuperior() <= obtemMaximo(dia) && trade.limiteSuperior() >= obtemMinimo(dia)) {
			trade.saidaSuperior(cotacao);
			return true;
		}
		return false;
	}

	private Double obtemMaximo(DiaPregao dia) {
		Double max = (dia.getCotacaoDiarioAcaos().size()>0?dia.getCotacaoDiarioAcaos().get(0).getMaximo():null);
		if (max!=null) return max;
		max = 0d;
		for (CotacaoIntradayAcaoResultado cotacao :dia.getCotacaoIntradayAcaoResultados()) {
			if (cotacao.getValor() > max) max = cotacao.getValor();
		}
		return max;
		
		
	}
	private Double obtemMinimo(DiaPregao dia) {
		Double min = (dia.getCotacaoDiarioAcaos().size()>0?dia.getCotacaoDiarioAcaos().get(0).getMinimo():null);
		if (min!=null) return min;
		min = 99999d;
		for (CotacaoIntradayAcaoResultado cotacao :dia.getCotacaoIntradayAcaoResultados()) {
			if (cotacao.getValor() < min) min = cotacao.getValor();
		}
		return min;
	}

	@Override
	protected DaoBase getProximo() {
		return new PrevisaoRede_AtualizaResultado();
	}

}
