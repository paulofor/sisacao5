package sisacao.deeplearning.desenvolvimento.dao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class PrevisaoRede_AtualizaResultado extends DaoBasePrevisao{

	
	DummyDaoBase dummy = new DummyDaoBase();
	
	@Override
	protected void executaImpl() {
		// TODO Auto-generated method stub
		DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		PrevisaoRede previsao = ds.getTradeCorrente().getPrevisao();
		System.out.println(previsao);
		this.repPrevisao.atualizaResultado(previsao, new VoidCallback() {

			public void onSuccess() {
				executaProximo();

				finalizar();
			}

			public void onError(Throwable t) {
				// TODO Auto-generated method stub
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

}
