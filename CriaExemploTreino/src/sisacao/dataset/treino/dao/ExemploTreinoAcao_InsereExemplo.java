package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExemploTreinoAcao_InsereExemplo extends DaoBaseApp {

	private ExemploTreinoAcao dado;
	
	private DummyDaoBase dummy = null;
	
	
	public ExemploTreinoAcao_InsereExemplo() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	public void executaImpl() {
		this.repExemploTreino.insereExemplo(dado, new VoidCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Inseriu Dado:" + dado);
				executaProximo();
			}
			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}

	public void setDado(ExemploTreinoAcao exemplo) {
		this.dado = exemplo;
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

	

	
	
}
