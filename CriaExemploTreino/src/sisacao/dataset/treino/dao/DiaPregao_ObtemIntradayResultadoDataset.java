package sisacao.dataset.treino.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import sisacao.dataset.treino.proc.GeraDataset;

public class DiaPregao_ObtemIntradayResultadoDataset extends DaoBase {

	


	@Override
	public void executaImpl() {
		repDiaPregao.obtemIntradayResultadoTickerPeriodo(this.getComum().getTicker(), 
				this.getComum().getInicioPeriodo(), new ListCallback<DiaPregao>() {

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				System.out.println("Resultado.Ok: " + objects.size() + " dias");
				GeraDataset exec = new GeraDataset();
				getComum().setListaPregao(objects);
				exec.setDatasetComum(getComum());
				exec.executa();
				setConcluido();
				
			}
			@Override
			public void onError(Throwable t) {
				this.onError(t);
			}
		});
	}



	

}
