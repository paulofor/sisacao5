package br.inf.digicom.simulacao.regraProjecao;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.modelo.CotacaoIntradayAcaoResultadoValor;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.inf.digicom.desen.CotacaoRegraProjecaoValorApp;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class CotacaoIntradayResultadoValor_InsereLista  extends ExecutorRegraProjecao {


	private List<CotacaoIntradayAcaoResultadoValor> listaValor;
	private DummyDaoBase dummy = null;
	
	
	public CotacaoIntradayResultadoValor_InsereLista() {
		this.dummy = new DummyDaoBase();
	}
	
	

	public void setLista(List<CotacaoIntradayAcaoResultadoValor> listaValor) {
		this.listaValor = listaValor;
	}
	@Override
	protected void executaImpl() {
		this.repValor.insereLista(listaValor, new VoidCallback() {
			@Override
			public void onSuccess() {
				System.out.println("Inseriu listaValor");
				executaProximo();
			}
			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
	}

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}
}

