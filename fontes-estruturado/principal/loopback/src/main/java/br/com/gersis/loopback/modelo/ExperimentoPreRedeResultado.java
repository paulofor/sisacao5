package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExperimentoPreRedeResultado extends Model {


	private String campoY;
	private int resultado;
	private double score;
	// Relacionamentos 1
	private ExperimentoPreRede ExperimentoPreRede;
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
			obj.put("campoY", campoY);
			obj.put("resultado", resultado);
			obj.put("score", score);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setCampoY(String valor) { 
		this.campoY = valor;
	}
	public String getCampoY() { 
		return this.campoY;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}
	public void setScore(double valor) { 
		this.score = valor;
	}
	public double getScore() { 
		return this.score;
	}

	public ExperimentoPreRede getExperimentoPreRede() {
		return ExperimentoPreRede;
	}
	public void setExperimentoPreRede(HashMap valor) {
		this.ExperimentoPreRede = new ExperimentoPreRede();
		BeanUtil.setProperties(this.ExperimentoPreRede, (Map<String, ? extends Object>) valor, true);
	}
}
