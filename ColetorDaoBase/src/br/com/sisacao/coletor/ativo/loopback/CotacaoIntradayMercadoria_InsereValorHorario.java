package br.com.sisacao.coletor.ativo.loopback;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.repositorio.RepositorioMercadoriaBase;
import br.com.sisacao.coletor.mercadoria.daobase.ColetorMercadoriaDaoBase;
import br.com.sisacao.coletor.mercadoria.daobase.DatasetColetorMercadoria;

public class CotacaoIntradayMercadoria_InsereValorHorario extends ColetorMercadoriaDaoBase{

	
	
	//RestAdapter adapterItem = null;
	//protected RepositorioMercadoriaBase.CotacaoIntradayMercadoriaRepository rep = null; 
	
	public CotacaoIntradayMercadoria_InsereValorHorario() {
		super();
		//adapterItem = new RestAdapter(urlLoopback);
		//rep = adapterItem.createRepository(RepositorioMercadoriaBase.CotacaoIntradayMercadoriaRepository.class);
	}
	
	
	
	@Override
	protected void executaImpl() {
		final SisacaoAdaptador th = new SisacaoAdaptador();
		RepositorioMercadoriaBase.CotacaoIntradayMercadoriaRepository rep = th.getRepMercadoria();
		//RepositorioMercadoriaBase.CotacaoIntradayMercadoriaRepository rep = SisacaoAdaptador.getRep();
		DatasetColetorMercadoria ds = (DatasetColetorMercadoria) getComum();
		String ticker = ds.getAtivoMercadoriaCorrente().getTicker();
		Double valor = ds.getCotacaoIntradayMercadoria().getValor();
		String horaNegocio = ds.getCotacaoIntradayMercadoria().getDataHoraNegStr();
		System.out.println("Chamada para inserir " + ticker + ":" + valor);
		
		rep.insereValorHorario(ticker, horaNegocio, valor, new VoidCallback() {
			@Override
			public void onSuccess() {
				//System.out.println("Inseriu");
				finalizar();
			}

			@Override
			public void onError(Throwable t) {
				onErrorBase(t);
			}});
				
		//th.liberaConexao();
	}
		
}
