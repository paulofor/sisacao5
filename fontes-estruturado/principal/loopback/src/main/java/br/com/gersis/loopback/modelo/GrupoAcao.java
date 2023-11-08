package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class GrupoAcao extends Model {


	private String nome;
	private String descricao;
	private int quantidade;
	private String codigoGrupoAcao;
	// Relacionamentos 1
	// Relacionamentos N
	private List<RegraProjecaoReversao> RegraProjecaoReversaos;
	private List<FechamentoRegraDia> FechamentoRegraDias;
	private List<ExperimentoPreRedeTreinada> ExperimentoPreRedeTreinadas;
	private List<TreinoRede> TreinoRedes;
	private List<RelGrupoAcao> RelGrupoAcaos;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("nome", nome);
			obj.put("descricao", descricao);
			obj.put("quantidade", quantidade);
			obj.put("codigoGrupoAcao", codigoGrupoAcao);
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
	public void setDescricao(String valor) { 
		this.descricao = valor;
	}
	public String getDescricao() { 
		return this.descricao;
	}
	public void setQuantidade(int valor) { 
		this.quantidade = valor;
	}
	public int getQuantidade() { 
		return this.quantidade;
	}
	public void setCodigoGrupoAcao(String valor) { 
		this.codigoGrupoAcao = valor;
	}
	public String getCodigoGrupoAcao() { 
		return this.codigoGrupoAcao;
	}

	public List<RegraProjecaoReversao> getRegraProjecaoReversaos() {
		return  RegraProjecaoReversaos;
	}
	public void setRegraProjecaoReversaos(List<RegraProjecaoReversao> valores) {
		this.RegraProjecaoReversaos = new ArrayList<RegraProjecaoReversao>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new RegraProjecaoReversao();
			System.out.println(" --> ObjetoMap ");
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
			System.out.println(" --> ObjetoMap ");
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
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExperimentoPreRedeTreinadas.add((ExperimentoPreRedeTreinada) objeto);
		}
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
	public List<RelGrupoAcao> getRelGrupoAcaos() {
		return  RelGrupoAcaos;
	}
	public void setRelGrupoAcaos(List<RelGrupoAcao> valores) {
		this.RelGrupoAcaos = new ArrayList<RelGrupoAcao>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new RelGrupoAcao();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.RelGrupoAcaos.add((RelGrupoAcao) objeto);
		}
	}
}
