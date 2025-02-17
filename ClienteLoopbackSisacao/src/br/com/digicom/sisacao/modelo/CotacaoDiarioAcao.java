package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class CotacaoDiarioAcao extends Model{
	
	private String ticker;
	private Double abertura;
	private Double maximo;
	private Double minimo;
	private Double fechamento;
	
	private Integer negocios;
	private Integer volume;
	private Integer diaNum;
	
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Double getAbertura() {
		return abertura;
	}
	public void setAbertura(Double abertura) {
		this.abertura = abertura;
	}
	public void setAbertura(Integer abertura) {
		this.abertura = abertura.doubleValue();
	}
	public Double getMaximo() {
		return maximo;
	}
	public void setMaximo(Double maximo) {
		this.maximo = maximo;
	}
	public void setMaximo(Integer maximo) {
		this.maximo = maximo.doubleValue();
	}
	public Double getMinimo() {
		return minimo;
	}
	public void setMinimo(Double minimo) {
		this.minimo = minimo;
	}
	public void setMinimo(Integer minimo) {
		this.minimo = minimo.doubleValue();
	}
	public Double getFechamento() {
		return fechamento;
	}
	public void setFechamento(Double fechamento) {
		this.fechamento = fechamento;
	}
	public void setFechamento(Integer fechamento) {
		this.fechamento = fechamento.doubleValue();
	}
	public Integer getNegocios() {
		return negocios;
	}
	public void setNegocios(Integer negocios) {
		this.negocios = negocios;
	}
	public Integer getVolume() {
		return volume;
	}
	public void setVolume(Integer volume) {
		this.volume = volume;
	}
	public Integer getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Integer diaNum) {
		this.diaNum = diaNum;
	}
	
	public String toString() {
		return this.diaNum + ") abe:" + this.abertura + " , max:" + this.maximo + " , min:" + this.minimo + " , fec:" + this.fechamento;
 	}
	
	

}
