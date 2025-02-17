package br.inf.digicom.monitor;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.RegraSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioValorMonitoria;
import br.inf.digicom.Constantes;
import br.inf.digicom.TempoSleep;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.RepositorioCotacao;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDia;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDiaVenda;
import br.inf.digicom.simulacao.regra.FabricaRegra;
import br.inf.digicom.simulacao.regra.IRegraVenda;

public class ExperimentoMonitoradoFacade {
	
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter.createRepository(RepositorioExecucaoSimulacao.class);
	RepositorioValorMonitoria repValorMonitoria = adapter.createRepository(RepositorioValorMonitoria.class);
	
	int cont = 0;
	
	public synchronized void atualizaPrecoEntrada(final int dataNum, final ExecucaoSimulacao execucao) {
		trataExecucaoMonitor(execucao,dataNum);
		try {
			Thread.sleep(TempoSleep.PRE_INSERE_MONITORIA);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repValorMonitoria.insereMonitoria(execucao, dataNum, execucao.getPrecoEntrada(), execucao.getTipo(), 
					execucao.getPeriodoExperimentoId(), new VoidCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Atualizou");
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
	}

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
					repValorMonitoria.insereMonitoria(execucao, dataNum, execucao.getPrecoEntrada(), 
							execucao.getTipo(), execucao.getPeriodoExperimentoId(), new VoidCallback() {
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
		RegraSimulacao regraObj = execucao.getCombinacaoParametro().getRegraSimulacao();
		if (regraObj==null) {
			regraObj = execucao.getRegraSimulacao();
		}
		IRegraPontoEntrada regra = FabricaRegra.criaRegra(regraObj);
		try {
			Thread.sleep(TempoSleep.TRATA_EXECUCAO_MONITOR);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		SimuladorPontoEntradaDia simulador = null;
		if (regra instanceof IRegraVenda) {
			 simulador = new SimuladorPontoEntradaDiaVenda();
		} else {
			 simulador = new SimuladorPontoEntradaDia();
		}
		try {
			Thread.sleep(10000); // tempo para carregar o RepositorioCotacao
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		Double preco = simulador.precoEntrada(RepositorioCotacao.getCotacao(execucao.getTicker()), execucao.getCombinacaoParametro(), regra, dataNum);
		execucao.setPrecoEntrada(preco);
	}

}
