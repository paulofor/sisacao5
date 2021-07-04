package br.com.digicom.sisacao.modelo;

import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class RendaFixa  extends Model {
	
	private String nome;
	private Float percentual;
	private String ativo;
	private String tipo;
	private String emissor;
	private String distribuidor;
	private Float valorMinimo;
	private String dataVencimento;
	private Float rentabilidadeAnual;
	
	
	public JSONObject getJSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("nome", nome);
			obj.put("percentual", percentual);
			obj.put("ativo", ativo);
			obj.put("tipo", tipo);
			obj.put("emissor", emissor);
			obj.put("distribuidor", distribuidor);
			obj.put("valorMinimo", valorMinimo);
			obj.put("percentual", percentual);
			obj.put("dataVencimento", dataVencimento);
			obj.put("rentabilidadeAnual", rentabilidadeAnual);
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
	public Float getPercentual() {
		return percentual;
	}
	public void setPercentual(Integer percentual) {
		this.percentual = percentual.floatValue();
	}
	public void setPercentual(Float percentual) {
		this.percentual = percentual;
	}
	public String getAtivo() {
		return ativo;
	}
	public void setAtivo(String ativo) {
		this.ativo = ativo;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
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
	public Float getValorMinimo() {
		return valorMinimo;
	}
	public void setValorMinimo(Integer valorMinimo) {
		this.valorMinimo = valorMinimo.floatValue();
	}
	public void setValorMinimo(Float valorMinimo) {
		this.valorMinimo = valorMinimo;
	}
	public String getDataVencimento() {
		return dataVencimento;
	}
	public void setDataVencimento(String dataVencimento) {
		this.dataVencimento = dataVencimento;
	}
	public Float getRentabilidadeAnual() {
		return rentabilidadeAnual;
	}
	public void setRentabilidadeAnual(Integer rentabilidadeAnual) {
		this.rentabilidadeAnual = rentabilidadeAnual.floatValue();
	}
	public void setRentabilidadeAnual(Float rentabilidadeAnual) {
		this.rentabilidadeAnual = rentabilidadeAnual;
	}
	
	
	


}
