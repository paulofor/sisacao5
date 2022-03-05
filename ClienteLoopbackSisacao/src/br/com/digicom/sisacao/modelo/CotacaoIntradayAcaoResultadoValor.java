package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayAcaoResultadoValor extends Model{

	private String ticker;
	private Integer diaNum;
	private String hora;
	
	private Integer resultado;
	private Integer dias;
	
	private Integer regraProjecaoId;
	private String diaHoraNumTicker;
	
	
	private Double valorEntrada;
	private Double valorSaida;
	private Integer diaNumSaida;
	
	private String dataHora;
	private Double valorSuperior;
	private Double valorInferior;
	private Integer anoMesNum;
	
	public JSONObject getJSON() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("diaNum", this.diaNum);
			saida.put("hora", this.hora);
			saida.put("ticker", this.ticker);
			saida.put("resultado", this.resultado);
			saida.put("dias", this.dias);
			saida.put("regraProjecaoId", this.regraProjecaoId);
			saida.put("diaHoraNumTicker", this.diaHoraNumTicker);
			saida.put("valorEntrada", this.valorEntrada);
			saida.put("valorSaida", this.valorSaida);
			saida.put("diaNumSaida", this.diaNumSaida);
			saida.put("dataHora", this.dataHora);
			saida.put("valorSuperior", this.valorSuperior);
			saida.put("valorInferior", this.valorInferior);
			saida.put("anoMesNum", this.anoMesNum);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	
	public String getDataHora() {
		return dataHora;
	}



	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}



	public Double getValorSuperior() {
		return valorSuperior;
	}



	public void setValorSuperior(Double valorSuperior) {
		this.valorSuperior = valorSuperior;
	}



	public Double getValorInferior() {
		return valorInferior;
	}



	public void setValorInferior(Double valorInferior) {
		this.valorInferior = valorInferior;
	}



	public Double getValorEntrada() {
		return valorEntrada;
	}



	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}



	public Double getValorSaida() {
		return valorSaida;
	}



	public void setValorSaida(Double valorSaida) {
		this.valorSaida = valorSaida;
	}



	public Integer getDiaNumSaida() {
		return diaNumSaida;
	}



	public void setDiaNumSaida(Integer diaNumSaida) {
		this.diaNumSaida = diaNumSaida;
	}



	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Integer getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Integer getResultado() {
		return resultado;
	}
	public void setResultado(Integer resultado) {
		this.resultado = resultado;
	}
	public Integer getDias() {
		return dias;
	}
	public void setDias(Integer dias) {
		this.dias = dias;
	}
	public Integer getRegraProjecaoId() {
		return regraProjecaoId;
	}
	public void setRegraProjecaoId(Integer regraProjecaoId) {
		this.regraProjecaoId = regraProjecaoId;
	}
	public String getDiaHoraNumTicker() {
		return diaHoraNumTicker;
	}
	public void setDiaHoraNumTicker(String diaHoraNumTicker) {
		this.diaHoraNumTicker = diaHoraNumTicker;
	}



	public Integer getAnoMesNum() {
		return anoMesNum;
	}



	public void setAnoMesNum(Integer anoMesNum) {
		this.anoMesNum = anoMesNum;
	}
	
	
	
	
}
