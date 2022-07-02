package sisacao.deeplearning.tensorflow.loopback;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.tensorflow.python.GeraPython;

public class RedeNeural_ObtemListaTreino extends DaoAplicacao {

	
	private DaoBase proximo = new GeraPython();
	
	@Override
	protected void executaImpl() {
		final DatasetTreinoRede ds = (DatasetTreinoRede) getComum();
		this.repTreinoRede.obtemListaParaTreino(new ListCallback<TreinoRede>() {

			public void onSuccess(List<TreinoRede> objects) {
				for (TreinoRede treino : objects) {
					ds.setTreinoRedeCorrente(treino);
					executaProximoSemFinalizar();
				}
				finalizar();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}
		});

		
	}

	@Override
	protected DaoBase getProximo() {
		return proximo;
	}

}
