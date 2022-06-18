package br.com.bb.app;

import java.io.IOException;

import br.com.bb.NotebookSql;

public class NotebookRenMensalApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Ola NotebookRenMensalApp");
		NotebookSql obj = new NotebookSql();
		String nomeArquivo = "atacado";
		try {
			obj.setPropriedades(nomeArquivo);
			obj.geraNotebook();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
