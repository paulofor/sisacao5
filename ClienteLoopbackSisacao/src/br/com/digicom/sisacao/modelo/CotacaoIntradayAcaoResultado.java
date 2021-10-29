package br.com.digicom.sisacao.modelo;

import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class CotacaoIntradayAcaoResultado extends Model {

	
	
	private String ticker;
	private Double valor;

	private String hora;
	private String dataHora;
	private Integer diaNum;
	
	private String dataExtraida;
	private String horaExtraida;
	
	
	private boolean atualizaTg15St15 = false;
	private Integer tg15St15;
	
	private boolean atualizaCompraTg15St10 = false;
	private Integer compraTg15St10;
	
	private boolean atualizaVendaTg15St10 = false;
	private Integer vendaTg15St10;
	
	public void atualizaTg15St15() {
		atualizaTg15St15 = true;
	}
	public void atualizaCompraTg15St10() {
		atualizaCompraTg15St10 = true;
	}
	public void atualizaVendaTg15St10() {
		atualizaVendaTg15St10 = true;
	}
	
	
	public Integer getTg15St15() {
		return tg15St15;
	}
	public void setTg15St15(Integer tg15St15) {
		this.tg15St15 = tg15St15;
	}
	public Integer getCompraTg15St10() {
		return compraTg15St10;
	}
	public void setCompraTg15St10(Integer compraTg15St10) {
		this.compraTg15St10 = compraTg15St10;
	}
	public Integer getVendaTg15St10() {
		return vendaTg15St10;
	}
	public void setVendaTg15St10(Integer vendaTg15St10) {
		this.vendaTg15St10 = vendaTg15St10;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
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

	public String getDataHora() {
		return dataHora;
	}
	public void setDataHora(String dataHora) {
		this.dataHora = dataHora;
		this.dataExtraida = dataHora.substring(0, 10);
		this.horaExtraida = dataHora.substring(11, 19);
	}
	

	public String toString() {
		return this.dataHora + ": " + this.valor;
	}
	public JSONObject getJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
