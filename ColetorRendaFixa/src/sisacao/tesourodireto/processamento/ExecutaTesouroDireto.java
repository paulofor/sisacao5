package sisacao.tesourodireto.processamento;

import br.com.digicom.parse.CallbackParseJson;
import br.com.digicom.parse.ExecutadorParseJson;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.tesourodireto.callback.CallbackTesouroDiretoJson;
import sisacao.tesourodireto.callback.TesouroDadosParse;
import sisacao.tesourodireto.daobase.ColetorTesouroDaoBase;
import sisacao.tesourodireto.daobase.DatasetColetorTesouro;

public class ExecutaTesouroDireto extends ColetorTesouroDaoBase{

	private DummyDaoBase dummy = null;
	ExecutadorParseJson executador =  new ExecutadorParseJson();
	TesouroDadosParse dados = new TesouroDadosParse();
	CallbackTesouroDiretoJson callback = new CallbackTesouroDiretoJson();
	
	AtivoAcao ativo = null;
	DatasetColetorTesouro ds = null;
	
	/*
	public ExecutaAtivoAcao(AtivoAcao ativo) {
		DatasetColetorTesouro ds = new DatasetColetorTesouro();
		ds.setAtivoAcaoCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
	}
	*/
	
	
	

	@Override
	protected void executaImpl() {
		dados.setDs((DatasetColetorTesouro) this.getComum());
		callback.setDados(dados);
		executador.setCallbackParse(callback);
		executador.executa();
		this.finalizar();
	}


	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}
	
	

}
