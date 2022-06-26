package br.com.sisacao.coletor.indice.processamento;



import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.digicom.sisacao.modelo.AtivoIndice;
import br.com.sisacao.coletor.b3.CallbackB3Json;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.com.sisacao.coletor.indice.daobase.DatasetColetorIndice;
import br.com.sisacao.coletor.yahoo.YahooCallbackHtml;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaAtivoIndiceCompleto extends ColetorIndiceDaoBase {
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	IndiceDadosParse dados = new IndiceDadosParse();
	ICallbackParse callback = null;
	
	AtivoAcao ativo = null;
	DatasetColetorIndice ds = null;
	
	public ExecutaAtivoIndiceCompleto(AtivoIndice ativo) {
		DatasetColetorIndice ds = new DatasetColetorIndice();
		ds.setAtivoIndiceCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
		if ("IBOVESPA".equals(ativo.getNome())) {
			callback = new CallbackB3Json();
		} else {
			callback = new YahooCallbackHtml();
		}
		
	}
	
	
	

	@Override
	protected void executaImpl() {
		dados.setDs((DatasetColetorIndice) this.getComum());
		executador.setCallbackParse(callback);
		executador.setDadosParse(dados);
		executador.executa();
		this.finalizar();
	}


	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}



	
	
	
	

}
