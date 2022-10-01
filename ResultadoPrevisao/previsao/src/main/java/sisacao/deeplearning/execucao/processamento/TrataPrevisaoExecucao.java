package sisacao.deeplearning.execucao.processamento;

import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.dao.TradeTreinoRede_InsereTrade;

public class TrataPrevisaoExecucao extends DaoBasePrevisao{
	
	


	@Override
	protected void executaImpl() {
		DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		PrevisaoRede previsao = ds.getPrevisaoExecucaoCorrente();
		System.out.println(previsao);
		//List<PrevisaoTeste> listaPrevisao = ds.getListaPrevisao();
		double precoEntrada = previsao.getPrecoEntrada();
		double minimoDia = previsao.getMinimoDiario();
		double maximoDia = previsao.getMaximoDiario();
		if (precoEntrada >= minimoDia && precoEntrada <= maximoDia) {
			System.out.println("Ativou o preço");
			if (ds.podeProcessar(previsao)) {
				System.out.println("Não esta operando");
				TradeTreinoRede trade = new TradeTreinoRede();
				trade.setTicker(previsao.getTicker());
				trade.setPrecoEntrada(precoEntrada);
				trade.setTreinoRedeId(ds.getTreinoCorrente().getId());
				trade.setDiaNumEntrada(previsao.getDiaNumPrevisao());
				ds.setTradeTreinoRede(trade);
				executaProximo();
			} else {
				System.out.println("Ja esta operando");
				finalizar();
			}
		} else {
			System.out.println("Fora dos limites");
			finalizar();
		}
	}

	@Override
	protected DaoBase getProximo() {
		return new TradeTreinoRede_InsereTrade();
	}

}
