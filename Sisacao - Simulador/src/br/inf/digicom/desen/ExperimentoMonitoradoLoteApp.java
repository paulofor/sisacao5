package br.inf.digicom.desen;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.inf.digicom.monitor.ExperimentoMonitoradoFacade;

public class ExperimentoMonitoradoLoteApp {

	
	public static void main(String[] args) {
		
		RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
		RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter.createRepository(RepositorioExecucaoSimulacao.class);
		
		System.out.println("Ola Mundo - ExperimentoMonitoradoLoteApp");

		int id = 2742622;
		repExecucaoSimulacao.obtemMonitorarPorId(id, new ObjectCallback<ExecucaoSimulacao>() {

			@Override
			public void onSuccess(ExecucaoSimulacao execucao) {
				ExperimentoMonitoradoFacade facade = new ExperimentoMonitoradoFacade();
				
				facade.atualizaPrecoEntrada(20210301, execucao);
				facade.atualizaPrecoEntrada(20210302, execucao);
				facade.atualizaPrecoEntrada(20210303, execucao);
				facade.atualizaPrecoEntrada(20210304, execucao);
				facade.atualizaPrecoEntrada(20210305, execucao);
				facade.atualizaPrecoEntrada(20210308, execucao);
				facade.atualizaPrecoEntrada(20210309, execucao);
				facade.atualizaPrecoEntrada(20210310, execucao);
				facade.atualizaPrecoEntrada(20210311, execucao);
				facade.atualizaPrecoEntrada(20210312, execucao);
				facade.atualizaPrecoEntrada(20210315, execucao);
				facade.atualizaPrecoEntrada(20210316, execucao);
				facade.atualizaPrecoEntrada(20210317, execucao);
				facade.atualizaPrecoEntrada(20210318, execucao);
				facade.atualizaPrecoEntrada(20210319, execucao);
				facade.atualizaPrecoEntrada(20210322, execucao);
				facade.atualizaPrecoEntrada(20210323, execucao);
				facade.atualizaPrecoEntrada(20210324, execucao);
				facade.atualizaPrecoEntrada(20210325, execucao);
				facade.atualizaPrecoEntrada(20210326, execucao);
				facade.atualizaPrecoEntrada(20210329, execucao);
				facade.atualizaPrecoEntrada(20210330, execucao);
				facade.atualizaPrecoEntrada(20210331, execucao);
				facade.atualizaPrecoEntrada(20210401, execucao);
				facade.atualizaPrecoEntrada(20210406, execucao);
				facade.atualizaPrecoEntrada(20210407, execucao);
				facade.atualizaPrecoEntrada(20210408, execucao);
				facade.atualizaPrecoEntrada(20210409, execucao);
				facade.atualizaPrecoEntrada(20210412, execucao);
				facade.atualizaPrecoEntrada(20210413, execucao);
				facade.atualizaPrecoEntrada(20210414, execucao);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
		
		
	}
}
