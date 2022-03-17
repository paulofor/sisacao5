package br.inf.digicom;

import br.inf.digicom.simulacao.validacao.AtivoAcao_SimulacaoComMonitor;

public class ValidadorSimulacaoObj {

	public void executa() {
		AtivoAcao_SimulacaoComMonitor exec = new AtivoAcao_SimulacaoComMonitor();
		exec.setIdPeriodo(9);
		exec.executa();
	}

}
