package sisacao.deeplearning.desenvolvimento.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;

public class TreinoRede_ObtemListaPrevisaoTeste  extends DaoBasePrevisao{

	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		this.repTreino.obtemListaPrevisaoTeste(new ListCallback<TreinoRede>() {

			public void onSuccess(List<TreinoRede> objects) {
				for (TreinoRede treino:objects) {
					ds.setTreinoCorrente(treino);
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
		return new PrevisaoTeste_ListaComDiarioTeste();
	}

}
