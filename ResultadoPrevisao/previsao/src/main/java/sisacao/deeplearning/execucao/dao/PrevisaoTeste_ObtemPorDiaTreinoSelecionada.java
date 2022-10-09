package sisacao.deeplearning.execucao.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.PrevisaoRede;
import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.inf.digicom.loopback.comum.ativoacao.CotacaoDiarioAcao_CotacaoDia;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.processamento.TrataPrevisaoExecucao;

public class PrevisaoTeste_ObtemPorDiaTreinoSelecionada extends DaoBasePrevisao {

	
	

	@Override
	public void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		long idTreinoRede = ds.getTreinoCorrente().getId();
		final int diaNumExecucao = ds.getDiaNumExecucao();
		repPrevisaoExecucao.obtemPorDiaTreinoSelecionada(idTreinoRede, diaNumExecucao, new ListCallback<PrevisaoRede>() {

			public void onSuccess(List<PrevisaoRede> objects) {
				System.out.println("Previsões dia: " + objects.size());
				System.out.println("Abertos: " + ds.getTreinoCorrente().getTradeTreinoRedes().size());
				for (PrevisaoRede previsao : objects) {
					ds.setPrevisaoExecucaoCorrente(previsao);
					executaProximoSemFinalizar();
					
				}
				
				for (TradeTreinoRede trade : ds.getTreinoCorrente().getTradeTreinoRedes()) {
					ds.setTradeTreinoRede(trade);
					ds.setDiaNum(diaNumExecucao);
					ds.setTicker(trade.getTicker());
					CotacaoDiarioAcao_CotacaoDia exec = new CotacaoDiarioAcao_CotacaoDia();
					exec.setComum(ds);
					exec.executa();
				}
				finalizar();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}

			
		});
	}

	@Override
	protected DaoBasePrevisao getProximo() {
		return new TrataPrevisaoExecucao();
	}

	



	

}
