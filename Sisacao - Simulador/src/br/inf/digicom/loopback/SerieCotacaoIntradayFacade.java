package br.inf.digicom.loopback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ExecucaoSimulacao;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioExecucaoSimulacao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDia;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;
import br.inf.digicom.simulacao.trade.Trade;

public class SerieCotacaoIntradayFacade {
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO_LOCAL); 
	
	RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	RepositorioExecucaoSimulacao repExecucaoSimulacao = adapter.createRepository(RepositorioExecucaoSimulacao.class);
	
	SimuladorPontoEntradaDia simulacao = new SimuladorPontoEntradaDia();

	public void obtemSerie(String ticker, IRegraPontoEntrada regra, CombinacaoParametro combinacao, int dias) {
	
		repDiaPregao.obtemPorDiaTicker(ticker, dias, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {

				Map parametros = new HashMap();
				for (ValorParametro param : combinacao.getValorParametros()) {
					parametros.put(param.getParametroRegra().getAtributoClasse(),param.getValorParametro());
				}
				ExecucaoPontoEntrada execucao = simulacao.executa(objects,parametros, regra);
				salvaExecucao(execucao,ticker,combinacao);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		}); 
				
	}
	
	public void salvaExecucao(ExecucaoPontoEntrada execucao, String ticker, CombinacaoParametro combinacao) {
		System.out.println(ticker);
		System.out.println(combinacao);
		execucao.exibeResultado();
		ExecucaoSimulacao exec = new ExecucaoSimulacao();
		exec.setTicker(ticker);
		exec.setCombinacaoParametroId(combinacao.getId());
		exec.setQuantidadeLucro(execucao.getSomaLucro());
		exec.setQuantidadePrejuizo(execucao.getSomaPrejuizo());
		for (Trade trade : execucao.listaTrades()) {
			br.com.digicom.sisacao.modelo.Trade tradeModel = new br.com.digicom.sisacao.modelo.Trade();
			tradeModel.setPrecoEntrada(trade.getValorEntrada());
			tradeModel.setPrecoSaida(trade.getValorSaida());
			tradeModel.setPercentual(trade.percentual());
			tradeModel.setQuantidadeDia(trade.getQuantidadeDia());
			tradeModel.setDataEntrada(trade.getCotacaoEntrada().getDataExtraida());
			tradeModel.setDataSaida(trade.getCotacaoSaida().getDataExtraida());
			tradeModel.setDataHoraEntrada(trade.getCotacaoEntrada().getDataExtraida() + " " + trade.getCotacaoEntrada().getHoraExtraida());
			tradeModel.setDataHoraSaida(trade.getCotacaoSaida().getDataExtraida() + " " + trade.getCotacaoSaida().getHoraExtraida());
			exec.addTrade(tradeModel);
		};
		repExecucaoSimulacao.insereExecucaoSimulacao(exec, new VoidCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Inseriu execucao");
			}
			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
		});
	}
}
