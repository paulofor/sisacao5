package br.com.digicom.sisacao.modelo;

import java.util.Collection;

import org.json.JSONObject;

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
	
	public void converteDataParaServer() {
		// DD-MM-AAAA
		// 0123456789
		String dia = this.vencimento.substring(0,2);
		String mes = this.vencimento.substring(3, 5);
		String ano = this.vencimento.substring(6);
		this.vencimento = ano + "-" + mes + "-" + dia;
	}
	
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("nome", nome);
			obj.put("emissor", emissor);
			obj.put("distribuidor", distribuidor);
			obj.put("vencimento", vencimento);
			obj.put("rentabilidadeAnualCalculada", rentabilidadeAnualCalculada);
			obj.put("tipo", tipo);
			obj.put("valorMinimo", valorMinimo);

		} catch (Exception e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
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
	
	
	
	
	
}
