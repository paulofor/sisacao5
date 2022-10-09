package sisacao.deeplearning.execucao.processamento;

import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class VerificaTrade extends DaoBasePrevisao{

	
	
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		CotacaoDiarioAcao cotacao = ds.getCotacaoDiarioAcao();
		TradeTreinoRede trade = ds.getTradeTreinoRede();
		// trata stop
		if (trade.getPrecoStop()>=cotacao.getMinimo() && trade.getPrecoStop()<= cotacao.getMaximo()) {
			trade.setDiaNumSaida(cotacao.getDiaNum());
			trade.setPrecoSaida(trade.getPrecoStop());
			int pontuacao = (int) (ds.getTreinoCorrente().getRegraProjecao().getStop() * 100);
			trade.setResultado(-1);
			trade.setPontuacao(pontuacao * -1);
			repTrade.finalizaTrade(trade, new ObjectCallback<TradeTreinoRede>() {

				public void onSuccess(TradeTreinoRede object) {
					finalizar();
				}

				public void onError(Throwable t) {
					onErrorBase(t);
				}});
		} else {
			// trata target
			if (trade.getPrecoTarget()>=cotacao.getMinimo() && trade.getPrecoTarget()<= cotacao.getMaximo()) {
				trade.setDiaNumSaida(cotacao.getDiaNum());
				trade.setPrecoSaida(trade.getPrecoTarget());
				int pontuacao = (int) (ds.getTreinoCorrente().getRegraProjecao().getTarget() * 100);
				trade.setResultado(1);
				trade.setPontuacao(pontuacao);
				repTrade.finalizaTrade(trade, new ObjectCallback<TradeTreinoRede>() {

					public void onSuccess(TradeTreinoRede object) {
						finalizar();
					}

					public void onError(Throwable t) {
						onErrorBase(t);
					}});
			} else {
				System.out.println("Continua no trade");
				finalizar();
			}
		}
		
	}

	@Override
	protected DaoBase getProximo() {

		return null;
	}

}
