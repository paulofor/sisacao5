package br.com.digicom.parse;

import java.net.URL;

import org.json.JSONObject;

// Criado em 01-10-2022 --> Para tesouro direto e outros JSONs

public class ExecutadorParseJson {
	
	private br.com.digicom.parse.callback.CallbackParseJson callbackParse;

	
	public void setCallbackParse(br.com.digicom.parse.callback.CallbackParseJson callbackParse) {
		this.callbackParse = callbackParse;
	}

	
	
	
	public void executa() {
		try {
			ConectorApache conector = new ConectorApache();
			URL url = this.callbackParse.getUrl();
			conector.setUri(url.toURI());
			conector.start();
			conector.join(360000L);
			this.callbackParse.inicializacao();
			this.callbackParse.setJson(new JSONObject(conector.getResposta()));
			this.callbackParse.finalizacaoOk();
		} catch (Exception e) {
			e.printStackTrace();
			this.callbackParse.finalizacaoErro();
		}

	}

}
