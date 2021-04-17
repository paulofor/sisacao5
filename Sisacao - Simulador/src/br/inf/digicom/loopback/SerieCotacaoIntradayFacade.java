package br.inf.digicom.loopback;

import java.util.HashMap;
import java.util.Map;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ExperimentoSimulacao;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.RepositorioCotacao;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDia;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;
import br.inf.digicom.simulacao.trade.Trade;

public class SerieCotacaoIntradayFacade {
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter.createRepository(RepositorioExecucaoSimulacao.class);
	
	SimuladorPontoEntradaDia simulacao = new SimuladorPontoEntradaDia();
	
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
	
	public void executaTicker(String ticker, IRegraPontoEntrada regra, CombinacaoParametro combinacao,ExperimentoSimulacao experimento) {
		Map parametros = new HashMap();
		for (ValorParametro param : combinacao.getValorParametros()) {
			parametros.put(param.getParametroRegra().getAtributoClasse(),param.getValorParametro());
		}
		ExecucaoPontoEntrada execucao = simulacao.executa(RepositorioCotacao.getCotacao(ticker),parametros, regra, experimento.diaInicio(), experimento.diaFinal());
		salvaExecucao(execucao,ticker,combinacao, regra, experimento);
		parametros = null;
	}
	
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
			Thread.sleep(800);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		repExecucaoSimulacao.insereExecucaoSimulacao(exec, new VoidCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Inseriu execucao");
				addConcluido();
				
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
