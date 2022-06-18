package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookSql;

public class NotebookDiris01 {

	public static void main(String[] args) {
		System.out.println("Ola NotebookDiris01");
		NotebookSql obj = new NotebookSql();
		String nomeArquivo = "diris1";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
