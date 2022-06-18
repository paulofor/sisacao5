package br.com.sisacao.coletor.indice.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.digicom.sisacao.repositorio.RepositorioIndiceBase;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.com.sisacao.coletor.indice.processamento.TrataListaAtivoIndice;
import br.inf.digicom.loopback.DaoBase;

public class AtivoIndice_ListaColetaIntraday extends ColetorIndiceDaoBase{

	
	
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioIndiceBase.AtivoIndiceRepository rep = 
			adapterItem.createRepository(RepositorioIndiceBase.AtivoIndiceRepository.class);
	
	TrataListaAtivoIndice proximo = new TrataListaAtivoIndice();
			
	
	

	@Override
	protected void executaImpl() {
		
		final DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		this.rep.listaColetaIntraday(new ListCallback<AtivoIndice>() {
			@Override
			public void onSuccess(List<AtivoIndice> objects) {
				ds.setListaAtivoIndice(objects);
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
