package sisacao.dataset.treino.saida.dao;

import java.util.List;

import com.strongloop.android.loopback.callbacks.ListCallback;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.loopback.comum.diapregao.DiaPregao_ObtemIntradayResultadoTickerAteFinal;
import sisacao.dataset.treino.dao.DaoBaseApp;
import sisacao.dataset.treino.dao.DatasetExemplo;

public class RegraProjecao_FinalizaInsercao extends DaoBaseApp {


	
	private DummyDaoBase dummy = new DummyDaoBase();
	
	
	public RegraProjecao_FinalizaInsercao() {
		super();
	}
	
	@Override
	public void executaImpl() {
		System.out.println("Entrou no executaImpl:");
		final DatasetExemplo ds = (DatasetExemplo) getComum();
		int idRegra = ds.getRegraProjecao().getId();
		System.out.println("Serviço finalizacao ID:" + idRegra);
		this.repRegraProjecao.finalizaInsercao(idRegra, new VoidCallback() {

			@Override
			public void onSuccess() {
				System.out.println("onSuccess");
				finalizar();
				System.exit(0);
			}

			@Override
			public void onError(Throwable t) {
				System.out.println("onError");
				onErrorBase(t);
			}
			
		}); 
	}

	

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

	

	
	
}
