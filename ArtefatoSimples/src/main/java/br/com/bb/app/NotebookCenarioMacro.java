package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookSql;

public class NotebookCenarioMacro {

	public static void main(String[] args) {
		System.out.println("Ola NotebookCenarioMacro");
		NotebookSql obj = new NotebookSql();
		String nomeArquivo = "cenario_macro";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
