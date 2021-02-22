package br.com.digicom.sisacao.modelo;

public class CotacaoDiarioAcao {
	
	private String ticker;
	private Double abertura;
	private Double maximo;
	private Double minimo;
	private Double fechamento;
	
	private Long negocios;
	private Long volume;
	private Long diaNum;
	
	
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
	public void setAbertura(Long abertura) {
		this.abertura = abertura.doubleValue();
	}
	public Double getMaximo() {
		return maximo;
	}
	public void setMaximo(Double maximo) {
		this.maximo = maximo;
	}
	public void setMaximo(Long maximo) {
		this.maximo = maximo.doubleValue();
	}
	public Double getMinimo() {
		return minimo;
	}
	public void setMinimo(Double minimo) {
		this.minimo = minimo;
	}
	public void setMinimo(Long minimo) {
		this.minimo = minimo.doubleValue();
	}
	public Double getFechamento() {
		return fechamento;
	}
	public void setFechamento(Double fechamento) {
		this.fechamento = fechamento;
	}
	public void setFechamento(Long fechamento) {
		this.fechamento = fechamento.doubleValue();
	}
	public Long getNegocios() {
		return negocios;
	}
	public void setNegocios(Long negocios) {
		this.negocios = negocios;
	}
	public Long getVolume() {
		return volume;
	}
	public void setVolume(Long volume) {
		this.volume = volume;
	}
	public Long getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(Long diaNum) {
		this.diaNum = diaNum;
	}
	
	public String toString() {
		return this.diaNum + ": " + this.abertura + " , " + this.maximo + " , " + this.minimo + " , " + this.fechamento;
 	}
	
	

}
