package sisacao.deeplearning.execucao.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.processamento.TrataPrevisaoDiaTreino;

public class DiaPregao_ObtemComPrevisaoRedePorIdTreino extends DaoBasePrevisao {
	
	public static String NOME = "DiaPregao_ObtemComPrevisaoRedePorIdTreino";

	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		TreinoRede treino = ds.getTreinoCorrente();
		this.repDia.obtemComPrevisaoRedePorIdTreino(treino.getId(), new ListCallback<DiaPregao>() {

			public void onSuccess(List<DiaPregao> objects) {
				System.out.println("Dias em execução: " + objects.size());
				ds.setListaDiaPrevisao(objects);
				executaProximo();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});
		
	}

	@Override
	protected DaoBase getProximo() {
		return new TrataPrevisaoDiaTreino();
	}

	
	

}
