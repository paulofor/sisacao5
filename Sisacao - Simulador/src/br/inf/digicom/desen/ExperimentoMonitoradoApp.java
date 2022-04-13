package br.inf.digicom.desen;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.Constantes;
import br.inf.digicom.monitor.ExperimentoMonitoradoFacade;

public class ExperimentoMonitoradoApp {

	static RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	static RepositorioDiaPregao repExecucaoSimulacao = adapter.createRepository(RepositorioDiaPregao.class);
	
	public static void main(String[] args) {
		
		repExecucaoSimulacao.obtemProximoB3(new ObjectCallback<DiaPregao>() {
			@Override
			public void onSuccess(DiaPregao dia) {
				System.out.println("Ola Mundo - ExperimentoMonitoradoApp  " + dia.getDiaNum());
				ExperimentoMonitoradoFacade facade = new ExperimentoMonitoradoFacade();
				facade.atualizaPrecoEntrada(dia.getDiaNum());
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		}); 
		
	}
}
