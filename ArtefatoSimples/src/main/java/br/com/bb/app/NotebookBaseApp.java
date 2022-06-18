package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookSql;

public class NotebookBaseApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookBaseApp");
		NotebookSql obj = new NotebookSql();
		String nomeArquivo = args[0];
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
