package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class PrevisaoRede extends Model{

	private String ticker;
	private int diaNumPrevisao;
	private Double valorPrevisao;
	private Long redeNeuralId;
	private Double precoEntrada;
	private Double precoReferencia;
	private String tipoCompraVenda;
	
	private Double maximoDiario;
	private Double minimoDiario;
	private Double precoSaida;
	private Long resultado;
	private int diaNumSaida;
	
	private Double target;
	private Double stop;
	

	public String toString() {
		return "#" + this.getId() + " - " + this.ticker + "(" + this.diaNumPrevisao + "): " + this.precoEntrada + " resultado: " + this.resultado;
	}
	
	public double precoTarget() {
		double valorSaida = 0;
		if ("C".equals(tipoCompraVenda)) {
			valorSaida = (precoEntrada) * (1+this.target);
		}
		if ("V".equals(tipoCompraVenda)) {
			valorSaida = (precoEntrada) * (1-this.target);
		}
		return valorSaida;
	}
	public double precoStop() {
		double valorSaida = 0;
		if ("C".equals(tipoCompraVenda)) {
			valorSaida = (precoEntrada) * (1-this.stop);
		}
		if ("V".equals(tipoCompraVenda)) {
			valorSaida = (precoEntrada) * (1+this.stop);
		}
		return valorSaida;
	}
	
	public JSONObject jSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", this.getId());
			obj.put("resultado", this.resultado);
			obj.put("precoSaida", this.precoSaida);
			obj.put("diaNumSaida", this.diaNumSaida);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	public Double getTarget() {
		return target;
	}
	public void setTarget(Double target) {
		this.target = target;
	}
	public void setTarget(Integer target) {
		this.target = target.doubleValue();
	}
	public Double getStop() {
		return stop;
	}
	public void setStop(Double stop) {
		this.stop = stop;
	}
	public void setStop(Integer stop) {
		this.stop = stop.doubleValue();
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public int getDiaNumPrevisao() {
		return diaNumPrevisao;
	}
	public void setDiaNumPrevisao(int diaNumPrevisao) {
		this.diaNumPrevisao = diaNumPrevisao;
	}
	public Double getValorPrevisao() {
		return valorPrevisao;
	}
	public void setValorPrevisao(Double valorPrevisao) {
		this.valorPrevisao = valorPrevisao;
	}
	public void setValorPrevisao(Integer valorPrevisao) {
		this.valorPrevisao = valorPrevisao.doubleValue();
	}
	public Long getRedeNeuralId() {
		return redeNeuralId;
	}
	public void setRedeNeuralId(Long redeNeuralId) {
		this.redeNeuralId = redeNeuralId;
	}
	public Double getPrecoEntrada() {
		return precoEntrada;
	}
	public void setPrecoEntrada(Double precoEntrada) {
		this.precoEntrada = precoEntrada;
	}
	public void setPrecoEntrada(Integer precoEntrada) {
		this.precoEntrada = precoEntrada.doubleValue();
	}
	public Double getPrecoReferencia() {
		return precoReferencia;
	}
	public void setPrecoReferencia(Double precoReferencia) {
		this.precoReferencia = precoReferencia;
	}
	public void setPrecoReferencia(Integer precoReferencia) {
		this.precoReferencia = precoReferencia.doubleValue();
	}
	public String getTipoCompraVenda() {
		return tipoCompraVenda;
	}
	public void setTipoCompraVenda(String tipoCompraVenda) {
		this.tipoCompraVenda = tipoCompraVenda;
	}
	public Double getMaximoDiario() {
		return maximoDiario;
	}
	public void setMaximoDiario(Double maximoDiario) {
		this.maximoDiario = maximoDiario;
	}
	public void setMaximoDiario(Integer maximoDiario) {
		this.maximoDiario = maximoDiario.doubleValue();
	}
	public Double getMinimoDiario() {
		return minimoDiario;
	}
	public void setMinimoDiario(Double minimoDiario) {
		this.minimoDiario = minimoDiario;
	}
	public void setMinimoDiario(Integer minimoDiario) {
		this.minimoDiario = minimoDiario.doubleValue();
	}
	public Double getPrecoSaida() {
		return precoSaida;
	}
	public void setPrecoSaida(Double precoSaida) {
		this.precoSaida = precoSaida;
	}
	public void setPrecoSaida(Integer precoSaida) {
		this.precoSaida = precoSaida.doubleValue();
	}
	public Long getResultado() {
		return resultado;
	}
	public void setResultado(Long resultado) {
		this.resultado = resultado;
	}

	public int getDiaNumSaida() {
		return diaNumSaida;
	}

	public void setDiaNumSaida(int diaNumSaida) {
		this.diaNumSaida = diaNumSaida;
	}
	
	
	
}
