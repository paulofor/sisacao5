package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class GrupoRegraRel extends Model {


	// Relacionamentos 1
	private GrupoRegra GrupoRegra;
	private RegraProjecao RegraProjecao;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}



	public GrupoRegra getGrupoRegra() {
		return GrupoRegra;
	}
	public void setGrupoRegra(HashMap valor) {
		this.GrupoRegra = new GrupoRegra();
		BeanUtil.setProperties(this.GrupoRegra, (Map<String, ? extends Object>) valor, true);
	}
	public RegraProjecao getRegraProjecao() {
		return RegraProjecao;
	}
	public void setRegraProjecao(HashMap valor) {
		this.RegraProjecao = new RegraProjecao();
		BeanUtil.setProperties(this.RegraProjecao, (Map<String, ? extends Object>) valor, true);
	}
}
