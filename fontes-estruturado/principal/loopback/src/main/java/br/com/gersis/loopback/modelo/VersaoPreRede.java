package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class VersaoPreRede extends Model {


	private int numero;
	private String caracteristica;
	private String dataCriacao;
	private int finalizada;
	private int preRedeNeuralId;
	private String compilacao;
	private String estrutura;
	private String fitTreinamento;
	private int qtdeParametro;
	// Relacionamentos 1
	private PreRedeNeural preRedeNeural;
	private RedeNeural RedeNeural;
	// Relacionamentos N
	private List<VersaoPreRedeRegra> VersaoPreRedeRegras;
	private List<ExperimentoPreRede> ExperimentoPreRedes;
	private List<RedeNeural> RedeNeurals;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("numero", numero);
			obj.put("caracteristica", caracteristica);
			obj.put("dataCriacao", dataCriacao);
			obj.put("finalizada", finalizada);
			obj.put("preRedeNeuralId", preRedeNeuralId);
			obj.put("compilacao", compilacao);
			obj.put("estrutura", estrutura);
			obj.put("fitTreinamento", fitTreinamento);
			obj.put("qtdeParametro", qtdeParametro);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setNumero(int valor) { 
		this.numero = valor;
	}
	public int getNumero() { 
		return this.numero;
	}
	public void setCaracteristica(String valor) { 
		this.caracteristica = valor;
	}
	public String getCaracteristica() { 
		return this.caracteristica;
	}
	public void setDataCriacao(String valor) { 
		this.dataCriacao = valor;
	}
	public String getDataCriacao() { 
		return this.dataCriacao;
	}
	public void setFinalizada(int valor) { 
		this.finalizada = valor;
	}
	public int getFinalizada() { 
		return this.finalizada;
	}
	public void setPreRedeNeuralId(int valor) { 
		this.preRedeNeuralId = valor;
	}
	public int getPreRedeNeuralId() { 
		return this.preRedeNeuralId;
	}
	public void setCompilacao(String valor) { 
		this.compilacao = valor;
	}
	public String getCompilacao() { 
		return this.compilacao;
	}
	public void setEstrutura(String valor) { 
		this.estrutura = valor;
	}
	public String getEstrutura() { 
		return this.estrutura;
	}
	public void setFitTreinamento(String valor) { 
		this.fitTreinamento = valor;
	}
	public String getFitTreinamento() { 
		return this.fitTreinamento;
	}
	public void setQtdeParametro(int valor) { 
		this.qtdeParametro = valor;
	}
	public int getQtdeParametro() { 
		return this.qtdeParametro;
	}

	public PreRedeNeural getPreRedeNeural() {
		return preRedeNeural;
	}
	public void setPreRedeNeural(HashMap valor) {
		this.preRedeNeural = new PreRedeNeural();
		BeanUtil.setProperties(this.preRedeNeural, (Map<String, ? extends Object>) valor, true);
	}
	public RedeNeural getRedeNeural() {
		return RedeNeural;
	}
	public void setRedeNeural(HashMap valor) {
		this.RedeNeural = new RedeNeural();
		BeanUtil.setProperties(this.RedeNeural, (Map<String, ? extends Object>) valor, true);
	}
	public List<VersaoPreRedeRegra> getVersaoPreRedeRegras() {
		return  VersaoPreRedeRegras;
	}
	public void setVersaoPreRedeRegras(List<VersaoPreRedeRegra> valores) {
		this.VersaoPreRedeRegras = new ArrayList<VersaoPreRedeRegra>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new VersaoPreRedeRegra();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.VersaoPreRedeRegras.add((VersaoPreRedeRegra) objeto);
		}
	}
	public List<ExperimentoPreRede> getExperimentoPreRedes() {
		return  ExperimentoPreRedes;
	}
	public void setExperimentoPreRedes(List<ExperimentoPreRede> valores) {
		this.ExperimentoPreRedes = new ArrayList<ExperimentoPreRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExperimentoPreRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedes.add((ExperimentoPreRede) objeto);
		}
	}
	public List<RedeNeural> getRedeNeurals() {
		return  RedeNeurals;
	}
	public void setRedeNeurals(List<RedeNeural> valores) {
		this.RedeNeurals = new ArrayList<RedeNeural>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new RedeNeural();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.RedeNeurals.add((RedeNeural) objeto);
		}
	}
}
