package br.com.digicom.parse;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.xml.parsers.SAXParser;

import org.json.JSONObject;

import br.com.digicom.parse.callback.CallbackParseJson;
import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.log.ArquivoLog;

public class ParserJsonTh extends ParserThread{

	SAXParser parseDelegator = null;
	Conector conector = null;
	CallbackParseJson callback = null;

	public void setCallback(ICallbackParse callback) {
		this.callback = (CallbackParseJson) callback;
	}

	public void setConector(Conector conector) {
		this.conector = conector;
	}

	public void setParser(SAXParser parser) {
		this.parseDelegator = parser;
	}

	public void run() {
		try {
			this.callback.inicializacao();
			StringBuilder stringBuilder = new StringBuilder();
			String line = null;
			try (BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(this.conector.getInputStream()))) {	
				while ((line = bufferedReader.readLine()) != null) {
					stringBuilder.append(line);
				}
			}
			JSONObject result = new JSONObject(stringBuilder.toString());
			callback.setJson(result);
			this.callback.finalizacaoOk();
		} catch (IOException e) {
			System.out.println("Erro IO Parser.");
			ArquivoLog.getInstancia().salvaErro(e);
			System.out.println("Finalizacao de ParserThread Erro");
			this.callback.finalizacaoErro();
		} catch (Exception e) {
			System.out.println("Erro Parser *** : " + e);
			this.callback.finalizacaoErro();
		} finally {
			this.conector.closeBuffer();
			this.conector = null;
		}
	}

}
