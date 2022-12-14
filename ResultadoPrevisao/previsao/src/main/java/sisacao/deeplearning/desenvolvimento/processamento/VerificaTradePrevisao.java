package sisacao.deeplearning.desenvolvimento.processamento;

import java.util.List;

import br.com.digicom.sisacao.modelo.CotacaoDiarioAcao;
import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.processamento.TradePrevisaoExecucao;

public class VerificaTradePrevisao extends DaoBasePrevisao{


	
	
	public VerificaTradePrevisao() {
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		List<PrevisaoRede> listaPrevisao = ds.getListaPrevisaoExecucao();
		for (PrevisaoRede previsao : listaPrevisao) {
			System.out.println(previsao.getDiaNumPrevisao() + " - " + previsao.getTicker());
			if (ds.podeProcessar(previsao)) {
				CotacaoDiarioAcao cotacao = getCotacaoDia(previsao.getTicker());
				if ("C".equals(previsao.getTipoCompraVenda())) {
					// compra 
					System.out.println("Compra em " + previsao.getPrecoEntrada() + " Minimo em " + minimoDia(cotacao));
					if (minimoDia(cotacao)<=previsao.getPrecoEntrada()) {
						// Entrou
						ds.criaTrade(previsao);
						System.out.println("Comprou !");
					}
				}
				if ("V".equals(previsao.getTipoCompraVenda())) {
					// venda 
					System.out.println("Venda em " + previsao.getPrecoEntrada() + " Maximo em " + maximoDia(cotacao));
					if (maximoDia(cotacao)>=previsao.getPrecoEntrada()) {
						// Entrou
						ds.criaTrade(previsao);
						System.out.println("Vendeu !");
					}
				};
			}
		}
		executaProximo();
	}



	

	@Override
	protected DaoBase getProximo() {
		return new VerificaTradeSaida();
	}

}
