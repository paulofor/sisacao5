package sisacao.coletor.uniswap.processamento;


import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import sisacao.coletor.uniswap.daobase.DatasetColetorUniswap;

public class UniswapDado implements IDadosParse{
	
	
	private DatasetColetorUniswap ds = null;

	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}

	public void setDs(DatasetColetorUniswap comum) {
		this.ds = comum;
	}
	
}
