package br.com.sisacao.coletor.ativo.processamento;



import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.com.sisacao.coletor.b3.B3DadosParse;
import br.com.sisacao.coletor.b3.CallbackCotacaoB3Json;
import br.com.sisacao.coletor.indice.daobase.ColetorIndiceDaoBase;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaAtivoAcao extends ColetorIndiceDaoBase {
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	B3DadosParse dados = new B3DadosParse();
	CallbackCotacaoB3Json callback = new CallbackCotacaoB3Json();
	
	public ExecutaAtivoAcao() {
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected long getTempo() {
		return 5000;
	}

	@Override
	protected void executaImpl() {
		final DatasetColetorAcao ds = (DatasetColetorAcao) getComum();
		AtivoAcao ativo = ds.getAtivoAcaoCorrente();
		System.out.println("Ativo: " + ativo.getTicker());
		dados.setDs(ds);
		dados.setAcao(ativo);
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
