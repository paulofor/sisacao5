package gerador.criapythontreinorede.jupyter;



import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.lang.reflect.Field;
import java.nio.charset.StandardCharsets;
import java.util.LinkedHashMap;

import org.json.JSONArray;
import org.json.JSONObject;
import org.json.JSONTokener;


public abstract class NotebookObj {
	

	
	private JSONObject propJson = null;
	private String nomeArquivo = null;

	
	protected JSONObject getProp() {
		return propJson;
	}

	protected void insereCelula(JSONArray notebook, CelulaNotebook celula) {
		JSONArray celulas = celula.getJSON();
		for (int i=0; i<celulas.length(); i++) {
			JSONObject item = (JSONObject) celulas.get(i);
			notebook.put(item);
		}
	}
	
	public void setPropriedades(String nomeArquivo) throws FileNotFoundException  {
		File file = new File(nomeArquivo + ".json");
		InputStream inputStream = new FileInputStream(file);
		JSONTokener tokener = new JSONTokener(inputStream);
		propJson = new JSONObject(tokener);
	}

	public void geraNotebook() {
		String nomeArquivo = propJson.getString("script");
		if (nomeArquivo==null) {
			nomeArquivo = "rotina-principal";
		}
		this.geraNotebook(nomeArquivo);
	}
	
	
	public void geraNotebook(String nome) {
		String arquivoSaida = nome + ".ipynb";
		Writer fw;
		try {
			fw = new OutputStreamWriter(new FileOutputStream(arquivoSaida), StandardCharsets.UTF_8);
			System.out.println("Gerando arquivo " + arquivoSaida);
			geraArquivo(fw);
			fw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	protected abstract void montaScript(JSONArray notebook) ;

	private void geraArquivo(Writer fw) throws IOException {
		JSONObject notebook = new JSONObject();
		
		try {
		      Field changeMap = notebook.getClass().getDeclaredField("map");
		      changeMap.setAccessible(true);
		      changeMap.set(notebook, new LinkedHashMap());
		      changeMap.setAccessible(false);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		
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
	}

	
	private void geraArquivo(FileWriter fw) throws IOException {
		JSONObject notebook = new JSONObject();
		
		try {
		      Field changeMap = notebook.getClass().getDeclaredField("map");
		      changeMap.setAccessible(true);
		      changeMap.set(notebook, new LinkedHashMap());
		      changeMap.setAccessible(false);
		    } catch (Exception e) {
		      e.printStackTrace();
		    }
		
		
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
	}

	

}
