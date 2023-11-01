package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class TipoExemploTreino extends Model {


	private int qtdeDias;
	private int posicaoReferencia;
	private int diaNumInicio;
	private int diaNumAtualizado;
	private int diaNumFinal;
	private int tamanhoEntrada;
	private int geraExemplo;
	private int diaNumExemploEntradaInicio;
	private int diaNumInicioEntradaIndice;
	// Relacionamentos 1
	// Relacionamentos N
	private List<AmostraDadoSintetico> AmostraDadoSinteticos;

	private List<RedeNeural> RedeNeurals;

	private List<PreRedeNeural> PreRedeNeurals;

	private List<TreinoRede> TreinoRedes;
	private List<ExemploTreinoIndiceAcaoEntrada> ExemploTreinoIndiceAcaoEntradas;

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("qtdeDias", qtdeDias);
			obj.put("posicaoReferencia", posicaoReferencia);
			obj.put("diaNumInicio", diaNumInicio);
			obj.put("diaNumAtualizado", diaNumAtualizado);
			obj.put("diaNumFinal", diaNumFinal);
			obj.put("tamanhoEntrada", tamanhoEntrada);
			obj.put("geraExemplo", geraExemplo);
			obj.put("diaNumExemploEntradaInicio", diaNumExemploEntradaInicio);
			obj.put("diaNumInicioEntradaIndice", diaNumInicioEntradaIndice);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setQtdeDias(int valor) { 
		this.qtdeDias = valor;
	}
	public int getQtdeDias() { 
		return this.qtdeDias;
	}
	public void setPosicaoReferencia(int valor) { 
		this.posicaoReferencia = valor;
	}
	public int getPosicaoReferencia() { 
		return this.posicaoReferencia;
	}
	public void setDiaNumInicio(int valor) { 
		this.diaNumInicio = valor;
	}
	public int getDiaNumInicio() { 
		return this.diaNumInicio;
	}
	public void setDiaNumAtualizado(int valor) { 
		this.diaNumAtualizado = valor;
	}
	public int getDiaNumAtualizado() { 
		return this.diaNumAtualizado;
	}
	public void setDiaNumFinal(int valor) { 
		this.diaNumFinal = valor;
	}
	public int getDiaNumFinal() { 
		return this.diaNumFinal;
	}
	public void setTamanhoEntrada(int valor) { 
		this.tamanhoEntrada = valor;
	}
	public int getTamanhoEntrada() { 
		return this.tamanhoEntrada;
	}
	public void setGeraExemplo(int valor) { 
		this.geraExemplo = valor;
	}
	public int getGeraExemplo() { 
		return this.geraExemplo;
	}
	public void setDiaNumExemploEntradaInicio(int valor) { 
		this.diaNumExemploEntradaInicio = valor;
	}
	public int getDiaNumExemploEntradaInicio() { 
		return this.diaNumExemploEntradaInicio;
	}
	public void setDiaNumInicioEntradaIndice(int valor) { 
		this.diaNumInicioEntradaIndice = valor;
	}
	public int getDiaNumInicioEntradaIndice() { 
		return this.diaNumInicioEntradaIndice;
	}

	public List<AmostraDadoSintetico> getAmostraDadoSinteticos() {
		return  AmostraDadoSinteticos;
	}
	public void setAmostraDadoSinteticos(List<AmostraDadoSintetico> valores) {
		this.AmostraDadoSinteticos = new ArrayList<AmostraDadoSintetico>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new AmostraDadoSintetico();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.AmostraDadoSinteticos.add((AmostraDadoSintetico) objeto);
		}
	}
	public List<RedeNeural> getRedeNeurals() {
		return  RedeNeurals;
	}

	public void setRedeNeurals(List<RedeNeural> valores) {
		this.RedeNeurals = new ArrayList<RedeNeural>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new RedeNeural();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.RedeNeurals.add((RedeNeural) objeto);
		}
	}

	public List<PreRedeNeural> getPreRedeNeurals() {
		return  PreRedeNeurals;
	}
	public void setPreRedeNeurals(List<PreRedeNeural> valores) {
		this.PreRedeNeurals = new ArrayList<PreRedeNeural>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new PreRedeNeural();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.PreRedeNeurals.add((PreRedeNeural) objeto);
		}
	}
	
	public List<TreinoRede> getTreinoRedes() {
		return  TreinoRedes;
	}
	public void setTreinoRedes(List<TreinoRede> valores) {
		this.TreinoRedes = new ArrayList<TreinoRede>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new TreinoRede();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.TreinoRedes.add((TreinoRede) objeto);
		}
	}
	public List<ExemploTreinoIndiceAcaoEntrada> getExemploTreinoIndiceAcaoEntradas() {
		return  ExemploTreinoIndiceAcaoEntradas;
	}
	public void setExemploTreinoIndiceAcaoEntradas(List<ExemploTreinoIndiceAcaoEntrada> valores) {
		this.ExemploTreinoIndiceAcaoEntradas = new ArrayList<ExemploTreinoIndiceAcaoEntrada>();
		for (int i = 0; i < valores.size(); i++) {
			Object objeto = new ExemploTreinoIndiceAcaoEntrada();
			BeanUtil.setProperties(objeto, (Map<String, ? extends Object>) valores.get(i), true);
			this.ExemploTreinoIndiceAcaoEntradas.add((ExemploTreinoIndiceAcaoEntrada) objeto);
		}
	}
}
