package sisacao.deeplearning.execucao.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.PrevisaoTeste;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.processamento.TrataPrevisao;

public class PrevisaoTeste_ListaComDiarioExecucao extends DaoBasePrevisao {

	
	

	@Override
	public void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		long idTreinoRede = ds.getTreinoCorrente().getId();
		long diaNumInicial = ds.getTreinoCorrente().getDiaNumInicioExecucao();
		long diaNumFinal = ds.getTreinoCorrente().getDiaNumFinalExecucao();
		double valorLimite = ds.getTreinoCorrente().getLimiteParaEntrada();
		repPrevisao.listaComDiarioTargetStopTeste(idTreinoRede, diaNumInicial, diaNumFinal, valorLimite,new ListCallback<PrevisaoTeste>() {

			public void onSuccess(List<PrevisaoTeste> objects) {
				System.out.println("Trazendo: " + objects.size() + " itens");
				for (PrevisaoTeste previsao : objects) {
					ds.setPrevisaoCorrente(previsao);
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
		return new TrataPrevisao();
	}

	



	

}
