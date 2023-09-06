package br.com.digicom.parse;

import java.io.IOException;
import java.io.Reader;
import java.io.StringReader;

import javax.swing.text.html.HTMLEditorKit;
import javax.swing.text.html.parser.ParserDelegator;

import br.com.digicom.lib.dao.DaoException;
import br.com.digicom.parse.callback.ICallbackParse;

public class ProcessaParser {



	public void executa(String responseBody, ICallbackParse callbackParse)  {
		Reader reader = new StringReader(responseBody);
		callbackParse.setString(responseBody);
		callbackParse.inicializacao();
		
		try {

			//System.out.println("5_chamar_parser");
			new ParserDelegator().parse(reader, (HTMLEditorKit.ParserCallback) callbackParse, true);
			//System.out.println("6_chamar_finalizacao");
			/*
			while (!callbackParse.getConcluido()) {
				try {
					Thread.sleep(3000);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
				System.out.println("esperando terminar o parser");
			}
			*/
			callbackParse.finalizacaoOk();
		} catch (DaoException | IOException e) {
			e.printStackTrace();
		}
	}
}
