package sisacao.dataset.treino.entrada.dao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.dataset.treino.dao.DaoBaseApp;

public class ExemploTreinoAcaoEntrada_InsereExemploEntrada extends DaoBaseApp {

	private ExemploTreinoAcaoEntrada dado;
	
	private DummyDaoBase dummy = null;
	
	
	public ExemploTreinoAcaoEntrada_InsereExemploEntrada() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	public void executaImpl() {
		this.repExemploTreinoEntrada.insereExemploEntrada(dado, new VoidCallback() {
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

	public void setDado(ExemploTreinoAcaoEntrada exemplo) {
		this.dado = exemplo;
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

	

	
	
}
