package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class FechamentoRegraDia extends Model {


	private double percentualTargetStop;
	private int grupoAcaoId;
	private int diaNumFechado;
	// Relacionamentos 1
	private GrupoAcao GrupoAcao;
	// Relacionamentos N
	private List<FechamentoPontoSaida> FechamentoPontoSaidas;
	private List<FechamentoRegraDiaQuantidade> FechamentoRegraDiaQuantidades;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("percentualTargetStop", percentualTargetStop);
			obj.put("grupoAcaoId", grupoAcaoId);
			obj.put("diaNumFechado", diaNumFechado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setPercentualTargetStop(double valor) { 
		this.percentualTargetStop = valor;
	}
	public double getPercentualTargetStop() { 
		return this.percentualTargetStop;
	}
	public void setGrupoAcaoId(int valor) { 
		this.grupoAcaoId = valor;
	}
	public int getGrupoAcaoId() { 
		return this.grupoAcaoId;
	}
	public void setDiaNumFechado(int valor) { 
		this.diaNumFechado = valor;
	}
	public int getDiaNumFechado() { 
		return this.diaNumFechado;
	}

	public GrupoAcao getGrupoAcao() {
		return GrupoAcao;
	}
	public void setGrupoAcao(HashMap valor) {
		this.GrupoAcao = new GrupoAcao();
		BeanUtil.setProperties(this.GrupoAcao, (Map<String, ? extends Object>) valor, true);
	}
	public List<FechamentoPontoSaida> getFechamentoPontoSaidas() {
		return  FechamentoPontoSaidas;
	}
	public void setFechamentoPontoSaidas(List<FechamentoPontoSaida> valores) {
		this.FechamentoPontoSaidas = new ArrayList<FechamentoPontoSaida>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new FechamentoPontoSaida();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.FechamentoPontoSaidas.add((FechamentoPontoSaida) objeto);
		}
	}
	public List<FechamentoRegraDiaQuantidade> getFechamentoRegraDiaQuantidades() {
		return  FechamentoRegraDiaQuantidades;
	}
	public void setFechamentoRegraDiaQuantidades(List<FechamentoRegraDiaQuantidade> valores) {
		this.FechamentoRegraDiaQuantidades = new ArrayList<FechamentoRegraDiaQuantidade>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new FechamentoRegraDiaQuantidade();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.FechamentoRegraDiaQuantidades.add((FechamentoRegraDiaQuantidade) objeto);
		}
	}
}
