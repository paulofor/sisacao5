package br.com.bb.app.curso;

import org.json.JSONArray;

import br.com.bb.NotebookObj;
import br.com.bb.notebook.modulo.SparkBasicoMod;

public class NotebookCursoObj extends NotebookObj {

	private SparkBasicoMod sparkBasico = null;
	
	public NotebookCursoObj() {
		this.sparkBasico = new SparkBasicoMod();
	}
	
	@Override
	protected void montaScript(JSONArray notebook) {
		this.sparkBasico.bbmagic(notebook);
		this.sparkBasico.sessaoSpark(notebook, false);
		this.sparkBasico.finalizaSpark(notebook);
		
	}

}
