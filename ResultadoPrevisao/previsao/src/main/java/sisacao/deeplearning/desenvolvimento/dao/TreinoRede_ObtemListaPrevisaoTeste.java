package sisacao.deeplearning.desenvolvimento.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public class TreinoRede_ObtemListaPrevisaoTeste  extends DaoBasePrevisao{

	private TreinoRede_ExecutouPrevisaoTeste paralelo = new TreinoRede_ExecutouPrevisaoTeste();
	public static String NOME = "TreinoRede_ObtemListaPrevisaoTeste";
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		this.repTreino.obtemListaPrevisaoTeste(new ListCallback<TreinoRede>() {

			public void onSuccess(List<TreinoRede> objects) {
				for (TreinoRede treino:objects) {
					ds.setTreinoCorrente(treino);
					executaProximoSemFinalizar();
					paralelo.setComum(ds);
					paralelo.executa();
				}
				finalizar();
			}

			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});
	}

	@Override
	protected DaoBase getProximo() {
		return DaoBaseComum.getProximo(NOME);
	}

	

}
