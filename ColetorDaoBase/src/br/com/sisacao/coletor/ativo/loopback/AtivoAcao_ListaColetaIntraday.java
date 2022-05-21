package br.com.sisacao.coletor.ativo.loopback;

import java.util.List;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.ListCallback;

import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.com.sisacao.coletor.ativo.processamento.TrataListaAtivoAcao;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.inf.digicom.loopback.DaoBase;

public class AtivoAcao_ListaColetaIntraday extends ColetorIndiceDaoBase{

	
	
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioAcaoBase.AtivoAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.AtivoAcaoRepository.class);
	
	

	@Override
	protected long getTempo() {
		return 5000;
	}

	@Override
	protected void executaImpl() {
		final DatasetColetorAcao ds = (DatasetColetorAcao) getComum();
		this.rep.listaColetaIntraday(new ListCallback<AtivoAcao>() {
			@Override
			public void onSuccess(List<AtivoAcao> objects) {
				ds.setListaAtivoAcao(objects);
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
		return new TrataListaAtivoAcao();
	}
	
	

}
