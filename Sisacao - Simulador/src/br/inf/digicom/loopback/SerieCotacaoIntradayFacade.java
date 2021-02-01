package br.inf.digicom.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.app.Loopback;
import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.inf.digicom.simulacao.SimuladorPontoEntradaDia;
import br.inf.digicom.simulacao.trade.ExecucaoPontoEntrada;

public class SerieCotacaoIntradayFacade {
	
	RestAdapter adapter = new RestAdapter(Loopback.URL_SISACAO); 
	
	RepositorioDiaPregao repDiaPregao = adapter.createRepository(RepositorioDiaPregao.class);
	
	SimuladorPontoEntradaDia simulacao = new SimuladorPontoEntradaDia();

	public void obtemSerie(String ticker, int dias) {
	
		repDiaPregao.obtemPorDiaTicker(ticker, dias, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				//System.out.println(objects.size());
				//for (DiaPregao dia : objects) {
				//	System.out.println("Dia: " + dia.getDiaNum() + " " + dia.getCotacaoIntradayAcaos().size());
				//}
				ExecucaoPontoEntrada execucao = new ExecucaoPontoEntrada();
				simulacao.executa(objects,execucao);
			}

			@Override
			public void onError(Throwable t) {
				t.printStackTrace();
			}
			
		}); 
				
	}
}
