package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class PrevisaoRede extends Model {


	// Relacionamentos 1
	private DiaPregao DiaPregao;
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



	public DiaPregao getDiaPregao() {
		return DiaPregao;
	}
	public void setDiaPregao(HashMap valor) {
		this.DiaPregao = new DiaPregao();
		BeanUtil.setProperties(this.DiaPregao, (Map<String, ? extends Object>) valor, true);
	}
}
