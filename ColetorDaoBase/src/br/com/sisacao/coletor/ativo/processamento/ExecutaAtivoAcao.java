package br.com.sisacao.coletor.ativo.processamento;



import java.lang.management.ManagementFactory;

import br.com.digicom.parse.ExecutadorParse;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.com.sisacao.coletor.ativo.daobase.ColetorAcaoDaoBase;
import br.com.sisacao.coletor.ativo.daobase.DatasetColetorAcao;
import br.com.sisacao.coletor.b3.B3DadosParse;
import br.com.sisacao.coletor.b3.CallbackCotacaoB3Json;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;

public class ExecutaAtivoAcao extends ColetorAcaoDaoBase {
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	B3DadosParse dados = new B3DadosParse();
	CallbackCotacaoB3Json callback = new CallbackCotacaoB3Json();
	
	AtivoAcao ativo = null;
	DatasetColetorAcao ds = null;
	
	public ExecutaAtivoAcao(AtivoAcao ativo) {
		DatasetColetorAcao ds = new DatasetColetorAcao();
		ds.setAtivoAcaoCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
	}
	
	
	

	@Override
	protected void executaImpl() {
		dados.setDs((DatasetColetorAcao) this.getComum());
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
