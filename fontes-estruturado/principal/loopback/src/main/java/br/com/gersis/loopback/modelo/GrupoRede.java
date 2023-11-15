package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class GrupoRede extends Model {


	private String nome;
	private int quantidade;
	private int entrada1;
	private int entrada2;
	// Relacionamentos 1
	// Relacionamentos N
	private List<GrupoRedeRel> GrupoRedeRels;
	private List<ExperimentoRedeNeural> ExperimentoRedeNeurals;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("nome", nome);
			obj.put("quantidade", quantidade);
			obj.put("entrada1", entrada1);
			obj.put("entrada2", entrada2);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setNome(String valor) { 
		this.nome = valor;
	}
	public String getNome() { 
		return this.nome;
	}
	public void setQuantidade(int valor) { 
		this.quantidade = valor;
	}
	public int getQuantidade() { 
		return this.quantidade;
	}
	public void setEntrada1(int valor) { 
		this.entrada1 = valor;
	}
	public int getEntrada1() { 
		return this.entrada1;
	}
	public void setEntrada2(int valor) { 
		this.entrada2 = valor;
	}
	public int getEntrada2() { 
		return this.entrada2;
	}

	public List<GrupoRedeRel> getGrupoRedeRels() {
		return  GrupoRedeRels;
	}
	public void setGrupoRedeRels(List<GrupoRedeRel> valores) {
		this.GrupoRedeRels = new ArrayList<GrupoRedeRel>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new GrupoRedeRel();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.GrupoRedeRels.add((GrupoRedeRel) objeto);
		}
	}
	public List<ExperimentoRedeNeural> getExperimentoRedeNeurals() {
		return  ExperimentoRedeNeurals;
	}
	public void setExperimentoRedeNeurals(List<ExperimentoRedeNeural> valores) {
		this.ExperimentoRedeNeurals = new ArrayList<ExperimentoRedeNeural>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoRedeNeural();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoRedeNeurals.add((ExperimentoRedeNeural) objeto);
		}
	}
}
