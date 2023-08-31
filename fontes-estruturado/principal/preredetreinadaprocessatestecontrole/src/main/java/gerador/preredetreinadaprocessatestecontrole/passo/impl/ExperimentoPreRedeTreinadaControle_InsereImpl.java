package gerador.preredetreinadaprocessatestecontrole.passo.impl;


import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaControle;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaScore;
import gerador.preredetreinadaprocessatestecontrole.passo.ExperimentoPreRedeTreinadaControle_Insere;



public class ExperimentoPreRedeTreinadaControle_InsereImpl extends ExperimentoPreRedeTreinadaControle_Insere {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinadaScore escolhidoDia) {
		this.controle = new ExperimentoPreRedeTreinadaControle();
		controle.setTicker(escolhidoDia.getTicker());
		controle.setDiaNum(escolhidoDia.getDiaNum());
		controle.setDiaNumEntrada(escolhidoDia.getDiaNumEntrada());
		controle.setDiaNumSaida(escolhidoDia.getDiaNumSaida());
		controle.setResultado(escolhidoDia.getResultado());
		controle.setExperimentoPreRedeTreinadaId(escolhidoDia.getExperimentoPreRedeTreinadaId());
		controle.setValorEntrada(escolhidoDia.getValorEntrada());
		controle.setValorSaida(escolhidoDia.getValorSaida());
		return true;
	} 


}

