package sisacao.cdb.processamento;

import br.com.digicom.parse.ExecutadorParse;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.cdb.daobase.ColetorCDBDaoBase;
import sisacao.cdb.daobase.DatasetColetorCDB;

public class ExecutaColetaDiarioCDB extends  ColetorCDBDaoBase{
	
	private DummyDaoBase dummy = null;
	ExecutadorParse executador =  new ExecutadorParse();
	ItemRendaFixaDado dados = new ItemRendaFixaDado();
	ListaRendaFixaYubbCallback callback = new ListaRendaFixaYubbCallback();
	

	DatasetColetorCDB ds = null;
	
	public ExecutaColetaDiarioCDB() {
		//DatasetColetorCDB ds = new DatasetColetorCDB();
		//ds.setAtivoAcaoCorrente(ativo);
		this.setComum(ds);
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected void executaImpl() {

		dados.setDs((DatasetColetorCDB) this.getComum());
		executador.setCallbackParse(callback);
		executador.setDadosParse(dados);
		executador.executa();
		finalizar();
	}

}
