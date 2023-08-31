package gerador.preredetreinadaprocessateste.passo.impl;


import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import gerador.preredetreinadaprocessateste.passo.*;



public class ExperimentoPreRedeTreinadaScore_ObtemMelhoresPorDiaImpl extends ExperimentoPreRedeTreinadaScore_ObtemMelhoresPorDia {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento, DiaPregao diaCorrente) {
		this.diaNum = diaCorrente.getDiaNum();
		this.experimentoId = (Integer) experimento.getId();
		return true;
	} 


}

