package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayIndice extends Model {

	private String ticker;
	private Double valor;
	private String dataHoraStr;
	private String dataHora;

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
	public String getDataHoraStr() {
		return dataHoraStr;
	}
	public void setDataHoraStr(String dataHoraStr) {
		this.dataHoraStr = dataHoraStr;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	


}
