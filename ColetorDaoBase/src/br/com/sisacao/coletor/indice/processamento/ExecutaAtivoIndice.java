package br.com.sisacao.coletor.indice.processamento;

import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.com.sisacao.coletor.yahoo.YahooCallbackHtml;
import br.com.sisacao.coletor.yahoo.YahooDadosParse;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaAtivoIndice extends ColetorIndiceDaoBase {
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	YahooDadosParse dados = new YahooDadosParse();
	YahooCallbackHtml callback = new YahooCallbackHtml();
	
	public ExecutaAtivoIndice() {
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected long getTempo() {
		return 5000;
	}

	@Override
	protected void executaImpl() {
		final DatasetColetorIndice ds = (DatasetColetorIndice) getComum();
		AtivoIndice indice = ds.getAtivoIndiceCorrente();
		System.out.println("Indice: " + indice.getTicker());
		dados.setDataset(ds);
		dados.setAtivoIndice(indice);
		executador.setCallbackParse(callback);
		executador.setDadosParse(dados);
		executador.executa();
		this.executaProximo();
	}


	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}
	
	
	
	

}
