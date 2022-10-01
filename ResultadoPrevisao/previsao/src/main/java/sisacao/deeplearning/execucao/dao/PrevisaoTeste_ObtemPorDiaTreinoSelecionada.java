package sisacao.deeplearning.execucao.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.PrevisaoRede;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.execucao.processamento.TrataPrevisaoExecucao;

public class PrevisaoTeste_ObtemPorDiaTreinoSelecionada extends DaoBasePrevisao {

	
	

	@Override
	public void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		long idTreinoRede = ds.getTreinoCorrente().getId();
		long diaNumExecucao = ds.getDiaNumExecucao();
		repPrevisaoExecucao.obtemPorDiaTreinoSelecionada(idTreinoRede, diaNumExecucao, new ListCallback<PrevisaoRede>() {

			public void onSuccess(List<PrevisaoRede> objects) {
				System.out.println("Trazendo: " + objects.size() + " itens");
				for (PrevisaoRede previsao : objects) {
					ds.setPrevisaoExecucaoCorrente(previsao);
					executaProximoSemFinalizar();
					
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
