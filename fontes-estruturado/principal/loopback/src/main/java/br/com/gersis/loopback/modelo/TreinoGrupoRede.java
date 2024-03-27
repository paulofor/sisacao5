package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class TreinoGrupoRede extends Model {


	private String objetivo;
	// Relacionamentos 1
	private PeriodoTreinoRede PeriodoTreinoRede;
	private GrupoRede GrupoRede;
	private GrupoAcao GrupoAcao;
	// Relacionamentos N
	private List<TreinoRede> TreinoRedes;

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
			obj.put("objetivo", objetivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setObjetivo(String valor) { 
		this.objetivo = valor;
	}
	public String getObjetivo() { 
		return this.objetivo;
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
	public List<TreinoRede> getTreinoRedes() {
		return  TreinoRedes;
	}
	public void setTreinoRedes(List<TreinoRede> valores) {
		this.TreinoRedes = new ArrayList<TreinoRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new TreinoRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.TreinoRedes.add((TreinoRede) objeto);
		}
	}
}
