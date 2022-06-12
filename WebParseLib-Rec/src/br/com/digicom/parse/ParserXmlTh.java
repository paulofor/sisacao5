package br.com.digicom.parse;

import br.com.digicom.parse.callback.ICallbackParse;
import br.com.digicom.parse.log.ArquivoLog;

import java.io.IOException;
import java.io.PrintStream;
import javax.xml.parsers.SAXParser;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

public class ParserXmlTh extends ParserThread {
	SAXParser parseDelegator = null;
	Conector conector = null;
	ICallbackParse callback = null;

	public void setCallback(ICallbackParse callback) {
		this.callback = callback;
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
			this.parseDelegator.parse(this.conector.getInputStream(), (DefaultHandler) this.callback);
			this.callback.finalizacaoOk();
		} catch (IOException e) {
			System.out.println("Erro IO Parser.");
			ArquivoLog.getInstancia().salvaErro(e);
			System.out.println("Finalizacao de ParserThread Erro");
			this.callback.finalizacaoErro();
		} catch (SAXException e) {
			System.out.println("Erro SAX Parser.");
			System.out.println("Finalizacao de ParserThread Erro");
			this.callback.finalizacaoErro();
		} catch (Exception e) {
			e.printStackTrace();
			System.out.println("Erro Parser *** : " + e);
			this.callback.finalizacaoErro();
		} finally {
			this.conector.closeBuffer();
			this.conector = null;
		}
	}
}

/*
 * Location: D:\Java-Recuperacao\webparse.jar Qualified Name:
 * br.com.digicom.parse.ParserXmlTh JD-Core Version: 0.6.0
 */