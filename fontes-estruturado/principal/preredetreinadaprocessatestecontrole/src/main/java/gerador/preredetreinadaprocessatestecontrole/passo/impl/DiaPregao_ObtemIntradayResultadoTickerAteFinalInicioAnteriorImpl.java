package gerador.preredetreinadaprocessatestecontrole.passo.impl;


import br.com.gersis.loopback.modelo.DiaPregao;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaControle;
import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinadaScore;
import gerador.preredetreinadaprocessatestecontrole.passo.*;



public class DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnteriorImpl extends DiaPregao_ObtemIntradayResultadoTickerAteFinalInicioAnterior { 

	
	
	

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento, DiaPregao diaCorrente,
			ExperimentoPreRedeTreinadaScore escolhidoDia) {
		this.ticker = escolhidoDia.getTicker();
		this.dataNumInicio = diaCorrente.getDiaNum();
		this.tamanhoAmostra = 200;
		return true;
	}



	
}

