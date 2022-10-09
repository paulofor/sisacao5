package sisacao.deeplearning.execucao.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.TradeTreinoRede;
import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;

public class TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto  extends DaoBasePrevisao{


	public static String NOME = "TreinoRede_ObtemListaPrevisaoExecucaoComTradeAberto";
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		this.repTreino.obtemListaPrevisaoExecucaoComTradeAberto(new ListCallback<TreinoRede>() {

			public void onSuccess(List<TreinoRede> objects) {
				System.out.println("Treinos em execução: " + objects.size());
				for (TreinoRede treino:objects) {
					ds.setTreinoCorrente(treino);
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
	protected DaoBase getProximo() {
		return new PrevisaoTeste_ObtemPorDiaTreinoSelecionada();
	}

	

}
