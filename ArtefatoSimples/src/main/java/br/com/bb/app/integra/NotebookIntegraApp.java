package br.com.bb.app.integra;

import java.io.IOException;

import br.com.bb.NotebookObj;

public class NotebookIntegraApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookIntegra");
		NotebookIntegraObj obj = new NotebookIntegraObj();
		String nomeArquivo = "temp_integra";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
