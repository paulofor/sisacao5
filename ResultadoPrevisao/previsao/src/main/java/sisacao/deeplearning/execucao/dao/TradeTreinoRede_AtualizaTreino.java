package sisacao.deeplearning.execucao.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class TradeTreinoRede_AtualizaTreino extends DaoBasePrevisao{
	
	public TradeTreinoRede_AtualizaTreino() {
		this.dummy = new DummyDaoBase();
	}

	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		List<TradeTreinoRede> resultado = ds.getTradeResultado();
		this.repTrade.atualizaTreino(resultado, new VoidCallback() {

			public void onSuccess() {
				executaProximo();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
				
			}
			
		});
	}

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}

}
