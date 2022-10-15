package sisacao.tesourodireto.processamento;

import br.com.digicom.parse.CallbackParseJson;
import br.com.digicom.parse.ExecutadorParseJson;
import br.com.digicom.sisacao.modelo.AtivoAcao;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DaoBaseRecorrente;
import br.inf.digicom.loopback.DummyDaoBase;
import br.inf.digicom.loopback.IDatasetComum;
import br.inf.digicom.loopback.comum.DaoBaseRestricaoTempo;
import sisacao.tesourodireto.callback.CallbackTesouroDiretoJson;
import sisacao.tesourodireto.callback.TesouroDadosParse;
import sisacao.tesourodireto.daobase.ColetorTesouroDaoBase;
import sisacao.tesourodireto.daobase.DatasetColetorTesouro;

public class ExecutaTesouroDireto extends DaoBaseRecorrente{

	private DummyDaoBase dummy = null;
	ExecutadorParseJson executador =  new ExecutadorParseJson();
	TesouroDadosParse dados = new TesouroDadosParse();
	CallbackTesouroDiretoJson callback = new CallbackTesouroDiretoJson();
	
	AtivoAcao ativo = null;
	DatasetColetorTesouro ds = null;
	
	
	

	@Override
	protected DaoBase getProximo() {
		return this.dummy;
	}
	
	@Override
	protected void inicializaTempos(DaoBaseRestricaoTempo restricaoTempo2) {
		restricaoTempo2.setHorarioInicial(8,50);
		restricaoTempo2.setHorarioFinal(18,30);
		restricaoTempo2.setHorarioDesliga(19,0);
	}

	


	@Override
	protected void executaPrincipal() {
		dados.setDs((DatasetColetorTesouro) this.getComum());
		callback.setDados(dados);
		executador.setCallbackParse(callback);
		executador.executa();
	}


	@Override
	protected long getTempo() {
		return 3000;
	}


	@Override
	protected IDatasetComum criaDataSet() {
		return null;
	}

	@Override
	protected int getIntervaloMinuto() {
		return 60;
	}

}


