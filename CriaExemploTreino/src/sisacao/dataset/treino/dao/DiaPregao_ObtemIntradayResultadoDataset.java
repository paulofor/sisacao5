package sisacao.dataset.treino.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import sisacao.dataset.treino.proc.GeraDataset;

public class DiaPregao_ObtemIntradayResultadoDataset extends DaoBaseApp {

	


	@Override
	public void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		String ticker = ds.getTicker();
		Integer inicioPeriodo = ds.getInicioPeriodo();
		repDiaPregao.obtemIntradayResultadoTickerPeriodo(ticker, inicioPeriodo, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				System.out.println("Resultado.Ok: " + objects.size() + " dias");
				GeraDataset exec = new GeraDataset();
				ds.setListaPregao(objects);
				executaProximo();
		
				
			}
			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
		});
	}

	@Override
	protected DaoBaseApp getProximo() {
		return new ProcessadorGeraDataset();
	}



	

}
