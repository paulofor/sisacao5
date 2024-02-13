package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExemploDadoSintetico extends Model {


	private String campoX;
	private String campoXOriginal;
	private String campoY;
	private int amostraDadoSinteticoId;
	private int resultado;
	// Relacionamentos 1
	private AmostraDadoSintetico AmostraDadoSintetico;
	// Relacionamentos N

	public void setId(Long id) {
		this.setIdObjeto(id);
	}
	public void setId(Integer id) {
		this.setIdObjeto(id);
	}

	public int getIdInteger() {
		return new Integer(getId().toString());
	}
	public long getIdLong() {
		return new Long(getId().toString());
	}

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("campoX", campoX);
			obj.put("campoXOriginal", campoXOriginal);
			obj.put("campoY", campoY);
			obj.put("amostraDadoSinteticoId", amostraDadoSinteticoId);
			obj.put("resultado", resultado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setCampoX(String valor) { 
		this.campoX = valor;
	}
	public String getCampoX() { 
		return this.campoX;
	}
	public void setCampoXOriginal(String valor) { 
		this.campoXOriginal = valor;
	}
	public String getCampoXOriginal() { 
		return this.campoXOriginal;
	}
	public void setCampoY(String valor) { 
		this.campoY = valor;
	}
	public String getCampoY() { 
		return this.campoY;
	}
	public void setAmostraDadoSinteticoId(int valor) { 
		this.amostraDadoSinteticoId = valor;
	}
	public int getAmostraDadoSinteticoId() { 
		return this.amostraDadoSinteticoId;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}

	public AmostraDadoSintetico getAmostraDadoSintetico() {
		return AmostraDadoSintetico;
	}
	public void setAmostraDadoSintetico(HashMap valor) {
		this.AmostraDadoSintetico = new AmostraDadoSintetico();
		BeanUtil.setProperties(this.AmostraDadoSintetico, (Map<String, ? extends Object>) valor, true);
	}
}
