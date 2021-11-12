package br.inf.digicom.validador;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.inf.digicom.simulacao.RepositorioCotacao;

public class AtivoAcao_CarregaMelhorAtivos extends ExecutorBase{

	
	private boolean concluido = false;
	public void executa(ExperimentoSimulacao experimento) {
		repAtivoAcao.melhorParaValidacao(experimento.getId(), new ListCallback<AtivoAcao>() {
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				System.out.println("Ativos Melhores: " + objects.size());
				RepositorioCotacao.carregaAtivos(objects, experimento.diaInicioColeta());
				int id = experimento.getId();
				ExecutaValidacao exec = new ExecutaValidacao();
				exec.executa(id, objects, experimento);
				System.out.println("Terminou AtivoAcao_CarregaMelhorAtivos");
				concluido = true;
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}});
		while (!concluido) {
			System.out.println("wait AtivoAcao_CarregaMelhorAtivos");
			try {
				Thread.sleep(5000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
