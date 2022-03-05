package br.inf.digicom.simulacao.validacao;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.inf.digicom.Constantes;
import br.inf.digicom.simulacao.ExecutadorSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.regra.FabricaRegra;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class ExecutadorSimulacaoValidacao extends ExecutadorSimulacao{
	
	private ExecucaoSimulacao execucaoCorrente = null;
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	RepositorioExecucaoSimulacao rep = adapter.createRepository(RepositorioExecucaoSimulacao.class);
	
	protected void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao, IRegraPontoEntrada regra, ExperimentoSimulacao experimento)  {
		System.out.println("Execucao: " + execucaoCorrente.getId());
		System.out.println("Ticker: " + ticker);
		serie.salvaExecucaoValidacao(execucao,ticker,combinacao, regra, experimento,execucaoCorrente);
	}

	private boolean concluido = false;
	public void executa(AtivoAcao ativo, ExecucaoSimulacao execucao,final ExperimentoSimulacao experimentoValidacao) {
		this.execucaoCorrente = execucao;
		rep.obtemMonitorarPorId(execucao.getId(), new ObjectCallback<ExecucaoSimulacao>() {
			@Override
			public void onSuccess(ExecucaoSimulacao execucaoAtual) {
				IRegraPontoEntrada regra = FabricaRegra.criaRegra(execucaoAtual.getCombinacaoParametro().getRegraSimulacao());
				experimentoValidacao.setValidacao();
				executaTicker(ativo.getTicker(), regra, execucaoAtual.getCombinacaoParametro(), experimentoValidacao);
				concluido = true;
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}}); 
		while (!concluido) {
			try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
