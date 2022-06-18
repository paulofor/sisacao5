package sisacao.deeplearning.tensorflow.python;

import java.io.FileNotFoundException;

import br.com.digicom.sisacao.modelo.RedeNeural;
import br.inf.digicom.loopback.DaoBase;
import br.inf.digicom.loopback.DummyDaoBase;
import sisacao.deeplearning.tensorflow.jupyter.NotebookTreinoTensorFlow;
import sisacao.deeplearning.tensorflow.loopback.DaoAplicacao;
import sisacao.deeplearning.tensorflow.loopback.DatasetTreinoRede;

public class GeraPython extends DaoAplicacao {
	
	
	private DummyDaoBase dummy;

	public GeraPython() {
		this.dummy = new DummyDaoBase();
	}
	
	
	@Override
	protected void executaImpl() {
		DatasetTreinoRede ds = (DatasetTreinoRede) getComum();
		RedeNeural rede = ds.getRedeCorrente();
		NotebookTreinoTensorFlow obj = new NotebookTreinoTensorFlow();
		obj.geraNotebook("treino" + rede.getId());
		finalizar();
	}

	@Override
	protected DaoBase getProximo() {
		return dummy;
	}
	
	
	
	/*
	private void geraArquivoPy(RedeNeural rede) {
		String nomePythonTreino = "treinamento_" + rede.getId() + ".py";
		Writer fw = null;
		try {
			fw = new OutputStreamWriter(new FileOutputStream(nomePythonTreino), StandardCharsets.UTF_8);
			geraNotebookTreino(fw,rede);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	private void geraNotebookTreino(Writer fw, RedeNeural rede) {
		JSONObject notebook = new JSONObject();
		try {
			Field changeMap = notebook.getClass().getDeclaredField("map");
			changeMap.setAccessible(true);
			changeMap.set(notebook, new LinkedHashMap());
			changeMap.setAccessible(false);
			JSONArray celulas = new JSONArray();
			montaScript(celulas);
			notebook.put("cells", celulas);
			JSONObject kernel = new JSONObject();
			kernel.put("display_name", "Python 3");
			kernel.put("language", "python");
			kernel.put("name", "python3");
			JSONObject languageInfo = new JSONObject();
			languageInfo.put("name", " ");
			JSONObject metadata = new JSONObject();
			metadata.put("kernelspec", kernel);
			metadata.put("language_info", languageInfo);
			notebook.put("metadata", metadata);
			notebook.put("nbformat", 4);
			notebook.put("nbformat_minor", 4);
			
			fw.write(notebook.toString(4));
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		
		//fw.print("");
		//fw.print("");
	}


	private void montaScript(JSONArray celulas) {
		// TODO Auto-generated method stub
		
	}
	*/
	

}
