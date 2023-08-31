package gerador.preredetreinadaprocessateste.passo.impl;


import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import gerador.preredetreinadaprocessateste.passo.*;



public class ExperimentoPreRedeTreinada_CalculaResultadoImpl extends ExperimentoPreRedeTreinada_CalculaResultado {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento) {
		this.experimentoId = (Integer) experimento.getId();
		return true;
	} 


}

