package gerador.preredetreinadaprocessatestecontrole.passo.impl;


import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import gerador.preredetreinadaprocessatestecontrole.passo.*;



public class ExperimentoPreRedeTreinada_CalculaResultadoControleImpl extends ExperimentoPreRedeTreinada_CalculaResultadoControle {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento) {
		this.experimentoId = (Integer) experimento.getId();
		return true;
	}


	


	
}

