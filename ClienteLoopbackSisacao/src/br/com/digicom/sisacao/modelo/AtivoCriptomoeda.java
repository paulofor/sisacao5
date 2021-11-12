package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class AtivoCriptomoeda  extends Model{

	private String ticker;
	private String nome;
	//private Integer intraday5;
	//private Integer intraday15;
	//private Integer intraday30;
	//private Integer intraday10;
	
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
	
	
}
