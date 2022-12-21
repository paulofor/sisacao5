package sisacao.deeplearning.execucao.dao;

import java.util.ArrayList;
import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.TreinoRede;
import br.inf.digicom.loopback.DaoBase;
import sisacao.deeplearning.comum.TradeI;
import sisacao.deeplearning.desenvolvimento.dao.DaoBasePrevisao;
import sisacao.deeplearning.desenvolvimento.dao.DatasetResultadoPrevisao;
import sisacao.deeplearning.desenvolvimento.dao.TreinoRede_ExecutouPrevisaoTeste;

public class TreinoRede_ObtemSelecionadoComPeriodoExecucao  extends DaoBasePrevisao{

	private TradeTreinoRede_AtualizaTreino paralelo = new TradeTreinoRede_AtualizaTreino();
	public static String NOME = "TreinoRede_ObtemSelecionadoComPeriodoExecucao";
	
	@Override
	protected void executaImpl() {
		final DatasetResultadoPrevisao ds = (DatasetResultadoPrevisao) getComum();
		this.repTreino.obtemSelecionadoComPeriodoExecucao(new ListCallback<TreinoRede>() {

			public void onSuccess(List<TreinoRede> objects) {
				System.out.println("Treinos em execução: " + objects.size());
				for (TreinoRede treino:objects) {
					ds.setTreinoCorrente(treino);
					ds.getListaTrade().clear();
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
		return new DiaPregao_ObtemComPrevisaoRedePorIdTreino();
	}

	

}
