package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class ExemploTreinoAcaoSaida extends Model{

	private String ticker;
	private String campoY;
	private Integer regraProjecaoId;
	private Integer diaNumSaida;
	private Double valorSaida;
	private Double valorEntrada;
	private Integer diaNumPrevisao;
	private Double limiteSuperior;
	private Double limiteInferior;
	private int resultado;
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("ticker", ticker);
			obj.put("campoY", campoY);
			obj.put("regraProjecaoId", regraProjecaoId);
			obj.put("diaNumSaida", diaNumSaida);
			obj.put("diaNumPrevisao", diaNumPrevisao);
			obj.put("valorSaida", valorSaida);
			obj.put("valorEntrada", valorEntrada);
			obj.put("limiteSuperior", limiteSuperior);
			obj.put("limiteInferior", limiteInferior);
			obj.put("resultado", resultado);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}

	public String getTicker() {
		return ticker;
	}

	public void setTicker(String ticker) {
		this.ticker = ticker;
	}

	public String getCampoY() {
		return campoY;
	}

	public void setCampoY(String campoY) {
		this.campoY = campoY;
	}

	public Integer getRegraProjecaoId() {
		return regraProjecaoId;
	}

	public void setRegraProjecaoId(Integer regraProjecaoId) {
		this.regraProjecaoId = regraProjecaoId;
	}

	public Integer getDiaNumSaida() {
		return diaNumSaida;
	}

	public void setDiaNumSaida(Integer diaNumSaida) {
		this.diaNumSaida = diaNumSaida;
	}

	public Double getValorSaida() {
		return valorSaida;
	}
	public void setValorSaida(Integer valor) {
		this.valorSaida = new Double(valorSaida);
	}
	public void setValorSaida(Double valorSaida) {
		this.valorSaida = valorSaida;
	}

	public Double getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(Integer valorEntrada) {
		this.valorEntrada = new Double(valorEntrada);
	}
	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}

	public Integer getDiaNumPrevisao() {
		return diaNumPrevisao;
	}

	public void setDiaNumPrevisao(Integer diaNumPrevisao) {
		this.diaNumPrevisao = diaNumPrevisao;
	}

	public Double getLimiteSuperior() {
		return limiteSuperior;
	}
	public void setLimiteSuperior(Integer limiteSuperior) {
		this.limiteSuperior = new Double(limiteSuperior);
	}
	public void setLimiteSuperior(Double limiteSuperior) {
		this.limiteSuperior = limiteSuperior;
	}

	public Double getLimiteInferior() {
		return limiteInferior;
	}
	public void setLimiteInferior(Integer limiteInferior) {
		this.limiteInferior = new Double(limiteInferior);
	}
	public void setLimiteInferior(Double limiteInferior) {
		this.limiteInferior = limiteInferior;
	}

	public int getResultado() {
		return resultado;
	}

	public void setResultado(int resultado) {
		this.resultado = resultado;
	}
	
	
}
