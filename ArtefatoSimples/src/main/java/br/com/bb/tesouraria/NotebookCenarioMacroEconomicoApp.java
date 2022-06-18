package br.com.bb.tesouraria;

import java.io.FileNotFoundException;

import br.com.bb.NotebookPlanilhaInterna;

public class NotebookCenarioMacroEconomicoApp {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		NotebookPlanilhaInterna planilha = new NotebookPlanilhaInterna();
		try {
			planilha.setPropriedades("cenario_macro_economico");
			planilha.geraNotebook();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		
	}

}
