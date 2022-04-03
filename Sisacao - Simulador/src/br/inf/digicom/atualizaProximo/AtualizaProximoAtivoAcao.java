package br.inf.digicom.atualizaProximo;

import br.inf.digicom.loopback.DaoBaseApp;
import br.inf.digicom.simulacao.validacao.AtivoAcao_SimulacaoComMonitor;

public class AtualizaProximoAtivoAcao extends AtivoAcao_SimulacaoComMonitor {

	@Override
	protected DaoBaseApp getProximo() {
		return new AtualizaProximoDiaPregao();
	}

	
	
}
