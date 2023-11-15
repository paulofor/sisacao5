package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExperimentoRedeNeural extends Model {


	private int possuiCache;
	// Relacionamentos 1
	private PeriodoTreinoRede PeriodoTreinoRede;
	private GrupoRede GrupoRede;
	private GrupoAcao GrupoAcao;
	private GrupoRegra GrupoRegra;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("possuiCache", possuiCache);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setPossuiCache(int valor) { 
		this.possuiCache = valor;
	}
	public int getPossuiCache() { 
		return this.possuiCache;
	}

	public PeriodoTreinoRede getPeriodoTreinoRede() {
		return PeriodoTreinoRede;
	}
	public void setPeriodoTreinoRede(HashMap valor) {
		this.PeriodoTreinoRede = new PeriodoTreinoRede();
		BeanUtil.setProperties(this.PeriodoTreinoRede, (Map<String, ? extends Object>) valor, true);
	}
	public GrupoRede getGrupoRede() {
		return GrupoRede;
	}
	public void setGrupoRede(HashMap valor) {
		this.GrupoRede = new GrupoRede();
		BeanUtil.setProperties(this.GrupoRede, (Map<String, ? extends Object>) valor, true);
	}
	public GrupoAcao getGrupoAcao() {
		return GrupoAcao;
	}
	public void setGrupoAcao(HashMap valor) {
		this.GrupoAcao = new GrupoAcao();
		BeanUtil.setProperties(this.GrupoAcao, (Map<String, ? extends Object>) valor, true);
	}
	public GrupoRegra getGrupoRegra() {
		return GrupoRegra;
	}
	public void setGrupoRegra(HashMap valor) {
		this.GrupoRegra = new GrupoRegra();
		BeanUtil.setProperties(this.GrupoRegra, (Map<String, ? extends Object>) valor, true);
	}
}
