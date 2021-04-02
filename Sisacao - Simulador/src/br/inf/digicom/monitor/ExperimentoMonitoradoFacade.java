package br.inf.digicom.monitor;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioValorMonitoria;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.RepositorioCotacao;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDia;
import br.inf.digicom.simulacao.regra.FabricaRegra;

public class ExperimentoMonitoradoFacade {
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter.createRepository(RepositorioExecucaoSimulacao.class);
	RepositorioValorMonitoria repValorMonitoria = adapter.createRepository(RepositorioValorMonitoria.class);
	
	int cont = 0;

	public void atualizaPrecoEntrada(final int dataNum) {
		repExecucaoSimulacao.listaMonitorar( new ListCallback<ExecucaoSimulacao>() {
			@Override
			public void onSuccess(List<ExecucaoSimulacao> listaExecucao) {
				for (ExecucaoSimulacao execucao : listaExecucao) {
					trataExecucaoMonitor(execucao,dataNum);
				}
				try {
					Thread.sleep(10000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				cont = 0;
				for (ExecucaoSimulacao execucao : listaExecucao) {
					System.out.println(execucao.getTicker() + ":" + execucao.getPrecoEntrada());
					repValorMonitoria.insereMonitoria(execucao, dataNum, execucao.getPrecoEntrada(), new VoidCallback() {
						@Override
						public void onSuccess() {
							System.out.println("Atualizou");
							cont++;
							if (cont==listaExecucao.size()) {
								System.exit(0);
							}
						}

						@Override
						public void onError(Throwable t) {
							t.printStackTrace();
							cont++;
							if (cont==listaExecucao.size()) System.exit(0);
						}
						
					});
	
				}
				//System.exit(0);
			}
			
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		});
		
	}
	
	private void trataExecucaoMonitor(ExecucaoSimulacao execucao, int dataNum) {
		RepositorioCotacao.carregaPorTicker(execucao.getTicker());
		IRegraPontoEntrada regra = FabricaRegra.criaRegra(execucao.getCombinacaoParametro().getRegraSimulacao());
		try {
			Thread.sleep(5000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimuladorPontoEntradaDia simulador = new SimuladorPontoEntradaDia();
		Double preco = simulador.precoEntrada(RepositorioCotacao.getCotacao(execucao.getTicker()), execucao.getCombinacaoParametro(), regra, dataNum);
		execucao.setPrecoEntrada(preco);
	}

}
