package br.inf.digicom.loopback;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.CombinacaoParametro;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.ValorParametro;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.simulacao.IRegraPontoEntrada;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDia;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class SerieCotacaoIntradayFacade {
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	
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
	}
}
