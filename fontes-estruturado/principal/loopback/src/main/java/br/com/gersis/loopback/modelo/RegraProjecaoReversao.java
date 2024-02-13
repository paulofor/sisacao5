package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class RegraProjecaoReversao extends Model {


	private double targetStop;
	private int ativa;
	// Relacionamentos 1
	private GrupoAcao GrupoAcao;
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
			obj.put("targetStop", targetStop);
			obj.put("ativa", ativa);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTargetStop(double valor) { 
		this.targetStop = valor;
	}
	public double getTargetStop() { 
		return this.targetStop;
	}
	public void setAtiva(int valor) { 
		this.ativa = valor;
	}
	public int getAtiva() { 
		return this.ativa;
	}

	public GrupoAcao getGrupoAcao() {
		return GrupoAcao;
	}
	public void setGrupoAcao(HashMap valor) {
		this.GrupoAcao = new GrupoAcao();
		BeanUtil.setProperties(this.GrupoAcao, (Map<String, ? extends Object>) valor, true);
	}
}
