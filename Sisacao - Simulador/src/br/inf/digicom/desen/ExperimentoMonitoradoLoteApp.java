package br.inf.digicom.desen;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.inf.digicom.Constantes;
import br.inf.digicom.TempoSleep;
import br.inf.digicom.monitor.ExperimentoMonitoradoFacade;

public class ExperimentoMonitoradoLoteApp {

	static RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback);
	static RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter
			.createRepository(RepositorioExecucaoSimulacao.class);
	static RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);

	public static void main(String[] args) {

		System.out.println("Ola Mundo - ExperimentoMonitoradoLoteApp (24-01-2022)");

		//int id = 3156573;
		repExecucaoSimulacao.obtemProximoMonitorar(new ObjectCallback<ExecucaoSimulacao>() {
			@Override
			public void onSuccess(ExecucaoSimulacao execucao) {
				//execucao.setExperimentoSimulacaoId(3700658);
				if (execucao.getExperimentoSimulacaoId()!=null) {
					System.out.println("ID-Execucao: " + execucao.getId());
					atualizaPeriodos(execucao);
				} else {
					System.out.println("Sem pendencias");
					System.exit(0);
				}
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.exit(0);
			}
		});
	}

	
	
	
	public static void atualizaPeriodos(ExecucaoSimulacao execucao) {
		repDiaPregao.periodoAtualizacaoMonitoria(execucao.getId(), new ListCallback<DiaPregao>() {
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				System.exit(0);
			}

			@Override
			public void onSuccess(List<DiaPregao> lista) {
				ExperimentoMonitoradoFacade facade = new ExperimentoMonitoradoFacade();
				for (DiaPregao dia : lista) {
					facade.atualizaPrecoEntrada(dia.getDiaNum(), execucao);
				}
				try {
					Thread.sleep(TempoSleep.PRE_ENCERRAMENTO);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("Terminou");
				System.exit(0);

			}
		});
	}
}
