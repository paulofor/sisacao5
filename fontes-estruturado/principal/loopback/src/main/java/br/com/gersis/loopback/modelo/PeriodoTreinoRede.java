package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class PeriodoTreinoRede extends Model {


	private int diaNumInicioTreino;
	private int diaNumFinalTreino;
	private int diaNumInicioValidacao;
	private int diaNumFinalValidacao;
	private int diaNumInicioTeste;
	private int diaNumFinalTeste;
	private int maximoTradeTeste;
	private int minimoTradeTeste;
	private int simultaneoTradeTeste;
	private int diaNumInicioExecucao;
	private int diaNumFinalExecucao;
	private String nome;
	private int quantidadeDiaTreino;
	private int quantidadeDiaTeste;
	// Relacionamentos 1
	// Relacionamentos N
	private List<PreRedeNeural> preRedeNeurals;
	private List<ExperimentoPreRedeTreinada> ExperimentoPreRedeTreinadas;
	private List<TreinoGrupoRede> TreinoGrupoRedes;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("diaNumInicioTreino", diaNumInicioTreino);
			obj.put("diaNumFinalTreino", diaNumFinalTreino);
			obj.put("diaNumInicioValidacao", diaNumInicioValidacao);
			obj.put("diaNumFinalValidacao", diaNumFinalValidacao);
			obj.put("diaNumInicioTeste", diaNumInicioTeste);
			obj.put("diaNumFinalTeste", diaNumFinalTeste);
			obj.put("maximoTradeTeste", maximoTradeTeste);
			obj.put("minimoTradeTeste", minimoTradeTeste);
			obj.put("simultaneoTradeTeste", simultaneoTradeTeste);
			obj.put("diaNumInicioExecucao", diaNumInicioExecucao);
			obj.put("diaNumFinalExecucao", diaNumFinalExecucao);
			obj.put("nome", nome);
			obj.put("quantidadeDiaTreino", quantidadeDiaTreino);
			obj.put("quantidadeDiaTeste", quantidadeDiaTeste);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setDiaNumInicioTreino(int valor) { 
		this.diaNumInicioTreino = valor;
	}
	public int getDiaNumInicioTreino() { 
		return this.diaNumInicioTreino;
	}
	public void setDiaNumFinalTreino(int valor) { 
		this.diaNumFinalTreino = valor;
	}
	public int getDiaNumFinalTreino() { 
		return this.diaNumFinalTreino;
	}
	public void setDiaNumInicioValidacao(int valor) { 
		this.diaNumInicioValidacao = valor;
	}
	public int getDiaNumInicioValidacao() { 
		return this.diaNumInicioValidacao;
	}
	public void setDiaNumFinalValidacao(int valor) { 
		this.diaNumFinalValidacao = valor;
	}
	public int getDiaNumFinalValidacao() { 
		return this.diaNumFinalValidacao;
	}
	public void setDiaNumInicioTeste(int valor) { 
		this.diaNumInicioTeste = valor;
	}
	public int getDiaNumInicioTeste() { 
		return this.diaNumInicioTeste;
	}
	public void setDiaNumFinalTeste(int valor) { 
		this.diaNumFinalTeste = valor;
	}
	public int getDiaNumFinalTeste() { 
		return this.diaNumFinalTeste;
	}
	public void setMaximoTradeTeste(int valor) { 
		this.maximoTradeTeste = valor;
	}
	public int getMaximoTradeTeste() { 
		return this.maximoTradeTeste;
	}
	public void setMinimoTradeTeste(int valor) { 
		this.minimoTradeTeste = valor;
	}
	public int getMinimoTradeTeste() { 
		return this.minimoTradeTeste;
	}
	public void setSimultaneoTradeTeste(int valor) { 
		this.simultaneoTradeTeste = valor;
	}
	public int getSimultaneoTradeTeste() { 
		return this.simultaneoTradeTeste;
	}
	public void setDiaNumInicioExecucao(int valor) { 
		this.diaNumInicioExecucao = valor;
	}
	public int getDiaNumInicioExecucao() { 
		return this.diaNumInicioExecucao;
	}
	public void setDiaNumFinalExecucao(int valor) { 
		this.diaNumFinalExecucao = valor;
	}
	public int getDiaNumFinalExecucao() { 
		return this.diaNumFinalExecucao;
	}
	public void setNome(String valor) { 
		this.nome = valor;
	}
	public String getNome() { 
		return this.nome;
	}
	public void setQuantidadeDiaTreino(int valor) { 
		this.quantidadeDiaTreino = valor;
	}
	public int getQuantidadeDiaTreino() { 
		return this.quantidadeDiaTreino;
	}
	public void setQuantidadeDiaTeste(int valor) { 
		this.quantidadeDiaTeste = valor;
	}
	public int getQuantidadeDiaTeste() { 
		return this.quantidadeDiaTeste;
	}

	public List<PreRedeNeural> getPreRedeNeurals() {
		return  preRedeNeurals;
	}
	public void setPreRedeNeurals(List<PreRedeNeural> valores) {
		this.preRedeNeurals = new ArrayList<PreRedeNeural>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new PreRedeNeural();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.preRedeNeurals.add((PreRedeNeural) objeto);
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
	public List<TreinoGrupoRede> getTreinoGrupoRedes() {
		return  TreinoGrupoRedes;
	}
	public void setTreinoGrupoRedes(List<TreinoGrupoRede> valores) {
		this.TreinoGrupoRedes = new ArrayList<TreinoGrupoRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new TreinoGrupoRede();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.TreinoGrupoRedes.add((TreinoGrupoRede) objeto);
		}
	}
}
