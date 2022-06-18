package br.com.bb.app.curso;

import java.io.IOException;

import br.com.bb.app.integra.NotebookIntegraObj;

public class NotebookCursoApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookCursoApp");
		NotebookCursoObj obj = new NotebookCursoObj();
		String nomeArquivo = "aula_01";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
