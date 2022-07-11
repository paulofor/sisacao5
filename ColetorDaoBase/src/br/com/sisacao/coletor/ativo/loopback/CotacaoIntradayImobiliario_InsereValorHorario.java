package br.com.sisacao.coletor.ativo.loopback;

import com.strongloop.android.loopback.callbacks.VoidCallback;

import br.com.digicom.sisacao.repositorio.RepositorioImobiliarioBase;
import br.com.sisacao.coletor.imobiliario.daobase.ColetorImobiliarioDaoBase;
import br.com.sisacao.coletor.imobiliario.daobase.DatasetColetorImobiliario;

public class CotacaoIntradayImobiliario_InsereValorHorario extends ColetorImobiliarioDaoBase{

	
	
	//RestAdapter adapterItem = null;
	//protected RepositorioImobiliarioBase.CotacaoIntradayImobiliarioRepository rep = null; 
	
	public CotacaoIntradayImobiliario_InsereValorHorario() {
		super();
		//adapterItem = new RestAdapter(urlLoopback);
		//rep = adapterItem.createRepository(RepositorioImobiliarioBase.CotacaoIntradayImobiliarioRepository.class);
	}
	
	
	
	@Override
	protected void executaImpl() {
		final SisacaoAdaptador th = new SisacaoAdaptador();
		RepositorioImobiliarioBase.CotacaoIntradayImobiliarioRepository rep = th.getRepImobiliario();
		//RepositorioImobiliarioBase.CotacaoIntradayImobiliarioRepository rep = SisacaoAdaptador.getRep();
		DatasetColetorImobiliario ds = (DatasetColetorImobiliario) getComum();
		String ticker = ds.getFundoImobiliarioCorrente().getTicker();
		Double valor = ds.getCotacaoIntradayImobiliario().getValor();
		String horaNegocio = ds.getCotacaoIntradayImobiliario().getDataHoraStr();
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
