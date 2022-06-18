package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookSql;

public class NotebookDigovApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookDigovApp");
		NotebookSql obj = new NotebookSql();
		String nomeArquivo = "digov";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
