package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class GrupoRedeRel extends Model {


	// Relacionamentos 1
	private RedeNeural RedeNeural;
	private GrupoRede GrupoRede;
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



	public RedeNeural getRedeNeural() {
		return RedeNeural;
	}
	public void setRedeNeural(HashMap valor) {
		this.RedeNeural = new RedeNeural();
		BeanUtil.setProperties(this.RedeNeural, (Map<String, ? extends Object>) valor, true);
	}
	public GrupoRede getGrupoRede() {
		return GrupoRede;
	}
	public void setGrupoRede(HashMap valor) {
		this.GrupoRede = new GrupoRede();
		BeanUtil.setProperties(this.GrupoRede, (Map<String, ? extends Object>) valor, true);
	}
}
