package br.com.sisacao.coletor.ativo.loopback;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.sisacao.coletor.ativo.daobase.ColetorAcaoDaoBase;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;

public class CotacaoIntradayAcao_InsereValorHorario extends ColetorAcaoDaoBase{

	
	
	//RestAdapter adapterItem = null;
	//protected RepositorioAcaoBase.CotacaoIntradayAcaoRepository rep = null; 
	
	public CotacaoIntradayAcao_InsereValorHorario() {
		super();
		//adapterItem = new RestAdapter(urlLoopback);
		//rep = adapterItem.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);
	}
	
	
	
	@Override
	protected void executaImpl() {
		final SisacaoAdaptador th = new SisacaoAdaptador();
		RepositorioAcaoBase.CotacaoIntradayAcaoRepository rep = th.getRep();
		//RepositorioAcaoBase.CotacaoIntradayAcaoRepository rep = SisacaoAdaptador.getRep();
		DatasetColetorAcao ds = (DatasetColetorAcao) getComum();
		String ticker = ds.getAtivoAcaoCorrente().getTicker();
		Double valor = ds.getCotacaoIntradayAcao().getValor();
		String horaNegocio = ds.getCotacaoIntradayAcao().getDataHoraNegStr();
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
