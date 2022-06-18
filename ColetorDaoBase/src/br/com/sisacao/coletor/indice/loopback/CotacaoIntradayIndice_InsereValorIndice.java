package br.com.sisacao.coletor.indice.loopback;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioIndiceBase;
import br.com.sisacao.coletor.ativo.loopback.SisacaoAdaptador;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;

public class CotacaoIntradayIndice_InsereValorIndice extends ColetorIndiceDaoBase{

	
	
	//static RestAdapter adapterItem = new RestAdapter(urlLoopback);
	//protected final RepositorioIndiceBase.CotacaoIntradayIndiceRepository rep = 
	//		adapterItem.createRepository(RepositorioIndiceBase.CotacaoIntradayIndiceRepository.class);
	
	
	@Override
	protected void executaImpl() {
		final SisacaoAdaptador th = new SisacaoAdaptador();
		RepositorioIndiceBase.CotacaoIntradayIndiceRepository rep = th.getRepIndice();
		DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		String ticker = ds.getCotacaoIntradayIndice().getTicker();
		Double valor = ds.getCotacaoIntradayIndice().getValor();
		rep.insereValor(ticker, valor, new VoidCallback() {

			@Override
			public void onSuccess() {
				System.out.println("Inseriu");
				finalizar();
				//finalize();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
		
	}
}
