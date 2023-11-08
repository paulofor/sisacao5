package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class DiaPregao extends Model {


	private String data;
	private int mes;
	private int ano;
	private int diaNum;
	private String dataStr;
	private String dataDbStr;
	// Relacionamentos 1
	// Relacionamentos N
	private List<CotacaoIntradayAcao> CotacaoIntradayAcaos;
	private List<CotacaoIntradayAcaoResultado> CotacaoIntradayAcaoResultados;
	private List<CotacaoDiarioAcao> CotacaoDiarioAcaos;
	private List<PrevisaoRede> PrevisaoRedes;
	private List<FechamentoRegraDiaQuantidade> FechamentoRegraDiaQuantidades;
	private List<CotacaoDiarioAcaoUsa> CotacaoDiarioAcaoUsas;
	private List<CotacaoIntradayIndiceResultado> CotacaoIntradayIndiceResultados;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("data", data);
			obj.put("mes", mes);
			obj.put("ano", ano);
			obj.put("diaNum", diaNum);
			obj.put("dataStr", dataStr);
			obj.put("dataDbStr", dataDbStr);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setData(String valor) { 
		this.data = valor;
	}
	public String getData() { 
		return this.data;
	}
	public void setMes(int valor) { 
		this.mes = valor;
	}
	public int getMes() { 
		return this.mes;
	}
	public void setAno(int valor) { 
		this.ano = valor;
	}
	public int getAno() { 
		return this.ano;
	}
	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}
	public void setDataStr(String valor) { 
		this.dataStr = valor;
	}
	public String getDataStr() { 
		return this.dataStr;
	}
	public void setDataDbStr(String valor) { 
		this.dataDbStr = valor;
	}
	public String getDataDbStr() { 
		return this.dataDbStr;
	}

	public List<CotacaoIntradayAcao> getCotacaoIntradayAcaos() {
		return  CotacaoIntradayAcaos;
	}
	public void setCotacaoIntradayAcaos(List<CotacaoIntradayAcao> valores) {
		this.CotacaoIntradayAcaos = new ArrayList<CotacaoIntradayAcao>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new CotacaoIntradayAcao();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.CotacaoIntradayAcaos.add((CotacaoIntradayAcao) objeto);
		}
	}
	public List<CotacaoIntradayAcaoResultado> getCotacaoIntradayAcaoResultados() {
		return  CotacaoIntradayAcaoResultados;
	}
	public void setCotacaoIntradayAcaoResultados(List<CotacaoIntradayAcaoResultado> valores) {
		this.CotacaoIntradayAcaoResultados = new ArrayList<CotacaoIntradayAcaoResultado>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new CotacaoIntradayAcaoResultado();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.CotacaoIntradayAcaoResultados.add((CotacaoIntradayAcaoResultado) objeto);
		}
	}
	public List<CotacaoDiarioAcao> getCotacaoDiarioAcaos() {
		return  CotacaoDiarioAcaos;
	}
	public void setCotacaoDiarioAcaos(List<CotacaoDiarioAcao> valores) {
		this.CotacaoDiarioAcaos = new ArrayList<CotacaoDiarioAcao>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new CotacaoDiarioAcao();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.CotacaoDiarioAcaos.add((CotacaoDiarioAcao) objeto);
		}
	}
	public List<PrevisaoRede> getPrevisaoRedes() {
		return  PrevisaoRedes;
	}
	public void setPrevisaoRedes(List<PrevisaoRede> valores) {
		this.PrevisaoRedes = new ArrayList<PrevisaoRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new PrevisaoRede();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.PrevisaoRedes.add((PrevisaoRede) objeto);
		}
	}
	public List<FechamentoRegraDiaQuantidade> getFechamentoRegraDiaQuantidades() {
		return  FechamentoRegraDiaQuantidades;
	}
	public void setFechamentoRegraDiaQuantidades(List<FechamentoRegraDiaQuantidade> valores) {
		this.FechamentoRegraDiaQuantidades = new ArrayList<FechamentoRegraDiaQuantidade>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new FechamentoRegraDiaQuantidade();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.FechamentoRegraDiaQuantidades.add((FechamentoRegraDiaQuantidade) objeto);
		}
	}
	public List<CotacaoDiarioAcaoUsa> getCotacaoDiarioAcaoUsas() {
		return  CotacaoDiarioAcaoUsas;
	}
	public void setCotacaoDiarioAcaoUsas(List<CotacaoDiarioAcaoUsa> valores) {
		this.CotacaoDiarioAcaoUsas = new ArrayList<CotacaoDiarioAcaoUsa>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new CotacaoDiarioAcaoUsa();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.CotacaoDiarioAcaoUsas.add((CotacaoDiarioAcaoUsa) objeto);
		}
	}
	public List<CotacaoIntradayIndiceResultado> getCotacaoIntradayIndiceResultados() {
		return  CotacaoIntradayIndiceResultados;
	}
	public void setCotacaoIntradayIndiceResultados(List<CotacaoIntradayIndiceResultado> valores) {
		this.CotacaoIntradayIndiceResultados = new ArrayList<CotacaoIntradayIndiceResultado>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new CotacaoIntradayIndiceResultado();
			System.out.println(" --> ObjetoMap ");
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.CotacaoIntradayIndiceResultados.add((CotacaoIntradayIndiceResultado) objeto);
		}
	}
}
