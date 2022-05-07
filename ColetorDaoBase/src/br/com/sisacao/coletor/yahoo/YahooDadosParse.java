package br.com.sisacao.coletor.yahoo;

import org.json.JSONObject;

import br.com.digicom.parse.callback.IDadosParse;
import br.com.digicom.sisacao.modelo.AtivoIndice;


public class YahooDadosParse implements IDadosParse{

	private AtivoIndice indice = null;
	
	@Override
	public void setServidor(String paramString) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void setJson(JSONObject json) {
		// TODO Auto-generated method stub
		
	}



	public void setAtivoIndice(AtivoIndice indice) {
		this.indice = indice;
	}
	public AtivoIndice getAtivoIndice() {
		return this.indice;
	}

}
