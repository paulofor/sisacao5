package sisacao.deeplearning.desenvolvimento.dao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class TreinoRede_ExecutouPrevisaoTeste  extends DaoBasePrevisao{

	
	DummyDaoBase dummy = new DummyDaoBase();
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		long id = ds.getTreinoCorrente().getId();
		this.repTreino.executouPrevisaoTeste(id, new VoidCallback() {

			public void onSuccess() {
				finalizar();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

}
