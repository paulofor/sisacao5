package sisacao.deeplearning.execucao.dao;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class TradeTreinoRede_AtualizaTrade  extends DaoBasePrevisao{


	public static String NOME = "TradeTreinoRede_AtualizaTrade";
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		this.repTrade.atualizaTrade(new ObjectCallback<TradeTreinoRede>() {
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			public void onSuccess(TradeTreinoRede object) {
				System.out.println("Trade enviado");
				finalizar();
			}
		});
	}

	@Override
	protected DaoBase getProximo() {
		return null;
	}

	

}
