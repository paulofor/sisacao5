package gerador.preredetreinadaprocessatestecontrole.passo.impl;


import java.util.List;

import br.com.gersis.loopback.modelo.CotacaoDiarioAcao;
import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaScore;
import br.com.gersis.loopback.modelo.RegraProjecao;
import gerador.preredetreinadaprocessatestecontrole.passo.VerificaTrade;



public class VerificaTradeImpl extends VerificaTrade {

	
	

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento, List<DiaPregao> listaDiaComCotacao,
			ExperimentoPreRedeTreinadaScore ativoMelhorDia) {
		RegraProjecao regra = experimento.getRegraProjecao();
		DiaPregao diaReferencia = listaDiaComCotacao.get(0);
		
		int ultimaPos = diaReferencia.getCotacaoIntradayAcaoResultados().size() - 1;
		double valorReferencia = diaReferencia.getCotacaoIntradayAcaoResultados().get(ultimaPos).getValor();
		
		// compra
		double valorEntrada = valorReferencia * (1-regra.getPercentualEntradaDataset()) ;
		DiaPregao diaEntrada = listaDiaComCotacao.get(1);
		CotacaoDiarioAcao diario = diaEntrada.getCotacaoDiarioAcaos().get(0);
		if (diario.getMinimo() < valorEntrada) {
			// Entrou
			ativoMelhorDia.setDiaNumEntrada(diaEntrada.getDiaNum());
			ativoMelhorDia.setValorEntrada(valorEntrada);
			
			double target = valorEntrada * (1+regra.getTarget());
			double stop = valorEntrada * (1-regra.getStop());
			
			for (int pos=2;pos<regra.getDiaLimite()+2;pos++) {
				if (listaDiaComCotacao.get(pos).getCotacaoDiarioAcaos().size()==0) {
					throw new RuntimeException("Dia:" + listaDiaComCotacao.get(pos).getDiaNum() + " ticker: " + ativoMelhorDia.getTicker() + " sem cotação diario");
				}
				
				CotacaoDiarioAcao corrente = listaDiaComCotacao.get(pos).getCotacaoDiarioAcaos().get(0);
				// Testa Saida
				if (corrente.getMaximo() >= target) {
					// saiu no target
					ativoMelhorDia.setValorSaida(target);
					ativoMelhorDia.setDiaNumSaida(corrente.getDiaNum());
					ativoMelhorDia.setResultado(1);
					return true;
				}
				if (corrente.getMinimo() <= stop) {
					// saiu no stop
					ativoMelhorDia.setValorSaida(stop);
					ativoMelhorDia.setDiaNumSaida(corrente.getDiaNum());
					ativoMelhorDia.setResultado(-1);
					return true;
				}
			}
			ativoMelhorDia.setResultado(0);
		}
		
		return true;
	} 


}

