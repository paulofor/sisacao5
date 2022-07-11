package br.com.sisacao.coletor.imobiliario.processamento;



import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.sisacao.modelo.FundoImobiliario;
import br.com.sisacao.coletor.ativo.daobase.ColetorAcaoDaoBase;
import br.com.sisacao.coletor.b3.B3DadosImobiliarioParse;
import br.com.sisacao.coletor.b3.CallbackCotacaoB3Json;
import br.com.sisacao.coletor.imobiliario.daobase.DatasetColetorImobiliario;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaFundoImobiliario extends ColetorAcaoDaoBase {
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	B3DadosImobiliarioParse dados = new B3DadosImobiliarioParse();
	CallbackCotacaoB3Json callback = new CallbackCotacaoB3Json();
	
	FundoImobiliario ativo = null;
	DatasetColetorImobiliario ds = null;
	
	public ExecutaFundoImobiliario(FundoImobiliario ativo) {
		DatasetColetorImobiliario ds = new DatasetColetorImobiliario();
		ds.setFundoImobiliarioCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
	}
	
	
	

	@Override
	protected void executaImpl() {
		dados.setDs((DatasetColetorImobiliario) this.getComum());
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
