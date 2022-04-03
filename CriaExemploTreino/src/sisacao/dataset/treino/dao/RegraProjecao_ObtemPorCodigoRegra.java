package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.RegraProjecao;
import br.inf.digicom.loopback.DaoBase;

public class RegraProjecao_ObtemPorCodigoRegra extends DaoBaseApp {

	
	





	@Override
	public void executaImpl() {
		final DatasetComum ds = (DatasetComum) getComum();
		String codigoRegra = ds.getRegraProjecao().getCodigoRegraProjecao();
		repRegraProjecao.obtemPorCodigoRegra(codigoRegra, new ObjectCallback<RegraProjecao>() {

			@Override
			public void onSuccess(RegraProjecao object) {
				System.out.println("Regra Id: " + object.getId());
				ds.setRegraProjecao(object);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});

	}

	@Override
	protected DaoBase getProximo() {
		return new DiaPregao_ObtemIntradayResultadoDataset();
	}

}
