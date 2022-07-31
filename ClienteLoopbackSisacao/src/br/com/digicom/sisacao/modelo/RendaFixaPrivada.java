package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import com.strongloop.android.loopback.Model;

public class RendaFixaPrivada extends Model{
	
	private String nome;
	private String emissor;
	private String distribuidor;
	
	private String vencimento;
	private Double rentabilidadeAnualCalculada;
	private String tipo;
	
	private Double valorMinimo;
	private String dataInsercao;
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getEmissor() {
		return emissor;
	}
	public void setEmissor(String emissor) {
		this.emissor = emissor;
	}
	public String getDistribuidor() {
		return distribuidor;
	}
	public void setDistribuidor(String distribuidor) {
		this.distribuidor = distribuidor;
	}
	public String getVencimento() {
		return vencimento;
	}
	public void setVencimento(String vencimento) {
		this.vencimento = vencimento;
	}
	public Double getRentabilidadeAnualCalculada() {
		return rentabilidadeAnualCalculada;
	}
	public void setRentabilidadeAnualCalculada(Double rentabilidadeAnualCalculada) {
		this.rentabilidadeAnualCalculada = rentabilidadeAnualCalculada;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public Double getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(Double valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public String getDataInsercao() {
		return dataInsercao;
	}
	public void setDataInsercao(String dataInsercao) {
		this.dataInsercao = dataInsercao;
	}
	public Collection getJSON() {
		// TODO Auto-generated method stub
		return null;
	}
	
	
	
	
}
