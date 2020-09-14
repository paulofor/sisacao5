package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class AtivoAcao extends Model implements Ativo{

	
	private String ticker;
	private String nome;
	private Long intraday5;
	private Long intraday15;
	private Long intraday30;
	
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
	public Long getIntraday5() {
		return intraday5;
	}
	public void setIntraday5(Long intraday5) {
		this.intraday5 = intraday5;
	}
	public Long getIntraday15() {
		return intraday15;
	}
	public void setIntraday15(Long intraday15) {
		this.intraday15 = intraday15;
	}
	public Long getIntraday30() {
		return intraday30;
	}
	public void setIntraday30(Long intraday30) {
		this.intraday30 = intraday30;
	}
	
	
	
}
