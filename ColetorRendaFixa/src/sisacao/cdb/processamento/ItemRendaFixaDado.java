package sisacao.cdb.processamento;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import sisacao.cdb.daobase.DatasetColetorCDB;

public class ItemRendaFixaDado implements IDadosParse{
	
	
	private DatasetColetorCDB ds = null;

	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public void setDs(DatasetColetorCDB comum) {
		this.ds = comum;
	}

}
