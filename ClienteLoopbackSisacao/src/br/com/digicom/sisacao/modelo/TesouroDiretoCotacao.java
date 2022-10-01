package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class TesouroDiretoCotacao  extends Model{

	private String nome;
	private String codigoTesouro;
	private int diaNum;
	private String hora;
	private Double taxaAnual;
	
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getCodigoTesouro() {
		return codigoTesouro;
	}
	public void setCodigoTesouro(String codigoTesouro) {
		this.codigoTesouro = codigoTesouro;
	}
	public int getDiaNum() {
		return diaNum;
	}
	public void setDiaNum(int diaNum) {
		this.diaNum = diaNum;
	}
	public String getHora() {
		return hora;
	}
	public void setHora(String hora) {
		this.hora = hora;
	}
	public Double getTaxaAnual() {
		return taxaAnual;
	}
	public void setTaxaAnual(Double taxaAnual) {
		this.taxaAnual = taxaAnual;
	}
	
	
}
