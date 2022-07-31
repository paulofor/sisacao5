package sisacao.cdb.processamento;


import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.ExecutadorParseApache2;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.cdb.daobase.ColetorCDBDaoBase;
import sisacao.cdb.daobase.DatasetColetorCDB;

public class ExecutaColetaDiarioCDB extends  ColetorCDBDaoBase{
	
	private DummyDaoBase dummy = null;
	ExecutadorParseApache2 executador =  new ExecutadorParseApache2();
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
		try {
			executador.executa();
		} catch (DaoException e) {
			e.printStackTrace();
		}
		finalizar();
	}

}
