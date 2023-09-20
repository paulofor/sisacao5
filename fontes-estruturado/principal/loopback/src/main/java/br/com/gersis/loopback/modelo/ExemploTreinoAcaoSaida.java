package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExemploTreinoAcaoSaida extends Model {


	private String ticker;
	private int regraProjecaoId;
	private int campoY;
	private int diaNumSaida;
	private double valorSaida;
	private double valorEntrada;
	private int diaNumPrevisao;
	private double limiteSuperior;
	private double limiteInferior;
	private int resultado;
	private int validado;
	// Relacionamentos 1
	private RegraProjecao RegraProjecao;
	// Relacionamentos N

	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id",getId());
			obj.put("ticker", ticker);
			obj.put("regraProjecaoId", regraProjecaoId);
			obj.put("campoY", campoY);
			obj.put("diaNumSaida", diaNumSaida);
			obj.put("valorSaida", valorSaida);
			obj.put("valorEntrada", valorEntrada);
			obj.put("diaNumPrevisao", diaNumPrevisao);
			obj.put("limiteSuperior", limiteSuperior);
			obj.put("limiteInferior", limiteInferior);
			obj.put("resultado", resultado);
			obj.put("validado", validado);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setRegraProjecaoId(int valor) { 
		this.regraProjecaoId = valor;
	}
	public int getRegraProjecaoId() { 
		return this.regraProjecaoId;
	}
	public void setCampoY(int valor) { 
		this.campoY = valor;
	}
	public int getCampoY() { 
		return this.campoY;
	}
	public void setDiaNumSaida(int valor) { 
		this.diaNumSaida = valor;
	}
	public int getDiaNumSaida() { 
		return this.diaNumSaida;
	}
	public void setValorSaida(double valor) { 
		this.valorSaida = valor;
	}
	public double getValorSaida() { 
		return this.valorSaida;
	}
	public void setValorEntrada(double valor) { 
		this.valorEntrada = valor;
	}
	public double getValorEntrada() { 
		return this.valorEntrada;
	}
	public void setDiaNumPrevisao(int valor) { 
		this.diaNumPrevisao = valor;
	}
	public int getDiaNumPrevisao() { 
		return this.diaNumPrevisao;
	}
	public void setLimiteSuperior(double valor) { 
		this.limiteSuperior = valor;
	}
	public double getLimiteSuperior() { 
		return this.limiteSuperior;
	}
	public void setLimiteInferior(double valor) { 
		this.limiteInferior = valor;
	}
	public double getLimiteInferior() { 
		return this.limiteInferior;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}
	public void setValidado(int valor) { 
		this.validado = valor;
	}
	public int getValidado() { 
		return this.validado;
	}

	public RegraProjecao getRegraProjecao() {
		return RegraProjecao;
	}
	public void setRegraProjecao(HashMap valor) {
		this.RegraProjecao = new RegraProjecao();
		BeanUtil.setProperties(this.RegraProjecao, (Map<String, ? extends Object>) valor, true);
	}
}
