package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookPlanilhaExterna;

public class NotebookFrangoApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookAbateApp");
		NotebookPlanilhaExterna obj = new NotebookPlanilhaExterna();
		String nomeArquivo = "frango";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook(nomeArquivo);
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
