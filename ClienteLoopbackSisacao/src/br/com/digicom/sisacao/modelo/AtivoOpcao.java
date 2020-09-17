package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class AtivoOpcao  extends Ativo{



	private String ticker;
	private String nome;
	private Integer intraday5;
	private Integer intraday15;
	private Integer intraday30;
	
	public String getTicker() {
		return ticker;
	}
	public void setTicker(String ticker) {
		this.ticker = ticker;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public Integer getIntraday5() {
		return intraday5;
	}
	public void setIntraday5(Integer intraday5) {
		this.intraday5 = intraday5;
	}
	public Integer getIntraday15() {
		return intraday15;
	}
	public void setIntraday15(Integer intraday15) {
		this.intraday15 = intraday15;
	}
	public Integer getIntraday30() {
		return intraday30;
	}
	public void setIntraday30(Integer intraday30) {
		this.intraday30 = intraday30;
	}
	
	
	
	
}
