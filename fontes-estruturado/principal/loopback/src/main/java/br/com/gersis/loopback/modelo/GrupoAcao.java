package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class GrupoAcao extends Model {


	// Relacionamentos 1
	// Relacionamentos N
	private List<RegraProjecaoReversao> RegraProjecaoReversaos;
	private List<FechamentoRegraDia> FechamentoRegraDias;
	private List<ExperimentoPreRedeTreinada> ExperimentoPreRedeTreinadas;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}



	public List<RegraProjecaoReversao> getRegraProjecaoReversaos() {
		return  RegraProjecaoReversaos;
	}
	public void setRegraProjecaoReversaos(List<RegraProjecaoReversao> valores) {
		this.RegraProjecaoReversaos = new ArrayList<RegraProjecaoReversao>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new RegraProjecaoReversao();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.RegraProjecaoReversaos.add((RegraProjecaoReversao) objeto);
		}
	}
	public List<FechamentoRegraDia> getFechamentoRegraDias() {
		return  FechamentoRegraDias;
	}
	public void setFechamentoRegraDias(List<FechamentoRegraDia> valores) {
		this.FechamentoRegraDias = new ArrayList<FechamentoRegraDia>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new FechamentoRegraDia();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.FechamentoRegraDias.add((FechamentoRegraDia) objeto);
		}
	}
	public List<ExperimentoPreRedeTreinada> getExperimentoPreRedeTreinadas() {
		return  ExperimentoPreRedeTreinadas;
	}
	public void setExperimentoPreRedeTreinadas(List<ExperimentoPreRedeTreinada> valores) {
		this.ExperimentoPreRedeTreinadas = new ArrayList<ExperimentoPreRedeTreinada>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRedeTreinada();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedeTreinadas.add((ExperimentoPreRedeTreinada) objeto);
		}
	}
}
