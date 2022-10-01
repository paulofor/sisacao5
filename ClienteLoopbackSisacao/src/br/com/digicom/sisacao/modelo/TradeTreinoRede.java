package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class TradeTreinoRede extends Model{

	private String ticker;
	private Double precoEntrada;
	private int diaNumEntrada;
	private Double precoSaida;
	private int diaNumSaida;
	private int treinoRedeId;
	
	
	public Object getJsonEstrada() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("precoEntrada", this.precoEntrada);
			saida.put("diaNumEntrada", this.diaNumEntrada);
			saida.put("treinoRedeId", this.treinoRedeId);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getPrecoEntrada() {
		return precoEntrada;
	}
	public void setPrecoEntrada(Double precoEntrada) {
		this.precoEntrada = precoEntrada;
	}
	public int getDiaNumEntrada() {
		return diaNumEntrada;
	}
	public void setDiaNumEntrada(int diaNumEntrada) {
		this.diaNumEntrada = diaNumEntrada;
	}
	public Double getPrecoSaida() {
		return precoSaida;
	}
	public void setPrecoSaida(Double precoSaida) {
		this.precoSaida = precoSaida;
	}
	public int getDiaNumSaida() {
		return diaNumSaida;
	}
	public void setDiaNumSaida(int diaNumSaida) {
		this.diaNumSaida = diaNumSaida;
	}
	public int getTreinoRedeId() {
		return treinoRedeId;
	}
	public void setTreinoRedeId(int treinoRedeId) {
		this.treinoRedeId = treinoRedeId;
	}
	
	
	
}
