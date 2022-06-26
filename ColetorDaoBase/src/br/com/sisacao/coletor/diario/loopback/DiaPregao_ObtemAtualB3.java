package br.com.sisacao.coletor.diario.loopback;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ObjectCallback;

import br.com.digicom.sisacao.modelo.DiaPregao;
import br.com.digicom.sisacao.repositorio.RepositorioDiaPregao;
import br.com.sisacao.coletor.diario.daobase.ColetorDiarioDaoBase;
import br.com.sisacao.coletor.diario.daobase.DatasetColetorDiario;
import br.com.sisacao.coletor.diario.processamento.ExecutaColetaDiario;
import br.inf.digicom.loopback.DaoBase;

public class DiaPregao_ObtemAtualB3 extends ColetorDiarioDaoBase{

	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioDiaPregao rep = 
			adapterItem.createRepository(RepositorioDiaPregao.class);
	
	ExecutaColetaDiario proximo = new ExecutaColetaDiario();
	@Override
	protected void executaImpl() {
		rep.obtemAtualB3(new ObjectCallback<DiaPregao>() {
			final DatasetColetorDiario ds = (DatasetColetorDiario) getComum();
			@Override
			public void onSuccess(DiaPregao object) {
				ds.setDiaPregao(object);
				executaProximo();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}
			
		});
	}
	@Override
	protected DaoBase getProximo() {
		return this.proximo;
	}

	
	
}
