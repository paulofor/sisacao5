package br.inf.digicom.validador;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;

public class Experimento_ObtemParaValidacao extends ExecutorBase{

	
	private boolean concluido = false;
	public void executa() {
		this.repExperimento.obtemParaValidacao( new ObjectCallback<ExperimentoSimulacao>() {
			@Override
			public void onSuccess(ExperimentoSimulacao experimento) {
				System.out.println("Experimento:" + experimento.getCodigo());
				AtivoAcao_CarregaMelhorAtivos exec = new AtivoAcao_CarregaMelhorAtivos();
				exec.executa(experimento);
				concluido = true;
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		}); 
		while (!concluido) {
			System.out.println("wait Experimento_ObtemParaValidacao");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		return;
	}
}
