package br.inf.digicom.simulacao.validacao;

import br.inf.digicom.loopback.DaoBase;

public class ValidadorExperimentoDaoBase extends DaoBase {
	
	private ExecutaValidadorSelecionado exec = new ExecutaValidadorSelecionado();
	

	@Override
	protected void executaImpl() {
		exec.setComum(getComum());
		exec.executa();
	}

	@Override
	protected DaoBase getProximo() {
		// TODO Auto-generated method stub
		return null;
	}

}
