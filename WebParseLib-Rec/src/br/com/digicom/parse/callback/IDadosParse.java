package br.com.digicom.parse.callback;

import org.json.JSONObject;

public abstract interface IDadosParse {
	
	public abstract void setServidor(String paramString);

	public abstract void setJson(JSONObject json);
}

