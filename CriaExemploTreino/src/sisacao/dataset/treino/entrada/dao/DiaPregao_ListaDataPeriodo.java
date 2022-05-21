package sisacao.dataset.treino.entrada.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.ativoacao.AtivoAcao_ListaPorNomeGrupo;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetExemplo;

public class DiaPregao_ListaDataPeriodo extends DaoBaseApp {

	@Override
	protected void executaImpl() {
		final DatasetExemplo ds = (DatasetExemplo) getComum();
		this.repDiaPregao.listaDataPeriodo(ds.getDiaNumInicio(), ds.getDiaNumFinal(), new  ListCallback<DiaPregao>() {
		@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}

			@Override
			public void onSuccess(List<DiaPregao> objects) {
				System.out.println("Dia: " + objects.size());
				for (DiaPregao corrente: objects) {
					ds.setDiaPregaoCorrente(corrente);
					executaProximoSemFinalizar();
				}
				finalizar();
			}
			
		});

	}

	@Override
	protected DaoBase getProximo() {
		return new AtivoAcao_ListaPorNomeGrupo();
	}

}
