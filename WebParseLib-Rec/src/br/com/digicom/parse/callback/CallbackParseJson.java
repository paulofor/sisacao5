package br.com.digicom.parse.callback;

import org.json.JSONObject;
import org.xml.sax.helpers.DefaultHandler;

import br.com.digicom.parse.ParserJsonTh;
import br.com.digicom.parse.ParserThread;

public abstract class CallbackParseJson extends DefaultHandler implements ICallbackParse {

	private JSONObject json;

	public final ParserThread criaParse() {
		ParserJsonTh parser = new ParserJsonTh();
		parser.setCallback(this);
		return parser;
	}
	
	protected JSONObject getJson() {
		return json;
	}
	public void setJson(JSONObject json) {
		this.json = json;
	}

}
