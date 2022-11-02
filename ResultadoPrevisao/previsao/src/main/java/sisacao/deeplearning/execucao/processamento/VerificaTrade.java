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
		if (verificaStop(trade,cotacao)) {
			System.out.println("Saiu por stop");
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
			if (verificaTarget(trade,cotacao)) {
				System.out.println("Saiu por target");
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

	private boolean verificaStop(TradeTreinoRede trade, CotacaoDiarioAcao cotacao) {
		double precoStop = trade.getPrecoStop();
		double maximo = cotacao.getMaximo();
		double minimo = cotacao.getMinimo();
		boolean compra = "C".equals(trade.getTipoCompraVenda());
		
		if (compra) {
			System.out.println("Bull - Stop: " + precoStop + ", minimo: " + minimo);
			if (minimo<=precoStop) return true;
			else return false;
		} else {
			System.out.println("Bear - Stop: " + precoStop + ", maximo: " + maximo);
			if (maximo>=precoStop) return true;
			else return false;
		}
	}
	private boolean verificaTarget(TradeTreinoRede trade, CotacaoDiarioAcao cotacao) {
		double precoStop = trade.getPrecoStop();
		double precoTarget = trade.getPrecoTarget();
		double maximo = cotacao.getMaximo();
		double minimo = cotacao.getMinimo();
		boolean compra = "C".equals(trade.getTipoCompraVenda());
		if (compra) {
			if (precoTarget<=maximo) return true;
			else return false;
		} else {
			if (precoTarget>=minimo) return true;
			else return false;
		}
	}
	
	@Override
	protected DaoBase getProximo() {

		return null;
	}

}
