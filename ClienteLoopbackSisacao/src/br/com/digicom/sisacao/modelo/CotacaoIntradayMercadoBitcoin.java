package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayMercadoBitcoin extends Model{
	
	private String ticker;
	private Double valor;
	private Integer diaNum;
	private String dataHora;
	private Double maximo;
	private Double minimo;
	private String tickerMoeda;

	
	public JSONObject getJSON() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("valor", this.valor);
			saida.put("diaNum", this.diaNum);
			saida.put("dataHora", this.dataHora);
			saida.put("maximo", this.maximo);
			saida.put("minimo", this.minimo);
			saida.put("tickerMoeda", this.tickerMoeda);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	public String toString() {
		return ticker + ":" + valor;
	}
	
	
	

	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Integer getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	
	public String getTickerMoeda() {
		return tickerMoeda;
	}
	public void setTickerMoeda(String tickerMoeda) {
		this.tickerMoeda = tickerMoeda;
	}


	public Double getMaximo() {
		return maximo;
	}


	public void setMaximo(Double maximo) {
		this.maximo = maximo;
	}


	public Double getMinimo() {
		return minimo;
	}


	public void setMinimo(Double minimo) {
		this.minimo = minimo;
	}


	



	


}
