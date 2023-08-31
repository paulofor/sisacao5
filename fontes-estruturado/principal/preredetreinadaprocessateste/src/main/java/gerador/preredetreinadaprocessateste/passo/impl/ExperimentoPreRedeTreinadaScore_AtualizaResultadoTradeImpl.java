package gerador.preredetreinadaprocessateste.passo.impl;


import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaScore;
import gerador.preredetreinadaprocessateste.passo.*;



public class ExperimentoPreRedeTreinadaScore_AtualizaResultadoTradeImpl extends ExperimentoPreRedeTreinadaScore_AtualizaResultadoTrade {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinadaScore ativoMelhorDia) {
		this.resultado = ativoMelhorDia;
		return true;
	} 


	
	
}

