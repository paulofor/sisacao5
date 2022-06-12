package br.com.sisacao.coletor.ativo.loopback;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.sisacao.coletor.ativo.app.ColetorIntradayAtivoApp;

public class SisacaoAdaptador {

	
	RestAdapter adapterItem = new RestAdapter(ColetorIntradayAtivoApp.UrlLoopback);
	RepositorioAcaoBase.CotacaoIntradayAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);
	
	
	
	public RepositorioAcaoBase.CotacaoIntradayAcaoRepository getRep() {
		return rep;
	}
	
	public void liberaConexao() {
		adapterItem.liberaConexao();
	}
}
