package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayOpcao extends Model {

	private String ticker;
	private Double valor;
	private String dataHoraStr;
	private String dataHora;
	private Long posicaoDia;
	private Long intervalo;
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
	public Long getPosicaoDia() {
		return posicaoDia;
	}
	public void setPosicaoDia(Long posicaoDia) {
		this.posicaoDia = posicaoDia;
	}
	public Long getIntervalo() {
		return intervalo;
	}
	public void setIntervalo(Long intervalo) {
		this.intervalo = intervalo;
	}



}
