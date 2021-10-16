package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayIndice extends Model {

	private String ticker;
	private Double valor;
	private String dataHoraNegStr;
	private String dataHora;
	private Integer dia;

	public String getDataHoraNegStr() {
		return dataHoraNegStr;
	}
	public void setDataHoraNegStr(String dataHoraNegStr) {
		this.dataHoraNegStr = dataHoraNegStr;
	}
	public Integer getDia() {
		return dia;
	}
	public void setDia(Integer dia) {
		this.dia = dia;
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
	
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
	}
	


}
