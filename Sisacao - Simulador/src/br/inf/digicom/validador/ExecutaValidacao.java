package br.inf.digicom.validador;

import java.util.List;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.inf.digicom.simulacao.validacao.ExecutadorSimulacaoValidacao;

public class ExecutaValidacao extends ExecutorBase {
	
	private boolean concluido = false;
	public void executa(Integer id, List<AtivoAcao> listaAtivo, ExperimentoSimulacao experimento) {
		ExecutadorSimulacaoValidacao executadorValidacao = new ExecutadorSimulacaoValidacao();
		for (AtivoAcao acao : listaAtivo) {
			for (ExecucaoSimulacao execucao : acao.getExecucaoSimulacaos()) {
				CombinacaoParametro combinacao = execucao.getCombinacaoParametro();
				executadorValidacao.executa(acao,execucao,experimento);
				System.out.println("Finalizou ExecutaValidacao #" + execucao.getId());
			}
		}
		concluido = true;
		while (!concluido) {
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
