package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class TreinoGrupoRede extends Model {


	// Relacionamentos 1
	private PeriodoTreinoRede PeriodoTreinoRede;
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



	public PeriodoTreinoRede getPeriodoTreinoRede() {
		return PeriodoTreinoRede;
	}
	public void setPeriodoTreinoRede(HashMap valor) {
		this.PeriodoTreinoRede = new PeriodoTreinoRede();
		BeanUtil.setProperties(this.PeriodoTreinoRede, (Map<String, ? extends Object>) valor, true);
	}
}
