package br.com.digicom.parse;

import org.json.JSONArray;
import org.json.JSONObject;
import org.xml.sax.helpers.DefaultHandler;

import br.com.digicom.parse.callback.ICallbackParse;

public abstract class CallbackParseJson extends DefaultHandler implements ICallbackParse {

	private JSONObject json;
	private JSONArray jsonList;

	protected boolean concluido = false;
	
	public void setConcluido(boolean valor) {
		this.concluido = valor;
	}
	public boolean getConcluido() {
		return this.concluido;
	}
	
	public final ParserThread criaParse() {
		ParserJsonTh parser = new ParserJsonTh();
		parser.setCallback(this);
		return parser;
	}
	
	protected final JSONObject getJson() {
		return json;
	}
	protected final JSONArray getJsonList() {
		return jsonList;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}
	public void setJsonList(JSONArray jsonList) {
		this.jsonList = jsonList;
	}

}
