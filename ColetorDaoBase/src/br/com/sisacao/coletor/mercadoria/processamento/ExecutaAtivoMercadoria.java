package br.com.sisacao.coletor.mercadoria.processamento;



import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.sisacao.modelo.AtivoMercadoria;
import br.com.sisacao.coletor.b3.B3DadosMercadoriaParse;
import br.com.sisacao.coletor.b3.CallbackCotacaoB3Json;
import br.com.sisacao.coletor.mercadoria.daobase.ColetorMercadoriaDaoBase;
import br.com.sisacao.coletor.mercadoria.daobase.DatasetColetorMercadoria;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaAtivoMercadoria extends ColetorMercadoriaDaoBase {
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	B3DadosMercadoriaParse dados = new B3DadosMercadoriaParse();
	CallbackCotacaoB3Json callback = new CallbackCotacaoB3Json();
	
	AtivoMercadoria ativo = null;
	DatasetColetorMercadoria ds = null;
	
	public ExecutaAtivoMercadoria(AtivoMercadoria ativo) {
		DatasetColetorMercadoria ds = new DatasetColetorMercadoria();
		ds.setAtivoMercadoriaCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
	}
	
	
	

	@Override
	protected void executaImpl() {
		dados.setDs((DatasetColetorMercadoria) this.getComum());
		//dados.setDaoBase(this);
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
