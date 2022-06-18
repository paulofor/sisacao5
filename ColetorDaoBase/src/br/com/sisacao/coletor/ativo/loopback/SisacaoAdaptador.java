package br.com.sisacao.coletor.ativo.loopback;

import com.strongloop.android.loopback.RestAdapter;

import br.com.digicom.sisacao.repositorio.RepositorioAcaoBase;
import br.com.digicom.sisacao.repositorio.RepositorioIndiceBase;
import br.inf.digicom.loopback.comum.DaoBaseComum;

public class SisacaoAdaptador {

	
	static RestAdapter adapterItem = new RestAdapter(DaoBaseComum.urlLoopback);
	RepositorioAcaoBase.CotacaoIntradayAcaoRepository rep = 
			adapterItem.createRepository(RepositorioAcaoBase.CotacaoIntradayAcaoRepository.class);
	RepositorioIndiceBase.CotacaoIntradayIndiceRepository repIndice = 
			adapterItem.createRepository(RepositorioIndiceBase.CotacaoIntradayIndiceRepository.class);
	
	
	
	
	public RepositorioAcaoBase.CotacaoIntradayAcaoRepository getRep() {
		return rep;
	}
	public RepositorioIndiceBase.CotacaoIntradayIndiceRepository getRepIndice() {
		return repIndice;
	}
	
	/*
	public void liberaConexao() {
		//adapterItem.liberaConexao();
	}
	*/
}
