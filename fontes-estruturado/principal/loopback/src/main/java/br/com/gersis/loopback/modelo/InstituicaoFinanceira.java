package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class InstituicaoFinanceira extends Model {


	// Relacionamentos 1
	// Relacionamentos N
	private List<AplicacaoInstituicao> AplicacaoInstituicaos;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}



	public List<AplicacaoInstituicao> getAplicacaoInstituicaos() {
		return  AplicacaoInstituicaos;
	}
	public void setAplicacaoInstituicaos(List<AplicacaoInstituicao> valores) {
		this.AplicacaoInstituicaos = new ArrayList<AplicacaoInstituicao>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new AplicacaoInstituicao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.AplicacaoInstituicaos.add((AplicacaoInstituicao) objeto);
		}
	}
}
