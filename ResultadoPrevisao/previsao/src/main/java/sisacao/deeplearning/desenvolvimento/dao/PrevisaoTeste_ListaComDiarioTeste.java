package sisacao.deeplearning.desenvolvimento.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.PrevisaoTeste;
import sisacao.deeplearning.desenvolvimento.processamento.TrataPrevisao;

public class PrevisaoTeste_ListaComDiarioTeste extends DaoBasePrevisao {

	
	

	@Override
	public void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		long idTreinoRede = ds.getTreinoCorrente().getId();
		long diaNumInicial = ds.getTreinoCorrente().getDiaNumInicioTeste();
		long diaNumFinal = ds.getTreinoCorrente().getDiaNumFinalTeste();
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
