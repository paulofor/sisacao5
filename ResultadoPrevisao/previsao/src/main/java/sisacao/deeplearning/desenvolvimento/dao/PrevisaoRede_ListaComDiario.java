package sisacao.deeplearning.desenvolvimento.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.PrevisaoRede;
import sisacao.deeplearning.desenvolvimento.processamento.TrataPrevisao;

public class PrevisaoRede_ListaComDiario extends DaoBasePrevisao {

	


	@Override
	public void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		long idTreinoRede = ds.getIdTreinoRede();
		long diaNumInicial = ds.getDiaNumInicial();
		long diaNumFinal = ds.getDiaNumFinal();
		double valorLimite = ds.getValorLimite();
		repPrevisao.listaComDiarioTargetStop(idTreinoRede, diaNumInicial, diaNumFinal, valorLimite,new ListCallback<PrevisaoRede>() {

			public void onSuccess(List<PrevisaoRede> objects) {
				for (PrevisaoRede previsao : objects) {
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
