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
	private Double ofertaCompra;
	private Double ofertaVenda;
	private Long dataInt;
	private Double volume;

	
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
			saida.put("ofertaCompra", this.ofertaCompra);
			saida.put("ofertaVenda", this.ofertaVenda);
			saida.put("dataInt", this.dataInt);
			saida.put("volume", this.volume);
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


	public Double getOfertaCompra() {
		return ofertaCompra;
	}


	public void setOfertaCompra(Double ofertaCompra) {
		this.ofertaCompra = ofertaCompra;
	}


	public Double getOfertaVenda() {
		return ofertaVenda;
	}


	public void setOfertaVenda(Double ofertaVenda) {
		this.ofertaVenda = ofertaVenda;
	}


	public Long getDataInt() {
		return dataInt;
	}


	public void setDataInt(Long dataInt) {
		this.dataInt = dataInt;
	}


	public Double getVolume() {
		return volume;
	}


	public void setVolume(Double volume) {
		this.volume = volume;
	}





	



	


}
