package gerador.preredetreinadaprocessateste.passo.impl;


import br.com.gersis.loopback.modelo.ExperimentoPreRedeTreinada;
import gerador.preredetreinadaprocessateste.passo.*;



public class DiaPregao_ObtemPeriodoPrevisaoTesteImpl extends DiaPregao_ObtemPeriodoPrevisaoTeste {

	@Override
	protected boolean executaCustom(ExperimentoPreRedeTreinada experimento) {
		this.idPeriodoTreinoRede = experimento.getPeriodoTreinoRedeId();
		return true;
	} 

	

}

