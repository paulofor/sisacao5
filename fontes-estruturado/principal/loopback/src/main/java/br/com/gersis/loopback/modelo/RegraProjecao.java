package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class RegraProjecao extends Model {


	private double target;
	private double stop;
	private int diaLimite;
	private String tipoCompraVenda;
	private int processando;
	private double percentualEntradaDataset;
	private int indiceHoraReferenciaDataset;
	private String codigoRegraProjecao;
	private int quantidadeTicker;
	private int diaNumMaisAntigo;
	private String ultimaInsercao;
	private int exemploQuantidadeSaida;
	private double exemploPercentualSaida;
	private int exemploQuantidadeClasse0;
	private double exemploPercentualClasse0;
	private int exemploQuantidadeClasse1;
	private double exemploPercentualClasse1;
	private int exemploQuantidadeResultado;
	private double exemploPercentualResultado;
	private String dataHoraAcesso;
	private String maiorDataProcessamento;
	private int quantidadeValidada;
	private double percentualValidado;
	private int prioridade;
	private String tickerExemploSaidaRecente;
	private int diaNumExemploSaidaRecente;
	private String dataHoraExemploSaidaRecente;
	// Relacionamentos 1
	// Relacionamentos N
	private List<VersaoPreRedeRegra> VersaoPreRedeRegras;
	private List<ExperimentoPreRedeTreinada> ExperimentoPreRedeTreinadas;
	private List<GrupoRegraRel> GrupoRegraRels;
	private List<TreinoRede> TreinoRedes;
	private List<ExemploTreinoAcaoSaida> ExemploTreinoAcaoSaidas;

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
			obj.put("target", target);
			obj.put("stop", stop);
			obj.put("diaLimite", diaLimite);
			obj.put("tipoCompraVenda", tipoCompraVenda);
			obj.put("processando", processando);
			obj.put("percentualEntradaDataset", percentualEntradaDataset);
			obj.put("indiceHoraReferenciaDataset", indiceHoraReferenciaDataset);
			obj.put("codigoRegraProjecao", codigoRegraProjecao);
			obj.put("quantidadeTicker", quantidadeTicker);
			obj.put("diaNumMaisAntigo", diaNumMaisAntigo);
			obj.put("ultimaInsercao", ultimaInsercao);
			obj.put("exemploQuantidadeSaida", exemploQuantidadeSaida);
			obj.put("exemploPercentualSaida", exemploPercentualSaida);
			obj.put("exemploQuantidadeClasse0", exemploQuantidadeClasse0);
			obj.put("exemploPercentualClasse0", exemploPercentualClasse0);
			obj.put("exemploQuantidadeClasse1", exemploQuantidadeClasse1);
			obj.put("exemploPercentualClasse1", exemploPercentualClasse1);
			obj.put("exemploQuantidadeResultado", exemploQuantidadeResultado);
			obj.put("exemploPercentualResultado", exemploPercentualResultado);
			obj.put("dataHoraAcesso", dataHoraAcesso);
			obj.put("maiorDataProcessamento", maiorDataProcessamento);
			obj.put("quantidadeValidada", quantidadeValidada);
			obj.put("percentualValidado", percentualValidado);
			obj.put("prioridade", prioridade);
			obj.put("tickerExemploSaidaRecente", tickerExemploSaidaRecente);
			obj.put("diaNumExemploSaidaRecente", diaNumExemploSaidaRecente);
			obj.put("dataHoraExemploSaidaRecente", dataHoraExemploSaidaRecente);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTarget(double valor) { 
		this.target = valor;
	}
	public double getTarget() { 
		return this.target;
	}
	public void setStop(double valor) { 
		this.stop = valor;
	}
	public double getStop() { 
		return this.stop;
	}
	public void setDiaLimite(int valor) { 
		this.diaLimite = valor;
	}
	public int getDiaLimite() { 
		return this.diaLimite;
	}
	public void setTipoCompraVenda(String valor) { 
		this.tipoCompraVenda = valor;
	}
	public String getTipoCompraVenda() { 
		return this.tipoCompraVenda;
	}
	public void setProcessando(int valor) { 
		this.processando = valor;
	}
	public int getProcessando() { 
		return this.processando;
	}
	public void setPercentualEntradaDataset(double valor) { 
		this.percentualEntradaDataset = valor;
	}
	public double getPercentualEntradaDataset() { 
		return this.percentualEntradaDataset;
	}
	public void setIndiceHoraReferenciaDataset(int valor) { 
		this.indiceHoraReferenciaDataset = valor;
	}
	public int getIndiceHoraReferenciaDataset() { 
		return this.indiceHoraReferenciaDataset;
	}
	public void setCodigoRegraProjecao(String valor) { 
		this.codigoRegraProjecao = valor;
	}
	public String getCodigoRegraProjecao() { 
		return this.codigoRegraProjecao;
	}
	public void setQuantidadeTicker(int valor) { 
		this.quantidadeTicker = valor;
	}
	public int getQuantidadeTicker() { 
		return this.quantidadeTicker;
	}
	public void setDiaNumMaisAntigo(int valor) { 
		this.diaNumMaisAntigo = valor;
	}
	public int getDiaNumMaisAntigo() { 
		return this.diaNumMaisAntigo;
	}
	public void setUltimaInsercao(String valor) { 
		this.ultimaInsercao = valor;
	}
	public String getUltimaInsercao() { 
		return this.ultimaInsercao;
	}
	public void setExemploQuantidadeSaida(int valor) { 
		this.exemploQuantidadeSaida = valor;
	}
	public int getExemploQuantidadeSaida() { 
		return this.exemploQuantidadeSaida;
	}
	public void setExemploPercentualSaida(double valor) { 
		this.exemploPercentualSaida = valor;
	}
	public double getExemploPercentualSaida() { 
		return this.exemploPercentualSaida;
	}
	public void setExemploQuantidadeClasse0(int valor) { 
		this.exemploQuantidadeClasse0 = valor;
	}
	public int getExemploQuantidadeClasse0() { 
		return this.exemploQuantidadeClasse0;
	}
	public void setExemploPercentualClasse0(double valor) { 
		this.exemploPercentualClasse0 = valor;
	}
	public double getExemploPercentualClasse0() { 
		return this.exemploPercentualClasse0;
	}
	public void setExemploQuantidadeClasse1(int valor) { 
		this.exemploQuantidadeClasse1 = valor;
	}
	public int getExemploQuantidadeClasse1() { 
		return this.exemploQuantidadeClasse1;
	}
	public void setExemploPercentualClasse1(double valor) { 
		this.exemploPercentualClasse1 = valor;
	}
	public double getExemploPercentualClasse1() { 
		return this.exemploPercentualClasse1;
	}
	public void setExemploQuantidadeResultado(int valor) { 
		this.exemploQuantidadeResultado = valor;
	}
	public int getExemploQuantidadeResultado() { 
		return this.exemploQuantidadeResultado;
	}
	public void setExemploPercentualResultado(double valor) { 
		this.exemploPercentualResultado = valor;
	}
	public double getExemploPercentualResultado() { 
		return this.exemploPercentualResultado;
	}
	public void setDataHoraAcesso(String valor) { 
		this.dataHoraAcesso = valor;
	}
	public String getDataHoraAcesso() { 
		return this.dataHoraAcesso;
	}
	public void setMaiorDataProcessamento(String valor) { 
		this.maiorDataProcessamento = valor;
	}
	public String getMaiorDataProcessamento() { 
		return this.maiorDataProcessamento;
	}
	public void setQuantidadeValidada(int valor) { 
		this.quantidadeValidada = valor;
	}
	public int getQuantidadeValidada() { 
		return this.quantidadeValidada;
	}
	public void setPercentualValidado(double valor) { 
		this.percentualValidado = valor;
	}
	public double getPercentualValidado() { 
		return this.percentualValidado;
	}
	public void setPrioridade(int valor) { 
		this.prioridade = valor;
	}
	public int getPrioridade() { 
		return this.prioridade;
	}
	public void setTickerExemploSaidaRecente(String valor) { 
		this.tickerExemploSaidaRecente = valor;
	}
	public String getTickerExemploSaidaRecente() { 
		return this.tickerExemploSaidaRecente;
	}
	public void setDiaNumExemploSaidaRecente(int valor) { 
		this.diaNumExemploSaidaRecente = valor;
	}
	public int getDiaNumExemploSaidaRecente() { 
		return this.diaNumExemploSaidaRecente;
	}
	public void setDataHoraExemploSaidaRecente(String valor) { 
		this.dataHoraExemploSaidaRecente = valor;
	}
	public String getDataHoraExemploSaidaRecente() { 
		return this.dataHoraExemploSaidaRecente;
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
	public List<GrupoRegraRel> getGrupoRegraRels() {
		return  GrupoRegraRels;
	}
	public void setGrupoRegraRels(List<GrupoRegraRel> valores) {
		this.GrupoRegraRels = new ArrayList<GrupoRegraRel>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new GrupoRegraRel();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.GrupoRegraRels.add((GrupoRegraRel) objeto);
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
	public List<ExemploTreinoAcaoSaida> getExemploTreinoAcaoSaidas() {
		return  ExemploTreinoAcaoSaidas;
	}
	public void setExemploTreinoAcaoSaidas(List<ExemploTreinoAcaoSaida> valores) {
		this.ExemploTreinoAcaoSaidas = new ArrayList<ExemploTreinoAcaoSaida>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExemploTreinoAcaoSaida();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExemploTreinoAcaoSaidas.add((ExemploTreinoAcaoSaida) objeto);
		}
	}
}
