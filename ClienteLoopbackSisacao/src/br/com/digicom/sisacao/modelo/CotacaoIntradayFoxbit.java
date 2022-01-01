package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayFoxbit extends Model{
	
	private String ticker;
	private Double valor;
	private Integer diaNum;
	private String dataHora;
	private Double valorCompra;
	private Double valorVenda;
	private String tickerMoeda;
	private String cambio;
	private Double valorUSD;
	private Double maximo;
	private Double minimo;
	
	public JSONObject getJSON() {
		JSONObject saida = new JSONObject();
		try {
			saida.put("ticker", this.ticker);
			saida.put("valor", this.valor);
			saida.put("diaNum", this.diaNum);
			saida.put("dataHora", this.dataHora);
			saida.put("valorCompra", this.valorCompra);
			saida.put("valorVenda", this.valorVenda);
			saida.put("tickerMoeda", this.tickerMoeda);
			saida.put("cambio", this.cambio);
			saida.put("valorUSD", this.valorUSD);
			saida.put("maximo", this.maximo);
			saida.put("minimo", this.minimo);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return saida;
	}
	
	
	public String toString() {
		return ticker + ":" + valor + "(" + cambio + ") - " + tickerMoeda;
	}
	
	
	public String getCambio() {
		return cambio;
	}


	public void setCambio(String cambio) {
		this.cambio = cambio;
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
	public Double getValorCompra() {
		return valorCompra;
	}
	public void setValorCompra(Double valorCompra) {
		this.valorCompra = valorCompra;
	}
	public Double getValorVenda() {
		return valorVenda;
	}
	public void setValorVenda(Double valorVenda) {
		this.valorVenda = valorVenda;
	}
	public String getTickerMoeda() {
		return tickerMoeda;
	}
	public void setTickerMoeda(String tickerMoeda) {
		this.tickerMoeda = tickerMoeda;
	}


	


	public Double getValorUSD() {
		return valorUSD;
	}


	public void setValorUSD(Double valorUSD) {
		this.valorUSD = valorUSD;
	}


	public void criaValorDolar(double usd) {
		this.setValorUSD(this.valor / usd);
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
