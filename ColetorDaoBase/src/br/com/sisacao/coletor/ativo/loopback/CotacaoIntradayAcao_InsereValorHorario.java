package br.com.sisacao.coletor.ativo.loopback;

import com.strongloop.android.loopback.RestAdapter;
import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioIndiceBase;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;

public class CotacaoIntradayAcao_InsereValorHorario extends ColetorIndiceDaoBase{

	
	
	RestAdapter adapterItem = new RestAdapter(urlLoopback);
	protected final RepositorioAcaoBase.CotacaoIntradayAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);
	
	@Override
	protected long getTempo() {
		return 5000;
	}
	@Override
	protected void executaImpl() {
		DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		String ticker = ds.getCotacaoIntradayIndice().getTicker();
		Double valor = ds.getCotacaoIntradayIndice().getValor();
		String horaNegocio = ds.getCotacaoIntradayIndice().getDataHoraNegStr();
		rep.insereValorHorario(ticker, horaNegocio, valor, new VoidCallback() {

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
