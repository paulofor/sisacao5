package br.com.digicom.sisacao.modelo;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import com.strongloop.android.loopback.Model;

public class FundoImobiliario extends Model{

	private String ticker;
	private String nome;
	private String administrador;
	private String descricao;
	private String segmento;
	
	private Double percentual6;
	private Double percentual12;
	
	private Double mediaNegocio1;
	private Double mediaNegocio3;
	private Double mediaNegocio4;
	
	private Double precoAtual;
	private Double preco6;
	private Double preco12;
	

	public JSONObject jSON() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("ticker", this.ticker);
			obj.put("nome", this.nome);
			obj.put("administrador", this.administrador);
			obj.put("descricao", this.descricao);
			obj.put("segmento", this.segmento);
			obj.put("percentual6", percentual6);
			obj.put("percentual12", percentual12);
			obj.put("mediaNegocio1", mediaNegocio1 );
			obj.put("mediaNegocio3", mediaNegocio3);
			obj.put("mediaNegocio4", this.mediaNegocio4);
			obj.put("precoAtual", this.precoAtual);
			obj.put("preco6", this.preco6);
			obj.put("preco12", this.preco12);
			
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	
	
	
	public Double getPrecoAtual() {
		return precoAtual;
	}


	public void setPrecoAtual(Integer precoAtual) {
		this.precoAtual = precoAtual.doubleValue();
	}

	public void setPrecoAtual(Double precoAtual) {
		this.precoAtual = precoAtual;
	}




	public Double getPreco6() {
		return preco6;
	}

	public void setPreco6(Integer preco6) {
		this.preco6 = preco6.doubleValue();
	}


	public void setPreco6(Double preco6) {
		this.preco6 = preco6;
	}




	public Double getPreco12() {
		return preco12;
	}


	public void setPreco12(Integer preco12) {
		this.preco12 = preco12.doubleValue();
	}

	public void setPreco12(Double preco12) {
		this.preco12 = preco12;
	}




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
	public String getAdministrador() {
		return administrador;
	}
	public void setAdministrador(String administrador) {
		this.administrador = administrador;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public Double getPercentual6() {
		return percentual6;
	}
	public void setPercentual6(Integer percentual6) {
		this.percentual6 = percentual6.doubleValue();
	}
	public void setPercentual6(Double percentual6) {
		this.percentual6 = percentual6;
	}
	public Double getPercentual12() {
		return percentual12;
	}
	public void setPercentual12(Integer percentual12) {
		this.percentual12 = percentual12.doubleValue();
	}
	public void setPercentual12(Double percentual12) {
		this.percentual12 = percentual12;
	}
	public Double getMediaNegocio1() {
		return mediaNegocio1;
	}
	public void setMediaNegocio1(Integer mediaNegocio1) {
		this.mediaNegocio1 = mediaNegocio1.doubleValue();
	}
	public void setMediaNegocio1(Double mediaNegocio1) {
		this.mediaNegocio1 = mediaNegocio1;
	}
	public Double getMediaNegocio3() {
		return mediaNegocio3;
	}
	public void setMediaNegocio3(Integer mediaNegocio3) {
		this.mediaNegocio3 = mediaNegocio3.doubleValue();
	}
	public void setMediaNegocio3(Double mediaNegocio3) {
		this.mediaNegocio3 = mediaNegocio3;
	}
	public Double getMediaNegocio4() {
		return mediaNegocio4;
	}
	public void setMediaNegocio4(Integer mediaNegocio4) {
		this.mediaNegocio4 = mediaNegocio4.doubleValue();
	}
	public void setMediaNegocio4(Double mediaNegocio4) {
		this.mediaNegocio4 = mediaNegocio4;
	}
	public String getSegmento() {
		return segmento;
	}
	public void setSegmento(String segmento) {
		this.segmento = segmento;
	}




	public Object jSONWhere() {
		JSONObject obj = new JSONObject();
		try {
			obj.put("ticker", this.ticker);
		} catch (JSONException e) {
			e.printStackTrace();
		}
		return obj;
	}
	
	

	
	
}
