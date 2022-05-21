package sisacao.dataset.treino.saida.dao;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoEntrada;
import br.com.digicom.sisacao.modelo.ExemploTreinoAcaoSaida;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.dataset.treino.dao.DaoBaseApp;

public class ExemploTreinoAcaoSaida_InsereExemploSaida extends DaoBaseApp {

	private ExemploTreinoAcaoSaida dado;
	
	private DummyDaoBase dummy = null;
	
	
	public ExemploTreinoAcaoSaida_InsereExemploSaida() {
		super();
		this.dummy = new DummyDaoBase();
	}
	
	@Override
	public void executaImpl() {
		this.repExemploTreinoSaida.insereExemploSaida(dado, new VoidCallback() {
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

	public void setDado(ExemploTreinoAcaoSaida exemplo) {
		this.dado = exemplo;
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}

	

	
	
}
