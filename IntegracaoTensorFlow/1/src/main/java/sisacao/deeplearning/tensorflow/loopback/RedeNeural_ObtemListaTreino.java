package sisacao.deeplearning.tensorflow.loopback;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.RedeNeural;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.tensorflow.python.GeraPython;

public class RedeNeural_ObtemListaTreino extends DaoAplicacao {

	
	private DaoBase proximo = new GeraPython();
	
	@Override
	protected void executaImpl() {
		final DatasetTreinoRede ds = (DatasetTreinoRede) getComum();
		this.repRede.obtemListaTreino(new ListCallback<RedeNeural>() {

			public void onSuccess(List<RedeNeural> objects) {
				for (RedeNeural rede : objects) {
					ds.setRedeCorrente(rede);
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
