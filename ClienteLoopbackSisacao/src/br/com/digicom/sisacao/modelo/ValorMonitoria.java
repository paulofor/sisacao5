package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class ValorMonitoria  extends Model {
	private Double valorEntrada;
	private String ticker;
	private Integer diaNumEntrada;
	private String situacao;
	private Integer id;
	
	public Double getValorEntrada() {
		return valorEntrada;
	}
	public void setValorEntrada(Double valorEntrada) {
		this.valorEntrada = valorEntrada;
	}
	public void setValorEntrada(Integer valorEntrada) {
		this.valorEntrada = valorEntrada.doubleValue();
	}
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public Integer getDiaNumEntrada() {
		return diaNumEntrada;
	}
	public void setDiaNumEntrada(Integer diaNumEntrada) {
		this.diaNumEntrada = diaNumEntrada;
	}
	public String getSituacao() {
		return situacao;
	}
	public void setSituacao(String situacao) {
		this.situacao = situacao;
	}
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	
	
	

}
