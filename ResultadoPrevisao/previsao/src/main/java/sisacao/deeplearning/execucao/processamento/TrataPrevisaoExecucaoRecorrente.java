package sisacao.deeplearning.execucao.processamento;

import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.comum.TradeI;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.dao.TradeTreinoRede_InsereTrade;

public class TrataPrevisaoExecucaoRecorrente extends DaoBasePrevisao{
	
	


	@Override
	protected void executaImpl() {
		
		DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		PrevisaoRede previsao = ds.getPrevisaoExecucaoCorrente();
		System.out.println("Testando entrada em " + previsao.getTicker());
		if (!ds.podeProcessarTreinoCorrente(previsao)) {
			finalizar();
			return;
		}
		
		
		System.out.println(previsao);
		//List<PrevisaoTeste> listaPrevisao = ds.getListaPrevisao();
		double precoEntrada = previsao.getPrecoEntrada();
		double minimoDia = previsao.getMinimoDiario();
		double maximoDia = previsao.getMaximoDiario();
		if (precoEntrada >= minimoDia && precoEntrada <= maximoDia) {
			System.out.println("Ativou o preço");
			TradeTreinoRede trade = new TradeTreinoRede();
			trade.setTicker(previsao.getTicker());
			trade.setPrecoEntrada(precoEntrada);
			trade.setTreinoRedeId(ds.getTreinoCorrente().getId());
			trade.setDiaNumEntrada(previsao.getDiaNumPrevisao());
			double precoStop = previsao.precoStop();
			double precoTarget = previsao.precoTarget();
			trade.setPrecoTarget(precoTarget);
			trade.setPrecoStop(precoStop);
			trade.setTipoCompraVenda(previsao.getTipoCompraVenda());
			ds.setTradeTreinoRede(trade);
			ds.getTreinoCorrente().getTradeTreinoRedes().add(trade);
			executaProximo();
		} else {
			System.out.println("Fora do preço [" + minimoDia + "-" + maximoDia + "]");
			finalizar();
		}
	}

	@Override
	protected DaoBase getProximo() {
		return new TradeTreinoRede_InsereTrade();
	}

}
