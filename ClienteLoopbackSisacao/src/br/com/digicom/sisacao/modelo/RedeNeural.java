package br.com.digicom.sisacao.modelo;

import com.strongloop.android.loopback.Model;

public class RedeNeural extends Model {

	private String estrutura;
	private String fitTreinamento;
	private String compilacao;
	private Integer id;
	
	
	
	
	public Integer getId() {
		return id;
	}
	public void setId(Integer id) {
		this.id = id;
	}
	public String getEstrutura() {
		return estrutura;
	}
	public void setEstrutura(String estrutura) {
		this.estrutura = estrutura;
	}
	public String getFitTreinamento() {
		return fitTreinamento;
	}
	public void setFitTreinamento(String fitTreinamento) {
		this.fitTreinamento = fitTreinamento;
	}
	public String getCompilacao() {
		return compilacao;
	}
	public void setCompilacao(String compilacao) {
		this.compilacao = compilacao;
	}
	
	
}
