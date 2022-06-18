package sisacao.deeplearning.tensorflow.jupyter;

import org.json.JSONArray;

public class NotebookTreinoTensorFlow extends NotebookObj {

	@Override
	protected void montaScript(JSONArray notebook) {
		CelulaNotebook celula = new CelulaNotebook();
		celula.setTitulo("Importacoes", 1);
		celula.adicionaLinha("import tensorflow as tf");
		notebook.putAll(celula.getJSON());
		celula = new CelulaNotebook();
		celula.adicionaLinha("print(tf.__version__)");
		notebook.putAll(celula.getJSON());
	}

}
