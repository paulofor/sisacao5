package br.com.digicom.parse;

import java.io.IOException;

public class ForbiddenException extends IOException {
	
	private String url;

	public ForbiddenException(String url) {
		this.url = url;
	}

}
