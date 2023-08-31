package gerador.preredetreinadaprocessatestecontrole.passo.impl;


import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import gerador.preredetreinadaprocessatestecontrole.passo.*;



public class ExperimentoPreRedeTreinadaScore_ObtemAleatoriaBaseadaEmMelhoresImpl extends ExperimentoPreRedeTreinadaScore_ObtemAleatoriaBaseadaEmMelhores { 


	
	
	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento, DiaPregao diaCorrente) {
		this.diaNum = diaCorrente.getDiaNum();
		this.experimentoId = (Integer) experimento.getId();
		return true;
	} 
}

