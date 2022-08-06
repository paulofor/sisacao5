package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class PrevisaoTeste extends Model{

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
	private Double pontuacao;
	

	public String toString() {
		return "#" + this.getId() + " - " + this.ticker + "(" + this.diaNumPrevisao + "): " + this.precoEntrada + " resultado: " + this.resultado;
	}
	
	
	public JSONObject jSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("id", this.getId());
			obj.put("resultado", this.resultado);
			obj.put("precoSaida", this.precoSaida);
			obj.put("diaNumSaida", this.diaNumSaida);
			obj.put("pontuacao", this.pontuacao);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	
	
	
	
	public Double getPontuacao() {
		return pontuacao;
	}
	public void setPontuacao(Double pontuacao) {
		this.pontuacao = pontuacao;
	}
	public void setPontuacao(Integer pontuacao) {
		this.pontuacao = new Double(pontuacao);
	}
	public void calculaPontuacao() {
		this.pontuacao = 0d;
		if (this.resultado==1) {
			this.pontuacao = this.target;
		}
		if (this.resultado==-1) {
			this.pontuacao = this.stop * -1;
		}
	}


	public Double getTarget() {
		return target;
	}
	public void setTarget(Double target) {
		this.target = target;
	}
	
	
	public Double getStop() {
		return stop;
	}
	public void setStop(Double stop) {
		this.stop = stop;
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
		this.valorPrevisao = new Double(valorPrevisao);
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
		this.precoEntrada = new Double(precoEntrada);
	}
	
	
	public Double getPrecoReferencia() {
		return precoReferencia;
	}
	public void setPrecoReferencia(Double precoReferencia) {
		this.precoReferencia = precoReferencia;
	}
	public void setPrecoReferencia(Integer precoReferencia) {
		this.precoReferencia = new Double(precoReferencia);
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
		this.maximoDiario = new Double(maximoDiario);
	}
	
	
	public Double getMinimoDiario() {
		return minimoDiario;
	}
	public void setMinimoDiario(Double minimoDiario) {
		this.minimoDiario = minimoDiario;
	}
	public void setMinimoDiario(Integer minimoDiario) {
		this.minimoDiario = new Double(minimoDiario);
	}
	
	
	public Double getPrecoSaida() {
		return precoSaida;
	}
	public void setPrecoSaida(Double precoSaida) {
		this.precoSaida = precoSaida;
	}
	public void setPrecoSaida(Integer precoSaida) {
		this.precoSaida = new Double(precoSaida);
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
