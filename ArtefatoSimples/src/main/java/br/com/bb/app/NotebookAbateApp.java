package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookPlanilhaExterna;

public class NotebookAbateApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookAbateApp");
		NotebookPlanilhaExterna obj = new NotebookPlanilhaExterna();
		String nomeArquivo = "abate";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook(nomeArquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
