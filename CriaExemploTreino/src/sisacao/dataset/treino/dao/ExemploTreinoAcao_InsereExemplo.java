package sisacao.dataset.treino.dao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcao;
import br.inf.digicom.loopback.DaoBase;

public class ExemploTreinoAcao_InsereExemplo extends DaoBaseApp {

	private ExemploTreinoAcao dado;
	
	
	@Override
	public void executaImpl() {
		// TODO Auto-generated method stub
		this.repExemploTreino.insereExemplo(dado, new VoidCallback() {

			@Override
			public void onSuccess() {
				System.out.println("Inseriu Dado:" + dado);
				setConcluido();
			}

			@Override
			public void onError(Throwable t) {
				this.onError(t);
			}});
	}

	public void setDado(ExemploTreinoAcao exemplo) {
		// TODO Auto-generated method stub
		this.dado = exemplo;
	}

	@Override
	protected DaoBase getProximo() {
		// TODO Auto-generated method stub
		return null;
	}

}
