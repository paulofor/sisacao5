package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayAcao extends Model {

	private String ticker;
	private Double valor;
	private String dataHoraNegStr;
	private String dataHora;
	//private Long posicaoDia;
	//private Long intervalo;
	private Integer diaNum;
	
	private String dataExtraida;
	private String horaExtraida;
	
	
	
	
	public Integer getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}
	public String getDataExtraida() {
		return dataExtraida;
	}
	public void setDataExtraida(String dataExtraida) {
		this.dataExtraida = dataExtraida;
	}
	public String getHoraExtraida() {
		return horaExtraida;
	}
	public void setHoraExtraida(String horaExtraida) {
		this.horaExtraida = horaExtraida;
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
	public void setValor(Long valor) {
		this.valor = valor.doubleValue();
	}
	public void setValor(Integer valor) {
		this.valor = valor.doubleValue();
	}
	public String getDataHoraNegStr() {
		return dataHoraNegStr;
	}
	public void setDataHoraNegStr(String dataHoraNegStr) {
		this.dataHoraNegStr = dataHoraNegStr;
	}
	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
		this.dataExtraida = dataHora.substring(0, 10);
		this.horaExtraida = dataHora.substring(11, 19);
	}
	

	public String toString() {
		return this.dataHoraNegStr + ": " + this.valor;
	}

}
