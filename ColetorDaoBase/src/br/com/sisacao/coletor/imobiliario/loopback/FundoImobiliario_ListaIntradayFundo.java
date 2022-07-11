package br.com.sisacao.coletor.imobiliario.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.FundoImobiliario;
import br.com.digicom.sisacao.repositorio.RepositorioFundoImobiliario;
import br.com.sisacao.coletor.imobiliario.daobase.ColetorImobiliarioDaoBase;
import br.com.sisacao.coletor.imobiliario.daobase.DatasetColetorImobiliario;
import br.com.sisacao.coletor.imobiliario.processamento.TrataListaFundoImobiliario;
import br.inf.digicom.loopback.DaoBase;

public class FundoImobiliario_ListaIntradayFundo extends ColetorImobiliarioDaoBase{

	
	
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioFundoImobiliario rep = 
			adapterItem.createRepository(RepositorioFundoImobiliario.class);
	
	TrataListaFundoImobiliario proximo = new TrataListaFundoImobiliario();
			
	
	

	@Override
	protected void executaImpl() {
		System.out.println(this + " único ?");
		final DatasetColetorImobiliario ds = (DatasetColetorImobiliario) getComum();
		this.rep.listaIntradayFundo(new ListCallback<FundoImobiliario>() {
			@Override
			public void onSuccess(List<FundoImobiliario> objects) {
				ds.setListaFundoImobiliario(objects);
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
		return proximo;
	}
	
	

}
