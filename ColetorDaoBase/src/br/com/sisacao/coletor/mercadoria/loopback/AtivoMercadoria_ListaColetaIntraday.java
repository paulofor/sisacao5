package br.com.sisacao.coletor.mercadoria.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.digicom.sisacao.repositorio.RepositorioMercadoriaBase;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.mercadoria.daobase.DatasetColetorMercadoria;
import br.com.sisacao.coletor.mercadoria.processamento.TrataListaAtivoMercadoria;
import br.inf.digicom.loopback.DaoBase;

public class AtivoMercadoria_ListaColetaIntraday extends ColetorIndiceDaoBase{

	
	
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioMercadoriaBase.AtivoMercadoriaRepository rep = 
			adapterItem.createRepository(RepositorioMercadoriaBase.AtivoMercadoriaRepository.class);
	
	TrataListaAtivoMercadoria proximo = new TrataListaAtivoMercadoria();
			
	
	

	@Override
	protected void executaImpl() {
		
		final DatasetColetorMercadoria ds = (DatasetColetorMercadoria) getComum();
		this.rep.listaColetaIntradayMercadoria(new ListCallback<AtivoMercadoria>() {
			@Override
			public void onSuccess(List<AtivoMercadoria> objects) {
				ds.setListaAtivoMercadoria(objects);
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
