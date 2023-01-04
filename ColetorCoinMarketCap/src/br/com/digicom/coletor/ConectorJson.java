package br.com.digicom.coletor;

import br.com.digicom.parse.CallbackParseJson;

public class ConectorJson  extends Thread {

	private CallbackParseJson callback;
	
	@Override
	public void run() {
		System.out.println("Ola Mundo !");
	}

	
}
