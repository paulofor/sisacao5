package br.com.gersis.loopback.modelo;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.strongloop.android.loopback.Model;
import com.strongloop.android.remoting.BeanUtil;
import org.json.JSONObject;


public class ExperimentoPreRedeTreinadaControle extends Model {


	private int diaNum;
	private String ticker;
	private int experimentoPreRedeTreinadaId;
	private double valorEntrada;
	private double valorSaida;
	private int resultado;
	private int diaNumEntrada;
	private int diaNumSaida;
	// Relacionamentos 1
	private ExperimentoPreRedeTreinada ExperimentoPreRedeTreinada;
	// Relacionamentos N

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
			obj.put("diaNum", diaNum);
			obj.put("ticker", ticker);
			obj.put("experimentoPreRedeTreinadaId", experimentoPreRedeTreinadaId);
			obj.put("valorEntrada", valorEntrada);
			obj.put("valorSaida", valorSaida);
			obj.put("resultado", resultado);
			obj.put("diaNumEntrada", diaNumEntrada);
			obj.put("diaNumSaida", diaNumSaida);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}


	public void setDiaNum(int valor) { 
		this.diaNum = valor;
	}
	public int getDiaNum() { 
		return this.diaNum;
	}
	public void setTicker(String valor) { 
		this.ticker = valor;
	}
	public String getTicker() { 
		return this.ticker;
	}
	public void setExperimentoPreRedeTreinadaId(int valor) { 
		this.experimentoPreRedeTreinadaId = valor;
	}
	public int getExperimentoPreRedeTreinadaId() { 
		return this.experimentoPreRedeTreinadaId;
	}
	public void setValorEntrada(double valor) { 
		this.valorEntrada = valor;
	}
	public double getValorEntrada() { 
		return this.valorEntrada;
	}
	public void setValorSaida(double valor) { 
		this.valorSaida = valor;
	}
	public double getValorSaida() { 
		return this.valorSaida;
	}
	public void setResultado(int valor) { 
		this.resultado = valor;
	}
	public int getResultado() { 
		return this.resultado;
	}
	public void setDiaNumEntrada(int valor) { 
		this.diaNumEntrada = valor;
	}
	public int getDiaNumEntrada() { 
		return this.diaNumEntrada;
	}
	public void setDiaNumSaida(int valor) { 
		this.diaNumSaida = valor;
	}
	public int getDiaNumSaida() { 
		return this.diaNumSaida;
	}

	public ExperimentoPreRedeTreinada getExperimentoPreRedeTreinada() {
		return ExperimentoPreRedeTreinada;
	}
	public void setExperimentoPreRedeTreinada(HashMap valor) {
		this.ExperimentoPreRedeTreinada = new ExperimentoPreRedeTreinada();
		BeanUtil.setProperties(this.ExperimentoPreRedeTreinada, (Map<String, ? extends Object>) valor, true);
	}
}
