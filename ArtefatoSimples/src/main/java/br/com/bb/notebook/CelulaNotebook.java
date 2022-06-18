package br.com.bb.notebook;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;

import org.json.JSONArray;
import org.json.JSONObject;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

public class CelulaNotebook {
	private String titulo;
	private int nivel;
	private List<String> linhasComando;
	
	private JSONObject texto;
	private JSONObject codigo;
	
	public CelulaNotebook() {
		this.linhasComando = new ArrayList<String>();
	}
	

	
	public JSONArray getJSON() {
		this.criaJSONTexto();
		this.criaJSONCodigo();
		JSONArray lista = new JSONArray();
		if (this.texto != null)
			lista.put(this.texto);
		if (this.codigo != null)
			lista.put(this.codigo);
		return lista;
	}
	
	private void criaJSONTexto() {
		if (this.titulo == null) return;
		texto = new JSONObject();
		
		try {
			Field changeMap = texto.getClass().getDeclaredField("map");
			changeMap.setAccessible(true);
			changeMap.set(texto, new LinkedHashMap());
			changeMap.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		texto.put("cell_type", "markdown");
		//texto.put("execution_count",null);
		texto.put("metadata", new JSONObject());
		texto.put("outputs", new JSONArray());
		JSONArray source = new JSONArray();
		String nivelStr = "";
		for (int i=0;i<nivel;i++) {
			nivelStr += "#";
		}
		source.put(nivelStr + " " + this.titulo);
		texto.put("source", source);
		
	}
	private void criaJSONCodigo() {
		if (this.linhasComando.size()==0) return;
		codigo = new JSONObject();
		
		try {
			Field changeMap = codigo.getClass().getDeclaredField("map");
			changeMap.setAccessible(true);
			changeMap.set(codigo, new LinkedHashMap());
			changeMap.setAccessible(false);
		} catch (Exception e) {
			e.printStackTrace();
		}

		
		codigo.put("cell_type", "code");
		codigo.put("metadata", new JSONObject());
		codigo.put("outputs", new JSONArray());
		JSONArray source = new JSONArray();
		for (String linha : this.linhasComando) {
			source.put(linha + "\n");
		}
		codigo.put("source", source);
	}
	
	
	
	public void setTitulo(String titulo) {
		this.setTitulo(titulo, 2);
	}
	public void setTitulo(String titulo, int nivel) {
		this.titulo = titulo;
		this.nivel = nivel;
	}
	
	public void adicionaLinha(String linha) {
		this.linhasComando.add(linha);
	}

	public void registra(FileWriter fw)throws IOException {
		this.criaJSONTexto();
		this.criaJSONCodigo();
		fw.write(this.texto.toString(4));
	}
	public static String toPrettyFormat(String jsonString) 
	  {
	      JsonParser parser = new JsonParser();
	      JsonObject json = parser.parse(jsonString).getAsJsonObject();

	      Gson gson = new GsonBuilder().setPrettyPrinting().create();
	      String prettyJson = gson.toJson(json);

	      return prettyJson;
	  }
	
	
}
