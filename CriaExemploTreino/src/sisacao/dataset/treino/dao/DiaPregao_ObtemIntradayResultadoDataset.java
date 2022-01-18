package sisacao.dataset.treino.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;

public class DiaPregao_ObtemIntradayResultadoDataset extends DaoBase {

	private String ticker;
	private int inicioPeriodo;

	
 	
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}



	public void setInicioPeriodo(int inicioPeriodo) {
		this.inicioPeriodo = inicioPeriodo;
	}



	@Override
	public void executa() {
		repDiaPregao.obtemIntradayResultadoTickerPeriodo(ticker, inicioPeriodo, new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				System.out.println("Resultado.Ok: " + objects.size());
			}
			@Override
			public void onError(Throwable t) {
				this.onError(t);
			}
		});
	}

}
