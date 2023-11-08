package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class RedeNeural extends Model {


	private String estrutura;
	private String compilacao;
	private String fitTreinamento;
	private String nome;
	private int entrada1;
	private int enttrada2;
	private int qtdeTradeReal;
	private double resultadoTradeReal;
	private int comIbovespa;
	private String estagio;
	private String objetivo;
	// Relacionamentos 1
	private TipoExemploTreino tipoExemploTreino1;
	private TipoExemploTreino tipoExemploTreino2;
	private VersaoPreRede VersaoPreRede;
	// Relacionamentos N
	private List<VersaoPreRede> VersaoPreRedes;
	private List<TreinoRede> TreinoRedes;
	private List<GrupoRedeRel> GrupoRedeRels;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("estrutura", estrutura);
			obj.put("compilacao", compilacao);
			obj.put("fitTreinamento", fitTreinamento);
			obj.put("nome", nome);
			obj.put("entrada1", entrada1);
			obj.put("enttrada2", enttrada2);
			obj.put("qtdeTradeReal", qtdeTradeReal);
			obj.put("resultadoTradeReal", resultadoTradeReal);
			obj.put("comIbovespa", comIbovespa);
			obj.put("estagio", estagio);
			obj.put("objetivo", objetivo);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setEstrutura(String valor) { 
		this.estrutura = valor;
	}
	public String getEstrutura() { 
		return this.estrutura;
	}
	public void setCompilacao(String valor) { 
		this.compilacao = valor;
	}
	public String getCompilacao() { 
		return this.compilacao;
	}
	public void setFitTreinamento(String valor) { 
		this.fitTreinamento = valor;
	}
	public String getFitTreinamento() { 
		return this.fitTreinamento;
	}
	public void setNome(String valor) { 
		this.nome = valor;
	}
	public String getNome() { 
		return this.nome;
	}
	public void setEntrada1(int valor) { 
		this.entrada1 = valor;
	}
	public int getEntrada1() { 
		return this.entrada1;
	}
	public void setEnttrada2(int valor) { 
		this.enttrada2 = valor;
	}
	public int getEnttrada2() { 
		return this.enttrada2;
	}
	public void setQtdeTradeReal(int valor) { 
		this.qtdeTradeReal = valor;
	}
	public int getQtdeTradeReal() { 
		return this.qtdeTradeReal;
	}
	public void setResultadoTradeReal(double valor) { 
		this.resultadoTradeReal = valor;
	}
	public double getResultadoTradeReal() { 
		return this.resultadoTradeReal;
	}
	public void setComIbovespa(int valor) { 
		this.comIbovespa = valor;
	}
	public int getComIbovespa() { 
		return this.comIbovespa;
	}
	public void setEstagio(String valor) { 
		this.estagio = valor;
	}
	public String getEstagio() { 
		return this.estagio;
	}
	public void setObjetivo(String valor) { 
		this.objetivo = valor;
	}
	public String getObjetivo() { 
		return this.objetivo;
	}

	public TipoExemploTreino getTipoExemploTreino1() {
		return tipoExemploTreino1;
	}
	public void setTipoExemploTreino1(HashMap valor) {
		this.tipoExemploTreino1 = new TipoExemploTreino();
		BeanUtil.setProperties(this.tipoExemploTreino1, (Map<String, ? extends Object>) valor, true);
	}
	public TipoExemploTreino getTipoExemploTreino2() {
		return tipoExemploTreino2;
	}
	public void setTipoExemploTreino2(HashMap valor) {
		this.tipoExemploTreino2 = new TipoExemploTreino();
		BeanUtil.setProperties(this.tipoExemploTreino2, (Map<String, ? extends Object>) valor, true);
	}
	public VersaoPreRede getVersaoPreRede() {
		return VersaoPreRede;
	}
	public void setVersaoPreRede(HashMap valor) {
		this.VersaoPreRede = new VersaoPreRede();
		BeanUtil.setProperties(this.VersaoPreRede, (Map<String, ? extends Object>) valor, true);
	}
	public List<VersaoPreRede> getVersaoPreRedes() {
		return  VersaoPreRedes;
	}
	public void setVersaoPreRedes(List<VersaoPreRede> valores) {
		this.VersaoPreRedes = new ArrayList<VersaoPreRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new VersaoPreRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.VersaoPreRedes.add((VersaoPreRede) objeto);
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
}
