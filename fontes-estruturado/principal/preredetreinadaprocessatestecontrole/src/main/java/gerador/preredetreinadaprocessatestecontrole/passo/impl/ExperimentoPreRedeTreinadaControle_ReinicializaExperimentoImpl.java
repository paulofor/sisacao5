package gerador.preredetreinadaprocessatestecontrole.passo.impl;


import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import gerador.preredetreinadaprocessatestecontrole.passo.*;



public class ExperimentoPreRedeTreinadaControle_ReinicializaExperimentoImpl extends ExperimentoPreRedeTreinadaControle_ReinicializaExperimento {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento) {
		this.experimentoId = (Integer) experimento.getId();
		return true;
	} 


}

