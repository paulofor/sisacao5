package br.inf.digicom.loopback;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacaoValidacao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacaoValidacao;
import br.inf.digicom.Constantes;
import br.inf.digicom.TempoSleep;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;
import br.inf.digicom.simulacao.trade.Trade;

public class SerieCotacaoIntradayFacade {
	
	RestAdapter adapter = new RestAdapter(Constantes.UrlLoopback); 
	
	RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter.createRepository(RepositorioExecucaoSimulacao.class);
	RepositorioExecucaoSimulacaoValidacao repExecucaoSimulacaoValidacao = adapter.createRepository(RepositorioExecucaoSimulacaoValidacao.class);
	//SimuladorPontoEntradaDia simulacao = new SimuladorPontoEntradaDia();
	
	private int contaConcluidos = 0;
	
	public int getConcluidos() {
		return this.contaConcluidos;
	}
	public synchronized void addConcluido() {
		this.contaConcluidos++;
	}

	/*
	public synchronized void  obtemSerie(String ticker, IRegraPontoEntrada regra, CombinacaoParametro combinacao, int dias) {
		Integer any = new Integer(0);
		ListCallback<DiaPregao> callback = new ListCallback<DiaPregao>() {
			@Override
			public void onSuccess(List<DiaPregao> objects) {

				Map parametros = new HashMap();
				for (ValorParametro param : combinacao.getValorParametros()) {
					parametros.put(param.getParametroRegra().getAtributoClasse(),param.getValorParametro());
				}
				ExecucaoPontoEntrada execucao = simulacao.executa(objects,parametros, regra);
				salvaExecucao(execucao,ticker,combinacao);
				//any.notify();
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
				//any.notify();
			}
		};
		repDiaPregao.obtemPorDiaTicker(ticker, dias, callback); 
			
	}
	*/
	
	
	
	public void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao, IRegraPontoEntrada regra, ExperimentoSimulacao experimento) {
		System.out.println(ticker);
		System.out.println(combinacao);
		execucao.exibeResultado();
		ExecucaoSimulacao exec = new ExecucaoSimulacao();
		exec.setTicker(ticker);
		exec.setCombinacaoParametroId(combinacao.getId());
		exec.setQuantidadeLucro(execucao.getSomaLucro());
		exec.setQuantidadePrejuizo(execucao.getSomaPrejuizo());
		exec.setTarget(regra.getTarget());
		exec.setStop(regra.getStop());
		exec.setExperimentoSimulacaoId(combinacao.getExperimentoSimulacaoId());
		exec.setRegraSimulacaoId(combinacao.getRegraSimulacaoId());
		exec.setPeriodoExperimentoId(experimento.periodoExperimentoId());
		exec.setTipo(regra.getTipo());
		String primeiraEntrada = "";
		if (execucao.listaTrades().size()>0) {
			primeiraEntrada = execucao.listaTrades().get(0).entradaDataPrecoDisplay();
		}
		exec.setPrimeiraEntrada(primeiraEntrada);
		for (Trade trade : execucao.listaTrades()) {
			br.com.digicom.sisacao.modelo.Trade tradeModel = new br.com.digicom.sisacao.modelo.Trade();
			tradeModel.setPrecoEntrada(trade.getValorEntrada());
			tradeModel.setPrecoSaida(trade.getValorSaida());
			tradeModel.setPercentual(trade.percentual());
			tradeModel.setQuantidadeDia(trade.getQuantidadeDia());
			tradeModel.setDataEntradaNum(trade.getCotacaoEntrada().getDiaNum());
			tradeModel.setDataSaidaNum(trade.getCotacaoSaida().getDiaNum());
			tradeModel.setDataHoraEntrada(trade.getCotacaoEntrada().getDataExtraida() + " " + trade.getCotacaoEntrada().getHoraExtraida());
			tradeModel.setDataHoraSaida(trade.getCotacaoSaida().getDataExtraida() + " " + trade.getCotacaoSaida().getHoraExtraida());
			exec.addTrade(tradeModel);
		};
		try {
			Thread.sleep(TempoSleep.PRE_INSERT_SIMULACAO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repExecucaoSimulacao.insereExecucaoSimulacao(exec, new VoidCallback() {
			@Override
			public void onSuccess() {
				//System.out.println("Inseriu execucao");
				addConcluido();
				
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
	}
	public void salvaExecucaoValidacao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao,
			IRegraPontoEntrada regra, ExperimentoSimulacao experimento, ExecucaoSimulacao execSim) {
		// TODO Auto-generated method stub
		System.out.println(ticker);
		System.out.println(combinacao);
		execucao.exibeResultado();
		ExecucaoSimulacaoValidacao exec = new ExecucaoSimulacaoValidacao();
		exec.setTicker(ticker);
		exec.setCombinacaoParametroId(combinacao.getId());
		exec.setQuantidadeLucro(execucao.getSomaLucro());
		exec.setQuantidadePrejuizo(execucao.getSomaPrejuizo());
		exec.setTarget(regra.getTarget());
		exec.setStop(regra.getStop());
		exec.setExperimentoSimulacaoId(experimento.getId());
		exec.setRegraSimulacaoId(combinacao.getRegraSimulacaoId());
		exec.setPeriodoExperimentoId(experimento.periodoExperimentoId());
		exec.setTipo(regra.getTipo());
		exec.setExperimentoSimulacaoId(experimento.getId());
		exec.setExecucaoSimulacaoId(execSim.getId());
		String primeiraEntrada = "";
		if (execucao.listaTrades().size()>0) {
			primeiraEntrada = execucao.listaTrades().get(0).entradaDataPrecoDisplay();
		}
		exec.setPrimeiraEntrada(primeiraEntrada);
		for (Trade trade : execucao.listaTrades()) {
			br.com.digicom.sisacao.modelo.Trade tradeModel = new br.com.digicom.sisacao.modelo.Trade();
			tradeModel.setPrecoEntrada(trade.getValorEntrada());
			tradeModel.setPrecoSaida(trade.getValorSaida());
			tradeModel.setPercentual(trade.percentual());
			tradeModel.setQuantidadeDia(trade.getQuantidadeDia());
			tradeModel.setDataEntradaNum(trade.getCotacaoEntrada().getDiaNum());
			tradeModel.setDataSaidaNum(trade.getCotacaoSaida().getDiaNum());
			tradeModel.setDataHoraEntrada(trade.getCotacaoEntrada().getDataExtraida() + " " + trade.getCotacaoEntrada().getHoraExtraida());
			tradeModel.setDataHoraSaida(trade.getCotacaoSaida().getDataExtraida() + " " + trade.getCotacaoSaida().getHoraExtraida());
			exec.addTrade(tradeModel);
		};
		try {
			Thread.sleep(TempoSleep.PRE_INSERT_SIMULACAO);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repExecucaoSimulacaoValidacao.insereExecucaoSimulacaoValidacao(exec, new VoidCallback() {
			@Override
			public void onSuccess() {
				//System.out.println("Inseriu execucao");
				addConcluido();
				
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
