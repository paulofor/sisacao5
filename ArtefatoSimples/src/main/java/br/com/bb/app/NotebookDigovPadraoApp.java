package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookSql;

public class NotebookDigovPadraoApp {

	public static void main(String[] args) {
		System.out.println("Ola NotebookDigovApp");
		NotebookSql obj = new NotebookSql();
		String nomeArquivo = "digov_padrao_novo";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

}
