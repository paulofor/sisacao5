package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class RelGrupoAcao extends Model {


	private int grupoAcaoId;
	private String ticker;
	// Relacionamentos 1
	private AtivoAcao AtivoAcao;
	private GrupoAcao GrupoAcao;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("grupoAcaoId", grupoAcaoId);
			obj.put("ticker", ticker);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setGrupoAcaoId(int valor) { 
		this.grupoAcaoId = valor;
	}
	public int getGrupoAcaoId() { 
		return this.grupoAcaoId;
	}
	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}

	public AtivoAcao getAtivoAcao() {
		return AtivoAcao;
	}
	public void setAtivoAcao(HashMap valor) {
		this.AtivoAcao = new AtivoAcao();
		BeanUtil.setProperties(this.AtivoAcao, (Map<String, ? extends Object>) valor, true);
	}
	public GrupoAcao getGrupoAcao() {
		return GrupoAcao;
	}
	public void setGrupoAcao(HashMap valor) {
		this.GrupoAcao = new GrupoAcao();
		BeanUtil.setProperties(this.GrupoAcao, (Map<String, ? extends Object>) valor, true);
	}
}
